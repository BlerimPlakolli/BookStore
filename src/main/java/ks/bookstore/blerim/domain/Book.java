package ks.bookstore.blerim.domain;

import javax.persistence.Entity;

@Entity
public class Book {
	
	private String title, author, isbn;
	private long year;
	private double price;

}
