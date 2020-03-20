package br.edu.unifei.ecoe08.yugioh.dao;

import java.util.List;

import br.edu.unifei.ecoe08.yugioh.model.CampoDeDuelo;
import br.edu.unifei.ecoe08.yugioh.model.Estrutura;

public class EstruturaDAO extends AbstractDAO<Estrutura, Integer> {

	public List<Estrutura> findEstruturasTorneio() {
		return getEntityManager().createQuery("from Estrutura e where DTYPE in ('DiscoDeDuelo','ArenaDeDuelo')").getResultList();
	}
	
	public List<Integer> findCamposDeDuelo() {
		return getEntityManager().createQuery("select e.id from CampoDeDuelo e").getResultList();
	}
}
