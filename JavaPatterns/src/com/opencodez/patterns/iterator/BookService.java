package com.opencodez.patterns.iterator;

import java.util.ArrayList;
import java.util.List;

public class BookService {
	
	private List<Book> books;
	
	public BookIterator getIterator(String publication) {
		return new BookIteratorImpl(books, publication);
	}
	
	private class BookIteratorImpl implements BookIterator {

		private String publicationCheck;
		private List<Book> listOfBooks;
		private int index;
		
		public BookIteratorImpl(List<Book> books, String pubCheck) {
			this.listOfBooks = books;
			this.publicationCheck = pubCheck;
		}

		@Override
		public boolean hasMore() {
			while(index < listOfBooks.size()) {
				Book buk = this.listOfBooks.get(index);
				if(buk.getPublication().equalsIgnoreCase(publicationCheck)) {
					return true;
				} else {
					index++;
				}
			}
			return false;
		}

		@Override
		public Book next() {
			Book buk = this.listOfBooks.get(index);
			index++;
			return buk;
		}
	}
	
	public BookService() {
		books = new ArrayList<Book>();
	}
	
	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
}
