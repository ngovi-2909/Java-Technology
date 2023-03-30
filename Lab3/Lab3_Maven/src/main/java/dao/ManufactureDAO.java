package dao;

import lab3.tdtu.Manufacture;
import lab3.tdtu.Phone;
import org.hibernate.Session;
import org.hibernate.query.Query;
import repository.Repository;
import utils.HibernateUtils;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class ManufactureDAO implements Repository<Manufacture, Long> {
    @Override
    public Long add(Manufacture item)
    {
        Session session = null;
        try
        {
            session = HibernateUtils.getFactory().openSession();
            session.beginTransaction();
            Long id = (Long) session.save(item);
            session.getTransaction().commit();
            if(id != 0)
            {
                return id;
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }finally{
            if(session != null)
            {
                session.close();
            }
        }
        return null;
    }

    @Override
    public List<Manufacture> getAll() {
        Session session = null;
        try
        {
            session = HibernateUtils.getFactory().openSession();
            Query q = session.createQuery("From Manufacture");
            return q.getResultList();
        }catch(Exception e)
        {
            e.printStackTrace();
        }finally
        {
            if(session !=null)
            {
                session.close();
            }
        }
        return null;
    }

    @Override
    public Manufacture get(Long id) {
        Session session = null;
        try
        {
            session = HibernateUtils.getFactory().openSession();
            Query q = session.createQuery("From Manufacture WHERE id = " + id);
            List<Manufacture> list = q.getResultList();
            session.close();
            return list.stream().filter(c->c.getID() == id).findFirst().orElse(null);
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
    public boolean update(Manufacture item) {
        Session session = null;
        try
        {
            session = HibernateUtils.getFactory().openSession();
            session.getTransaction().begin();
            Manufacture manufacture = get(item.getID());
            if(manufacture !=null)
            {
                session.update(item);
                session.getTransaction().commit();
                return true;
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }finally{
            if(session != null)
            {
                session.close();
            }
        }
        return false;
    }

    @Override
    public boolean remove(Manufacture item) {
        Session session = null;
        try
        {
            session = HibernateUtils.getFactory().openSession();
            session.getTransaction().begin();
            if(item !=null)
            {
                session.delete(item);
                session.getTransaction().commit();
                return true;
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
        return false;
    }

    @Override
    public boolean removeById(Long id) {
        Session session = null;
        try
        {
            session = HibernateUtils.getFactory().openSession();
            Manufacture item = (Manufacture)session.get(Manufacture.class, id);
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
        }finally
        {
            if(session != null)
            {
                session.close();
            }
        }
        return false;
    }
    public List<Manufacture> checkEmployees()
    {
        Session session = null;
        try
        {
            session = HibernateUtils.getFactory().openSession();
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Manufacture> cr = cb.createQuery(Manufacture.class);
            Root<Manufacture> root = cr.from(Manufacture.class);
            cr.select(root).where(cb.gt(root.get("Employee"),100));
            Query<Manufacture> query = session.createQuery(cr);
            List<Manufacture> list = query.getResultList();
            return list;
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            if(session !=null)
            {
                session.close();
            }
        }
        return null;
    }
    public List<Integer> sumaryEmployees()
    {
        Session session = null;
        try
        {
            session = HibernateUtils.getFactory().openSession();
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Integer> cr = cb.createQuery(Integer.class);
            Root<Manufacture> root = cr.from(Manufacture.class);
            cr.select(cb.sum(root.get("Employee")));
            Query<Integer> query = session.createQuery(cr);
            List<Integer> sum = query.getResultList();
            return sum;
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            if(session !=null)
            {
                session.close();
            }
        }
        return null;
    }

    public List<Manufacture> getLastManufactuterInUS()
    {
        Session session = null;
        try
        {
            session = HibernateUtils.getFactory().openSession();
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Phone> cr = cb.createQuery(Phone.class);
            CriteriaQuery<Manufacture> cr1 = cb.createQuery(Manufacture.class);

            Root<Phone> root = cr.from(Phone.class);
            cr.select(root).where(root.get("Country").in("US"));

            Root<Manufacture> root1 = cr1.from(Manufacture.class);
            cr1.orderBy(cb.desc(root1.get("ID")));
            cr1.select(root1).where(root.get("Country").in("US"));
            Query<Manufacture> query = session.createQuery(cr1);
            query.setMaxResults(1);
            List<Manufacture> list = query.getResultList();
            return list;
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            if(session !=null)
            {
                session.close();
            }
        }
        return null;
    }
}
