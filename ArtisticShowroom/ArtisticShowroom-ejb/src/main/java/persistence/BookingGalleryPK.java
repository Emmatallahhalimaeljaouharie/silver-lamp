package persistence;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the BookingGallery database table.
 * 
 */
@Embeddable
public class BookingGalleryPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ArtistId", insertable=false, updatable=false)
	private String artistId;

	@Column(name="GalleryId", insertable=false, updatable=false)
	private int galleryId;

	@Column(name="BookingDate")
	private String bookingDate;

	public BookingGalleryPK() {
	}
	public String getArtistId() {
		return this.artistId;
	}
	public void setArtistId(String artistId) {
		this.artistId = artistId;
	}
	public int getGalleryId() {
		return this.galleryId;
	}
	public void setGalleryId(int galleryId) {
		this.galleryId = galleryId;
	}
	public String getBookingDate() {
		return this.bookingDate;
	}
	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof BookingGalleryPK)) {
			return false;
		}
		BookingGalleryPK castOther = (BookingGalleryPK)other;
		return 
			this.artistId.equals(castOther.artistId)
			&& (this.galleryId == castOther.galleryId)
			&& this.bookingDate.equals(castOther.bookingDate);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.artistId.hashCode();
		hash = hash * prime + this.galleryId;
		hash = hash * prime + this.bookingDate.hashCode();
		
		return hash;
	}
}