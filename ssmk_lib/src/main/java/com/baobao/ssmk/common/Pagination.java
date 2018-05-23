package com.baobao.ssmk.common;

import java.io.Serializable;
import java.util.List;

public class Pagination<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 总记录数。
     */
    private final int total;

    /**
     * 记录列表。
     */
    private final List<T> rows;

    /**
     * 总页数
     */
    private final int totalPage;

    /**
     * 构造分页包装对象。
     *
     * @param total 总记录数。
     * @param rows  记录列表，不可为null，无记录时应该是空集。
     */
    public Pagination(int total, List<T> rows, int pageSize) {
        this.total = total;
        this.rows = rows;
        this.totalPage = (total + pageSize - 1) / pageSize;
    }

    public int getTotal() {
        return total;
    }

    public List<?> getRows() {
        return rows;
    }

    public int getTotalPage() {
        return totalPage;
    }
}
