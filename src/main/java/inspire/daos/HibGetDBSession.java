package inspire.daos;

import inspire.entities.Motivator;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import inspire.entities.Motivator;



/**
 * Class retriving different sessions, sessions factories and so on.
 * @author TalentLab1
 *
 */
public class HibGetDBSession{

	private  SessionFactory sessionFactory;
	private  ServiceRegistry serviceRegistry;
	private  Session session;

	
 /**
     * Get new session based on Anotations configuration
     * @return
     */
	public Session getNewSessionAnnotations(){
		Configuration config = new Configuration();
		config.addAnnotatedClass(Motivator.class);
        config.configure("hibernate.cfg.xml");
		SchemaExport schema = new SchemaExport(config);
        schema.setOutputFile("uiSchema.sql");//saved in eclipse main folder
        //schema.create(true, false);
        serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();        
        SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
        Session session = sessionFactory.openSession();
		return session;
	}

	
    /**
     * Get new session based on Annotations configuration with specified hibernate.cfg.xml file <br />
     * testhibernate.cfg.xml - for testing - h2:mem:testblogdb, hbm2ddl - create
     * 
     * @return
     */
	public Session getNewSessionAnnotations(String hibfile){
		Configuration config = new Configuration();
		config.addAnnotatedClass(Motivator.class);
        config.configure(hibfile);
		SchemaExport schema = new SchemaExport(config);
        schema.setOutputFile("uiSchema.sql");//saved in eclipse main folder
        //schema.create(true, false);
        serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();        
        SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
        Session session = sessionFactory.openSession();
		return session;
	}
	
    /**
     * Get new session factory object based on Annotations configuration
     * @return
     */
	public SessionFactory getAnnotationsSessionFactory(){
		Configuration config = new Configuration();
        //added annotated classes
		config.addAnnotatedClass(Motivator.class);
        config.configure("hibernate.cfg.xml");
        serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();        
        SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
      	return sessionFactory;
		
	}
	
	/**
	 * Get a session with a specified hibernate.cfg.xml file 				<br />
	 * hib4nodb.cfg.xml - file with ifexists=false and hbm2ddl create  		<br />
	 * will create DB and table for first run if there is no DB.			<br />
	 * 
	 * @param hibcfgxmlFile
	 * @return open session
	 */
	
	public Session getNewSessionAnnotationsWithHibernateCfgXmlSession(String hibcfgxmlFile){
		Configuration config = new Configuration();
		config.addAnnotatedClass(Motivator.class);
        config.configure(hibcfgxmlFile);
		SchemaExport schema = new SchemaExport(config);
        schema.setOutputFile("uiSchema.sql");
        //schema.create(true, false);
        serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();        
        SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
        Session session = sessionFactory.openSession();
		return session;
	}
	
	
	/**
	 * Get a session factory with a specified hibernate.cfg.xml file 				<br />
	 * hib4nodb.cfg.xml - file with ifexists=false and hbm2ddl create  		<br />
	 * will create DB and table for first run if there is no DB.			<br />
	 * 
	 * @param hibcfgxmlFile
	 * @return open session
	 */
	
	public SessionFactory getAnnotatedSessionFactorysWithSpecificHibCfgXmlFile(String hibcfgxmlFile){
		Configuration config = new Configuration();
		config.addAnnotatedClass(Motivator.class);
        config.configure(hibcfgxmlFile);
		SchemaExport schema = new SchemaExport(config);
        schema.setOutputFile("uiSchema.sql");//saved in eclipse main folder
        //schema.create(true, false);
        serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();        
        SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
		return sessionFactory;
	}
	
	
	
	
	

	//setters getter
	public SessionFactory getSessionFactory() {		return sessionFactory;	}
	public void setSessionFactory(SessionFactory sessionFactory) {		this.sessionFactory = sessionFactory;	}
	public ServiceRegistry getServiceRegistry() {		return serviceRegistry;	}
	public void setServiceRegistry(ServiceRegistry serviceRegistry) {		this.serviceRegistry = serviceRegistry;	}
	public Session getSession() {		return session;	}
	public void setSession(Session session) {		this.session = session;	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
	
	
	
	
	
	
	
	

