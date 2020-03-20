package br.edu.unifei.ecoe08.yugioh.bean;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.edu.unifei.ecoe08.yugioh.dao.CartaDAO;
import br.edu.unifei.ecoe08.yugioh.model.Carta;
import lombok.Data;

@Data
@Named
@RequestScoped
public class CartaBean {	
	CartaDAO cdao = new CartaDAO();
	List<Carta> cartas = cdao.findAll();
	
}
