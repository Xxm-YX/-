package com.example.utils;

public final class ValidatorUtils2 {
    private ValidatorUtils2() {}

    /**
     * 校验id是否合法
     *
     * @param id
     */
    public static boolean isNotId(Long id) {
        if (id == null) {
            return true;
        }
        if (id < 0) {
            return true;
        }
        return false;
    }
}