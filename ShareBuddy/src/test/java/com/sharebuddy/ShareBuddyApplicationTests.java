package com.sharebuddy;
  
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
 
import com.shareBuddy.entities.ReqBook; 
import com.shareBuddy.repository.ReqBookRepository; 
import com.shareBuddy.service.impl.ReqBookServiceImpl; 

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShareBuddyApplicationTests {

   
    
    @Autowired
    ReqBookServiceImpl reqbookServiceImpl;
    
     
     
    @MockBean
    ReqBookRepository reqbookRepo;
    
     
    
    @Test
    public void getReqBook() {
    	when(reqbookRepo.findAll()).thenReturn(Stream.of(new ReqBook(1, "My India Edition Latest", "MH Gandhi", "JSW Publ", "2011-11-11", "English", "Management", "PaperBack", 22121, 205, 145, 170, "India is Known as Country of Dignity", 2),
    			new ReqBook(2, "Political Thesis", "Raj Barot", "New Books Publ", "2017-11-11", "English", "Management", "PaperBack", 22121, 205, 145, 170, "Indian Politics is really thrilling", 2)
    			) 
    			.collect(Collectors.toList()));
    	
    	assertEquals(2,reqbookServiceImpl.findAll().size());
    
    }
    
    
    @Test
    public void saveReqBookTest() {
    	
    	ReqBook rq = new ReqBook(6, "Shamchi aai", "Sane Guruji", "New Books Publ", "2017-11-11", "Marathi", "Management", "PaperBack", 22121, 205, 145, 170, "best selling Marathi Literature Novel", 2);
         
    	when(reqbookRepo.save(rq)).thenReturn(rq);
    	 
    	assertEquals(rq,reqbookServiceImpl.save(rq));
    	
    	
    }
    
    @Test
    public void deleteReqBook() {
    	
    	ReqBook rq = new ReqBook(7, "Shamchi aai", "Sane Guruji", "New Books Publ", "2017-11-11", "Marathi", "Management", "PaperBack", 22121, 205, 145, 170, "best selling Marathi Literature Novel", 2);
    	reqbookServiceImpl.remove(rq);
    	
    	verify(reqbookRepo , times(1)).delete(rq) ;
    	
    }
    
    
    }
    
    