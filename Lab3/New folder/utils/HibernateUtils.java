package utils;

import lab3.tdtu.Manufacture;
import lab3.tdtu.Phone;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtils {
    private static final SessionFactory FACTORY;
    static{
        Configuration conf=new Configuration();
        conf.addAnnotatedClass(Phone.class);
        conf.addAnnotatedClass(Manufacture.class);
        //ServiceRegistry lớp trừ tượng
        FACTORY = buildSessionFactory();
    }
    private static SessionFactory buildSessionFactory()
    {
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder() //
                .configure() // Load hibernate.cfg.xml from resource folder by default
                .build();
        Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();
        return metadata.getSessionFactoryBuilder().build();
    }
    public static SessionFactory getFactory() {
        return FACTORY;
    }
    public static void close() {
        getFactory().close();
    }
}
