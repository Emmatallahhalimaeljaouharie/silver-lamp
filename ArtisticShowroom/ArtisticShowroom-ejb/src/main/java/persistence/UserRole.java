package persistence;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

/**
 * The persistent class for the UserRole database table.
 * 
 */
@Entity
@NamedQuery(name = "UserRole.findAll", query = "SELECT u FROM UserRole u")
public class UserRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UserRolePK id;

	// bi-directional many-to-one association to Role
	@ManyToOne

	@JoinColumn(name = "IdentityRole_Id", referencedColumnName = "Id", insertable = false, updatable = false)
	private Role role;

	// bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "UserId", referencedColumnName = "Id", insertable = false, updatable = false)
	private User user;

	public UserRole() {
	}

	public UserRolePK getId() {
		return this.id;
	}

	public void setId(UserRolePK id) {
		this.id = id;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}