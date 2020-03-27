package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Attractions;



public class AttractionHelper {
	static	EntityManagerFactory	emfactory	=	
			Persistence.createEntityManagerFactory("Animal");
	
	public void insertAttraction(Attractions li) {
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(li);
		em.getTransaction().commit();
		em.close();
		
	}
	
		public List<Attractions> getLists() {
		EntityManager em = emfactory.createEntityManager();
		List<Attractions> allAttractions = em.createQuery("SELECT d FROM Attractions d").getResultList();
		return allAttractions;
		}
		public Attractions searchForListId(Integer tempId) {
			EntityManager em= emfactory.createEntityManager();
			em.getTransaction().begin();
			Attractions found = em.find(Attractions.class, tempId);
			em.close();
			return found;
		}

		public void deleteAttraction(Attractions listToDelete) {
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			TypedQuery<Attractions> typedQuery = em.createQuery("select d from Attractions d where d.id=:selectedid",Attractions.class);

			//Substitute	parameter	with	actual	data	from	the	toDelete	item
			typedQuery.setParameter("selectedid",listToDelete.getId());
			
			//we	only	want	one	result
			typedQuery.setMaxResults(1);
			
			//get	the	result	and	save	it	into	a	new	list	item
			Attractions	result	=	typedQuery.getSingleResult();
			
			//remove	it
			em.remove(result);
			em.getTransaction().commit();
			em.close();
			}

		public void updateAttraction(Attractions toEdit) {
			// TODO Auto-generated method stub
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			
			em.merge(toEdit);
			em.getTransaction().commit();
			em.close();
		}
			
		
		
}



