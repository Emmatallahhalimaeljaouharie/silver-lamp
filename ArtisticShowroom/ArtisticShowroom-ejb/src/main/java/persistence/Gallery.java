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
 * The persistent class for the Gallery database table.
 * 
 */
@Entity
@NamedQuery(name = "Gallery.findAll", query = "SELECT g FROM Gallery g")
public class Gallery implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "GalleryId")
	private int galleryId;

	@Column(name = "Cityaddress")
	private String cityaddress;

	@Column(name = "GalleryName")
	private String galleryName;

	@Column(name = "Gallerysurface")
	private float gallerysurface;

	@Column(name = "Image")
	private String image;

	@Column(name = "Streetaddress")
	private String streetaddress;

	// bi-directional many-to-one association to BookingGallery
	@OneToMany(mappedBy = "gallery")
	private List<BookingGallery> bookingGalleries;

	// bi-directional many-to-one association to ExpositionEvent
	@OneToMany(mappedBy = "gallery")
	private List<ExpositionEvent> expositionEvents;

	// bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "UserId")
	private User user;

	// bi-directional many-to-one association to Stand
	@OneToMany(mappedBy = "gallery")
	private List<Stand> stands;

	public Gallery() {
	}

	public int getGalleryId() {
		return this.galleryId;
	}

	public void setGalleryId(int galleryId) {
		this.galleryId = galleryId;
	}

	public Object getCityaddress() {
		return this.cityaddress;
	}

	public void setCityaddress(Object cityaddress) {
		this.cityaddress = (String) cityaddress;
	}

	public Object getGalleryName() {
		return this.galleryName;
	}

	public void setGalleryName(Object galleryName) {
		this.galleryName = (String) galleryName;
	}

	public float getGallerysurface() {
		return this.gallerysurface;
	}

	public void setGallerysurface(float gallerysurface) {
		this.gallerysurface = gallerysurface;
	}

	public Object getImage() {
		return this.image;
	}

	public void setImage(Object image) {
		this.image = (String) image;
	}

	public Object getStreetaddress() {
		return this.streetaddress;
	}

	public void setStreetaddress(Object streetaddress) {
		this.streetaddress = (String) streetaddress;
	}

	public List<BookingGallery> getBookingGalleries() {
		return this.bookingGalleries;
	}

	public void setBookingGalleries(List<BookingGallery> bookingGalleries) {
		this.bookingGalleries = bookingGalleries;
	}

	public BookingGallery addBookingGallery(BookingGallery bookingGallery) {
		getBookingGalleries().add(bookingGallery);
		bookingGallery.setGallery(this);

		return bookingGallery;
	}

	public BookingGallery removeBookingGallery(BookingGallery bookingGallery) {
		getBookingGalleries().remove(bookingGallery);
		bookingGallery.setGallery(null);

		return bookingGallery;
	}

	public List<ExpositionEvent> getExpositionEvents() {
		return this.expositionEvents;
	}

	public void setExpositionEvents(List<ExpositionEvent> expositionEvents) {
		this.expositionEvents = expositionEvents;
	}

	public ExpositionEvent addExpositionEvent(ExpositionEvent expositionEvent) {
		getExpositionEvents().add(expositionEvent);
		expositionEvent.setGallery(this);

		return expositionEvent;
	}

	public ExpositionEvent removeExpositionEvent(ExpositionEvent expositionEvent) {
		getExpositionEvents().remove(expositionEvent);
		expositionEvent.setGallery(null);

		return expositionEvent;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Stand> getStands() {
		return this.stands;
	}

	public void setStands(List<Stand> stands) {
		this.stands = stands;
	}

	public Stand addStand(Stand stand) {
		getStands().add(stand);
		stand.setGallery(this);

		return stand;
	}

	public Stand removeStand(Stand stand) {
		getStands().remove(stand);
		stand.setGallery(null);

		return stand;
	}

}