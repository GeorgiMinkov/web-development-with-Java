package com.fmi.web.bookstoreproject;

import com.fmi.web.bookstoreproject.model.Book;
import com.fmi.web.bookstoreproject.service.BookStore;
import com.fmi.web.bookstoreproject.service.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookstoreprojectApplication implements CommandLineRunner {

	@Autowired
	private Store bookStore;

	public static void main(String[] args) {
		SpringApplication.run(BookstoreprojectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello Spring");
		bookStore.add(new Book("isb1231321", "Null pointer 101", "Stoyan"));

	}
}
