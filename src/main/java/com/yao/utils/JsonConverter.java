package com.yao.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * Created by root on 15-3-18.
 */
public class JsonConverter<T extends Object> {
    public static <T> T json2Obj(Object msgBody , Class<T> clazz) {
            return (T) JSON.parseObject(msgBody.toString(), clazz);

    }

}
