package persistence;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the Evaluation database table.
 * 
 */
@Embeddable
public class EvaluationPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ExpertFk", insertable=false, updatable=false)
	private String expertFk;

	@Column(name="ArtworkFk")
	private int artworkFk;

	@Column(name="EvaluationDate")
	private String evaluationDate;

	public EvaluationPK() {
	}
	public String getExpertFk() {
		return this.expertFk;
	}
	public void setExpertFk(String expertFk) {
		this.expertFk = expertFk;
	}
	public int getArtworkFk() {
		return this.artworkFk;
	}
	public void setArtworkFk(int artworkFk) {
		this.artworkFk = artworkFk;
	}
	public String getEvaluationDate() {
		return this.evaluationDate;
	}
	public void setEvaluationDate(String evaluationDate) {
		this.evaluationDate = evaluationDate;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof EvaluationPK)) {
			return false;
		}
		EvaluationPK castOther = (EvaluationPK)other;
		return 
			this.expertFk.equals(castOther.expertFk)
			&& (this.artworkFk == castOther.artworkFk)
			&& this.evaluationDate.equals(castOther.evaluationDate);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.expertFk.hashCode();
		hash = hash * prime + this.artworkFk;
		hash = hash * prime + this.evaluationDate.hashCode();
		
		return hash;
	}
}