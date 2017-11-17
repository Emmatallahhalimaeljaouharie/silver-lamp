package persistence;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the UserLogin database table.
 * 
 */
@Entity
@NamedQuery(name="UserLogin.findAll", query="SELECT u FROM UserLogin u")
public class UserLogin implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="UserId")
	private String userId;

	@Column(name="LoginProvider")
	private String loginProvider;

	@Column(name="ProviderKey")
	private String providerKey;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="User_Id")
	private User user;

	public UserLogin() {
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Object getLoginProvider() {
		return this.loginProvider;
	}

	public void setLoginProvider(Object loginProvider) {
		this.loginProvider = (String)loginProvider;
	}

	public Object getProviderKey() {
		return this.providerKey;
	}

	public void setProviderKey(Object providerKey) {
		this.providerKey = (String)providerKey;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}