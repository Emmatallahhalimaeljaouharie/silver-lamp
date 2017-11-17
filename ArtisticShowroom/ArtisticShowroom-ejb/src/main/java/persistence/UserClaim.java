package persistence;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

/**
 * The persistent class for the UserClaim database table.
 * 
 */
@Entity
@NamedQuery(name = "UserClaim.findAll", query = "SELECT u FROM UserClaim u")
public class UserClaim implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "Id")
	private int id;

	@Column(name = "ClaimType")
	private String claimType;

	@Column(name = "ClaimValue")
	private String claimValue;

	// bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "UserId")
	private User user;

	public UserClaim() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Object getClaimType() {
		return this.claimType;
	}

	public void setClaimType(Object claimType) {
		this.claimType = (String) claimType;
	}

	public Object getClaimValue() {
		return this.claimValue;
	}

	public void setClaimValue(Object claimValue) {
		this.claimValue = (String) claimValue;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}