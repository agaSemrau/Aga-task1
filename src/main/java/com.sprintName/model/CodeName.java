package com.sprintName.model;


public class CodeName {

    private Adjective adjective;
    private Noun noun;

    public CodeName(Adjective adjective, Noun noun) {
        this.noun = noun;
        this.adjective = adjective;
    }

    public Adjective getAdjective() {
        return adjective;
    }

    public void setAdjective(Adjective adjective) {
        this.adjective = adjective;
    }

    public Noun getNoun() {
        return noun;
    }

    public void setNoun(Noun noun) {
        this.noun = noun;
    }

    @Override
    public String toString() {
        return adjective.getAdjective() + " " + noun.getNoun();
    }
}
