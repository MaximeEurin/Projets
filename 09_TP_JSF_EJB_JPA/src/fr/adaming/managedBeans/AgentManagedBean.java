package fr.adaming.managedBeans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import fr.adaming.model.Agent;
import fr.adaming.model.User;
import fr.adaming.service.IAgentService;
import fr.adaming.service.IUserService;

@ManagedBean(name="agentMB")
@SessionScoped
public class AgentManagedBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String mail;
	private String mdp;
	
	private Agent agent;
	
	@EJB
	IAgentService agentService;
	
	@EJB
	IUserService userService;
	private List<User> listeUser;
	
	
	
	HttpSession session;


	/**
	 * 
	 */
	public AgentManagedBean() {
		//listeUser = userService.AllUsersGetByIdAgentService(agent.getId_agent());
	}

	/**
	 * @return the mail
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * @param mail the mail to set
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	/**
	 * @return the mdp
	 */
	public String getMdp() {
		return mdp;
	}

	/**
	 * @param mdp the mdp to set
	 */
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	/**
	 * @return the agent
	 */
	public Agent getAgent() {
		return agent;
	}

	/**
	 * @param agent the agent to set
	 */
	public void setAgent(Agent agent) {
		this.agent = agent;
	}
	
	
	
	
	/**
	 * @return the listeUser
	 */
	public List<User> getListeUser() {
		return listeUser;
	}

	/**
	 * @param listeUser the listeUser to set
	 */
	public void setListeUser(List<User> listeUser) {
		this.listeUser = listeUser;
	}

	
	//Méthode Metiers
	public String isExist(){
		
		List<Agent> listeAgents=agentService.isExistService(mail, mdp);
		
		if(listeAgents.size()==1){
			agent=listeAgents.get(0);
			
			session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
			session.setAttribute("agent", agent);
			
//			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("agent", agent);
//			listeUser = userService.AllUsersGetByIdAgentService(agent.getId_agent());
//			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("listeUser", listeUser);
			
			System.out.println(agent);
			return "succes";
			
		}else{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Le login ou le mot de passe est incorrect"));
			
			return "fail";
			
		}
		
	}

}
