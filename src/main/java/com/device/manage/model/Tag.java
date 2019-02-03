package com.device.manage.model;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Tag {
	
	public enum IsActive
	{ 
	    Y,N;
	}
	
	@Column
	@Id
	int tag_id;
	
	@Column(length = 200)
	String description;
    
	@Column
	IsActive is_active;
	
	@Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	Date created_on;
	
	@Column(columnDefinition = "int default 0")
	int taken;

	public Tag() {
		super();
	}
	
	public Tag(int tag_id, String description, IsActive is_active, Date created_on) {
		super();
		this.tag_id = tag_id;
		this.description = description;
		this.is_active = is_active;
		this.created_on = created_on;
	}
	public Tag(int tag_id, String description, IsActive is_active, Date created_on, int taken) {
		super();
		this.tag_id = tag_id;
		this.description = description;
		this.is_active = is_active;
		this.created_on = created_on;
		this.taken = taken;
	}
	public int getTaken() {
		return taken;
	}

	public void setTaken(int taken) {
		this.taken = taken;
	}

	public int getTag_id() {
		return tag_id;
	}

	public void setTag_id(int tag_id) {
		this.tag_id = tag_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public IsActive getIs_active() {
		return is_active;
	}

	public void setIs_active(IsActive is_active) {
		this.is_active = is_active;
	}

	public Date getCreated_on() {
		return created_on;
	}

	public void setCreated_on(Date created_on) {
		this.created_on = created_on;
	}
	
	

}
