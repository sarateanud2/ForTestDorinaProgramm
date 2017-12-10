package org.ascop.programs.servicess;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.ascop.programs.entitys.CopiiiSapp;
import org.ascop.programs.entitys.Parintii;
import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("servicesCopiiSapp")
public class ServicesCopiiSapp {
	
	@PersistenceContext
	private EntityManager em;
	
	public EntityManager getEm() {
		return em;
	}
	
	private List<CopiiiSapp> forAddCopii;
	private List<Parintii> forAddParinti;
	
	private List<CopiiiSapp> listForTestAddCopii = new ArrayList<>();
	
	public List<CopiiiSapp> getListForTestAddCopii() {
		return listForTestAddCopii;
	}
	
	

	public void setListForTestAddCopii(List<CopiiiSapp> listForTestAddCopii) {
		this.listForTestAddCopii = listForTestAddCopii;
	}

	public List<CopiiiSapp> getForAddCopii() {
		return forAddCopii;
	}

	public void setForAddCopii(List<CopiiiSapp> forAddCopii) {
		this.forAddCopii = forAddCopii;
	}

	public List<Parintii> getForAddParinti() {
		return forAddParinti;
	}

	public void setForAddParinti(List<Parintii> forAddParinti) {
		this.forAddParinti = forAddParinti;
	}

	@SuppressWarnings("unchecked")
	public List<CopiiiSapp> getAllCopiiParinti(){
		return this.em.createQuery("SELECT c FROM CopiiiSapp c").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Parintii> getAllParinti(){
		return this.em.createQuery("SELECT p FROM Parintii p").getResultList();
	}
	@Transactional
	public void addCopiiParintiList(List<CopiiiSapp> copiiSappList, List<Parintii> parintiSapp) {
//		copiiSappList.forEach(copii -> {
//										copii.getParintiis().addAll(parintiSapp);
//										this.em.merge(copii);
//										});
//		parintiSapp.forEach(parinti -> {parinti.getCopiiiSapps().addAll(copiiSappList);
//										this.em.merge(parinti);});
		
		/*for (CopiiiSapp copii : copiiSappList) {
				copii.setParintiis(parintiSapp);
		}*/

//		copiiSappList.forEach(cop -> cop.setParintiis(parintiSapp));
		parintiSapp.forEach(parinti -> parinti.setCopiiiSapps(copiiSappList));
		
//		copiiSappList.forEach(cop -> this.em.merge(cop));
		parintiSapp.forEach(p -> this.em.persist(p));
//		for (CopiiiSapp copii : copiiSappList) {
//			List<Parintii> parintiList = copii.getParintiis();
//			parintiList.forEach(p -> System.out.println(p.getNume()));
//		}
		
		
		
//		for (Parintii parintii : parintiSapp) {
//			parintii.getCopiiiSapps().addAll(copiiSappList);
//			
//		}
//		
//		for (CopiiiSapp copii : copiiSappList) {
//			this.em.merge(copii);
//		}
//		
//		for (Parintii parintii : parintiSapp) {
//			this.em.merge(parintii);
//		}
		
	}
	

	
	public List<Parintii> getParintiByCopiiSappId(int idCopil){
		Query query  = em.createQuery("SELECT p FROM Parintii p join p.copiiiSapps cs where cs.id = :copii");
		TypedQuery<Parintii> typeQuery = em.createQuery("SELECT p FROM Parintii p join p.copiiiSapps cs where cs.id = ?1", Parintii.class);
		return typeQuery.setParameter(1, idCopil).getResultList();
	}
	
//	public void addCopilSapp(Copi) {
//		
//	}
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ServicesCopiiSapp serv = (ServicesCopiiSapp) context.getBean("servicesCopiiSapp");
		List<CopiiiSapp> listServ = serv.getAllCopiiParinti();
//		List<Parintii> listParinti;
		/*
		for (CopiiiSapp c : listServ) {
			System.out.println("Copilul " + c.getNume() + " " + c.getPrenume() + " are parintii: ");
			List<Parintii> listParinti = c.getParintiis();
			for (Parintii parintii : listParinti) {
				System.out.println(parintii.getNume() + " " + parintii.getPrenume());
				System.out.println("\n\n");
			}
		}*/
		
		
		List<Parintii> listParinti = serv.getParintiByCopiiSappId(8);
		listParinti.forEach(s -> {System.out.println(s.getNume() + " " + s.getPrenume());});
		
	}
	
	public void copiiSappAdd(CopiiiSapp copiiiSapp){
		listForTestAddCopii.add(copiiiSapp);
	}
	
	
	//======================================================================
	@Transactional
	public void updateCopil(CopiiiSapp copii) {
		
		Query query = em.createQuery("Update CopiiiSapp " +
										"set nume = :nume, " +
										"prenume = :prenume " +
										"where id = :id");
		query.setParameter("nume", copii.getNume());
		query.setParameter("prenume", copii.getPrenume());
		query.setParameter("id", copii.getId());
		query.executeUpdate();
//		this.em.merge(copii);
//		em.unwrap(Session.class).update(copii);
	}
	
	@Transactional
	public void deleteCopilSapp(CopiiiSapp copil) {
		Query query = em.createQuery("delete from CopiiiSapp where id = :id");
		
		query.setParameter("id", copil.getId());
		query.executeUpdate();
	}

}
