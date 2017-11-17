package services;

import java.util.List;

import javax.ejb.Local;

import persistence.Artwork;
import persistence.ArtworkSale;
import persistence.ArtworkSalePK;
import persistence.Training;
import persistence.User;

@Local
public interface BasicOpsLocal {
	void saveOrUpdateUser(User user);

	void addUser(User user);

	void deleteUser(User user);

	User findUserById(String id);

	void updateUser(User user);

	void deleteUserById(String id);

	List<User> findAllUsers();

	User login(String email, String password);

	public ArtworkSale FindArtworkSaleById(ArtworkSalePK idArtSale);
	
	//List<Training> findAllTrainingByUser(String trainerId);
	
	void updateArtworkSale(ArtworkSale artworkSale);
}
