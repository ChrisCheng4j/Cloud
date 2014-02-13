package com.mic.dao;

import org.springframework.orm.hibernate3.HibernateTemplate;

public interface BaseDao<T,PK> {
	
	public HibernateTemplate getHibernateTemplate();
	
	PK save(T entity);
	
	void update(T entity);
	
	void delete(T entity);
	
	T get(PK id);
}
