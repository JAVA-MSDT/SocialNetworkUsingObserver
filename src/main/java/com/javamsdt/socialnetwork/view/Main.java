package com.javamsdt.socialnetwork.view;

import com.javamsdt.socialnetwork.controller.Observer;
import com.javamsdt.socialnetwork.model.Person;

public class Main {

    public static void main(String[] args) {

        Person admin = new Person(1, "Admin");
        Person adminFollower1 = new Person(2, "Admin Follower 1");
        Person adminFollower2 = new Person(3, "Admin Follower 2");
        Person adminFollower3 = new Person(4, "Admin Follower 3");
        Person adminFollower4 = new Person(5, "Admin Follower 4");

        admin.add(adminFollower1);
        admin.add(adminFollower2);
        admin.add(adminFollower3);
        admin.add(adminFollower4);

        admin.notification("Hello followers");
        admin.remove(adminFollower3);
        System.out.println("=====================");
        admin.setName("General Admin");
        System.out.println("=====================");

        adminFollower1.add(admin);
        adminFollower1.add(adminFollower2);
        adminFollower1.add(adminFollower3);
        adminFollower1.notification("Hello Admin Follower 2 ");
        System.out.println("=====================");
        System.out.println(admin);
        for (Observer o : admin.getObserverList()) {
            System.out.println(o);
        }

    }
}
