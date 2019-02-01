package ooad.amazon.com.resources;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class CommonSessionFactory {
	public static Configuration configuration = new Configuration().configure();
	StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
	applySettings(configuration.getProperties());
	public static SessionFactory sf = configuration.configure().buildSessionFactory();	
}
