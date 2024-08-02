package com.github.lucassalesmoreira.core.query;

public interface IBasicCommands {
    Query where();
    Query where(String column, String value);
    Query where(String column, int value);
    Query where(String column, float value);
    Query where(String column, double value);
    Query where(String column, Integer value);
    Query where(String column, Float value);
    Query where(String column, Double value);
}
