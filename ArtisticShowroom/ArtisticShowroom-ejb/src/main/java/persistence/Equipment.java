package persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 * The persistent class for the Equipment database table.
 * 
 */
@Entity
@NamedQuery(name = "Equipment.findAll", query = "SELECT e FROM Equipment e")
public class Equipment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "EquipmentId")
	private int equipmentId;

	@Column(name = "EquipmentImage")
	private String equipmentImage;

	@Column(name = "EquipmentName")
	private String equipmentName;

	@Column(name = "EquipmentPrice")
	private double equipmentPrice;

	@Column(name = "EquipmentQuantity")
	private int equipmentQuantity;

	@Column(name = "EquipmentType")
	private String equipmentType;

	// bi-directional many-to-one association to BookingEquipment
	@OneToMany(mappedBy = "equipment")
	private List<BookingEquipment> bookingEquipments;

	// bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "EquipmentOwnerFK")
	private User user;

	public Equipment() {
	}

	public int getEquipmentId() {
		return this.equipmentId;
	}

	public void setEquipmentId(int equipmentId) {
		this.equipmentId = equipmentId;
	}

	public Object getEquipmentImage() {
		return this.equipmentImage;
	}

	public void setEquipmentImage(Object equipmentImage) {
		this.equipmentImage = (String) equipmentImage;
	}

	public Object getEquipmentName() {
		return this.equipmentName;
	}

	public void setEquipmentName(Object equipmentName) {
		this.equipmentName = (String) equipmentName;
	}

	public double getEquipmentPrice() {
		return this.equipmentPrice;
	}

	public void setEquipmentPrice(double equipmentPrice) {
		this.equipmentPrice = equipmentPrice;
	}

	public int getEquipmentQuantity() {
		return this.equipmentQuantity;
	}

	public void setEquipmentQuantity(int equipmentQuantity) {
		this.equipmentQuantity = equipmentQuantity;
	}

	public Object getEquipmentType() {
		return this.equipmentType;
	}

	public void setEquipmentType(Object equipmentType) {
		this.equipmentType = (String) equipmentType;
	}

	public List<BookingEquipment> getBookingEquipments() {
		return this.bookingEquipments;
	}

	public void setBookingEquipments(List<BookingEquipment> bookingEquipments) {
		this.bookingEquipments = bookingEquipments;
	}

	public BookingEquipment addBookingEquipment(BookingEquipment bookingEquipment) {
		getBookingEquipments().add(bookingEquipment);
		bookingEquipment.setEquipment(this);

		return bookingEquipment;
	}

	public BookingEquipment removeBookingEquipment(BookingEquipment bookingEquipment) {
		getBookingEquipments().remove(bookingEquipment);
		bookingEquipment.setEquipment(null);

		return bookingEquipment;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}