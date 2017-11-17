package persistence;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

/**
 * The persistent class for the ComplaintArtwork database table.
 * 
 */
@Entity
@NamedQuery(name = "ComplaintArtwork.findAll", query = "SELECT c FROM ComplaintArtwork c")
public class ComplaintArtwork implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ComplaintArtworkPK id;

	@Column(name = "ComplaintDeleted")
	private boolean complaintDeleted;

	@Column(name = "ComplaintTreated")
	private boolean complaintTreated;

	@Column(name = "Description")

	private String description;

	@Column(name = "Subject")
	private String subject;

	// bi-directional many-to-one association to Artwork
	@ManyToOne
	@JoinColumn(name = "ArtworkFk", referencedColumnName = "ArtworkId", insertable = false, updatable = false)
	private Artwork artwork;

	// bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "ClientFk", referencedColumnName = "Id", insertable = false, updatable = false)
	private User user;

	public ComplaintArtwork() {
	}

	public ComplaintArtworkPK getId() {
		return this.id;
	}

	public void setId(ComplaintArtworkPK id) {
		this.id = id;
	}

	public boolean getComplaintDeleted() {
		return this.complaintDeleted;
	}

	public void setComplaintDeleted(boolean complaintDeleted) {
		this.complaintDeleted = complaintDeleted;
	}

	public boolean getComplaintTreated() {
		return this.complaintTreated;
	}

	public void setComplaintTreated(boolean complaintTreated) {
		this.complaintTreated = complaintTreated;
	}

	public Object getDescription() {
		return this.description;
	}

	public void setDescription(Object description) {
		this.description = (String) description;
	}

	public Object getSubject() {
		return this.subject;
	}

	public void setSubject(Object subject) {
		this.subject = (String) subject;
	}

	public Artwork getArtwork() {
		return this.artwork;
	}

	public void setArtwork(Artwork artwork) {
		this.artwork = artwork;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}