package persistence;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the BookingEquipment database table.
 * 
 */
@Embeddable
public class BookingEquipmentPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="TrainerId", insertable=false, updatable=false)
	private String trainerId;

	@Column(name="EquipmentId", insertable=false, updatable=false)
	private int equipmentId;

	@Column(name="BookingEquipmentDate")
	private String bookingEquipmentDate;

	public BookingEquipmentPK() {
	}
	public String getTrainerId() {
		return this.trainerId;
	}
	public void setTrainerId(String trainerId) {
		this.trainerId = trainerId;
	}
	public int getEquipmentId() {
		return this.equipmentId;
	}
	public void setEquipmentId(int equipmentId) {
		this.equipmentId = equipmentId;
	}
	public String getBookingEquipmentDate() {
		return this.bookingEquipmentDate;
	}
	public void setBookingEquipmentDate(String bookingEquipmentDate) {
		this.bookingEquipmentDate = bookingEquipmentDate;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof BookingEquipmentPK)) {
			return false;
		}
		BookingEquipmentPK castOther = (BookingEquipmentPK)other;
		return 
			this.trainerId.equals(castOther.trainerId)
			&& (this.equipmentId == castOther.equipmentId)
			&& this.bookingEquipmentDate.equals(castOther.bookingEquipmentDate);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.trainerId.hashCode();
		hash = hash * prime + this.equipmentId;
		hash = hash * prime + this.bookingEquipmentDate.hashCode();
		
		return hash;
	}
}