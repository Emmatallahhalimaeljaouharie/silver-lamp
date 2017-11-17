package utilities;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import persistence.User;
import services.BasicOpsLocal;

/**
 * Session Bean implementation class UtilityApp
 */
@Singleton
@LocalBean
@Startup
public class UtilityApp {
	@EJB
	private BasicOpsLocal basicOpsLocal;

	/**
	 * Default constructor.
	 */
	public UtilityApp() {
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	public void init() {
		User user = new User("ETU123", 38, "m@d.tn", 1, "ETU123");

		basicOpsLocal.addUser(user);

	}
}
