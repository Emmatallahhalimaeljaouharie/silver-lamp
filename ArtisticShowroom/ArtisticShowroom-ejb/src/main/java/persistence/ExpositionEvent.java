package persistence;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

/**
 * The persistent class for the ExpositionEvent database table.
 * 
 */
@Entity
@NamedQuery(name = "ExpositionEvent.findAll", query = "SELECT e FROM ExpositionEvent e")
public class ExpositionEvent implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ExpositionEventId")
	private int expositionEventId;

	@Column(name = "EndDate")
	private String endDate;

	@Column(name = "ExpoDescription")
	private String expoDescription;

	@Column(name = "ExpoImage")
	private String expoImage;

	@Column(name = "ExpoSubject")
	private String expoSubject;

	@Column(name = "StartDate")
	private String startDate;

	// bi-directional many-to-one association to Gallery
	@ManyToOne
	@JoinColumn(name = "GalleryId", referencedColumnName = "GalleryId", insertable = false, updatable = false)
	private Gallery gallery;

	// bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "UserId")
	private User user;

	public ExpositionEvent() {
	}

	public int getExpositionEventId() {
		return this.expositionEventId;
	}

	public void setExpositionEventId(int expositionEventId) {
		this.expositionEventId = expositionEventId;
	}

	public String getEndDate() {
		return this.endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public Object getExpoDescription() {
		return this.expoDescription;
	}

	public void setExpoDescription(Object expoDescription) {
		this.expoDescription = (String) expoDescription;
	}

	public Object getExpoImage() {
		return this.expoImage;
	}

	public void setExpoImage(Object expoImage) {
		this.expoImage = (String) expoImage;
	}

	public Object getExpoSubject() {
		return this.expoSubject;
	}

	public void setExpoSubject(Object expoSubject) {
		this.expoSubject = (String) expoSubject;
	}

	public String getStartDate() {
		return this.startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
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