package dao;

import lab3.tdtu.Phone;
import org.hibernate.Session;
import org.hibernate.query.Query;
import repository.Repository;
import utils.HibernateUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;


public class PhoneDAO implements Repository<Phone, Long> {
    @Override
    public Long add(Phone item)
    {
        Session session = null;
        try
        {
            session = HibernateUtils.getFactory().openSession();
            session.beginTransaction();
            Long phoneID = (Long) session.save(item);
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
    public List<Phone> getAll() {
        Session session = null;
        try
        {
            session = HibernateUtils.getFactory().openSession();
            Query q = session.createQuery("From Phone");
            List<Phone> list = q.getResultList();
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
    public Phone get(Long id) {
        Session session = null;
        try
        {
            session = HibernateUtils.getFactory().openSession();
            Query q = session.createQuery("From Phone WHERE id = " + id);
            List<Phone> list = q.getResultList();
            session.close();
            return list.stream().filter(c->c.getID() == id).findFirst().orElse(null);
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
    public boolean update(Phone item) {
        Session session = null;
        try
        {
            session = HibernateUtils.getFactory().openSession();
            session.getTransaction().begin();
            Phone phone = get(item.getID());
            if(phone !=null)
            {
                session.update(item);
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

    @Override
    public boolean remove(Phone item) {
        Session session = null;
        try
        {
            session = HibernateUtils.getFactory().openSession();
            session.getTransaction().begin();
            session.delete(item);
            session.getTransaction().commit();
            return true;
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

    @Override
    public boolean removeById(Long id) {
        Session session = null;
        try
        {
            session = HibernateUtils.getFactory().openSession();
            Phone item = (Phone)session.get(Phone.class, id);
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
    public List<Phone> getHighestPrice()
    {
        Session session = null;
        try
        {
            session = HibernateUtils.getFactory().openSession();
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Double> cr = cb.createQuery(Double.class);
            Root<Phone> root = cr.from(Phone.class);
            cr.select(cb.max(root.get("Price")));
            Query<Double> query = session.createQuery(cr);
            Double max = query.getSingleResult();

            CriteriaQuery<Phone> cr2 = cb.createQuery(Phone.class);
            Root<Phone> root2 = cr2.from(Phone.class);
            cr2.select(root2).where(cb.equal(root2.get("Price"),max));
            Query<Phone> query2 = session.createQuery(cr2);
            List<Phone> list = query2.getResultList();
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
    public List<Phone> sortByName()
    {
        Session session = null;
        try
        {
            session = HibernateUtils.getFactory().openSession();
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Phone> cr = cb.createQuery(Phone.class);
            Root<Phone> root = cr.from(Phone.class);
            cr.orderBy(cb.asc(root.get("Country")),cb.desc(root.get("Price")));
            Query<Phone> query = session.createQuery(cr);
            List<Phone> list = query.getResultList();
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
    public List<Phone> priceHighestThan50Mil()
    {
        Session session = null;
        try
        {
            session = HibernateUtils.getFactory().openSession();
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Phone> cr = cb.createQuery(Phone.class);
            Root<Phone> root = cr.from(Phone.class);
            cr.select(root).where(cb.gt(root.get("Price"), 50000000));
            Query<Phone> query = session.createQuery(cr);
            List<Phone> list = query.getResultList();
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
    public List<Phone> phoneWithPink_andGreater15Mil()
    {
        Session session = null;
        try
        {
            session = HibernateUtils.getFactory().openSession();
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Phone> cr = cb.createQuery(Phone.class);
            Root<Phone> root = cr.from(Phone.class);
            Predicate colorPink = root.get("Color").in("Pink", "pink");
            Predicate greater15Mil = cb.gt(root.get("Price"), 15000000);
            cr.select(root).where(cb.and(colorPink, greater15Mil));
            Query<Phone> query = session.createQuery(cr);
            query.setFirstResult(0);
            query.setMaxResults(1);
            List<Phone> list = query.getResultList();
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
}
