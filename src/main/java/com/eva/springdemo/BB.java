package com.eva.springdemo;

import java.util.function.Supplier;

public class BB {
    public static void main(String[] args) {
        var user = new User("k");
        Supplier<String> sup = methodA(user.getName());
        user = null;
        System.out.printf(sup.get());
    }

    public static Supplier<String> methodA(String name) {
        return () -> name + "hahaha";
    }


    public static class User {
        private final String name;

        public User(String name) {
            this.name = name;
        }

        public String getName() {
            return name + "123";
        }


    }
}





