package TBeans;



import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import mBeans.IdentityBean;
import persistence.Training;
import persistence.TrainingParticipation;
import persistence.User;
import services.BasicOpsLocal;
import services.TrainingLocal;

@ManagedBean
@SessionScoped
public class TrainingBean {
	
	@ManagedProperty(value = "#{identityBean}")
	private IdentityBean identityBean;

	public IdentityBean getIdentityBean() {
		return identityBean;
	}

	public void setIdentityBean(IdentityBean identityBean) {
		this.identityBean = identityBean;
	}

	private Training t ;
	private int trainingId;
	private String description;
	private String subject;
	private String trainingCity;
	
	private Date trainingDate;
	private String trainingStreet;
	List<TrainingParticipation> trainingParticipations;
	private User user;

	@EJB
	private TrainingLocal tl;
	private BasicOpsLocal basicOpsLocal;
	
	private IdentityBean IB ;
	
	public int getTrainingId() {
		return trainingId;
	}

	public void setTrainingId(int trainingId) {
		this.trainingId = trainingId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getTrainingCity() {
		return trainingCity;
	}

	public void setTrainingCity(String trainingCity) {
		this.trainingCity = trainingCity;
	}

	public Date getTrainingDate() {
		return trainingDate;
	}

	public void setTrainingDate(Date trainingDate) {
		this.trainingDate = trainingDate;
	}

	public String getTrainingStreet() {
		return trainingStreet;
	}

	public void setTrainingStreet(String trainingStreet) {
		this.trainingStreet = trainingStreet;
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

	public String addTrainer(){
		
		
		t= new Training();
		t.setUser(getIdentityBean().getUser());
		t.setDescription(description);
		t.setSubject(subject);
	    t.setTrainingCity(trainingCity);
	    t.setTrainingStreet(trainingStreet);
	    t.setTrainingDate(trainingDate);

		tl.addTraining(t);
		
		System.err.print("test");
		 return "ListTraining.jsf?faces-redirect=true";
		
		
	}
	
	private List<Training> trainings;
	

	public List<Training> getTrainings() {
		return trainings;
	}

	public void setTrainings(List<Training> trainings) {
		this.trainings = trainings;
	}
	
	public List<Training> getalltrainings() {

		trainings = tl.rechercheralltrainings();
		return trainings;

	}
	
	public List<Training>All(User user)
	{
		trainings =tl.AllTraining(getUser().getId());
		return trainings;
		
		
	}

	public void DeletetTraining(int id) {

		tl.deleteTrainingById(id);
	
	}

	public Training getT() {
		return t;
	}

	public void setT(Training t) {
		this.t = t;
	}
	
	public String  delete(int id) {
		tl.deleteTrainingById(id);
		 return "ListTraining.jsf?faces-redirect=true";
		
	}
	
	public String Details(Training tra) {

		
		int a=tra.getTrainingId();
		Training train=tl.findTrainingById(a);
		  String s =train.getDescription();
		  t=train;
		  String b=t.getDescription();
		
     System.out.println(s);
     System.out.println(b);
		return "update.jsf?faces-redirect=true";

	}
	
	public String MettreajourTraining() {
		
		Training tt = new Training(t.getDescription(),t.getSubject(),t.getTrainingCity(),t.getTrainingDate(),t.getTrainingStreet(),t.getUser());
		
		
		tl.updateTraining(tt);

		return "ListTraining.jsf?faces-redirect=true";

	}
	
	
	public String DetailsAffiche(Training trai)
	{
		
	

	int a=trai.getTrainingId();
		Training train=tl.findTrainingById(a);
		  String s =  train.getDescription();
		  t=train;
		  String b=t.getDescription();
		
    System.out.println(s);
    System.out.println(b);
		return "Detail.jsf?faces-redirect=true";
	
	}

	public String go()
	{
		
	

		return "ListTraining.jsf?faces-redirect=true";
	
	}

	public String Create()
	{
		
	

		return "ajouter.jsf?faces-redirect=true";
	
	}

	
}
