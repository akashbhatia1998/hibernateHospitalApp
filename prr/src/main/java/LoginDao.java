
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import org.hibernate.*;
import org.hibernate.service.ServiceRegistry;


public class LoginDao {

     public Boolean validate(String name , String password) {
         Configuration con = new Configuration().configure().addAnnotatedClass(admin.class);

         SessionFactory sf = con.buildSessionFactory();
         Session session = sf.openSession();

         Transaction ts = session.beginTransaction();
         String hql = "select name , password from admin";
         Query qry = session.createQuery(hql);
         List l;
         l = qry.list();
         System.out.println("Total Number Of Records : "+l.size());
         Iterator it = l.iterator();

         while(it.hasNext())
         {
             Object o[] = (Object[])it.next();

//             System.out.println("Product id : "+o[0]+ "Product Name : "+o[1]);
//
//             System.out.println("----------------");
             if(name == o[0]  && password == o[1])
             {
                 return true;
             }
         }
         ts.commit();
         session.close();
         return false;
     }
//
//    public static SessionFactory createSessionFactory() {
//        Configuration configuration = new Configuration();
//        configuration.configure();
//        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
//                configuration.getProperties()).build();
//        return configuration.buildSessionFactory(serviceRegistry);
//    }
//
}
