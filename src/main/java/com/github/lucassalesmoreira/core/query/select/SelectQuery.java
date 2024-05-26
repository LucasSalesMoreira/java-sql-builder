package com.github.lucassalesmoreira.core.query.select;

import com.github.lucassalesmoreira.core.query.BasicCommands;
import com.github.lucassalesmoreira.core.query.IQueryBuilder;
import com.github.lucassalesmoreira.core.query.Query;

import static java.lang.String.format;

public class SelectQuery extends BasicCommands implements IQueryBuilder {

    private String tableName;
    private String[] columns;

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
        return new Query(format("select %s from %s", this.formatColumns(), this.tableName));
    }

    private String formatColumns() {
        var numberOfColumns = this.columns.length;
        if (numberOfColumns == 0) return "*";
        var columnsFormatted = new StringBuilder();
        for (int i = 0; i < numberOfColumns; i++) {
            columnsFormatted.append(i == numberOfColumns - 1 ? this.columns[i] : this.columns[i] + ", ");
        }
        return columnsFormatted.toString();
    }
}
