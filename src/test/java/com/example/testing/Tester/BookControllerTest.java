package com.example.testing.Tester;


import com.example.testing.Tester.Controller.BookController;
import com.example.testing.Tester.Entity.Book;
import com.example.testing.Tester.Service.BookService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(value = BookController.class)
public class BookControllerTest {
    @MockBean
    BookService bookService;
    @Autowired
    MockMvc mockMvc;

    @Test
    public void nameTest() throws Exception {
        Book book = new Book();
        book.setBookid(1);
        book.setTitle("billu");
        Mockito.when(bookService.name(book.getBookid())).thenReturn(book.getTitle());
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/name/1");
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        Assert.assertEquals(book.getTitle(), result.getResponse().getContentAsString());
    }


    @Test
    public void showTest() throws Exception {
        Book book = new Book();
        book.setBookid(1);
        book.setTitle("Yaman");
        Book book2 = new Book();
        book2.setBookid(2);
        book2.setTitle("Sahana");
        Mockito.when(bookService.show()).thenReturn(Arrays.asList(book, book2));
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/show").accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        Assert.assertEquals("[{\"bookid\":1,\"title\":\"Yaman\"},{\"bookid\":2,\"title\":\"Sahana\"}]", result.getResponse().getContentAsString());
    }

    @Test
    public void addTest() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/add")
                .content("{\"id\":1,\"title\":\"sahana\"}")
                .contentType(MediaType.APPLICATION_JSON);
        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk()).andReturn();
    }

    @Test
    public void deleteTest() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/delete/1");
       mockMvc.perform(requestBuilder)
                .andExpect(status().isOk()).andReturn();
    }

   @Test
   public void find() throws Exception {
       Book book=new Book();
       book.setBookid(1);
       book.setTitle("Yaman");
       Mockito.when(bookService.find(book.getBookid())).thenReturn(book);
       RequestBuilder requestBuilder=MockMvcRequestBuilders.get("/find/1");
       MvcResult result=mockMvc.perform(requestBuilder).andReturn();
       Assert.assertEquals("{\"bookid\":1,\"title\":\"Yaman\"}",result.getResponse().getContentAsString());


   }
}
//yamanisthebest

//sahanaisthebestest

//sahanayamanisthebest

//fghdjfgdcxe
//xfhgjjkjkjhgfd