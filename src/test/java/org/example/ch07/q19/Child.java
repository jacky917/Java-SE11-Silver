package org.example.ch07.q19;

public class Child extends Parent {
    String name = "ChildName";

    @Override
    public String getChildName() {
        return this.name;
    }

}
