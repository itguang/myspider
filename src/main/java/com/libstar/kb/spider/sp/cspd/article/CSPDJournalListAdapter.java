package com.libstar.kb.spider.sp.cspd.article;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

/**
 * 对json数据转String操作
 *
 * @author itguang
 * @create 2018-06-26 17:07
 **/
public class CSPDJournalListAdapter implements JsonSerializer<String>, JsonDeserializer<String> {


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
