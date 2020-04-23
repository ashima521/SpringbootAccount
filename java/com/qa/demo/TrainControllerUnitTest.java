package com.qa.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;

import com.qa.demo.data.domain.Train;
import com.qa.demo.dto.TrainDTO;
import com.qa.demo.rest.TrainController;
import com.qa.demo.services.TrainService;

@RunWith(MockitoJUnitRunner.class)
public class TrainControllerUnitTest {

	private Long id = 1L;

	private Train train;

	private TrainDTO trainDTO;

	private ModelMapper mapper = new ModelMapper();

	@Mock
	private TrainService service;

	@InjectMocks
	private TrainController controller;

	@Before
	public void init() {
		this.train = new Train("Henry", "Green");
		this.trainDTO = this.mapper.map(train, TrainDTO.class);
		this.trainDTO.setId(id);
	}

	@Test
	public void testEquals() {
		assertEquals(train, new Train("Henry", "Green"));
	}

	@Test
	public void testCreate() {
		Mockito.when(this.service.create(train)).thenReturn(trainDTO);

		assertEquals(this.controller.create(train), trainDTO);

		Mockito.verify(this.service, times(1)).create(train);

	}

}
