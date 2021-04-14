package SDAproject.connectionUtil;

import HibernateTask2.model.Person;
import HibernateTask2.model.Phone;
import SDAproject.model.Login;
import SDAproject.model.Product;
import SDAproject.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernateUtility {

        private static SessionFactory sessionFactory;

        public static SessionFactory getSessionFactory(){

            //aprasom configuration, jei nera esancios sesijos, sukurti nauja
            if (sessionFactory == null){

                Configuration configuration = new Configuration();

                Properties properties = new Properties();
                properties.put(Environment.URL, "jdbc:mysql://localhost:3306/sdaproject?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true");
                properties.put(Environment.USER, "root");
                properties.put(Environment.PASS, "root");
                properties.put(Environment.HBM2DDL_AUTO, "create-drop"); //update, create-drop, create

                configuration.setProperties(properties);

                configuration.addAnnotatedClass(Login.class);
                configuration.addAnnotatedClass(Product.class);
                configuration.addAnnotatedClass(User.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);

            }
            return sessionFactory;
        }

        public static void shutDown(){
            getSessionFactory().close();
        }

}
