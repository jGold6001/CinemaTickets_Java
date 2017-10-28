package org.itstep.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.itstep.App;
import org.itstep.dao.pojo.Cinema;
import org.itstep.dao.pojo.City;
import org.itstep.test_data_collections.Cinemas;
import org.itstep.test_data_collections.Cities;
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
public class CinemaServiceTest {

	@Autowired
	private CinemaService cinemaService;
	
	@Autowired
	private CityService cityService;
	
	private List<Cinema> cinemas;
	private Cinema cinema;
	private City city;
	
	@Before
	public void setData() {
		cinemas = Cinemas.getCinemas();
		cinema = cinemas.get(0);
		city = Cities.getCities().get(0);
	}
	
	@Test
	public void test1CreateOrUpdate() {
		cityService.createOrUpdate(city);
		for (Cinema cinema : cinemas) {
			cinema.setCity(city);
			cinemaService.createOrUpdate(cinema);
		}
	}
	
	@Test
	public void test2GetOneString() {
		Cinema cinemaInDb = cinemaService.getOne(cinema.getName());
		assertEquals(cinemaInDb.getName(), cinema.getName());
	}
//
//	@Test
//	public void test3GetAll() {
//		 List<Cinema> cinemasInDb = cinemaService.getAll();
//		 assertEquals(cinemasInDb.get(0).getName(), cinemas.get(0).getName());
//	}

	@Test
	public void test4GetAllByCity() {
		
		
	}
	
	@Test
	public void test5Delete() {
		City city = cityService.getAll().get(0);
		cityService.delete(city.getId());
		
		List<Cinema> cinemasInDb = cinemaService.getAll();
		for (Cinema cinema : cinemasInDb) {
				cinemaService.delete(cinema.getId());
		}
		
	}


}
