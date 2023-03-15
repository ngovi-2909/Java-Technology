package tdtu.edu.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import tdtu.edu.model.Product;
import tdtu.edu.model.User;
import tdtu.edu.repository.Repository;
import tdtu.edu.utils.HibernateUtils;

public class ProductDao implements Repository<Product, Integer>{

	@Override
	public Integer add(Product item) {
		// TODO Auto-generated method stub
		Session session = null;
		try
		{
			session = HibernateUtils.getFactory().openSession();
			session.beginTransaction();
			Integer productID = (Integer) session.save(item);
			if(productID != 0)
			{
				session.close();
				return productID;
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
			if(session != null)
			{
				session.close();
			}
		}
		return null;
	}

	@Override
	public List<Product> getAll() {
		Session session = null;
        try
        {
            session = HibernateUtils.getFactory().openSession();
            Query q = session.createQuery("From Product");
            List<Product> list = q.getResultList();
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
	public Product get(Integer id) {
		Session session = null;
        try
        {
            session = HibernateUtils.getFactory().openSession();
            Query q = session.createQuery("From Product WHERE id = " + id);
            List<Product> list = q.getResultList();
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

	@Override
	public boolean update(Product item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(Product item) {
		// TODO Auto-generated method stub
		
		return false;
	}

	@Override
	public boolean removeById(Integer id) {
		// TODO Auto-generated method stub
		Session session = null;
        try
        {
            session = HibernateUtils.getFactory().openSession();
            Product item = (Product)session.get(Product.class, id);
            if(item !=null)
            {
                session.getTransaction().begin();
                session.delete(item);
                session.getTransaction().commit();
                return true;
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }finally {
            if(session != null)
            {
                session.close();
            }
        }
		return false;
	}

}
