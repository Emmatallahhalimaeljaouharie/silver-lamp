package persistence;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

/**
 * The persistent class for the ReservationStand database table.
 * 
 */
@Entity
@NamedQuery(name = "ReservationStand.findAll", query = "SELECT r FROM ReservationStand r")
public class ReservationStand implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ReservationStandPK id;

	// bi-directional many-to-one association to Stand
	@ManyToOne

	@JoinColumn(name = "StandId", referencedColumnName = "StandId", insertable = false, updatable = false)
	private Stand stand;

	// bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "UserId", referencedColumnName = "Id", insertable = false, updatable = false)
	private User user;

	public ReservationStand() {
	}

	public ReservationStandPK getId() {
		return this.id;
	}

	public void setId(ReservationStandPK id) {
		this.id = id;
	}

	public Stand getStand() {
		return this.stand;
	}

	public void setStand(Stand stand) {
		this.stand = stand;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}