package com.baobao.ssmk.common;
/**
 * @Company:新概念保险
 * @Auth:秦盼（Q）
 * @Description:
 * @Date:Created in 12:01 2017/12/11
 * @Modified By:
 */
public abstract class BaseModel {
    private Integer currPage = 1;
    private Integer pageSize = 10;
    private Integer startIndex;

    public Integer getCurrPage() {
        return currPage;
    }

    public void setCurrPage(Integer currPage) {
        this.currPage = currPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getStartIndex() {
        if (currPage != null && pageSize != null && currPage > 0 && pageSize > 0) {
            this.startIndex = (currPage - 1) * pageSize;
        } else {
            this.startIndex = 0;
        }
        return this.startIndex;
    }
}
