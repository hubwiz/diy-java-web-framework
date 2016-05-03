package com.hubwiz.web.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回视图JSP，视图中包含视图JSP路径和视图中所需的数据
 */
public class ModelAndView {

    //返回JSP路径
    private String path;

    //模型数据
    private Map<String,Object> mData;

    public ModelAndView(String path) {
        this.path = path;
        mData = new HashMap<>();
    }

    public ModelAndView addmData(String key, Object obj) {
        mData.put(key,obj);
        return this;
    }

    public String getPath() {
        return path;
    }


    public Map<String, Object> getmData() {
        return mData;
    }

}
