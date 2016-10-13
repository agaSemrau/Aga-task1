package com.SprintName.model;

import java.util.concurrent.atomic.AtomicLong;


public class Adjective {
    private long id;
    private String adjective;

    public Adjective(long id, String adjective) {
       this.id = id;
        this.adjective = adjective;
    }

    public String getAdjective() {
        return adjective;
    }

    public void setAdjective(String adjective) {
        this.adjective = adjective;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
};

