package com.example.springbootdemo.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * @description：
 * @author: zhangxianglong
 * @date: 2022/3/18
 */
public class JSONTOMap {

    public static void main(String[] args) {

        String content = "{\n" + "    \"1001\":{\n" + "        \"personRole\":\"客户经理（东店）\",\n" + "        \"basalRole\":\"01\"\n" + "    },\n" + "     \"1002\":{\n" + "        \"personRole\":\"客户经理（南店)\",\n" + "        \"basalRole\":\"02\"\n" + "    }\n" + "}";
        JSONObject object = JSON.parseObject(content);
        Object o = object.get("1001");
        JSONObject json = (JSONObject) JSONObject.toJSON(o);
        String s = json.get("basalRole").toString();

    }
}
