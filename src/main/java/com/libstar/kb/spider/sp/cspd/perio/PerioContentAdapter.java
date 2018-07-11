package com.libstar.kb.spider.sp.cspd.perio;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

/**
 * @author itguang
 * @create 2018-06-29 9:59
 **/
public class PerioContentAdapter implements JsonSerializer<String>, JsonDeserializer<String> {


    /**
     * 把json数组转为String存储,并且去掉引号
     * @param json
     * @param typeOfT
     * @param context
     * @return
     * @throws JsonParseException
     */
    @Override
    public String deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {


        if (json == null) {
            return null;

        }

        return json.toString().replace("\"", "");
    }

    @Override
    public JsonElement serialize(String src, Type typeOfSrc, JsonSerializationContext context) {


        return null;
    }
}