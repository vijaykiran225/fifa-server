package com.test.springboot.model.response.elastic;

import java.util.List;

public class Hits {

    private long total;
    private List<Hit> hits;

    public List<Hit> getHits() { return hits; }
    public void setHits(List<Hit> value) { this.hits = value; }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Hits{" +
                "total=" + total +
                ", hits=" + hits +
                '}';
    }
}