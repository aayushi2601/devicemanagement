package com.device.manage;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.device.manage.model.Device;
import com.device.manage.model.Device.Status;
import com.device.manage.model.Protocol;
import com.device.manage.model.Tag;
import com.device.manage.model.Tag.IsActive;
import com.device.manage.model.User;
import com.device.manage.service.IDeviceRepository;
import com.device.manage.service.IProtocolRepository;
import com.device.manage.service.ITagRepository;
import com.device.manage.service.IUserRepository;

@SpringBootApplication
public class DevicemanagementApplication implements CommandLineRunner{

	@Autowired
	IProtocolRepository repo1;
	@Autowired
	ITagRepository repo2;
	@Autowired
	IUserRepository repo3;
	@Autowired
	IDeviceRepository repo4;
	
	public static void main(String[] args) {
		SpringApplication.run(DevicemanagementApplication.class, args);
		
	}
	@Override
	public void run(String... args) throws Exception {
		  List<Protocol> protocols = new ArrayList<>();
		  protocols.add(new Protocol(1,"Protocol1",new Date(1549180645000l), new Date(1549180645000l)));
		  protocols.add(new Protocol(2,"Protocol2",new Date(), new Date(15680)));
		  protocols.add(new Protocol(3,"Protocol3",new Date(1549180645000l), new Date(1549180645000l)));
		  for(Protocol p : protocols)
		   	repo1.save(p);
		  List<Tag> tags = new ArrayList<>();
		  tags.add(new Tag(1,"Admin", IsActive.Y, new Date(1549180645)));
		  tags.add(new Tag(2,"Manager", IsActive.N, new Date(15680)));
		  tags.add(new Tag(3,"Opearator", IsActive.Y, new Date(15680)));
		  for(Tag t : tags)
		   	repo2.save(t);
		  List<User> users = new ArrayList<>();
		  users.add(new User(101,"user1", "aaa@gmail.com", 1));
		  users.add(new User(102,"user2", "aaa@gmail.com", 2));
		  users.add(new User(103,"user3", "aaa@gmail.com", 3));
		  for(User t : users)
		   	repo3.save(t);
		  List<Device> devices = new ArrayList<>();
		  devices.add(new Device(11,"Device1", Status.COMPLETE));
		  devices.add(new Device(22,"Device2", Status.COMPLETE));
		  devices.add(new Device(33,"Device3", Status.COMPLETE));
		  for(Device d : devices)
		   	repo4.save(d);
		  
	}

}

