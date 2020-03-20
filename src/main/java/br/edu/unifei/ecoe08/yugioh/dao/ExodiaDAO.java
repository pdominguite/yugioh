package br.edu.unifei.ecoe08.yugioh.dao;

import java.util.ArrayList;
import java.util.List;

import br.edu.unifei.ecoe08.yugioh.model.Exodia;

public class ExodiaDAO extends AbstractDAO<Exodia, Long> {
	
	public Exodia findExodia() {
		List<Exodia> m = new ArrayList<Exodia>();
		m = getEntityManager().createQuery("from Exodia e where e.nome='Exodia'").getResultList();
		if(m.isEmpty()) {
			return null;
		} else {
			System.out.println(m);
			return m.get(0);
		}
	}

}
