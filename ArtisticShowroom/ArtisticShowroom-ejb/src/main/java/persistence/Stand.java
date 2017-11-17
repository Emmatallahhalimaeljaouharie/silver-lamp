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
 * The persistent class for the Stand database table.
 * 
 */
@Entity
@NamedQuery(name = "Stand.findAll", query = "SELECT s FROM Stand s")
public class Stand implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "StandId")
	private int standId;

	@Column(name = "Description")
	private String description;

	@Column(name = "Image")
	private String image;

	@Column(name = "NombreOfVotes")
	private int nombreOfVotes;

	@Column(name = "Rating")
	private int rating;

	@Column(name = "StandNumber")
	private int standNumber;

	@Column(name = "Standsurface")
	private double standsurface;

	@Column(name = "UserId")
	private String userId;

	@Column(name = "Validity")
	private int validity;

	// bi-directional many-to-one association to ReservationStand
	@OneToMany(mappedBy = "stand")
	private List<ReservationStand> reservationStands;

	// bi-directional many-to-one association to Gallery
	@ManyToOne
	@JoinColumn(name = "GalleryId")
	private Gallery gallery;

	public Stand() {
	}

	public int getStandId() {
		return this.standId;
	}

	public void setStandId(int standId) {
		this.standId = standId;
	}

	public Object getDescription() {
		return this.description;
	}

	public void setDescription(Object description) {
		this.description = (String) description;
	}

	public Object getImage() {
		return this.image;
	}

	public void setImage(Object image) {
		this.image = (String) image;
	}

	public int getNombreOfVotes() {
		return this.nombreOfVotes;
	}

	public void setNombreOfVotes(int nombreOfVotes) {
		this.nombreOfVotes = nombreOfVotes;
	}

	public int getRating() {
		return this.rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getStandNumber() {
		return this.standNumber;
	}

	public void setStandNumber(int standNumber) {
		this.standNumber = standNumber;
	}

	public double getStandsurface() {
		return this.standsurface;
	}

	public void setStandsurface(double standsurface) {
		this.standsurface = standsurface;
	}

	public Object getUserId() {
		return this.userId;
	}

	public void setUserId(Object userId) {
		this.userId = (String) userId;
	}

	public int getValidity() {
		return this.validity;
	}

	public void setValidity(int validity) {
		this.validity = validity;
	}

	public List<ReservationStand> getReservationStands() {
		return this.reservationStands;
	}

	public void setReservationStands(List<ReservationStand> reservationStands) {
		this.reservationStands = reservationStands;
	}

	public ReservationStand addReservationStand(ReservationStand reservationStand) {
		getReservationStands().add(reservationStand);
		reservationStand.setStand(this);

		return reservationStand;
	}

	public ReservationStand removeReservationStand(ReservationStand reservationStand) {
		getReservationStands().remove(reservationStand);
		reservationStand.setStand(null);

		return reservationStand;
	}

	public Gallery getGallery() {
		return this.gallery;
	}

	public void setGallery(Gallery gallery) {
		this.gallery = gallery;
	}

}