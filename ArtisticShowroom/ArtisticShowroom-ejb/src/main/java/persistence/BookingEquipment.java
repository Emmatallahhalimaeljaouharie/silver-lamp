package persistence;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

/**
 * The persistent class for the BookingEquipment database table.
 * 
 */
@Entity
@NamedQuery(name = "BookingEquipment.findAll", query = "SELECT b FROM BookingEquipment b")
public class BookingEquipment implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private BookingEquipmentPK id;

	@Column(name = "BookingEquipmentDeleteDate")
	private String bookingEquipmentDeleteDate;

	@Column(name = "BookingEquipmentEnd")
	private String bookingEquipmentEnd;

	@Column(name = "BookingEquipmentQuantity")
	private int bookingEquipmentQuantity;

	@Column(name = "BookingEquipmentStart")
	private String bookingEquipmentStart;

	@Column(name = "Description")
	private String description;

	@Column(name = "ResponseBookingEquipment")
	private int responseBookingEquipment;

	// bi-directional many-to-one association to Equipment
	@ManyToOne
	@JoinColumn(name = "EquipmentId", referencedColumnName = "EquipmentId", insertable = false, updatable = false)
	private Equipment equipment;

	// bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "TrainerId", referencedColumnName = "Id", insertable = false, updatable = false)
	private User user;

	public BookingEquipment() {
	}

	public BookingEquipmentPK getId() {
		return this.id;
	}

	public void setId(BookingEquipmentPK id) {
		this.id = id;
	}

	public String getBookingEquipmentDeleteDate() {
		return this.bookingEquipmentDeleteDate;
	}

	public void setBookingEquipmentDeleteDate(String bookingEquipmentDeleteDate) {
		this.bookingEquipmentDeleteDate = bookingEquipmentDeleteDate;
	}

	public String getBookingEquipmentEnd() {
		return this.bookingEquipmentEnd;
	}

	public void setBookingEquipmentEnd(String bookingEquipmentEnd) {
		this.bookingEquipmentEnd = bookingEquipmentEnd;
	}

	public int getBookingEquipmentQuantity() {
		return this.bookingEquipmentQuantity;
	}

	public void setBookingEquipmentQuantity(int bookingEquipmentQuantity) {
		this.bookingEquipmentQuantity = bookingEquipmentQuantity;
	}

	public String getBookingEquipmentStart() {
		return this.bookingEquipmentStart;
	}

	public void setBookingEquipmentStart(String bookingEquipmentStart) {
		this.bookingEquipmentStart = bookingEquipmentStart;
	}

	public Object getDescription() {
		return this.description;
	}

	public void setDescription(Object description) {
		this.description = (String) description;
	}

	public int getResponseBookingEquipment() {
		return this.responseBookingEquipment;
	}

	public void setResponseBookingEquipment(int responseBookingEquipment) {
		this.responseBookingEquipment = responseBookingEquipment;
	}

	public Equipment getEquipment() {
		return this.equipment;
	}

	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}