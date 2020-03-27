package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Animals;


public class AnimalHelper {
	
	static	EntityManagerFactory	emfactory	=	
			Persistence.createEntityManagerFactory("Animal");
	
	public void insertAnimal(Animals li) {
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(li);
		em.getTransaction().commit();
		em.close();
		
	}
	
	public List<Animals>showAllAnimal(){
		EntityManager em = emfactory.createEntityManager();
		List<Animals>allAnimal = em.createQuery("SELECT i FROM Animals i").getResultList();
		return allAnimal;
	}
	
	public void deleteAnimal(Animals toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Animals>TypedQuery = em.createQuery("select li from Animals li where li.type=:selectedType and  li.area =:selectedArea",Animals.class);
		
		//Substitute	parameter	with	actual	data	from	the	toDelete	item
		TypedQuery.setParameter("selectedType",toDelete.getType());
		TypedQuery.setParameter("selectedArea",	toDelete.getArea());
		
	
		//we	only	want	one	result
		TypedQuery.setMaxResults(1);
		
		//get	the	result	and	save	it	into	a	new	list	item
		Animals	result	=	TypedQuery.getSingleResult();
		
		//remove	it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
		}

	public Animals searchForAnimalId(int idToEdit) {
		EntityManager em= emfactory.createEntityManager();
		em.getTransaction().begin();
		Animals found = em.find(Animals.class, idToEdit);
		em.close();
		return found;
	}

	

	public void updateAnimal(Animals toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
		
		
	}

	public List<Animals> searchForType(String typeName) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Animals>TypedQuery = em.createQuery("select li from Animals li where li.type = :selectedType", Animals.class);
		TypedQuery.setParameter("selectedType", typeName);
		
		List<Animals>foundItems = TypedQuery.getResultList();
		em.close();
		return foundItems;
	}

	public List<Animals> searchForArea(String areaName) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Animals>TypedQuery = em.createQuery("select li from Animals li where li.area =:selectedArea",Animals.class);
		TypedQuery.setParameter("selectedArea",areaName);
		
		List<Animals>foundItems = TypedQuery.getResultList();
		em.close();
		return foundItems;
	}
	
	
	public void cleanUp() {
		emfactory.close();
	}

	

}


