package com.mic.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "userinfo")
public class UserInfo implements Serializable {
	
	private static final long serialVersionUID = -6199564308715297081L;
	
	public UserInfo() {
		
	}
	
	public UserInfo(String name, String email, String tel, String pwd, String nickname) {
		this.name = name;
		this.email = email;
		this.tel = tel;
		this.pwd = pwd;
		this.nickname = nickname;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	
	@Column(name = "Name", unique = true, nullable = false)
	private String name;
	
	@Column(name = "Email", unique = true)
	private String email;
	
	@Column(name = "Tel", unique = true)
	private String tel;
	
	@Column(name = "Pwd", nullable = false)
	private String pwd;
	
	@Column(name = "Nickname")
	private String nickname;
	
	@Column(name = "CreationDate", nullable = false)
	private Date creationDate = new Date();
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getTel() {
		return tel;
	}
	
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public String getPwd() {
		return pwd;
	}
	
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	public String getNickname() {
		return nickname;
	}
	
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public Date getCreationDate() {
		return creationDate;
	}
	
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
}
