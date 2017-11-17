package services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import persistence.ArtworkSale;
import persistence.ArtworkSalePK;
import persistence.Training;
import persistence.User;

@Stateless
public class BasicOps implements BasicOpsRemote, BasicOpsLocal {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public BasicOps() {
	}

	@Override
	public void addUser(User user) {
		entityManager.persist(user);
		entityManager.flush();
	}

	@Override
	public void deleteUser(User user) {
		entityManager.remove(user);
	}

	@Override
	public User findUserById(String id) {
		return entityManager.find(User.class, id);
	}

	@Override
	public void updateUser(User user) {
		entityManager.merge(user);
	}

	@Override
	public void deleteUserById(String id) {
		entityManager.remove(findUserById(id));
	}

	@Override
	public List<User> findAllUsers() {
		String jpql = "SELECT u FROM User u";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}

	@Override
	public User login(String email, String password) {
		User user = null;
		Query query = entityManager
				.createQuery("SELECT u FROM User u WHERE u.email=:param1 AND u.passwordHash=:param2");
		query.setParameter("param1", email);
		query.setParameter("param2", password);
		try {
			user = (User) query.getSingleResult();
		} catch (Exception e) {
			System.err.println("user not found");
		}
		return user;
	}
	
	
//	@Override
//	public List<Training> findAllTrainingByUser(String trainerId) {
//		
//			String jpql = "SELECT t FROM Training t WHERE t.User.id=:param";
//			Query query = entityManager.createQuery(jpql);
//			query.setParameter("param", trainerId);
//			return query.getResultList();
//			
			
			
//		}

	@Override
	public void saveOrUpdateUser(User user) {
		entityManager.merge(user);

	}

	@Override
	public ArtworkSale FindArtworkSaleById(ArtworkSalePK idArtSale) {
		return entityManager.find(ArtworkSale.class, idArtSale);

	}

	@Override
	public void updateArtworkSale(ArtworkSale artworkSale) {
		entityManager.merge(artworkSale);

	}

	@Override
	public List<Training> findAllTrainingByUser(String trainerId) {
		// TODO Auto-generated method stub
		return null;
	}
}
