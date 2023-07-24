package org.example.ch12.q23;

import java.util.Collection;
import java.util.List;

public class B extends A{
    @Override
    public void sample(Collection arg) {
        System.out.println("B");
    }

    public void sample(List arg) {
        System.out.println("C");
    }

    @Override
    public void sample2(Collection arg) {
        System.out.println("BB Collection");
    }

//    @Override
//    public void sample2(List arg) {
//        System.out.println("BB List");
//    }

}
