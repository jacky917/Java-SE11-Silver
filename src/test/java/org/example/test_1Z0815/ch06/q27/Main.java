package org.example.test_1Z0815.ch06.q27;

public class Main {
    public static void main(String[] args) {
        StoryBook storyBook = new StoryBook();
        storyBook.setIsbn("xxxxx");
        System.out.println(storyBook.getIsbn());
        // 無法訪問 protected 方法
        // storyBook.printInfo();
        storyBook.printInfoStoryBook();
    }
}
