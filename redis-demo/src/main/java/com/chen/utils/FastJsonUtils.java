package com.chen.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.JSONLibDataFormatSerializer;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.List;
import java.util.Map;

public class FastJsonUtils {

    private static final SerializeConfig CONFIG;

    static {
        CONFIG = new SerializeConfig();
        // 使用和json-lib兼容的日期输出格式
        CONFIG.put(java.util.Date.class, new JSONLibDataFormatSerializer());
        // 使用和json-lib兼容的日期输出格式
        CONFIG.put(java.sql.Date.class, new JSONLibDataFormatSerializer());
    }

    /**
     * 输出空置字段
     */
    private static final SerializerFeature[] FEATURES = {
            // 是否输出值为null的字段,默认为false
            SerializerFeature.WriteMapNullValue,
            // List字段如果为null,输出为[],而非null
            SerializerFeature.WriteNullListAsEmpty,
            // 数值字段如果为null,输出为0,而非null
            SerializerFeature.WriteNullNumberAsZero,
            // Boolean字段如果为null,输出为false,而非null
            SerializerFeature.WriteNullBooleanAsFalse,
            // 字符类型字段如果为null,输出为"",而非null
            SerializerFeature.WriteNullStringAsEmpty
    };

    public static String toJSONString(Object object) {
        return JSON.toJSONString(object, CONFIG, FEATURES);
    }

    public static String toJSONNoFeatures(Object object) {
        return JSON.toJSONString(object, CONFIG, SerializerFeature.DisableCircularReferenceDetect);
    }

    public static Object toBean(String text) {
        return JSON.parse(text);
    }

    public static <T> T toBean(String text, Class<T> clazz) {
        return JSON.parseObject(text, clazz);
    }

    public static Object[] toArray(String text) {
        return toArray(text, null);
    }

    public static <T> Object[] toArray(String text, Class<T> clazz) {
        return JSON.parseArray(text, clazz).toArray();
    }

    public static <T> List<T> toList(String text, Class<T> clazz) {
        return JSON.parseArray(text, clazz);
    }

    /**
     * 将string转化为序列化的json字符串
     * @param text 字符串
     * @return json
     */
    public static Object textToJson(String text) {
        return JSON.parse(text);
    }

    /**
     * json字符串转化为map
     * @param s 字符串
     * @return map
     */
    public static Map stringToCollect(String s) {
        return JSONObject.parseObject(s);
    }

    /**
     * 将map转化为string
     * @param m map
     * @return string
     */
    public static String collectToString(Map m) {
        return JSONObject.toJSONString(m);
    }

    /**
     * 把对象转换为指定对象
     * @param source 实体
     * @param target 类型
     * @return 实体
     */
    public static <T> T toObjectFromSource(Object source,Class<T> target) {
        return toBean(toJSONString(source),target);
    }

}