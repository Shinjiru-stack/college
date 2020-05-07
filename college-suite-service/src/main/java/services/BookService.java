/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

/**
 *
 * @author SHINJIRU
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
 
import models.Book;
 
/*
 * It is just a helper class which should be replaced by database implementation.
 * It is not very well written class, it is just used for demonstration.
 */
public class BookService {
 
	static HashMap<Integer,Book> BookIdMap=getBookIdMap();
 
 
	public BookService() {
		super();
 
		if(BookIdMap==null)
		{
			BookIdMap=new HashMap<Integer,Book>();
			// Creating some objects of Book while initializing
			Book javaBook=new Book(1, "Head first java",400);
			Book springBook=new Book(4, "Spring in action",500);
			Book pythonBook=new Book(3, "Learning Python",250);
			Book hiberanteBook=new Book(2, "Hibernate in action",300);
 
 
			BookIdMap.put(1,javaBook);
			BookIdMap.put(4,springBook);
			BookIdMap.put(3,pythonBook);
			BookIdMap.put(2,hiberanteBook);
		}
	}
 
	public List<Book> getAllBooks()
	{
		List<Book>  books = new ArrayList<>(BookIdMap.values());
		return books;
	}
 
	public Book getBook(int id)
	{
		Book Book= BookIdMap.get(id);
		return Book;
	}
	public Book addBook(Book Book)
	{
		Book.setId(getMaxId()+1);
		BookIdMap.put(Book.getId(), Book);
		return Book;
	}
 
	public Book updateBook(Book Book)
	{
		if(Book.getId()<=0)
			return null;
		BookIdMap.put(Book.getId(), Book);
		return Book;
 
	}
	public void deleteBook(int id)
	{
		BookIdMap.remove(id);
	}
 
	public static HashMap<Integer, Book> getBookIdMap() {
		return BookIdMap;
	}
 
	// Utility method to get max id
	public static int getMaxId()
	{ int max=0;
	for (int id:BookIdMap.keySet()) { 
		if(max<=id)
			max=id;
 
	} 
	return max;
	}
}