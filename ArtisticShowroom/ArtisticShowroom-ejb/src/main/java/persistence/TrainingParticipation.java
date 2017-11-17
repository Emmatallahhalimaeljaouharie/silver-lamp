package persistence;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

/**
 * The persistent class for the TrainingParticipation database table.
 * 
 */
@Entity
@NamedQuery(name = "TrainingParticipation.findAll", query = "SELECT t FROM TrainingParticipation t")
public class TrainingParticipation implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TrainingParticipationPK id;

	@Column(name = "ResponseTrainingParticipation")
	private int responseTrainingParticipation;

	// bi-directional many-to-one association to Training
	@ManyToOne
	@JoinColumn(name = "TrainingId", referencedColumnName = "TrainingId", insertable = false, updatable = false)
	private Training training;

	// bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "TrainerId", referencedColumnName = "Id", insertable = false, updatable = false)
	private User user;

	public TrainingParticipation() {
	}

	public TrainingParticipationPK getId() {
		return this.id;
	}

	public void setId(TrainingParticipationPK id) {
		this.id = id;
	}

	public int getResponseTrainingParticipation() {
		return this.responseTrainingParticipation;
	}

	public void setResponseTrainingParticipation(int responseTrainingParticipation) {
		this.responseTrainingParticipation = responseTrainingParticipation;
	}

	public Training getTraining() {
		return this.training;
	}

	public void setTraining(Training training) {
		this.training = training;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}