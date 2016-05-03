package com.hubwiz.web.helper;

import com.hubwiz.web.annotation.Autowired;
import com.hubwiz.web.bean.BeanContainer;
import com.hubwiz.web.utils.ArrayUtil;
import com.hubwiz.web.utils.CollectionUtil;
import com.hubwiz.web.bean.BeanFactory;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * 依赖注入
 */
public final class IocHelper {

    static {
        Map<String, Object> beanContainer = BeanContainer.getBeanContainer();
        if (CollectionUtil.isNotEmpty(beanContainer)) {
            initIOC(beanContainer);
        }
    }

    private static void initIOC( Map<String, Object> beanContainer) {
        for (Map.Entry<String, Object> beanEntry : beanContainer.entrySet()) {
            String className = beanEntry.getKey();
            Object beanInstance = beanEntry.getValue();
            Class<?> beanClass = null;
            try {
                beanClass = Class.forName(className);
                System.out.println(className);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            //Controller类中定义的属性
            Field[] beanFields = beanClass.getDeclaredFields();
            if (ArrayUtil.isNotEmpty(beanFields)) {
                for (Field beanField : beanFields) {
                    //带有Autowired注解的成员变量
                    if (beanField.isAnnotationPresent(Autowired.class)) {
                        //成员变量的类
                        Class<?> beanFieldClass = beanField.getType();
                        Object beanFieldInstance = beanContainer.get(beanFieldClass.getName());
                        if (beanFieldInstance != null) {
                            //依赖注入
                            BeanFactory.setField(beanInstance, beanField, beanFieldInstance);
                        }
                    }
                }
            }
        }
    }
}
