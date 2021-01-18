package com.eden.learn.lambda;

import org.junit.Test;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionTest {

    @Test
    //https://blog.csdn.net/qq_39096058/article/details/82864851
    public void compose(){
        Function<Integer, Integer> times2 = i -> i*2;
        Function<Integer, Integer> squared = i -> i*i;

        System.out.println(times2.apply(4));

        System.out.println(squared.apply(4));

        //32                先4×4然后16×2,先执行apply(4)，在times2的apply(16),先执行参数，再执行调用者。
        System.out.println(times2.compose(squared).apply(4));

        //


        //64               先4×2,然后8×8,先执行times2的函数，在执行squared的函数。
        System.out.println(times2.andThen(squared).apply(4));

        //16
        System.out.println(Function.identity().compose(squared).apply(4));
    }

    @Test
    //https://www.cnblogs.com/chengmi/p/10900218.html
    public void test() {
        Integer[] i = {1, 2, 4, 5};
        Function<Integer[], ArrayList<Integer>> arrayListFunction = FunctionTest::arrToArrayList;
        arrayListFunction.apply(i).forEach(System.out::println);

        ArrayList<Integer> list = FunctionTest.arrToList(i, l -> new ArrayList<>(Arrays.asList(l)));
        list.forEach(System.out::println);

        FunctionTest.arrToList(i, l -> new HashSet<>(Arrays.asList(l))).forEach(System.out::println);
        FunctionTest.arrToList(i, l -> new LinkedList<>(Arrays.asList(l))).forEach(System.out::println);

        FunctionTest.arrToList(i, l -> new LinkedList<>(Arrays.asList(l))).forEach(System.out::println);

        System.out.println(FunctionTest.compute(7, s -> s + "百"));

        System.out.println(FunctionTest.addition("hello", "wolrd", (a, b) -> a + " " + b));

        Function<String, String> function = Function.identity();
        function.apply("hello wolrd");
    }

    //将数组转为ArrayList
    public static <T> ArrayList<T> arrToArrayList(T[] t) {
        Objects.requireNonNull(t);
        return new ArrayList<>(Arrays.asList(t));
    }

    private static <T, R> R arrToList(T[] t, Function<T[], R> function) {
        Objects.requireNonNull(t);
        return function.apply(t);
    }


    public static String compute(int a, Function<Integer, String> function) {
        return function.apply(a);             //function.apply() 接收实际的行为
    }

    public static String addition(String a, String b, BiFunction<String, String, String> biFunction) {
        return biFunction.apply(a, b);
    }

}
