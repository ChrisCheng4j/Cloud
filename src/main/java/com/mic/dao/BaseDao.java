package com.mic.dao;

import org.springframework.orm.hibernate3.HibernateTemplate;

public interface BaseDao<T,PK> {
	
	public HibernateTemplate getHibernateTemplate();
	
	PK save(T t);
	
	void update(T t);
	
	void delete(T t);
	
	T get(PK id);
}
