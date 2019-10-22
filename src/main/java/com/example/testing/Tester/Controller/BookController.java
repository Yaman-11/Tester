package com.example.testing.Tester.Controller;

import com.example.testing.Tester.Entity.Book;
import com.example.testing.Tester.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

@Autowired
    private BookService bookService;
    @RequestMapping(method = RequestMethod.GET,value="/show")
    public List<Book> show()
    {
        return bookService.show();

    }

    @RequestMapping(method = RequestMethod.POST,value="/add")
    public String add(@RequestBody Book book)
    {
        return bookService.add(book);
    }

    @RequestMapping(method = RequestMethod.GET,value="/find/{id}")
    public Book find(@PathVariable int id)
    {
        return bookService.find(id);

    }

    @RequestMapping(method = RequestMethod.GET,value="/name/{id}")
    public String name(@PathVariable  int id)
    {
        return bookService.name(id);
    }

    @RequestMapping(method = RequestMethod.POST,value="delete/{id}")
    public String delete(@PathVariable int id)
    {
        return bookService.delete(id);
    }

}
//fjhisksda
//edfhjkskaf
//yaman
//sahana