package services;

import java.util.List;

import javax.ejb.Remote;

import persistence.Training;
import persistence.User;

@Remote
public interface TrainingRemote {
	
	
	void saveOrUpdateTraining(Training training);

	void addTraining(Training training);

	void deleteTraining(Training training);

	Training findTrainingById(int id);

	void updateTraining(Training training);

	void deleteTrainingById(int id);

	List<Training> findAllTrainings();

	void addUser(User user);

	void deleteUser(User user);

	void updateUser(User User);

	User findUserById(int id);

	List<User> findAllUsers();

	User login(String login, String password);
	List<Training> AllTraining(String TrainerId);
	

}
