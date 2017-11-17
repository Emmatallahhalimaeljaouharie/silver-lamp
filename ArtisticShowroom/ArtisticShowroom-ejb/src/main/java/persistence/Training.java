package persistence;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 * The persistent class for the Training database table.
 * 
 */
@Entity
@NamedQuery(name = "Training.findAll", query = "SELECT t FROM Training t")
public class Training implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TrainingId")
	private int trainingId;

	@Column(name = "Description")
	private String description;

	@Column(name = "Subject")
	private String subject;

	@Column(name = "TrainingCity")
	private String trainingCity;

	@Column(name = "TrainingDate")
	private Date trainingDate;

	@Column(name = "TrainingStreet")
	private String trainingStreet;

	// bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "TrainerId")
	private User user;

	// bi-directional many-to-one association to TrainingParticipation
	@OneToMany(mappedBy = "training")
	private List<TrainingParticipation> trainingParticipations;

	public Training() {
	}

	public Training(int trainingId, String description, String subject, String trainingCity, String trainingStreet) {
		super();
		this.trainingId = trainingId;
		this.description = description;
		this.subject = subject;
		this.trainingCity = trainingCity;
		this.trainingStreet = trainingStreet;
	}

	public int getTrainingId() {
		return this.trainingId;
	}

	public void setTrainingId(int trainingId) {
		this.trainingId = trainingId;
	}

	public Training(int trainingId, String description, String subject, String trainingCity, Date trainingDate,
			String trainingStreet, User user) {
		super();
		this.trainingId = trainingId;
		this.description = description;
		this.subject = subject;
		this.trainingCity = trainingCity;
		this.trainingDate = trainingDate;
		this.trainingStreet = trainingStreet;
		this.user = user;
	}

	public Training(int trainingId, String description, String subject, String trainingCity, String trainingStreet,
			User user) {
		super();
		this.trainingId = trainingId;
		this.description = description;
		this.subject = subject;
		this.trainingCity = trainingCity;
		this.trainingStreet = trainingStreet;
		this.user = user;
	}

	public String getDescription() {
		return this.description;
	}

	public Training(String description, String subject, String trainingCity, Date trainingDate, String trainingStreet,
			User user) {
		super();
		this.description = description;
		this.subject = subject;
		this.trainingCity = trainingCity;
		this.trainingDate = trainingDate;
		this.trainingStreet = trainingStreet;
		this.user = user;
	}

	public String getTrainingCity() {
		return this.trainingCity;
	}

	public Date getTrainingDate() {
		return this.trainingDate;
	}

	public void setTrainingDate(Date trainingDate) {
		this.trainingDate = trainingDate;
	}

	public String getTrainingStreet() {
		return this.trainingStreet;
	}

	public String getSubject() {
		return subject;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<TrainingParticipation> getTrainingParticipations() {
		return this.trainingParticipations;
	}

	public void setTrainingParticipations(List<TrainingParticipation> trainingParticipations) {
		this.trainingParticipations = trainingParticipations;
	}

	public TrainingParticipation addTrainingParticipation(TrainingParticipation trainingParticipation) {
		getTrainingParticipations().add(trainingParticipation);
		trainingParticipation.setTraining(this);

		return trainingParticipation;
	}

	public TrainingParticipation removeTrainingParticipation(TrainingParticipation trainingParticipation) {
		getTrainingParticipations().remove(trainingParticipation);
		trainingParticipation.setTraining(null);

		return trainingParticipation;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void setTrainingCity(String trainingCity) {
		this.trainingCity = trainingCity;
	}

	public void setTrainingStreet(String trainingStreet) {
		this.trainingStreet = trainingStreet;
	}

}