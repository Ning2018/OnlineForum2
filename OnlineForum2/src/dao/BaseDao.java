package dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class BaseDao {

	Configuration cfg = new Configuration().configure();
	ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
	                    .applySettings(cfg.getProperties()).buildServiceRegistry();
	SessionFactory sessionFactory = cfg.buildSessionFactory(serviceRegistry);	

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
