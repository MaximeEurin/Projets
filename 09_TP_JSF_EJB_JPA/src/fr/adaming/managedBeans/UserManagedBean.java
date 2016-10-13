package fr.adaming.managedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.primefaces.event.SelectEvent;

import fr.adaming.dao.IUserDao;
import fr.adaming.model.Agent;
import fr.adaming.model.User;
import fr.adaming.service.IUserService;




@ManagedBean(name="userMB")
@ViewScoped
public class UserManagedBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private User user;
	private Agent agent;
	HttpSession session;
	
	@EJB
	IUserService userService;
	
	List<User> listeUsers;
	
	@PostConstruct
	private void init(){
		System.out.println("constructeur user managed bean");
		session=(HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		agent=(Agent) session.getAttribute("agent");
		
		listeUsers=userService.AllUsersGetByIdAgentService(agent.getId_agent());
	}
	
	public UserManagedBean() {
//		System.out.println("constructeur user managed bean");
//		session=(HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
//		agent=(Agent) session.getAttribute("agent");
//		
//		listeUsers=userService.AllUsersGetByIdAgentService(agent.getId_agent());
		
		this.user=new User();
		

		
	
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
	/**
	 * @return the listeUsers
	 */
	public List<User> getListeUsers() {
		return listeUsers;
	}

	/**
	 * @param listeUsers the listeUsers to set
	 */
	public void setListeUsers(List<User> listeUsers) {
		this.listeUsers = listeUsers;
	}

	public String ajouter(){
		
		user.setAgent(agent);
		userService.ajouterUserService(user);
		List<User> listeUsers=new ArrayList<User>();
		
		listeUsers=userService.AllUsersGetByIdAgentService(agent.getId_agent());
		//session.setAttribute("listeUsers", listeUsers);
		return "accueil";

	}
	
	public String modifier(){
		user.setAgent(agent);
		userService.modifierUserService(user);
		List<User> listeUsers=new ArrayList<User>();
		
		listeUsers=userService.AllUsersGetByIdAgentService(agent.getId_agent());
		session.setAttribute("listeUsers", listeUsers);
		return "accueil";
	}


}
