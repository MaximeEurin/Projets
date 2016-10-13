package fr.adaming.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.adaming.model.User;

@Stateless
public class UserDaoImpl implements IUserDao{
	
	@PersistenceContext(unitName="PU")
	EntityManager em;

	
	@Override
	public void ajouterUserDao(User us) {
		
		
		em.persist(us);
		
	}

	@Override
	public List<User> getAllUserDao() {
		
		String req = "select c from Utilisateur c";
		
		Query query = em.createQuery(req);

		List<User> liste = query.getResultList();

		for (User u : liste) {
			System.out.println(u);
		}
		return liste;

	}

	@Override
	public User getUserByIdDao(int id_user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void supprimerUserDao(User us) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifierUserDao(User us) {
		User user =em.find(User.class, us.getId_user());
		
		user.setNom(us.getNom());
		user.setDate(us.getDate());
		
		em.merge(user);
		
	}

	@Override
	public List<User> AllUsersGetByIdAgentDao(Long id_agent) {
		
		String req="Select u from User as u where u.agent.id_agent=:id";
		Query queryUsersByIdAgent = em.createQuery(req);
		queryUsersByIdAgent.setParameter("id",id_agent);
	
		
		@SuppressWarnings("unchecked")
		List<User> listeUsersByIdAgent = queryUsersByIdAgent.getResultList();
		
		System.out.println(listeUsersByIdAgent.size());

		return listeUsersByIdAgent;

	}
	
	
	

}
