package br.edu.unifei.ecoe08.yugioh.dao;

import java.util.List;

import br.edu.unifei.ecoe08.yugioh.model.MonstroDeFusao;

public class MonstroDeFusaoDAO extends AbstractDAO<MonstroDeFusao, Integer> {

	public List<MonstroDeFusao> findByName(String name) {
		return getEntityManager().createQuery("from MonstroDeFusao m where m.nome='" + name + "'").getResultList();
	}
	
}
