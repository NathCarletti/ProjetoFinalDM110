package br.inatel.dm110.hello.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.inatel.dm110.hello.entities.Infoip;

@Stateless
public class InfoipDAO {
	
	@PersistenceContext(unitName = "ipdatabase")
	private EntityManager em;

	public List<Infoip> listAll() {
		return em.createQuery("from Infoip i", Infoip.class).getResultList();
	}
	
	public void insert(Infoip infoip) {
		em.persist(infoip);
	}

}
