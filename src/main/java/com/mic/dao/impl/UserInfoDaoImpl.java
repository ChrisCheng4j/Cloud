package com.mic.dao.impl;

import java.math.BigInteger;
import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.mic.dao.UserInfoDao;
import com.mic.model.UserInfo;

@Repository
public class UserInfoDaoImpl extends BaseDaoImpl<UserInfo, Long> implements UserInfoDao {

 	public int getUserInfoNum(final String name, final String email, final String tel) {
		
		final String sql = "select count(*) from userinfo where Name=? or Email=? or Tel=?";
		
		return  (Integer) getHibernateTemplate().execute(new HibernateCallback<Object>() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {

				Query query = session.createSQLQuery(sql);
				query.setString(0, name).setString(1, email).setString(2, tel);
				
				return ((BigInteger)query.uniqueResult()).intValue();
			}	
		});
	}

}
