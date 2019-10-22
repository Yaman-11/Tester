package com.example.testing.Tester;

import com.example.testing.Tester.Entity.Book;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class TesterApplicationTests {

	@Autowired
	private TestRestTemplate testRestTemplate;

	HttpHeaders httpHeaders=new HttpHeaders();


	@Test
	void show() {
		String response=testRestTemplate.getForObject("/show",String.class);
		DocumentContext documentContext=JsonPath.parse(response);
		int n=documentContext.read("$.length()");
		Assert.assertEquals(4,n);
	}


	@Test
	public void add(){
		Book book=new Book();
		book.setBookid(6);
		book.setTitle("deepika");
		HttpEntity<Book> httpEntity=new HttpEntity<Book>(book,httpHeaders);
		ResponseEntity<String> response=testRestTemplate.exchange(createUrl("/add"),
				HttpMethod.POST,httpEntity,String.class);
        Assert.assertEquals("ADDED SUCCESSFULLY",response.getBody());
	}

	@Test
	public void findpoora(){
		HttpEntity<String> httpEntity=new HttpEntity<String>(null,httpHeaders);
		ResponseEntity<String> response=testRestTemplate.exchange(createUrl("/find/1"), HttpMethod.GET,httpEntity,String.class);
		Assert.assertEquals("{\"bookid\":1,\"title\":\"yaman\"}",response.getBody());

	}
	@Test
   public void name()
	{
		HttpEntity<String> httpEntity=new HttpEntity<String>(null,httpHeaders);
		ResponseEntity<String> response=testRestTemplate.exchange(createUrl("/name/1"), HttpMethod.GET,httpEntity,String.class);
		Assert.assertEquals("yaman",response.getBody());

	}
	@Test
	public void delete()
	{
		HttpEntity<String> httpEntity=new HttpEntity<String>(null,httpHeaders);
		ResponseEntity<String> response=testRestTemplate.exchange(createUrl("/delete/5"), HttpMethod.POST,httpEntity,String.class);
        Assert.assertEquals("200 OK",response.getStatusCode().toString());
	}




	public String createUrl(String url){
		return "http://localhost:8080"+url;
	}
}
