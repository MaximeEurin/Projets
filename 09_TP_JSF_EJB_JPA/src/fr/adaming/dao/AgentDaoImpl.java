package fr.adaming.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.adaming.model.Agent;

@Stateless
public class AgentDaoImpl implements IAgentDao{
	
	@PersistenceContext(unitName="PU")
	EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Agent> isExist(String login, String password) {
		
		
		
		String reqJpql="Select u from Agent u where u.login=:pmail and u.password=:pmdp";
		
		Query query=em.createQuery(reqJpql);
		
		query.setParameter("pmail", login);
		query.setParameter("pmdp", password);
		
		List<Agent> liste=query.getResultList();
		
		return liste;
	}

	@Override
	public Agent AgentGetByIdDAO(String login, String mdp) {
		
		Query queryAgentId = em.createNamedQuery("getAgent");
		queryAgentId.setParameter("mail",login);
		queryAgentId.setParameter("mdp",mdp);
		
		Agent searchAgent =  (Agent) queryAgentId.getSingleResult();
		System.out.println("l'agent est :" + searchAgent);
		return searchAgent;

	}
	
	

}
