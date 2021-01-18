package com.eden.learn.classloader;

import com.eden.learn.lambda.FunctionTest;

import java.util.ArrayList;
import java.util.function.Function;

public class Test {
    public static void main(String[] args) {
        System.out.println(new Test().getClass().getClassLoader());

    }
}
