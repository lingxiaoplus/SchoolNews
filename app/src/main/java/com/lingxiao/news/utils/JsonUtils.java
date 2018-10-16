package com.lingxiao.news.utils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.lingxiao.news.retrofit.modle.DetailModel;
import com.lingxiao.news.retrofit.modle.HomeListModle;
import com.lingxiao.news.retrofit.modle.NewsDetailModel;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JsonUtils {
    private static Gson mGson = new Gson();
    //读取并解析网页新闻json数据
    public static NewsDetailModel readJsonNewsContent(String res, String docId) {
        NewsDetailModel newsDetailBean = null;
        try {
            JsonParser parser = new JsonParser();
            JsonObject jsonObj = parser.parse(res).getAsJsonObject();
            JsonElement jsonElement = jsonObj.get(docId);
            if (jsonElement == null) {
                return null;
            }
            newsDetailBean = JsonUtils.deserialize(jsonElement.getAsJsonObject(), NewsDetailModel.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newsDetailBean;
    }

    /**
     * 解析出分类的json数据
     * @param res
     * @param docId
     * @return
     */
    public static List<DetailModel> readJsonNewsList(String res, String docId) {
        //HomeListModle newsList = null;
        List<DetailModel> newsList = null;
        try {
            LogUtils.d("得到的："+res);
            JsonParser parser = new JsonParser();
            //JsonArray jsonArray = parser.parse(res).getAsJsonArray();
            JsonObject jsonObj = parser.parse(res).getAsJsonObject();
            JsonElement jsonElement = jsonObj.get(docId);

            if (jsonElement == null) {
                return null;
            }
            newsList = JsonUtils.deserialize(jsonElement.getAsJsonArray(),DetailModel.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newsList;
    }
    /**
     * 将对象准换为json字符串
     *
     * @param object
     * @param <T>
     * @return
     */
    public static <T> String serialize(T object) {
        return mGson.toJson(object);
    }

    /**
     * 将json字符串转换为对象
     *
     * @param json
     * @param clz
     * @param <T>
     * @return
     */
    public static <T> T deserialize(String json, Class<T> clz) throws JsonSyntaxException {
        return mGson.fromJson(json, clz);
    }

    /**
     * 将json对象转换为实体对象
     *
     * @param json
     * @param clz
     * @param <T>
     * @return
     * @throws JsonSyntaxException
     */
    public static <T> T deserialize(JsonObject json, Class<T> clz) throws JsonSyntaxException {
        return mGson.fromJson(json, clz);
    }

    /**
     * 将json对象转换为列表
     *
     * @return
     * @throws JsonSyntaxException
     */
    public static <T> List<T> deserialize(JsonArray jsonArray,Class<T> clazz) throws JsonSyntaxException {
        List<T> mList = new ArrayList<T>();
        for(JsonElement elem : jsonArray){
            mList.add(mGson.fromJson(elem, clazz));
        }
        return mList;
    }

    /**
     * 将json字符串转换为对象
     *
     * @param json
     * @param type
     * @param <T>
     * @return
     */
    public static <T> T deserialize(String json, Type type) throws JsonSyntaxException {
        return mGson.fromJson(json, type);
    }
}
