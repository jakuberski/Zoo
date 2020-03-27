package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Presenter;

public class PresenterHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Animal");
	
	public void insertPresenter(Presenter p) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		em.close();
		
	}

	public List<Presenter> showAllPresenters(){
		EntityManager em = emfactory.createEntityManager();
		List<Presenter> allPresenters = em.createQuery("Select p from Presenter p").getResultList();
		return allPresenters;
	}
	
	public Presenter searchForPresenterName(String presenterName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Presenter> typedQuery = em.createQuery("select s from Presenter s where s.presenterName = :selectedName", Presenter.class);
		typedQuery.setParameter("selectedName", presenterName);
		typedQuery.setMaxResults(1);

		Presenter found = typedQuery.getSingleResult();
		em.close();
		return found;
	}
}
