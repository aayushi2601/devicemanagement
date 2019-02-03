package com.device.manage.model;

import java.util.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Protocol {

	@Column
	@Id
	int protocol_id;
	
	@Column(length = 200)
	String title;
	
	@Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	Date created_on;
	
	@Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	Date effectivity_date;
	
	@Column(columnDefinition = "int default 0")
	int is_taken;
	
	public Protocol()
	{
		super();
	}
	public Protocol(int protocol_id, String title, Date created_on, Date effectivity_date, int is_taken) {
		super();
		this.protocol_id = protocol_id;
		this.title = title;
		this.created_on = created_on;
		this.effectivity_date = effectivity_date;
		this.is_taken = is_taken;
	}
	
	public Protocol(int protocol_id, String title, Date created_on, Date effectivity_date) {
		super();
		this.protocol_id = protocol_id;
		this.title = title;
		this.created_on = created_on;
		this.effectivity_date = effectivity_date;
	}

	public int getIs_taken() {
		return is_taken;
	}
	public void setIs_taken(int is_taken) {
		this.is_taken = is_taken;
	}
	public int getProtocol_id() {
		return protocol_id;
	}

	public void setProtocol_id(int protocol_id) {
		this.protocol_id = protocol_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getCreated_on() {
		return created_on;
	}
	public void setCreated_on(Date created_on) {
		this.created_on = created_on;
	}
	public Date getEffectivity_date() {
		return effectivity_date;
	}

	public void setEffectivity_date(Date effectivity_date) {
		this.effectivity_date = effectivity_date;
	}
}
