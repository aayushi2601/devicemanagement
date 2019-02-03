package com.device.manage.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class User {
//
//	public int getDevice_id() {
//		return device_id;
//	}
//
//	public void setDevice_id(int device_id) {
//		this.device_id = device_id;
//	}

	@Column
	@Id
	int user_id;
	
	@Column(length = 500)
	String user_name;
	
	@Column(length = 200)
	@JsonIgnore
	String email;

//	@Column
//	int device_id;
	
	@Column
	int tag_id;
	
	@ManyToMany(mappedBy = "deviceusers")
	@JsonIgnore
	Set<Device> userdevices = new HashSet<>();

//	@OneToMany(mappedBy = "user",cascade=CascadeType.ALL)
//	Set<Device_User_Map> userdevices = new HashSet<>();
	
	public int getTag_id() {
		return tag_id;
	}

	public void setTag_id(int tag_id) {
		this.tag_id = tag_id;
	}

	public Set<Device> getUserdevices() {
		return userdevices;
	}

	public void setUserdevices(Set<Device> userdevices) {
		this.userdevices = userdevices;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public User()
	{
		super();
	}
	public User(int user_id, String user_name, String email, int tag_id) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.email = email;
		this.tag_id = tag_id;
	}
	public User(int user_id, String user_name, String email, int tag_id, Set<Device> userdevices) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.email = email;
		this.tag_id = tag_id;
		this.userdevices = userdevices;
	}
}
