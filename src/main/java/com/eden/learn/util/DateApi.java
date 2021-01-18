package com.eden.learn.util;

import org.junit.Test;

import java.time.Instant;
import java.time.LocalDate;

public class DateApi {

    @Test
    public void test(){
        LocalDate now = LocalDate.now();
        System.out.println(now);

        Instant now1 = Instant.now();
        int nano = now1.getNano();
        long l = now1.toEpochMilli();
        System.out.println(nano);
        System.out.println(l);
        System.out.println(now1.getEpochSecond());

        System.out.println(System.nanoTime());
    }
}
