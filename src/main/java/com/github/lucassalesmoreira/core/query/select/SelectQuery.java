package com.github.lucassalesmoreira.core.query.select;

import com.github.lucassalesmoreira.core.query.IQueryBuilder;
import com.github.lucassalesmoreira.core.query.Query;

import java.util.ArrayList;

import static java.lang.String.format;

public class SelectQuery implements IQueryBuilder {

    private String tableName;
    private String[] columns = new String[0];
    private ArrayList<String> whereStructure;

    public SelectQuery find(String tableName) {
        this.tableName = tableName;
        return this;
    }

    public SelectQuery columns(String... columns) {
        this.columns = columns;
        return this;
    }

    @Override
    public Query build() {
        return new Query(format("select %s from %s %s", this.formatColumns(), this.tableName, this.formatWhere()));
    }

    public SelectQuery equal(String column, String value) {
        this.whereStructure.add(format("%s = '%s'", column, value));
        return this;
    }

    public SelectQuery equal(String column, int value) {
        this.whereStructure.add(format("%s = %s", column, value));
        return this;
    }

    public SelectQuery equal(String column, float value) {
        this.whereStructure.add(format("%s = %s", column, value));
        return this;
    }

    public SelectQuery equal(String column, double value) {
        this.whereStructure.add(format("%s = %s", column, value));
        return this;
    }

    public SelectQuery notEqual(String column, String value) {
        this.whereStructure.add(format("%s != '%s'", column, value));
        return this;
    }

    public SelectQuery notEqual(String column, int value) {
        this.whereStructure.add(format("%s != %s", column, value));
        return this;
    }

    public SelectQuery notEqual(String column, float value) {
        this.whereStructure.add(format("%s != %s", column, value));
        return this;
    }

    public SelectQuery notEqual(String column, double value) {
        this.whereStructure.add(format("%s != %s", column, value));
        return this;
    }

    public SelectQuery and() {
        this.whereStructure.add("and");
        return this;
    }

    public SelectQuery or() {
        this.whereStructure.add("or");
        return this;
    }

    public SelectQuery lessThan(String column, int value) {
        this.whereStructure.add(format("%s < %s", column, value));
        return this;
    }

    public SelectQuery lessThan(String column, float value) {
        this.whereStructure.add(format("%s < %s", column, value));
        return this;
    }

    public SelectQuery lessThan(String column, double value) {
        this.whereStructure.add(format("%s < %s", column, value));
        return this;
    }

    public SelectQuery biggerThan(String column, int value) {
        this.whereStructure.add(format("%s > %s", column, value));
        return this;
    }

    public SelectQuery biggerThan(String column, float value) {
        this.whereStructure.add(format("%s > %s", column, value));
        return this;
    }

    public SelectQuery biggerThan(String column, double value) {
        this.whereStructure.add(format("%s > %s", column, value));
        return this;
    }

    public SelectQuery where() {
        this.whereStructure = new ArrayList<>();
        this.whereStructure.add("where");
        return this;
    }

    public SelectQuery where(String column, String value) {
        return this.where().equal(column, value);
    }

    public SelectQuery where(String column, int value) {
        return this.where().equal(column, value);
    }

    public SelectQuery where(String column, float value) {
        return this.where().equal(column, value);
    }

    public SelectQuery where(String column, double value) {
        return this.where().equal(column, value);
    }

    private String formatColumns() {
        var numberOfColumns = this.columns.length;
        if (numberOfColumns == 0) return "*";
        var columnsFormatted = new StringBuilder();
        for (int i = 0; i < numberOfColumns; i++) {
            columnsFormatted.append(i == numberOfColumns - 1 ?
                this.columns[i] : this.columns[i] + ", ");
        }
        return columnsFormatted.toString();
    }

    private String formatWhere() {
        var numberOfWhere = this.whereStructure.size();
        if (numberOfWhere == 0) return "";
        var whereFormatted = new StringBuilder();
        for (int i = 0; i < numberOfWhere; i++) {
            whereFormatted.append(i == numberOfWhere - 1 ?
                this.whereStructure.get(i) : this.whereStructure.get(i) + " ");
        }
        return whereFormatted.toString();
    }
}
