package mBeans;

import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.ws.rs.client.Client;

import persistence.User;
import services.BasicOpsLocal;

@ManagedBean
@SessionScoped
public class IdentityBean {
	// injection of the dependency
	@EJB
	private BasicOpsLocal basicOpsLocal;
	private boolean LoggedInAsClient = false ;
	public boolean isLoggedInAsClient() {
		return LoggedInAsClient;
	}


	public void setLoggedInAsClient(boolean loggedInAsClient) {
		LoggedInAsClient = loggedInAsClient;
	}

	private boolean LoggedInAsTrainer = false ;
	// the model
	private User user = new User();

	public String doLogin() {
		String navigateTo = "/pages/Artwork/ajouter?faces-redirect=true";
		User userLoggedIn = basicOpsLocal.login(user.getEmail(), user.getPasswordHash());
		if (userLoggedIn != null) {
			user = userLoggedIn;
		 if (userLoggedIn instanceof Client) { 
			 setLoggedInAsClient(true);
			
		 }
		 navigateTo = "/pages/Training/ajouter?faces-redirect=true";	

		}

		return navigateTo;
	}
	 public String logout() {
	        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	        return "/login?faces-redirect=true";
	    }
	
//	public String doLogin() {
//
//		String navigateTo =  "/pages/Artwork/ArtworkList?faces-redirect=true";
//	
//	User userLoggedIn = basicOpsLocal.login(user.getUserName(),user.getPasswordHash() );
//	
//	if (userLoggedIn != null) {
//		user = userLoggedIn;
//		
//		if (userLoggedIn instanceof Client) {
//			setLoggedInAsClient(true);
//			
//			navigateTo = "/pages/Training/ajouter?faces-redirect=true";
//		} else {
//			setLoggedInAsClient(false);
//			
//			navigateTo = "/pages/memberHome/home?faces-redirect=true";
//		}
//	}
//	System.err.println(user.getUserName());
//	return navigateTo;
//	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
