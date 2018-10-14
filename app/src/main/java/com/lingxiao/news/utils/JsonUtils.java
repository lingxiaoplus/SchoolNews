package com.lingxiao.news.utils;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.lingxiao.news.retrofit.modle.HomeListModle;
import com.lingxiao.news.retrofit.modle.NewsDetailModel;

import java.lang.reflect.Type;

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
    public static HomeListModle readJsonNewsList(String res, String docId) {
        HomeListModle newsList = null;
        try {
            LogUtils.d("得到的："+res);
            JsonParser parser = new JsonParser();
            JsonObject jsonObj = parser.parse(res).getAsJsonObject();
            JsonElement jsonElement = jsonObj.get(docId);
            if (jsonElement == null) {
                return null;
            }
            newsList = JsonUtils.deserialize(jsonElement.getAsJsonObject(), HomeListModle.class);
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
