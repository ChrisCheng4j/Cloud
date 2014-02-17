package com.mic.dao.impl;

import java.math.BigInteger;
import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.mic.dao.AlbumDao;
import com.mic.model.Album;

@Repository
public class AlbumDaoImpl extends BaseDaoImpl<Album, Long> implements AlbumDao {

	public int getAlbumNum(final Long userId, final Long albumId) {

		final String sql = "select count(*) from useralbum where UserId = ? and Id = ?";
		
		return (Integer) getHibernateTemplate().execute(new HibernateCallback<Object>() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				
				Query query = session.createSQLQuery(sql);
				query.setLong(0, userId).setLong(1, albumId);
				
				return ((BigInteger)query.uniqueResult()).intValue();
			}
		});	
	}

}
