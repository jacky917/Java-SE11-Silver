package org.example.ch12.q22.test1;

public class C extends B{
    @Override
    public void p(){
        // 沒有被覆蓋的情況下，super.num 和 num 都可以取到值
        System.out.println(super.num);
        System.out.println(num);
        super.sample();
    }

    public static void main(String[] args) {
        C c = new C();
        c.p();
    }
}
