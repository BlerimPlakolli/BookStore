package ks.bookstore.blerim.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ks.bookstore.blerim.domain.Book;
import ks.bookstore.blerim.domain.BookRepository;



@Controller
public class BookController {
	
	@Autowired
	private BookRepository repository;
	
	/*
	 * @RequestMapping("/index") public String nameOfBookStore() {
	 * 
	 * return "Blerim Plakolli Science Book Store"; }
	 */
	@RequestMapping(value="/booklist", method = RequestMethod.GET)
	public String listBooks(Model model) {
		model.addAttribute("books", repository.findAll());
		return "booklist";
	}
	
	@RequestMapping(value="/addBook")
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		return "addBook";		
	}
	@PostMapping("/save")
	public String saveBook(Book book) {
		repository.save(book);
		return "redirect:booklist";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteBook(@PathVariable("id") Long bookId, Model model) {
		repository.deleteById(bookId);
		return "redirect:../booklist";
	}
	
	@GetMapping("/edit/{id}")
	public String editBookData(@PathVariable("id") Long bookId, Model model) {
		model.addAttribute("book", repository.findById(bookId));
		return "editBook";
	}
	
	@GetMapping("/billi") // this listener is just for testing
	public String getBilli(Model model) {
		String testi = "Welcome billi";
		model.addAttribute("billi", testi);
		return "billi";
	}

}
