package com.javamsdt.socialnetwork.controller;

public interface Observeable {
    void add(Observer o);
    void remove(Observer o);
    void notify(String s);
}
