package com.hubwiz.web;

import com.hubwiz.web.bean.BeanContainer;
import com.hubwiz.web.helper.ClassHelper;
import com.hubwiz.web.helper.ControllerHelper;
import com.hubwiz.web.helper.IocHelper;
import com.hubwiz.web.utils.ClassUtil;

/**
 * 初始化框架
 */
public class Loader {

    public static void init() {
        Class<?>[] cs = {ClassHelper.class,
                BeanContainer.class,
                IocHelper.class,
                ControllerHelper.class};
        for (Class<?> c: cs) {
            ClassUtil.loadClass(c.getName(),true);
        }
    }
}
