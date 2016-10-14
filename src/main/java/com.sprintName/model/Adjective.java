package com.sprintName.model;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Adjective adjective1 = (Adjective) o;

        return adjective.equals(adjective1.adjective);

    }

    @Override
    public int hashCode() {
        return adjective.hashCode();
    }

    @Override
    public String toString() {
        return "Adjective{" +
                "id=" + id +
                ", adjective='" + adjective + '\'' +
                '}';
    }
};

