package persistence;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The primary key class for the ArtworkSale database table.
 * 
 */
@Embeddable
public class ArtworkSalePK implements Serializable {
	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name = "ClientId", insertable = false, updatable = false)
	private String clientId;

	@Column(name = "ArtworkId", insertable = false, updatable = false)
	private int artworkId;

	public ArtworkSalePK() {
	}

	public ArtworkSalePK(String clientId, int artworkId) {
		super();
		this.clientId = clientId;
		this.artworkId = artworkId;

	}

	public String getClientId() {
		return this.clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public int getArtworkId() {
		return this.artworkId;
	}

	public void setArtworkId(int artworkId) {
		this.artworkId = artworkId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ArtworkSalePK)) {
			return false;
		}
		ArtworkSalePK castOther = (ArtworkSalePK) other;
		return this.clientId.equals(castOther.clientId) && (this.artworkId == castOther.artworkId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.clientId.hashCode();
		hash = hash * prime + this.artworkId;

		return hash;
	}
}