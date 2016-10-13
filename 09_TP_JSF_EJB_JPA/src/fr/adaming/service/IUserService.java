package fr.adaming.service;

import java.util.List;

import javax.ejb.Local;

import fr.adaming.model.User;

@Local
public interface IUserService {
	
	public void ajouterUserService(User us);
	
	public List<User> getAllUserService();
	
	public User getUserByIdService(int id_user);
	
	public void supprimerUserService(User us);
	
	public void modifierUserService(User us);
	
	public List<User> AllUsersGetByIdAgentService(Long id_agent);
	
}
