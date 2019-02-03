package com.device.manage.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.device.manage.model.User;
import com.device.manage.service.DeviceService;

@RestController
public class DeviceController {
	
		@Autowired
		DeviceService repo;
		
		@GetMapping("users")
		public ResponseEntity<List<User>> getAllUsers() throws Exception
		{
			 List<User> test = repo.getAllUsers();
			 return new ResponseEntity<List<User>>(test,HttpStatus.OK);
		}
		
	}

