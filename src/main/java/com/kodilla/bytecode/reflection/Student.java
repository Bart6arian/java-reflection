package com.kodilla.bytecode.reflection;

import java.util.Random;

public class Student {

    private String indexNumber = generator();

    private String generator() {
        char left = 'a';
        char right = 'z';
        int len = 10;
        Random random = new Random();
        StringBuilder builder = new StringBuilder(len);
        for(int i = 0; i <= len; i++) {
            int indexInNums = (int) (left + (random.nextDouble() * (right-left)));
            builder.append((char) indexInNums).reverse();
        }
        return (builder.toString());
    }

    public Student() {

    }
}
