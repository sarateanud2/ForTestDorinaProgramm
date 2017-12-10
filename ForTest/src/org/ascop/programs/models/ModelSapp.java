package org.ascop.programs.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.ascop.programs.entitys.CopiiiSapp;
import org.ascop.programs.entitys.Parintii;
import org.ascop.programs.servicess.ServicesCopiiSapp;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@ManagedBean(name="modelSapp", eager=true)
@SessionScoped
public class ModelSapp implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@ManagedProperty("#{servicesCopiiSapp}")
	private ServicesCopiiSapp services;
	
	private CopiiiSapp copiiiSapp;
	private Parintii parinti;
	private List<CopiiiSapp> filteredCopiiParinti;
	private List<Parintii> filteredParinti;
    private CopiiiSapp selectedCopillSapp;
    private Parintii selectedParinti;
    private CopiiiSapp addCopillSapp = new CopiiiSapp();
    private Parintii addParinte = new Parintii();
   
    
	private List<CopiiiSapp> forAddCopii = new ArrayList<>();
	private List<Parintii> forAddParinti = new ArrayList<>();
    
    private CopiiiSapp editCopiiSapp = new CopiiiSapp();
    
    public CopiiiSapp getEditCopiiSapp() {
		return editCopiiSapp;
	}



	public void setEditCopiiSapp(CopiiiSapp editCopiiSapp) {
		this.editCopiiSapp = editCopiiSapp;
	}



	public ModelSapp() {
//    	addCopillSapp = new CopiiiSapp();
//    	forAddCopii = new ArrayList<>();
//    	addParinte = new Parintii();
//    	forAddParinti = new ArrayList<>();
	}
    
 

	public CopiiiSapp getAddCopillSapp() {
		return addCopillSapp;
	}

	public void setAddCopillSapp(CopiiiSapp addCopillSapp) {
		this.addCopillSapp = addCopillSapp;
	}

	public Parintii getAddParinte() {
		return addParinte;
	}

	public void setAddParinte(Parintii addParinte) {
		this.addParinte = addParinte;
	}

	
//
//	public List<CopiiiSapp> getForAddCopii() {
//		return forAddCopii;
//	}
//
//	public void setForAddCopii(List<CopiiiSapp> forAddCopii) {
//		this.forAddCopii = forAddCopii;
//	}

	public List<Parintii> getForAddParinti() {
		return forAddParinti;
	}

	public void setForAddParinti(List<Parintii> forAddParinti) {
		this.forAddParinti = forAddParinti;
	}
	
	

	public List<CopiiiSapp> getForAddCopii() {
		return forAddCopii;
	}


	public void setForAddCopii(List<CopiiiSapp> forAddCopii) {
		this.forAddCopii = forAddCopii;
	}


	public List<Parintii> getFilteredParinti() {
		return filteredParinti;
	}

	public void setFilteredParinti(List<Parintii> filteredParinti) {
		this.filteredParinti = filteredParinti;
	}

	public Parintii getSelectedParinti() {
		return selectedParinti;
	}

	public void setSelectedParinti(Parintii selectedParinti) {
		this.selectedParinti = selectedParinti;
	}

	public List<CopiiiSapp> getFilteredCopiiParinti() {
		return filteredCopiiParinti;
	}

	public void setFilteredCopiiParinti(List<CopiiiSapp> filteredCopiiParinti) {
		this.filteredCopiiParinti = filteredCopiiParinti;
	}

	public CopiiiSapp getSelectedCopillSapp() {
		return selectedCopillSapp;
	}

	public void setSelectedCopillSapp(CopiiiSapp selectedCopillSapp) {
		this.selectedCopillSapp = selectedCopillSapp;
	}

	public CopiiiSapp getCopiiiSapp() {
		return copiiiSapp;
	}

	public void setCopiiiSapp(CopiiiSapp copiiiSapp) {
		this.copiiiSapp = copiiiSapp;
	}

	public Parintii getParinti() {
		return parinti;
	}

	public void setParinti(Parintii parinti) {
		this.parinti = parinti;
	}

	public ServicesCopiiSapp getServices() {
		return services;
	}

	public void setServices(ServicesCopiiSapp services) {
		this.services = services;
	}
	
	public List<CopiiiSapp> getAllCopiiParintiSapp(){
		return this.services.getAllCopiiParinti();
	}
	
	public List<Parintii> getAllParinti(){
		return this.services.getAllParinti();
	}
	
	public List<Parintii> getParintiByCopiiSappId(int id) {
		return this.services.getParintiByCopiiSappId(id);
	}
	
	public void addCopillToList() {
		this.forAddCopii.add(addCopillSapp);
		this.addCopillSapp = new CopiiiSapp();
		
	}
	public void addParintiToList() {
		this.forAddParinti.add(addParinte);
		addParinte = new Parintii();
	}
	
	public List<CopiiiSapp> getAllCopiiListForAdd(){
		return this.forAddCopii;
	}
	
	public List<Parintii> getAllParintiListForAdd(){
		return forAddParinti;
	}
	
	@PostConstruct
	public void initAddLists() {
		forAddCopii = new ArrayList<>();
		forAddParinti = new ArrayList<>();
	}
	
	public void addCopiiParintiList() {
		this.services.addCopiiParintiList(this.forAddCopii, this.forAddParinti);
		forAddCopii = new ArrayList<>();
		forAddParinti = new ArrayList<>();
	}	
	
	@PostConstruct
	public void initUpdate() {
		
	}
	
	public void updateCopil() {
		
		this.services.updateCopil(this.selectedCopillSapp);
        addMessage("Modificarea a trecut cu succes");
    }
	
	public void deleteCopilSapp() {
		
		this.services.deleteCopilSapp(this.selectedCopillSapp);
		addMessage("Stergerea a trecut cu succes");
	}
     
    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
	 

}
