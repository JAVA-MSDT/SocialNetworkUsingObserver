package com.javamsdt.socialnetwork.model;

import com.javamsdt.socialnetwork.controller.Observeable;
import com.javamsdt.socialnetwork.controller.Observer;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Person implements Observer, Observeable {

    private static Logger logger = LogManager.getLogger(Person.class);
    private int id;
    private String name;

    private List<Observer> observerList = new ArrayList<Observer>();

    public Person() {
    }

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id < 0) {
            throw new IllegalArgumentException("It's not allow for a negative id");
        }
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("It's not allow to set name to null or to empty name");
        }
        String oldName = this.getName();
        this.name = name;
        notify(oldName + " has change his name to: " + name);
    }

    public List<Observer> getObserverList() {
        return observerList;
    }

    /**
     * @param notification that we need to send to all the members that subscribe in that account
     */
    public void notification(String notification) {
        if (notification == null || notification.isEmpty()) {
            throw new IllegalArgumentException("It's not allow to send null or empty notification");
        }
        notify(notification);
    }

    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        if (this == obj) {
            return true;
        }

        Person p = (Person) obj;

        if (this.id != p.id) {
            return false;
        }
        return equalHelper(this.name, p.name) &&
                equalHelper(this.observerList, p.observerList);
    }

    private boolean equalHelper(Object a, Object b) {
        return (a == b) || (a != null && a.equals(b));
    }

    public int hachCode() {
        final int prime = 31;
        int result = 1;

        result = prime * result + id;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((observerList == null) ? 0 : observerList.hashCode());

        return result;
    }

    public String toString() {

        return getClass().getSimpleName() + " " +
                "Person Id: " + id + " " +
                "Name: " + name;
    }

    public void add(Observer o) {
        if (o == null) {
            throw new IllegalArgumentException("It's not allow for a null observer object");
        }
        observerList.add(o);
    }

    public void remove(Observer o) {
        if (o == null) {
            throw new IllegalArgumentException("It's not allow for a null observer object");
        }
        if (!observerList.contains(o)) {
            logger.error("This observer object not in the list ro remove it");
        }
        observerList.remove(o);
    }

    public void notify(String s) {
        if (s == null || s.isEmpty()) {
            throw new IllegalArgumentException("It's not allow to send null or empty notification");
        }
        for (Observer o : observerList) {
            o.update(name, s);
        }
    }

    public void update(String name, String st) {
        if ((name == null || name.isEmpty() || st == null || st.isEmpty())) {
            throw new IllegalArgumentException("It's not allow to for null or empty String");
        }
        System.out.println("We have a new Notification from: " + name + " To all of his follower: " + st);
    }
}
