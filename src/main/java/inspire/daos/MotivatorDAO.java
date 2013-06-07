package inspire.daos;

import inspire.entities.Motivator;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class MotivatorDAO {

		/**
	 *Save a Motivator class  into the user table
	 *
	 * @param  Motivator motivator  
	 * @return 
	 */
	
	public String saveMotivator(inspire.entities.Motivator motivator){
		HibGetDBSession fabrykaHibernejta = new HibGetDBSession();
	   	try {
	   		Session session = fabrykaHibernejta.getNewSessionAnnotations();
	   		System.out.println("Wypisanie rzeczy w zwiazlku z embedded SessioNFactory pobranym z dispatchera");
	   		System.out.println("");
			System.out.println("Saving Record");
			Transaction tx = session.beginTransaction();

			//setting the date of adding the motivator
			session.save(motivator);
			tx.commit();
			System.out.println("Motivator id = "+motivator.getId()+" added !");
			return "OK";
		} catch (Exception e) {
			System.out.println("Cos sie wysypalo - FigureBoxDAO");
			 e.printStackTrace();
			 return "notOK";
		}

	}   	
	
	
	
	/**
	 * 
	 * @return All motivators as list.
	 */
	
	
	@SuppressWarnings("unchecked")
	public List<inspire.entities.Motivator> getAllMotivators(){
		HibGetDBSession fabrykaHibernejta = new HibGetDBSession();
		List<Motivator> motivatorsList = null;
	   	try {
			Session session = fabrykaHibernejta.getNewSessionAnnotations();
			Transaction tx = session.beginTransaction();
			motivatorsList = (List<Motivator>)session.createQuery("from Motivator").list();
		   	System.out.println("MotivatorsList count = "+motivatorsList.size());	
			tx.commit();
	   	} catch (Exception e) {
			System.out.println("Cos sie wysypalo - MotivatorDAO - getAllMotivators");
			 e.printStackTrace();
		}
	   
	   	
	   	return motivatorsList;
	}

	/**
	 * Return Motivator by ID.
	 * 
	 * @param motivatorId - Motivators ID which we wish to load.
	 * @return	Specified Motivator
	 */
	
	
	public Motivator getMotivatorByID(int motivatorId){
		HibGetDBSession fabrykaHibernejta = new HibGetDBSession();
		Motivator motivator = new Motivator();
	   	try {
			Session session = fabrykaHibernejta.getNewSessionAnnotations();
			Transaction tx = session.beginTransaction();
			
			motivator = (Motivator) session.get(Motivator.class, motivatorId);
			
			tx.commit();
	   	} catch (Exception e) {
			System.out.println("Cos sie wysypalo - getMotivatorByID");
			 e.printStackTrace();
		}
	   
		System.out.println("Pobrano motivator, id = "+motivatorId);
	   	return motivator;
	}

/**	Update a Motivator object in db.
 * 
 * @param motivator Motivator which we wish to update. Needs to have a specified ID.
 */

	public void updateMotivator(Motivator motivator){
		HibGetDBSession fabrykaHibernejta = new HibGetDBSession();
	   	try {
			Session session = fabrykaHibernejta.getNewSessionAnnotations();
			Transaction tx = session.beginTransaction();
			session.saveOrUpdate(motivator);
			tx.commit();
	   	} catch (Exception e) {
			System.out.println("Cos sie wysypalo - getMotivatorByID");
			 e.printStackTrace();
		}
	}


	/**	Delete in db a Motivator object by given ID.
	 * 
	 * @param Needs to have a specified ID.
	 */

		public void deleteMotivator(int id){
			HibGetDBSession fabrykaHibernejta = new HibGetDBSession();
		   	try {
				Session session = fabrykaHibernejta.getNewSessionAnnotations();
				MotivatorDAO motivator = new MotivatorDAO();
				Transaction tx = session.beginTransaction();
		   		System.out.println("Before delete");
		   		session.delete(motivator.getMotivatorByID(id));
		   		System.out.println("After delete");
				tx.commit();

		   	} catch (IllegalArgumentException e) {  
		   		System.out.println(" No motivator by that id");
				 e.printStackTrace();
	        }  	catch (Exception e) {
				System.out.println("Cos sie wysypalo - DeleteMotivatorByID");
			}
		}


	
	
	

}
