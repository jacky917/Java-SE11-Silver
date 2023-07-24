package org.example.ch08.q05;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        List<Sample> list = Arrays.asList(new Sample(10),new Sample(20),new Sample(30));
        Predicate<Sample> x1 = list::contains; // <- 題目正解
        Supplier<Boolean> x2 = () -> true;
        Function<Sample,Boolean> x3 = list::contains;

        if(x1.test(new Sample(20))) {
            System.out.println("ok");
        }

        if(x2.get()) {
            System.out.println("ok");
        }

        if(x3.apply(new Sample(20))) {
            System.out.println("ok");
        }
    }
}
