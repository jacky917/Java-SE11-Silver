package org.example.test_1Z0816.ch09.q06;

public class Main {
    public static void main(String[] args) {
        try (Sample s = new Sample()){
            System.out.println("try");
            throw new Exception();
        } catch (Exception e) {
            System.out.println("caught Exception");
        } finally {
            System.out.println("finally");
        }

        Sample s = new Sample();
        System.out.println("-------");
        System.out.println(s.isClosed());
        System.out.println("-------");
        try (s){
            System.out.println("try");
            throw new Exception();
        } catch (Exception e) {
            System.out.println("caught Exception");
        } finally {
            System.out.println("finally");
        }
        System.out.println("-------");
        System.out.println(s.isClosed());
        System.out.println("-------");
    }
}
