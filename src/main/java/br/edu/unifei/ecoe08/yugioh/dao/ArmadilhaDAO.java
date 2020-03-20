package br.edu.unifei.ecoe08.yugioh.dao;

import java.util.List;

import br.edu.unifei.ecoe08.yugioh.model.Armadilha;

public class ArmadilhaDAO extends AbstractDAO<Armadilha, Integer> {
	
	public List<Armadilha> findByName(String name) {
		return getEntityManager().createQuery("from Armadilha a where a.nome='" + name + "' and DTYPE='Armadilha'").getResultList();
	}

}
