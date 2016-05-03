package com.hubwiz.web.helper;

import com.hubwiz.web.annotation.Controller;
import com.hubwiz.web.annotation.Service;
import com.hubwiz.web.utils.ClassUtil;

import java.util.ArrayList;

/**
 * 类操作
 */
public class ClassHelper {

    //基础包名下所有的类
    private static ArrayList<Class<?>> classes;

    static {
        String basePackage = ConfigHelper.getAppBasePackage();
        classes = ClassUtil.getClasses(basePackage);
    }

    /**
     * 获取基础包名下所有的类
     *
     * @return
     */
    public static ArrayList<Class<?>> getClasses() {
        return classes;
    }

    /**
     * 获取所有Service类
     *
     * @return
     */
    public static ArrayList<Class<?>> getServiceClasses() {
        ArrayList<Class<?>> sc = new ArrayList<>();
        //补全代码
        for (Class<?> c : classes) {
            if (c.isAnnotationPresent(Service.class)) {
                sc.add(c);
            }
        }
        return sc;
    }

    /**
     * 获取所有Controller类
     *
     * @return
     */
    public static ArrayList<Class<?>> getControllerClasses() {
        ArrayList<Class<?>> cc = new ArrayList<>();
        for (Class<?> c : classes) {
            if (c.isAnnotationPresent(Controller.class)) {
                cc.add(c);
            }
        }
        return cc;
    }

    /**
     * 框架Bean容器主要管理Service,Controller类
     *
     * @return
     */
    public static ArrayList<Class<?>> getBeanClasses() {
        ArrayList<Class<?>> bc = new ArrayList<>();
        bc.addAll(getServiceClasses());
        bc.addAll(getControllerClasses());
        return bc;
    }
}
