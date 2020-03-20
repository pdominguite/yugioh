package br.edu.unifei.ecoe08.yugioh.dao;

import java.util.List;

import br.edu.unifei.ecoe08.yugioh.model.Magica;

public class MagicaDAO extends AbstractDAO<Magica, Integer> {
	
	public List<Magica> findByName(String name) {
		return getEntityManager().createQuery("from Magica m where m.nome='" + name + "'").getResultList();
	}
	
	public List<Magica> findAllRitual() {
		return getEntityManager().createQuery("from Magica m where m.tipo = 'RITUAL'").getResultList();
	}
}
