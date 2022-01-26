package com.example.model;

public class Question {
    int id;
    String question;
    String answer;
    String quname;
    String auname;

    public Question() {
    }

    public Question(String question, String answer, String quname) {
        this.question = question;
        this.answer = answer;
        this.quname = quname;
    }

    public Question(int id, String answer, String auname) {
        this.id = id;
        this.answer = answer;
        this.auname = auname;
    }

    public Question(int id, String question, String answer, String quname, String auname) {
        this.id = id;
        this.question = question;
        this.answer = answer;
        this.quname = quname;
        this.auname = auname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getQuname() {
        return quname;
    }

    public void setQuname(String quname) {
        this.quname = quname;
    }

    public String getAuname() {
        return auname;
    }

    public void setAuname(String auname) {
        this.auname = auname;
    }
}

