package com.atg.pojo;

import java.util.List;

public class Page<T> {
    //常量来用
    //public static final Integer PAGE_SIZE = 2;
    public static final Integer PAGE_SIZE = 4;
    //第几页
    private Integer pageNo;
    //总页数
    private Integer pageTotal;
    //每页显示条数
    //private Integer pageSize = 4; //右键rename一下变大写
    private Integer pageSize = PAGE_SIZE;
    // 总记录数
    private Integer pageTotalCount;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    //分页条的请求地址
    private String  url;

    public Integer getPageTotalCount() {
        return pageTotalCount;
    }

    //每页内容
    //private List<Book> items; 为了让商城适应各种，不只是书
    private List<T> items;

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        if (pageNo<1){
            pageNo = 1;
        }
        if (pageNo>pageTotal){
            pageNo = pageTotal;
        }
        this.pageNo = pageNo;
    }

    public Integer getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(Integer pageTotal) {
        this.pageTotal = pageTotal;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }


    @Override
    public String toString() {
        return "Page{" +
                "pageNo=" + pageNo +
                ", pageTotal=" + pageTotal +
                ", pageSize=" + pageSize +
                ", pageTotalCount=" + pageTotalCount +
                ", url='" + url + '\'' +
                ", items=" + items +
                '}';
    }

    public void setPageTotalCount(Integer pageTotalCount) {
        this.pageTotalCount = pageTotalCount;
    }
}
