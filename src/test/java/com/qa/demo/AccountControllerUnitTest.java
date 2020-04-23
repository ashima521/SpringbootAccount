package com.qa.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.account.persistence.domain.Account;
import com.qa.account.rest.AccountController;
import com.qa.account.service.AccountService;

@RunWith(MockitoJUnitRunner.class)
public class AccountControllerUnitTest {
	
	private Account account;
	private long id = 1L;
	
	@Mock
	private AccountService service;

	@InjectMocks
	private AccountController controller;
	
	@Before
	public void init() {
		this.account = new Account("firstname", "lastname", "b456789", 50.0);
		this.account.setId(id);
	}
	
	@Test
	public void testEquals() {
		assertEquals(account, new Account("firstname", "lastname", "b456789", 50.0));
		
	}
	
	
}
