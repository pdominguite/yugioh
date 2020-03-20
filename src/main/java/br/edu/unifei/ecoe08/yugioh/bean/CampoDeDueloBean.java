package br.edu.unifei.ecoe08.yugioh.bean;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.edu.unifei.ecoe08.yugioh.dao.CampoDeDueloDAO;
import br.edu.unifei.ecoe08.yugioh.dao.CartaDAO;
import br.edu.unifei.ecoe08.yugioh.dao.DuelistaDAO;
import br.edu.unifei.ecoe08.yugioh.dao.EstruturaDAO;
import br.edu.unifei.ecoe08.yugioh.model.CampoDeDuelo;
import br.edu.unifei.ecoe08.yugioh.model.Duelista;
import lombok.Data;
import net.bootsfaces.utils.FacesMessages;

@Data
@Named
@RequestScoped
public class CampoDeDueloBean {
	EstruturaDAO edao = new EstruturaDAO();
	CampoDeDueloDAO cdao = new CampoDeDueloDAO();
	CampoDeDuelo campo = new CampoDeDuelo();
	//Devemos usar Estrutura pois usando CampoDeDuelo.findAll() temos StackOverflow do método toString (recursão do autorrelacionamento)
	List<Integer> campos = edao.findCamposDeDuelo();
	CartaDAO cartaDAO = new CartaDAO();
	String cartasCemiterio = new String();
	String cartasJogo = new String();
	DuelistaDAO ddao = new DuelistaDAO();
	Duelista duelista = new Duelista();
	
	public String inserir() {
		//Feito pelo método builder.
		return "";
	}
	
	public String buscar() {
		campo = cdao.find(campo.getId());
		return "";
	}

	public String atualizar() {
		cdao.update(campo);
		FacesMessages.info("Successfully updated.");
		return "";
	}
	
	public String excluir() {
		cdao.delete(campo);
		FacesMessages.info("Successfully deleted.");
		return "";
	}
}
