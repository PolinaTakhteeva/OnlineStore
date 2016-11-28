package package1;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
    private static SessionFactory sessionFactory = buildSessionFactory();

    public HibernateUtil() {
    }

    protected static SessionFactory buildSessionFactory() {
        StandardServiceRegistry registry = (new StandardServiceRegistryBuilder()).configure().build();

        try {
            sessionFactory = (new MetadataSources(registry)).buildMetadata().buildSessionFactory();
        } catch (Exception var2) {
            StandardServiceRegistryBuilder.destroy(registry);
            throw new ExceptionInInitializerError("Initial SessionFactory failed" + var2);
        }

        return sessionFactory;
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        getSessionFactory().close();
    }
}