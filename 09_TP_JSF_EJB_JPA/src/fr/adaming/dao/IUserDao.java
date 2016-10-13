package fr.adaming.dao;

import java.util.List;

import javax.ejb.Local;

import fr.adaming.model.User;

@Local
public interface IUserDao {
	
	public void ajouterUserDao(User us);
	
	public List<User> getAllUserDao();
	
	public User getUserByIdDao(int id_user);
	
	public void supprimerUserDao(User us);
	
	public void modifierUserDao(User us);
	
	public List<User> AllUsersGetByIdAgentDao(Long id_agent);

}
