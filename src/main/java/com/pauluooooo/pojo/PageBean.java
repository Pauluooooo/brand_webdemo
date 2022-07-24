package com.pauluooooo.pojo;

import java.util.List;

public class PageBean<T> {
    /*总记录数*/
    private int totalCount;
    //    当前页码展示的对象
    private List<T> rows;

    @Override
    public String toString() {
        return "PageBean{" +
                "totalCount=" + totalCount +
                ", rows=" + rows +
                '}';
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }
}
