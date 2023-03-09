package tdtu.edu.dao;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import tdtu.edu.model.User;
import tdtu.edu.repository.*;
import tdtu.edu.utils.HibernateUtils;

public class UserDao implements Repository<User, Integer>{

	@Override
	public Integer add(User item) {
		// TODO Auto-generated method stub
		Session session = null;
        try
        {
            session = HibernateUtils.getFactory().openSession();
            session.beginTransaction();
            Integer phoneID = (Integer) session.save(item);
            session.getTransaction().commit();
            if(phoneID != 0)
            {
                session.close();
                return phoneID;
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }finally {
            if(session !=null)
            {
                session.close();
            }
        }
        return null;

	}

	@Override
	public List<User> getAll() {
		Session session = null;
        try
        {
            session = HibernateUtils.getFactory().openSession();
            Query q = session.createQuery("From User");
            List<User> list = q.getResultList();
            session.close();
            return list;
        }catch(Exception e)
        {
            e.printStackTrace();
        }finally {
            if(session !=null)
            {
                session.close();
            }
        }
        return null;
	}

	@Override
	public User get(Integer id) {
		 Session session = null;
	        try
	        {
	            session = HibernateUtils.getFactory().openSession();
	            Query q = session.createQuery("From User WHERE id = " + id);
	            List<User> list = q.getResultList();
	            session.close();
	            return list.stream().filter(c->c.getId() == id).findFirst().orElse(null);
	        }catch(Exception e)
	        {
	            e.printStackTrace();
	        }finally {
	            if(session != null)
	            {
	                session.close();
	            }
	        }
	        return null;
	}
	public boolean checkUsername(String username)
	{
		List<User> list = getAll();
		for(User i: list)
		{
			if(i.getName().equals(username))
				return true;
		}
		return false;
	}
	public boolean checkEmail(String email)
	{
		List<User> list = getAll();
		for(User i: list)
		{
			if(i.getEmail().equals(email))
				return true;
		}
		return false;
	}
	public boolean checkPassword(String password)
	{
		List<User> list = getAll();
		for(User i: list)
		{
			if(i.getPassword().equals(password))
				return true;
		}
		return false;
	}
	@Override
	public boolean update(User item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(User item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeById(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	

}
