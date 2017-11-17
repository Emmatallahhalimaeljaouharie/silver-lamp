package services;

import java.util.List;

import javax.ejb.Remote;

import persistence.ArtworkSale;
import persistence.ArtworkSalePK;
import persistence.Training;
import persistence.User;

@Remote
public interface BasicOpsRemote {
	void saveOrUpdateUser(User user);

	void addUser(User user);

	void deleteUser(User user);

	User findUserById(String id);

	void updateUser(User user);

	void deleteUserById(String id);

	List<User> findAllUsers();

	User login(String email, String password);

	public ArtworkSale FindArtworkSaleById(ArtworkSalePK idArtSale);

//	void updateArtworkSale(ArtworkSale artworkSale);
	List<Training> findAllTrainingByUser(String trainerId);
}
