package com.sprintName.model;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Noun noun1 = (Noun) o;

        return noun.equals(noun1.noun);

    }

    @Override
    public int hashCode() {
        return noun.hashCode();
    }

    @Override
    public String toString() {
        return "Noun{" +
                "noun='" + noun + '\'' +
                '}';
    }
}
