package com.example.testing.Tester;


import com.example.testing.Tester.Entity.Book;
import com.example.testing.Tester.Repository.BookRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest
{
    @Autowired
    private BookRepository bookRepository;

     @Test
    public void show()
     {
         List<Book> b= (List<Book>) bookRepository.findAll();
         Assert.assertNotNull(b);


     }



    @Test
    public void addTest(){
        Book books1=new Book();
        books1.setBookid(1);
        books1.setTitle("yaman");
        bookRepository.save(books1);
        Iterable<Book> b=bookRepository.findAll();
        List<Book> bb= (List<Book>) b;
        Assert.assertEquals(books1.getTitle(),bb.get(0).getTitle());
        Assert.assertEquals(books1.getBookid(),bb.get(0).getBookid());
    }

    @Test
    public void findTest()
    {
        Book books1=new Book();
        books1.setBookid(1);
        books1.setTitle("yaman");
        bookRepository.save(books1);
        Book b=bookRepository.findById(1).get();
        Assert.assertEquals(books1.getTitle(),b.getTitle());
        Assert.assertEquals(books1.getBookid(),b.getBookid());
    }

    @Test
    public void deleteTest(){
        Book books1=new Book();
        books1.setBookid(1);
        books1.setTitle("yaman");
        bookRepository.save(books1);
        bookRepository.delete(books1);
        Assert.assertEquals(0,bookRepository.count());
    }

}
