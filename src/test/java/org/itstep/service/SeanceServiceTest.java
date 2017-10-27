package org.itstep.service;

import org.itstep.App;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SeanceServiceTest {

	@Autowired
	private SeanceService seanceService; 
	
	@Before
	public void setData() {
		
	}
	
	@Test
	public void testGetOne() {
		
	}

	@Test
	public void testCreateOrUpdate() {
		
	}

	@Test
	public void testGetAll() {
		
	}

}
