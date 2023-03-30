package tdtu.edu.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import tdtu.edu.model.*;
import java.util.Properties;

public class HibernateUtils {
    private static final SessionFactory FACTORY;
    static{
        Configuration conf=new Configuration();
        Properties props = new Properties();
        
        conf.configure("hibernate.cfg.xml");
        conf.addAnnotatedClass(User.class);
        conf.addAnnotatedClass(Product.class);
        //ServiceRegistry lớp trừ tượng
        ServiceRegistry registry= new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
        FACTORY = conf.buildSessionFactory(registry);

    }
    public static SessionFactory getFactory() {
        return FACTORY;
    }

}
