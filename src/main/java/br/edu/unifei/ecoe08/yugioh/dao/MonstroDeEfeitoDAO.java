package br.edu.unifei.ecoe08.yugioh.dao;

import java.util.List;

import br.edu.unifei.ecoe08.yugioh.model.MonstroDeEfeito;

public class MonstroDeEfeitoDAO extends AbstractDAO<MonstroDeEfeito, Long> {
	
	public List<MonstroDeEfeito> findByName(String name) {
		return getEntityManager().createQuery("from MonstroDeEfeito m where m.nome='" + name + "'").getResultList();
	}
}
