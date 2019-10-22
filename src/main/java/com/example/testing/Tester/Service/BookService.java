package com.example.testing.Tester.Service;

import com.example.testing.Tester.Entity.Book;
import com.example.testing.Tester.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
@Autowired
    private BookRepository bookRepository;
    public List<Book> show() {

        List<Book> al = new ArrayList<>();
        for (Book b : bookRepository.findAll()) {
            al.add(b);

        }
        return al;


    }

    public String add(Book book) {
        bookRepository.save(book);
        return "ADDED SUCCESSFULLY";

    }

    public Book find(int id) {
      return bookRepository.findById(id).get();
    }


    public String name(int id)
    {
        for(Book b:bookRepository.findAll())
        {
            if(b.getBookid()==id)
            {
                return b.getTitle();
            }
        }
        return null;
    }

    public String delete(int id) {

        for(Book b:bookRepository.findAll())
        {
            if(b.getBookid()==id)
            {
                bookRepository.delete(b);
            }
        }
        return "DELETED SUCCESSFULLY";

    }



}
