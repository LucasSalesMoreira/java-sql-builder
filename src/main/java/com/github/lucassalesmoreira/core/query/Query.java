package com.github.lucassalesmoreira.core.query;

public class Query {
    private String nativeQuery;

    public Query(String nativeQuery) {
        this.nativeQuery = nativeQuery;
    }

    void setNativeQuery(String nativeQuery) {
        this.nativeQuery = nativeQuery;
    }

    @Override
    public String toString() {
        return nativeQuery;
    }
}
