package com.springboot.model.request;

import org.springframework.web.bind.annotation.RequestParam;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.QueryParam;

public class SearchRequest {

    @QueryParam("name")
    private String name;

    @QueryParam("page")
    @DefaultValue("1")
    private String page;

    @QueryParam("page_size")
    @DefaultValue("10")
    private String pageSize;

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SearchRequest{" +
                "name='" + name + '\'' +
                ", page='" + page + '\'' +
                ", pageSize='" + pageSize + '\'' +
                '}';
    }
}
