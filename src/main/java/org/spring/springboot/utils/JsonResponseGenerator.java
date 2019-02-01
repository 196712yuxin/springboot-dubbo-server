package org.spring.springboot.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class JsonResponseGenerator
{
    public static Object success(String message)
    {
        Map map = new HashMap();
        map.put("success", Boolean.valueOf(true));
        map.put("message", message);
        return map;
    }
    public static Object success(Object object) {
        Map map = new HashMap();
        map.put("success", Boolean.valueOf(true));
        map.put("message", object);
        return map;
    }

    public static Object success(String message, Map<String, Object> data) {
        Map map = (Map)success(message);
        for (Entry entrySet : data.entrySet()) {
            String key = (String)entrySet.getKey();
            Object value = entrySet.getValue();
            map.put(key, value);
        }
        return map;
    }

    public static Object fail(String message) {
        Map map = new HashMap();
        map.put("success", Boolean.valueOf(false));
        map.put("message", message);
        return map;
    }
}
