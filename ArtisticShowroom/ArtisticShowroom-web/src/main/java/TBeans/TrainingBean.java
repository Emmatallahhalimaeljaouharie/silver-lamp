package TBeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import mBeans.IdentityBean;
import persistence.Training;
import persistence.TrainingParticipation;
import persistence.User;
import services.TrainingLocal;

@ManagedBean
@ViewScoped
public class TrainingBean {
	private List<TrainingParticipation> trainingParticipations;
	private User user;
	private Training training = new Training();
	private Training trainingSelected = new Training();
	private List<Training> trainingsByUser = new ArrayList<>();

	@ManagedProperty(value = "#{identityBean}")
	private IdentityBean identityBean;

	@EJB
	private TrainingLocal trainingLocal;

	@PostConstruct
	public void init() {
		String TrainerId = identityBean.getUser().getId();
		trainingsByUser = trainingLocal.AllTraining(TrainerId);
	}

	public void doUpdateTraining() {
		trainingLocal.updateTraining(trainingSelected);
	}

	public void doDeleteTraining() {
		trainingLocal.deleteTraining(trainingSelected);
		init();
	}

	public List<TrainingParticipation> getTrainingParticipations() {
		return trainingParticipations;
	}

	public void setTrainingParticipations(List<TrainingParticipation> trainingParticipations) {
		this.trainingParticipations = trainingParticipations;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String doAddTraining() {
		training.setUser(identityBean.getUser());
		trainingLocal.addTraining(training);

		System.err.print("test");
		return "ListTraining.jsf?faces-redirect=true";

	}

	public IdentityBean getIdentityBean() {
		return identityBean;
	}

	public void setIdentityBean(IdentityBean identityBean) {
		this.identityBean = identityBean;
	}

	// public String Details(Training tra) {
	//
	// int a = tra.getTrainingId();
	// Training train = tl.findTrainingById(a);
	// String s = train.getDescription();
	// training = train;
	// String b = training.getDescription();
	//
	// System.out.println(s);
	// System.out.println(b);
	// return "update.jsf?faces-redirect=true";
	//
	// }

	// public String MettreajourTraining() {
	//
	// Training tt = new Training(training.getDescription(),
	// training.getSubject(), training.getTrainingCity(),
	// training.getTrainingDate(), training.getTrainingStreet(),
	// training.getUser());
	//
	// tl.updateTraining(tt);
	//
	// return "ListTraining.jsf?faces-redirect=true";
	//
	// }

	// public String DetailsAffiche(Training trai) {
	//
	// int a = trai.getTrainingId();
	// Training train = tl.findTrainingById(a);
	// String s = train.getDescription();
	// training = train;
	// String b = training.getDescription();
	//
	// System.out.println(s);
	// System.out.println(b);
	// return "Detail.jsf?faces-redirect=true";
	//
	// }

	public String go() {

		return "ListTraining.jsf?faces-redirect=true";

	}

	public String Create() {

		return "ajouter.jsf?faces-redirect=true";

	}

	public Training getTraining() {
		return training;
	}

	public void setTraining(Training training) {
		this.training = training;
	}

	public List<Training> getTrainingsByUser() {
		return trainingsByUser;
	}

	public void setTrainingsByUser(List<Training> trainingsByUser) {
		this.trainingsByUser = trainingsByUser;
	}

	public Training getTrainingSelected() {
		return trainingSelected;
	}

	public void setTrainingSelected(Training trainingSelected) {
		this.trainingSelected = trainingSelected;
	}

}
