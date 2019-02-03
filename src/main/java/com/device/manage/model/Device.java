package com.device.manage.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.*;

@Entity
@Table
public class Device {
	
	public enum Status 
	{ 
	    WORKING, IDLE, COMPLETE;
	}
	
	@Column
	@Id
	int device_id;
	
	@Column(length = 500)
	String description;
	
	@Column
	Status status;
	
//	@Column
//	int operator_id;
	
//	@Column
//	int protocol_id;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Device_Protocols", joinColumns = { @JoinColumn(name = "device_id") }, inverseJoinColumns = { @JoinColumn(name = "protocol_id") })
    Set<Protocol> device_protocols = new HashSet<Protocol>(0);
	
	@ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(name = "Device_User_Map", joinColumns = { @JoinColumn(name = "device_id") }, inverseJoinColumns = { @JoinColumn(name = "user_id") }
    )
    Set<User> deviceusers = new HashSet<>();
	
	public Device() {
		super();
	}
	
	public Device(int device_id, String description, Status status) {
		super();
		this.device_id = device_id;
		this.description = description;
		this.status = status;
	}
	
	public Device(int device_id, String description, Status status, Set<Protocol> device_protocols, Set<User> deviceusers) {
		super();
		this.device_id = device_id;
		this.description = description;
		this.status = status;
		this.device_protocols = device_protocols;
		this.deviceusers = deviceusers;
	}
	
	public int getDevice_id() {
		return device_id;
	}

	public void setDevice_id(int device_id) {
		this.device_id = device_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	public Set<Protocol> getDevice_protocols() {
		return device_protocols;
	}

	public void setDevice_protocols(Set<Protocol> device_protocols) {
		this.device_protocols = device_protocols;
	}

	public Set<User> getDeviceusers() {
		return deviceusers;
	}

	public void setDeviceusers(Set<User> deviceusers) {
		this.deviceusers = deviceusers;
	}
//	public int getProtocol_id() {
//		return protocol_id;
//	}
//
//	public void setProtocol_id(int protocol_id) {
//		this.protocol_id = protocol_id;
//	}

}
