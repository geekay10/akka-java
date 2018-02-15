package com.akkaDB.messages;

public class SetRequest {
    private final String key;
    private final Object value;

    private SetRequest(String key, Object value) {
        this.key = key;
        this.value = value;
    }

    public static SetRequest getInstance(String key, Object value) {
        return  new SetRequest(key, value);
    }

    public String getKey() {
        return key;
    }

    public Object getValue() {
        return value;
    }
}
