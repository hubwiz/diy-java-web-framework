package com.hubwiz.web.helper;

import com.hubwiz.web.annotation.RequestMapping;
import com.hubwiz.web.bean.Handler;
import com.hubwiz.web.bean.Request;
import com.hubwiz.web.utils.ArrayUtil;
import com.hubwiz.web.utils.CollectionUtil;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class ControllerHelper {

    //请求request与处理请求handler映射关系
    private static final Map<Request, Handler> RequestMap = new HashMap<>();

    static {
        ArrayList<Class<?>> controllerClasses = ClassHelper.getControllerClasses();
        if (CollectionUtil.isNotEmpty(controllerClasses)) {
            initRequestMapp(controllerClasses);
        }
    }

    private static void initRequestMapp(ArrayList<Class<?>> controllerClasses) {
        for (Class<?> controllerClass : controllerClasses) {
            Method[] methods = controllerClass.getDeclaredMethods();
            if (ArrayUtil.isNotEmpty(methods)) {
                for (Method method : methods) {
                    //带有RequestMapping注解的方法
                    if (method.isAnnotationPresent(RequestMapping.class)) {
                        RequestMapping rm = method.getAnnotation(RequestMapping.class);
                        Request request = new Request(rm.method(), rm.path());
                        Handler handler = new Handler(controllerClass, method);
                        RequestMap.put(request, handler);
                    }
                }
            }
        }
    }

    /**
     * 获取handler
     *
     * @param requestMethod
     * @param requestPath
     * @return
     */
    public static Handler getHandler(String requestMethod, String requestPath) {
        Request request = new Request(requestMethod, requestPath);
        return RequestMap.get(request);
    }
}
