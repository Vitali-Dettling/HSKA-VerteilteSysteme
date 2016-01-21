package org.eshop.account.model.database.dataAccessObjects;

import java.util.List;

import org.eshop.account.model.database.GenericHibernateDAO;
import org.eshop.account.model.database.dataobjects.User;
import org.eshop.account.model.sessionFactory.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class UserDAO extends GenericHibernateDAO<User, Integer> {
	
	public User getUserByUsername(String name) {
	    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try
		{
			User user = null;
			session.beginTransaction();
            Criteria crit = session.createCriteria(User.class);
            crit.add(Restrictions.eq("username",name));
            List<User> resultList = crit.list();
            if (resultList.size() > 0) {
            	user = (User) crit.list().get(0);
            }
            session.getTransaction().commit();
            return user;
		}
		catch (HibernateException e)
		{
			System.out.println("Hibernate Exception" + e.getMessage());
			session.getTransaction().rollback();
			throw new RuntimeException(e);
		}
	}



}
