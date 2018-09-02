package com.test.springboot.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Hit {
    @JsonProperty("_id")
    private String id;
    @JsonProperty("_source")
    private Source source;

    public String getID() { return id; }
    public void setID(String value) { this.id = value; }

    public Source getSource() { return source; }
    public void setSource(Source value) { this.source = value; }
}