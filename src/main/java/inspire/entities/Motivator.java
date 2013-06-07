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
