package inspire.config;

import inspire.daos.HibGetDBSession;
import inspire.daos.MotivatorDAO;
import inspire.entities.Motivator;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.hibernate.SessionFactory;


/**
 * Class to configure database with basic new data
 * @author TalentLab1
 * 
 *
 */

public class DBConfig implements ServletContextListener {


	String hibfile = "hibernate.cfg.xml"; 
	
	
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		
	System.out.println("" +
			"############   CREATING DATABASE FOR THE INITIAL RUN   ############ \n" +
			"############   CREATING DATABASE FOR THE INITIAL RUN   ############ \n" +
			"############   CREATING DATABASE FOR THE INITIAL RUN   ############ " +
			"\n http://forum.springsource.org/archive/index.php/t-29874.html" );
	  
		boolean noDB = false;
		//get basic sessionFact only if db is created 
		HibGetDBSession hibs = new HibGetDBSession();
		SessionFactory sf1 = hibs.getAnnotatedSessionFactorysWithSpecificHibCfgXmlFile("hibernate.cfg.xml");
		
        //Get errors if session can actualy get something.
	    
	        int postNo = -1;
	        MotivatorDAO fdao = new MotivatorDAO();
	        try {
				postNo = (int) fdao.getAllMotivators().size();
				System.out.println("postNumber = "+postNo);
				if (postNo == 0 ){						//if db is empty add initial posts
					System.out.print("0 posts.");
        			saveInitialDBData(sf1);
				}
			} catch (Exception e) {					//for checking when null while getting posts
				//e.printStackTrace()	;				
				noDB=true; 							//there is no db specified
				System.out.print("No database or session creating error.");
			}


	        /*if database does not exists */
		        
	        if (noDB){
	        			System.out.println(" NO DATABASE or sth like that ... creating new one.");
	        			//create db while trying to connect
	        			SessionFactory sf = hibs.getAnnotatedSessionFactorysWithSpecificHibCfgXmlFile("hibfornodb.cfg.xml");
	        			//add initial posts
	        			saveInitialDBData(sf);
				}//end if database none exist
	 }
	
	
	
	// METHODS 
	
	/**
	 * Save initials posts , Motivators to the database while creating it or inspecting if there is not enough information
	 * inside it			<br />
	 * @param sf - Session Factory for creating sessions inside methods and DAOs.
	 */
	
	public String saveInitialDBData( SessionFactory sf){
		saveSingleInitialMotivators(sf);
	return "OK";
	}
	
	
	
	
	
   	
	/**
	 * Savs the initial Motivators
	 * @param sf - Session Factory
	 * @return "ok"
	 */
	
	public String saveSingleInitialMotivators( SessionFactory sf){
		
    	try {
    		System.out.println ("Adding default posts.");
    		MotivatorDAO fdao = new MotivatorDAO();
    		Motivator us = new Motivator();
    		System.out.println("Motivator1 = "+us.toString());
    		fdao.saveMotivator(us);
    	
		} catch (Exception e) {
			//e.printStackTrace();
			return "Could not add initial Motivators - ui.config.DBConfig error.";
		}
	return "OK";
	}
	
	
	
	


	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	public String getHibfile() {
		return hibfile;
	}


/**
 * set the hibernate file for DB	<br />
 * hibernate.cfg.xml				<br />
 * testhibernate.cfg.xml			<br />
 * @param hibfile
 */
	public void setHibfile(String hibfile) {
		this.hibfile = hibfile;
	}

	

	
}
