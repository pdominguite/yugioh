package br.edu.unifei.ecoe08.yugioh.dao;

import java.util.List;

import br.edu.unifei.ecoe08.yugioh.model.Monstro;

public class MonstroDAO extends AbstractDAO<Monstro, Integer> {

	public List<Monstro> findByName(String name) {
		return getEntityManager().createQuery("from Monstro m where m.nome='" + name + "' and DTYPE='Monstro'").getResultList();
	}
}
