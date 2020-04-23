package com.qa.demo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;

import com.qa.demo.data.domain.Train;
import com.qa.demo.data.repo.TrainRepo;
import com.qa.demo.dto.TrainDTO;
import com.qa.demo.services.TrainService;

@RunWith(MockitoJUnitRunner.class)
public class TrainServiceUnitTest {

	@Before
	public void init() {
		this.train = new Train("Henry", "Green");
		this.trainWithID = new Train(train.getName(), train.getColour());
		this.trainWithID.setId(ID);
		this.dto = new TrainDTO(ID, "Henry", "Green");
	}

	private final Long ID = 1L;
	private Train train;

	private Train trainWithID;

	private TrainDTO dto;

	@Mock
	private ModelMapper mapper;

	@Mock
	private TrainRepo repo;

	@InjectMocks
	private TrainService service;

	@Test
	public void create() {
		when(repo.save(train)).thenReturn(trainWithID);
		when(mapper.map(trainWithID, TrainDTO.class)).thenReturn(dto);

		assertEquals(dto, service.create(train));

		verify(repo, times(1)).save(train);
		verify(mapper, times(2)).map(trainWithID, TrainDTO.class);
	}

}
