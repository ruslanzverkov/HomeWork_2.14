package com.example.homework2_14.StringArray;

import com.example.homework2_14.Application;
import org.springframework.boot.SpringApplication;

public class Main {
    public static void main(String[] args) {
        StringList stringList = new StringListImpl();
        stringList.add("t1");
        stringList.add("t2");
        stringList.add("t3");
        stringList.add("t4");
        System.out.println(stringList);
    }

}

