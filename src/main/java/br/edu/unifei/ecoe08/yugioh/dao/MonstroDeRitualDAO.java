package br.edu.unifei.ecoe08.yugioh.dao;

import java.util.List;

import br.edu.unifei.ecoe08.yugioh.model.MonstroDeRitual;

public class MonstroDeRitualDAO extends AbstractDAO<MonstroDeRitual, Integer> {
	
	public List<MonstroDeRitual> findByName(String name) {
		return getEntityManager().createQuery("from MonstroDeRitual m where m.nome='" + name + "'").getResultList();
	}
}
