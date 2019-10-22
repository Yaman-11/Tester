package com.example.testing.Tester;

import com.example.testing.Tester.Entity.Book;
import com.example.testing.Tester.Repository.BookRepository;
import com.example.testing.Tester.Service.BookService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
public class BookServiceTest {
@Mock
private BookRepository bookRepository;

@InjectMocks
private BookService bookService;

@Test
public void name()
{
    Book book=new Book();
    book.setBookid(1);
    book.setTitle("billu");
    Mockito.when(bookRepository.findAll()).thenReturn(Arrays.asList(book));
   String b= bookService.name(1);
    Assert.assertEquals(book.getTitle(),b);

}
@Test
public void show()
{
    Book book=new Book();
    book.setBookid(1);
    book.setTitle("Yaman");
    Book book2 =new Book();
    book2.setBookid(2);
    book2.setTitle("Sahana");
    Mockito.when(bookRepository.findAll()).thenReturn(Arrays.asList(book,book2));
    List<Book> b=bookService.show();
    Assert.assertEquals(Arrays.asList(book,book2),b);

}
    @Test
    public void add()
    {
        Book book=new Book();
        book.setBookid(1);
        book.setTitle("Yama");
        Mockito.when(bookRepository.findAll()).thenReturn(Arrays.asList(book));
        ResponseEntity<List<Book>> b= bookService.add(book);
        Assert.assertEquals(new ResponseEntity<>(Arrays.asList(book), HttpStatus.OK),b);
    }

    @Test
    public void findServiceTest(){
        Book book=new Book();
        book.setBookid(1);
        book.setTitle("yaman");
        Mockito.when(bookRepository.findById(book.getBookid())).thenReturn(Optional.of((book)));
        Book s= bookService.find(1);
        Assert.assertEquals(book,s);
    }

    @Test
    public void deleteServiceTest(){
        Book book=new Book();
        book.setBookid(1);
        book.setTitle("yaman");
        String s= bookService.delete(book.getBookid());
        Assert.assertEquals("DELETED SUCCESSFULLY",s);

   }
}
//bhfdsbfshbfhsbdfjsbdhbsfdhsfjdbfjsdbfhsdbfjhfbfsdff