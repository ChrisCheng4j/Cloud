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
@Table(name = "UserInfo")
public class UserInfo implements Serializable {
	
	private static final long serialVersionUID = -6199564308715297081L;

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
	
	@Column(name = "Establish", nullable = false)
	private Date establish;
	
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
	
	public Date getEstablish() {
		return establish;
	}
	
	public void setEstablish(Date establish) {
		this.establish = establish;
	}
}
