package dao;

import lab3.tdtu.Manufacture;
import lab3.tdtu.Phone;
import org.hibernate.Session;
import utils.HibernateUtils;

public class ManufactureDAO {
    public boolean add(Manufacture item)
    {
        Session session = HibernateUtils.getFactory().openSession();
        try
        {
            session.beginTransaction();
            String id = (String) session.save(item);
            session.getTransaction().commit();
            if(id !=null)
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
