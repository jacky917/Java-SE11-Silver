package org.example.test_1Z0815.ch12.q44;

public class SubSample extends Sample{
    int price;

    // There is no default constructor available in 'org.example.ch12.q44.Sample'
    // public SubSample(int price) {
    //     this.price = price;
    // }

    public SubSample(String name, int num) {
        super(name, num);
        // Cannot reference 'SubSample.price' before supertype constructor has been called
        //this(price);
    }
}
