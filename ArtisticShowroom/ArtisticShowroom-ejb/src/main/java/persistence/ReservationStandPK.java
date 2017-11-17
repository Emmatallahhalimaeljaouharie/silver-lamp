package persistence;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ReservationStand database table.
 * 
 */
@Embeddable
public class ReservationStandPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="UserId", insertable=false, updatable=false)
	private String userId;

	@Column(name="StandId", insertable=false, updatable=false)
	private int standId;

	@Column(name="Datereservation")
	private String datereservation;

	public ReservationStandPK() {
	}
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getStandId() {
		return this.standId;
	}
	public void setStandId(int standId) {
		this.standId = standId;
	}
	public String getDatereservation() {
		return this.datereservation;
	}
	public void setDatereservation(String datereservation) {
		this.datereservation = datereservation;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ReservationStandPK)) {
			return false;
		}
		ReservationStandPK castOther = (ReservationStandPK)other;
		return 
			this.userId.equals(castOther.userId)
			&& (this.standId == castOther.standId)
			&& this.datereservation.equals(castOther.datereservation);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.userId.hashCode();
		hash = hash * prime + this.standId;
		hash = hash * prime + this.datereservation.hashCode();
		
		return hash;
	}
}