package com.test.springboot.model;


public class ElasticResponse {
    private long took;
    private Hits hits;

    public long getTook() { return took; }
    public void setTook(long value) { this.took = value; }

    public Hits getHits() { return hits; }
    public void setHits(Hits value) { this.hits = value; }
}