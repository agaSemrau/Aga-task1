package com.SprintName.model;

public class Noun {

    private long id;
    private String noun;

    public Noun(long id, String noun) {
        this.id = id;
        this.noun = noun;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNoun() {
        return noun;
    }

    public void setNoun(String noun) {
        this.noun = noun;
    }
}
