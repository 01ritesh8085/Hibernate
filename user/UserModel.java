package com.rays.user;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;

public class UserModel {

	public void add(UserDto dto) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		session.save(dto);

		tx.commit();
		session.close();

	}

	public void update(UserDto dto) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		session.update(dto);

		tx.commit();

		session.close();
	}

	public void delete(UserDto dto) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		session.delete(dto);

		tx.commit();

		session.close();

	}

	public UserDto findByPk(int pk) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		UserDto dto = (UserDto) session.get(UserDto.class, pk);

		session.close();

		return dto;

	}

	public UserDto authenticate(String login, String password) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		Query q = session.createQuery("from UserDTO where loginId = ? and password = ?");

		q.setString(0, login);
		q.setString(1, password);

		List list = q.list();

		UserDto dto = null;

		if (list.size() > 0) {

			dto = (UserDto) list.get(0);

		}
		session.close();
		return dto;
	}

	public UserDto authenticateByCriteria(String login, String password) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		Criteria criteria = session.createCriteria(UserDto.class);

		criteria.add(Restrictions.eq("loginId", login));

		criteria.add(Restrictions.eq("password", password));

		List list = criteria.list();

		UserDto dto = null;

		if (list.size() > 0) {

			dto = (UserDto) list.get(0);

		}

		session.close();

		return dto;
	}

	public List search(UserDto dto, int pageNo, int pageSize) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		Criteria criteria = session.createCriteria(UserDto.class);

		if (dto != null) {

			if (dto.getFirstName() != null && dto.getFirstName().length() > 0) {

				criteria.add(Restrictions.like("firstName", dto.getFirstName() + "%"));

			}
		}

		if (pageSize > 0) {
			pageNo = (pageNo - 1) * pageSize;
			criteria.setFirstResult(pageNo);
			criteria.setMaxResults(pageSize);
		}

		List list = criteria.list();

		session.close();

		return list;

	}

}
