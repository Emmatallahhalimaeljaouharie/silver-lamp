package services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import persistence.Training;
import persistence.User;

@Stateless

public class TrainingService implements TrainingLocal, TrainingRemote {

	@PersistenceContext
	EntityManager em;

	private BasicOps bol = new BasicOps();

	@Override
	public void saveOrUpdateTraining(Training training) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addTraining(Training training) {
		em.persist(training);

	}

	@Override
	public void deleteTraining(Training training) {
		em.remove(em.merge(training));
	}

	@Override
	public Training findTrainingById(int id) {

		Training a = em.find(Training.class, id);
		return a;

	}

	@Override
	public void updateTraining(Training training) {
		em.merge(training);
	}

	@Override
	public List<Training> rechercheralltrainings() {
		TypedQuery<Training> querry = em.createQuery("Select  t From Training t", Training.class);
		return querry.getResultList();

	}

	@Override
	public void deleteTrainingById(int id) {
		Training t = em.find(Training.class, id);
		em.remove(t);
		em.flush();
	}

	@Override
	public List<Training> findAllTrainings() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateUser(User User) {
		// TODO Auto-generated method stub

	}

	@Override
	public User findUserById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User login(String login, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Training> AllTraining(String trainerId) {
		TypedQuery<Training> querry = em.createQuery("Select  t From Training t where t.user.id = :param",
				Training.class);
		querry.setParameter("param", trainerId);

		return querry.getResultList();

	}

}
