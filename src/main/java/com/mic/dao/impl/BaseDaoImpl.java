package com.mic.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.mic.dao.BaseDao;

public class BaseDaoImpl<T, PK extends Serializable> implements BaseDao<T, PK> {
	
	private HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	
	private Class<T> entityClass;
	
	/**
	 * 通过反射获取子类Dao对应的泛型实体类
	 */
	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {
		Type genType = getClass().getGenericSuperclass();
		Type[] params = ((ParameterizedType)genType).getActualTypeArguments();
		entityClass = (Class<T>) params[0];
	}

	@SuppressWarnings("unchecked")
	public PK save(T t) {
		return (PK) hibernateTemplate.save(t);
	}

	public void update(T t) {
		hibernateTemplate.update(t);
	}

	public void delete(T t) {
		hibernateTemplate.delete(t);
	}

	public T get(PK id) {
		return hibernateTemplate.get(entityClass, id);
	}
}
