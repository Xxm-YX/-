package com.example.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class ConvertUtil {

    private ConvertUtil() {
    }

    /**
     * 将List转为Map
     *
     * @param list         原数据
     * @param keyExtractor Key的抽取规则
     * @param <K>          Key
     * @param <V>          Value
     * @return
     */
    public static <K, V> Map<K, V> listToMap(List<V> list, Function<V, K> keyExtractor) {
        if (list == null || list.isEmpty()) {
            return new HashMap<>();
        }
        Map<K, V> map = new HashMap<>(list.size());
        for (V element : list) {
            K key = keyExtractor.apply(element);
            if (key == null) {
                continue;
            }
            map.put(key, element);
        }
        return map;
    }

    public static void main(String[] args) {

        System.out.println(testFunction(2,i -> i * 2 + 1));
    }

    public static int testFunction(int i, Function<Integer,Integer> function) {

        return function.apply(i);
    }

}