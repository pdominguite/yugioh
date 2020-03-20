package br.edu.unifei.ecoe08.yugioh.dao;

import java.util.List;

import br.edu.unifei.ecoe08.yugioh.model.ReliquiaDoMilenio;

public class ReliquiaDoMilenioDAO extends AbstractDAO<ReliquiaDoMilenio, String> {
	
	public List<String> reliquiasNomes() {
		return getEntityManager().createQuery("select r.nome from ReliquiaDoMilenio r").getResultList();
	}

}
