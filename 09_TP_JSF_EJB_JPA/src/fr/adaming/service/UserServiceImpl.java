package fr.adaming.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateful;

import fr.adaming.dao.IUserDao;
import fr.adaming.model.User;

@Stateful
public class UserServiceImpl implements IUserService{
	
	@EJB
	IUserDao userDao;

	@Override
	public void ajouterUserService(User us) {
		
		userDao.ajouterUserDao(us) ;
		
	}

	@Override
	public List<User> getAllUserService() {
		
		return userDao.getAllUserDao();
	}

	@Override
	public User getUserByIdService(int id_user) {
		return userDao.getUserByIdDao(id_user);
	}

	@Override
	public void supprimerUserService(User us) {
		userDao.supprimerUserDao(us);
		
	}

	@Override
	public void modifierUserService(User us) {
		userDao.modifierUserDao(us);
		
	}

	@Override
	public List<User> AllUsersGetByIdAgentService(Long id_agent) {
		
		return userDao.AllUsersGetByIdAgentDao(id_agent);
	}
	
	
	
}
