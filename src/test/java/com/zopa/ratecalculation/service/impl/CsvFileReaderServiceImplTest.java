package com.zopa.ratecalculation.service.impl;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.zopa.ratecalculation.model.Offer;
import com.zopa.ratecalculation.service.CVSReaderService;

@RunWith(JUnit4.class)
public class CsvFileReaderServiceImplTest {

	private CVSReaderService cvsReaderService;
	private String filePath = "src/test/resources/MarketDataforExercise.csv";
	
	@Before
	public void setUp() throws Exception {
		cvsReaderService = new CsvFileReaderServiceImpl(filePath);
	}

	@Test
	public void testReadAndProcessFile() {
		System.out.println("filePath : " + filePath);
		
		try {
			
			List<Offer> offers = cvsReaderService.getAvailableOffers();
			Assert.assertNotNull(offers);
			assertEquals("Confirm that 7 offers have been loaded", 7, offers.size());
			
			offers.forEach(System.out::println);
			Assert.assertNotNull(offers);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
    public void getLastAvailableOffersSortedLast() throws IOException {
        // Arrange
        List<Offer> offers = cvsReaderService.getAvailableOffers();

        // Assert
        assertEquals("The last after sort should be Mary", "Mary", offers.get(6).getLender());
    }
	
	
	@Test
    public void getAvailableOffersSortedFirst() throws IOException {
        // Arrange
        List<Offer> offers = cvsReaderService.getAvailableOffers();

        // Assert
        assertEquals("The first after sort should be Jane", "Jane", offers.get(0).getLender());
    }
	
	@Test
    public void getLastAvailableOffersSortedSecond() throws IOException {
        // Arrange
        List<Offer> offers = cvsReaderService.getAvailableOffers();

        // Assert
        assertEquals("The second  sort should be Fred", "Fred", offers.get(1).getLender());
    }
	 


}
