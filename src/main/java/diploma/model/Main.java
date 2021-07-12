package diploma.model;

import diploma.service.impl.PostServiceImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.orm.hibernate5.HibernateTransactionManager;

import javax.persistence.*;
import java.util.*;


public class Main {




    public static void main(String[] args) {


        System.out.println(Long.toBinaryString(1231232222));

        if(6==6){
            System.out.println(true);
        }



//        HibernatePersistenceProvider hibernatePersistenceProvider = new HibernatePersistenceProvider();
      /*  StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder()
                .configure()
                .build();

        Metadata metaData = new MetadataSources(standardServiceRegistry).addAnnotatedClass(User.class).getMetadataBuilder().build();
*/
   /*     SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

                    Session session = sessionFactory.getCurrentSession();
        System.err.println(session.isOpen());


            List hg = new ArrayList();
            hg.toArray();



       Hashtable map = new Hashtable();
        map.put("1","2");
        map.put("2","2");

        if(map.containsKey("1")){
            System.out.println(1);


        }
        System.out.println(0x1c);

        System.out.println(0X1c);


        System.out.println(0X1C);


*/



    }
}