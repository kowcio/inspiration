package inspire.daos;

import inspire.entities.Motivator;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;


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


	
		/**
		 * Get number of motivators in db
		 * @param viewType
		 * @return
		 */
		public int getPostsNumberInDB( ){
			HibGetDBSession fabrykaHibernejta = new HibGetDBSession();
			long pcl=0;
		   	try {
				Session session = fabrykaHibernejta.getNewSessionAnnotations();
				//postCount 
				 pcl =		 (Long) session.createCriteria(Motivator.class)
							 .setProjection(Projections.rowCount()).uniqueResult();
			return safeLongToInt(pcl);
		   	} catch (Exception e) {
				System.out.println("Exception error - PostDAO - getPostsNumberInDB");
				 e.printStackTrace();
			}
		   	return 0;
		}
		
		
		
		@SuppressWarnings("unchecked")
		public List<Motivator> getDisplayedMotivators(){
			HibGetDBSession fabrykaHibernejta = new HibGetDBSession();
			List<Motivator> motList = null;
		   	try {
				Session session = fabrykaHibernejta.getNewSessionAnnotations();
				Transaction tx = session.beginTransaction();
				motList = (List<Motivator>)session
						.createQuery("from Motivator where displayed = '1'").list();
			   	System.out.println("motList count = "+motList.size());	
				tx.commit();
				return motList;
		   	} catch (Exception e) {
				System.out.println("Exception error - PostDAO - getAllNotepadPosts");
				 e.printStackTrace();
			}
		   	return null;
		}
		
		
		@SuppressWarnings("unchecked")
		public Motivator getDisplayedSpecifiedTypeMotivators(String linkType){
			HibGetDBSession fabrykaHibernejta = new HibGetDBSession();
			List<Motivator> postsList = null;
		   	try {
				Session session = fabrykaHibernejta.getNewSessionAnnotations();
				Transaction tx = session.beginTransaction();
				postsList = (List<Motivator>)session
						.createQuery("from Motivator where linkType="+linkType+"and displayed = '1'").list();
			   	System.out.println("PostsList count = "+postsList.size());	
				tx.commit();
				return postsList.get(0);
		   	} catch (Exception e) {
				System.out.println("Exception error - PostDAO - getAllNotepadPosts");
				 e.printStackTrace();
			}
		   	return postsList.get(0);
		}
		
		
		
		/**
		 * return the number of posts with status display = 1 
		 * @return int 
		 */
		public int getMotivatorsNumberInDBThatAreDisplayed(int display){
			HibGetDBSession fabrykaHibernejta = new HibGetDBSession();
		   	try {
				Session session = fabrykaHibernejta.getNewSessionAnnotations();
 
				int postCount = 
						safeLongToInt(
						 (Long) session.createCriteria(Motivator.class)
						.add( Restrictions.eq("displayed", display ) )
						.setProjection(Projections.rowCount()).uniqueResult()
						);
				return postCount;
		   	} catch (Exception e) {
				System.out.println("Exception error - PostDAO - getPostsNumberInDB");
				 e.printStackTrace();
			}
		   	return 0;
		}
		
		/**
		 * return the number of posts with status display = 1 
		 * @return int 
		 */
		public int getSpecifiedMotivatorsNumberInDBThatAreDisplayed(String linkType, int display){
			HibGetDBSession fabrykaHibernejta = new HibGetDBSession();
		   	try {
				Session session = fabrykaHibernejta.getNewSessionAnnotations();
 
				int postCount = 
						safeLongToInt(
						 (Long) session.createCriteria(Motivator.class)
						.add( Restrictions.eq("displayed", display ) )
						.add( Restrictions.eq("linkType", linkType ) )
						.setProjection(Projections.rowCount()).uniqueResult()
						);
				return postCount;
		   	} catch (Exception e) {
				System.out.println("Exception error - PostDAO - getPostsNumberInDB");
				 e.printStackTrace();
			}
		   	return 0;
		}
		////////////////////
		////////////////////
		// UTILS 
		////////////////////
		////////////////////
		
		
		/**
		 * Method for casting Long to INT
		 * @param l long
		 * @return int l
		 */
		public int safeLongToInt(long l) {
		    if (l < Integer.MIN_VALUE || l > Integer.MAX_VALUE) {
		        throw new IllegalArgumentException
		            (l + " cannot be cast to int without changing its value.");
		    }
		    return (int) l;
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	

}
