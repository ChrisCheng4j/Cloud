package com.mic.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "useralbum")
public class UserAlbum implements Serializable {
	
	public UserAlbum() {
		
	}
	
	public UserAlbum(Long userId, String name, String classification, String status) {
		this.userId = userId;
		this.name = name;
		this.classification = classification;
		this.status = status;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "UserId", unique = true, nullable = false)
	private Long userId;
	
	@Column(name = "Name", unique = true, nullable = false)
	private String name;
	
	@Column(name = "Classification", nullable = false)
	private String classification;
	
	@Column(name = "Status", nullable = false)
	private String status;
	
	@Column(name = "CreationDate", nullable = false)
	private Date creationDate = new Date();
	
	@Column(name = "updateDate", nullable = false)
	private Date updateDate;
	
	@Column(name = "lastUpdate")
	private Date lastUpdate;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getUserId() {
		return userId;
	}
	
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getClassification() {
		return classification;
	}
	
	public void setClassification(String classification) {
		this.classification = classification;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Date getCreationDate() {
		return creationDate;
	}
	
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	public Date getUpdateDate() {
		return updateDate;
	}
	
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
	public Date getLastUpdate() {
		return lastUpdate;
	}
	
	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
}
