package com.solid.book;
import java.util.List;

interface BookReader {
    public static void main(String[] args) {
        Child1 book = new Book("Tyland", List.of("I", "moved", "here", "recently", "too"));
        book.printToScreen();
    }
}
