package persistence;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

/**
 * The persistent class for the BookingGallery database table.
 * 
 */
@Entity
@NamedQuery(name = "BookingGallery.findAll", query = "SELECT b FROM BookingGallery b")
public class BookingGallery implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private BookingGalleryPK id;

	@Column(name = "BookingEnd")
	private String bookingEnd;

	@Column(name = "BookingGalleryDeleteDate")
	private String bookingGalleryDeleteDate;

	@Column(name = "BookingStart")
	private String bookingStart;

	@Column(name = "Description")
	private String description;

	private String img;

	@Column(name = "ResponseBooking")
	private int responseBooking;

	// bi-directional many-to-one association to Gallery
	@ManyToOne
	@JoinColumn(name = "GalleryId", referencedColumnName = "GalleryId", insertable = false, updatable = false)
	private Gallery gallery;

	// bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "ArtistId", referencedColumnName = "Id", insertable = false, updatable = false)
	private User user;

	public BookingGallery() {
	}

	public BookingGalleryPK getId() {
		return this.id;
	}

	public void setId(BookingGalleryPK id) {
		this.id = id;
	}

	public String getBookingEnd() {
		return this.bookingEnd;
	}

	public void setBookingEnd(String bookingEnd) {
		this.bookingEnd = bookingEnd;
	}

	public String getBookingGalleryDeleteDate() {
		return this.bookingGalleryDeleteDate;
	}

	public void setBookingGalleryDeleteDate(String bookingGalleryDeleteDate) {
		this.bookingGalleryDeleteDate = bookingGalleryDeleteDate;
	}

	public String getBookingStart() {
		return this.bookingStart;
	}

	public void setBookingStart(String bookingStart) {
		this.bookingStart = bookingStart;
	}

	public Object getDescription() {
		return this.description;
	}

	public void setDescription(Object description) {
		this.description = (String) description;
	}

	public Object getImg() {
		return this.img;
	}

	public void setImg(Object img) {
		this.img = (String) img;
	}

	public int getResponseBooking() {
		return this.responseBooking;
	}

	public void setResponseBooking(int responseBooking) {
		this.responseBooking = responseBooking;
	}

	public Gallery getGallery() {
		return this.gallery;
	}

	public void setGallery(Gallery gallery) {
		this.gallery = gallery;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}