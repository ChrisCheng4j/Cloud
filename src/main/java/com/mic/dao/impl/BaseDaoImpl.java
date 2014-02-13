package com.mic.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.mic.dao.BaseDao;

public class BaseDaoImpl<T, PK extends Serializable> implements BaseDao<T, PK> {
	
	private HibernateTemplate hibernateTemplate;
	private Session session;
	private Class<T> entityClass;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	
	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		if (null == hibernateTemplate)
			hibernateTemplate = new HibernateTemplate(sessionFactory);
		
		if(null == session)
			session = sessionFactory.openSession();
	}
	
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
	public PK save(T entity) {
		PK pk = (PK) hibernateTemplate.save(entity);
		getHibernateTemplate().evict(entity);
		
		return pk;
	}

	public void update(T entity) {
		hibernateTemplate.update(entity);
	}

	public void delete(T entity) {
		hibernateTemplate.delete(entity);
	}

	public T get(PK id) {
		return hibernateTemplate.get(entityClass, id);
	}
}
