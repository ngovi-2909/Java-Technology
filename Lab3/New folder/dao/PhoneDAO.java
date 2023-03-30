package dao;

import lab3.tdtu.Phone;
import org.hibernate.Session;
import utils.HibernateUtils;

public class PhoneDAO {
    public boolean add(Phone item)
    {
        Session session = HibernateUtils.getFactory().openSession();
        try
        {
            session.beginTransaction();
            String phoneID = (String) session.save(item);
            session.getTransaction().commit();
            if(phoneID !=null)
            {
                return true;
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }
}
