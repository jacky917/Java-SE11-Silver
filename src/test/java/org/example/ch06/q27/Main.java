package org.example.ch06.q27;

public class Main {
    public static void main(String[] args) {
        StoryBook storyBook = new StoryBook();
        storyBook.setIsbn("xxxxx");
        // 無法訪問 protected 方法
        // storyBook.printInfo();
        storyBook.printInfoStoryBook();
    }
}
