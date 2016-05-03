package com.hubwiz.web.bean;

import com.hubwiz.web.annotation.Controller;
import com.hubwiz.web.annotation.Service;
import com.hubwiz.web.helper.ClassHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Bean容器
 */
public class BeanContainer {

    /**
     * 存放Bean类和Bean实例的映射关系
     */
    private static final Map<String, Object> beanContainer = new HashMap<>();

    static {
        ArrayList<Class<?>> beanClasses = ClassHelper.getBeanClasses();
        for (Class<?> beanClass : beanClasses) {
            if (beanClass.isAnnotationPresent(Controller.class) ||
                    beanClass.isAnnotationPresent(Service.class)) {
                Object obj = BeanFactory.newInstance(beanClass);
                beanContainer.put(beanClass.getName(), obj);
            }

        }
    }

    /**
     * 获取Bean映射
     *
     * @return
     */
    public static Map<String, Object> getBeanContainer() {
        return beanContainer;
    }

    /**
     * 获取Bean实例
     */
    @SuppressWarnings("unchecked")
    public static <T> T getBean(String className) {
        if (!beanContainer.containsKey(className)) {
            throw new RuntimeException("can not get bean by className: " + className);
        }
        return (T) beanContainer.get(className);
    }

    /**
     * 设置Bean实例
     */
    public static void setBean(String className, Object obj) {
        beanContainer.put(className, obj);
    }
}
