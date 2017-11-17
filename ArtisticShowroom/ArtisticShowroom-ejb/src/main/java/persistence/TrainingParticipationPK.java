package persistence;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the TrainingParticipation database table.
 * 
 */
@Embeddable
public class TrainingParticipationPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="TrainerId", insertable=false, updatable=false)
	private String trainerId;

	@Column(name="TrainingId", insertable=false, updatable=false)
	private int trainingId;

	@Column(name="TrainingParticipationDate")
	private String trainingParticipationDate;

	public TrainingParticipationPK() {
	}
	public String getTrainerId() {
		return this.trainerId;
	}
	public void setTrainerId(String trainerId) {
		this.trainerId = trainerId;
	}
	public int getTrainingId() {
		return this.trainingId;
	}
	public void setTrainingId(int trainingId) {
		this.trainingId = trainingId;
	}
	public String getTrainingParticipationDate() {
		return this.trainingParticipationDate;
	}
	public void setTrainingParticipationDate(String trainingParticipationDate) {
		this.trainingParticipationDate = trainingParticipationDate;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof TrainingParticipationPK)) {
			return false;
		}
		TrainingParticipationPK castOther = (TrainingParticipationPK)other;
		return 
			this.trainerId.equals(castOther.trainerId)
			&& (this.trainingId == castOther.trainingId)
			&& this.trainingParticipationDate.equals(castOther.trainingParticipationDate);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.trainerId.hashCode();
		hash = hash * prime + this.trainingId;
		hash = hash * prime + this.trainingParticipationDate.hashCode();
		
		return hash;
	}
}