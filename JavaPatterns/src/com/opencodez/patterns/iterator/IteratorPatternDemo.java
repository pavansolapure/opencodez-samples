package com.opencodez.patterns.iterator;

import java.util.ArrayList;
import java.util.List;

public class IteratorPatternDemo {

	public static void main(String[] args) {
		List<Book> books = new ArrayList<Book>();
		books.add(new Book("Java", "Pub A"));
		books.add(new Book("C++", "Pub B"));
		books.add(new Book("PHP", "Pub A"));
		books.add(new Book("Kotlin", "Pub B"));
		books.add(new Book("Kafka", "Pub A"));
		books.add(new Book("Salesforce", "Pub C"));
		
		BookService bs = new BookService();
		bs.getBooks().addAll(books);
		
		System.out.println("List of Books from Publisher C");
		
		BookIterator bi = bs.getIterator("Pub C");
		while (bi.hasMore()) {
			Book b = bi.next();
			System.out.println("--> " + b);
		}
		
		System.out.println("\nList of Books from Publisher B");
		
		bi = bs.getIterator("Pub B");
		while (bi.hasMore()) {
			Book b = bi.next();
			System.out.println("--> " + b);
		}
		
	}
}
