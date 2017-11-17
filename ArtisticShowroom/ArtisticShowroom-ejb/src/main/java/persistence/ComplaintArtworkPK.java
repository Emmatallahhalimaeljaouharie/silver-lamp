package persistence;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ComplaintArtwork database table.
 * 
 */
@Embeddable
public class ComplaintArtworkPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ClientFk", insertable=false, updatable=false)
	private String clientFk;

	@Column(name="ArtworkFk", insertable=false, updatable=false)
	private int artworkFk;

	@Column(name="DateCreation")
	private String dateCreation;

	public ComplaintArtworkPK() {
	}
	public String getClientFk() {
		return this.clientFk;
	}
	public void setClientFk(String clientFk) {
		this.clientFk = clientFk;
	}
	public int getArtworkFk() {
		return this.artworkFk;
	}
	public void setArtworkFk(int artworkFk) {
		this.artworkFk = artworkFk;
	}
	public String getDateCreation() {
		return this.dateCreation;
	}
	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ComplaintArtworkPK)) {
			return false;
		}
		ComplaintArtworkPK castOther = (ComplaintArtworkPK)other;
		return 
			this.clientFk.equals(castOther.clientFk)
			&& (this.artworkFk == castOther.artworkFk)
			&& this.dateCreation.equals(castOther.dateCreation);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.clientFk.hashCode();
		hash = hash * prime + this.artworkFk;
		hash = hash * prime + this.dateCreation.hashCode();
		
		return hash;
	}
}