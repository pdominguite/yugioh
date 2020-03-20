package br.edu.unifei.ecoe08.yugioh.bean;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.edu.unifei.ecoe08.yugioh.dao.EstruturaDAO;
import br.edu.unifei.ecoe08.yugioh.model.Estrutura;
import lombok.Data;

@Data
@Named
@RequestScoped
public class EstruturaBean {
	private EstruturaDAO edao = new EstruturaDAO();
	private List<Estrutura> estruturas = edao.findEstruturasTorneio();
	private List<Integer> campos = edao.findCamposDeDuelo();
}
