package inspire.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Motivator {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	@Column(name = "id", unique = true, nullable = false)  
	int id;
	
	@Column(name = "url", unique = true, nullable = true) 
	String url;
	
	@Column(name = "user", unique = false, nullable = true) 
	String user;
	
	@Column(name = "displayed", unique = false, nullable = true) 
	int displayed;
	
	@Column(name = "linkType", unique = false, nullable = true)
	String linkType;
	
	//GetLabel by Hibernate

	
	/**
	 * Constructor
	 */
	public Motivator() {
		this.url = 		"url";
		this.user =		"user"; 
		this.displayed = 0;
		this.linkType = "linkType";
	}
	
	
	
	
	/**
	 * Full construcotr
	 * @param id
	 * @param url
	 * @param user
	 * @param displayed
	 * @param linkType
	 */
	public Motivator(int id, String url, String user, int displayed,
			String linkType) {
		super();
		this.id = id;
		this.url = url;
		this.user = user;
		this.displayed = displayed;
		this.linkType = linkType;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public String toString() {
		return "Motivator [id=" + id + ", url=" + url + ", user=" + user
				+ ", displayed=" + displayed + ", linkType=" + linkType + "]";
	}




		//Setters and getters.
		public String getLinkType() {		return linkType;	}

		public void setLinkType(String linkType) {		this.linkType = linkType;	}
		public int getId() {		return id;	}
		public void setId(int id) {		this.id = id;	}
		public String getUrl() {		return url;	}
		public void setUrl(String url) {		this.url = url;	}
		public String getUser() {		return user;	}
		public void setUser(String user) {		this.user = user;	}
		public int getDisplayed() {		return displayed;	}
		public void setDisplayed(int displayed) {		this.displayed = displayed;	}
	//Inne
	
	
	
	
}
