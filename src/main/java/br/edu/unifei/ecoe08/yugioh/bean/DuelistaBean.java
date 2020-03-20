package br.edu.unifei.ecoe08.yugioh.bean;

import java.io.IOException;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.edu.unifei.ecoe08.yugioh.dao.DuelistaDAO;
import br.edu.unifei.ecoe08.yugioh.dao.ReliquiaDoMilenioDAO;
import br.edu.unifei.ecoe08.yugioh.model.Duelista;
import lombok.Data;
import net.bootsfaces.utils.FacesMessages;

@Data
@Named
@RequestScoped
public class DuelistaBean {
	DuelistaDAO ddao = new DuelistaDAO();
	Duelista duelista = new Duelista();
	List<Duelista> duelistas = ddao.findAll();
	ReliquiaDoMilenioDAO rdao = new ReliquiaDoMilenioDAO();
	String reliquias = new String();
	
	public void inserir() throws IOException {
		try {
			if(duelista.getNome().isBlank()) {
				FacesContext facesContext = FacesContext.getCurrentInstance();
				facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, null, "Duelista possui nome em branco."));
				facesContext.getExternalContext().getFlash().setKeepMessages(true);
				throw new Exception();
			}
			String reliquiasArray[] = reliquias.split(",");
			if(reliquiasArray[0] != "") {
				for(String r : reliquiasArray) {
					duelista.getReliquias().add(rdao.find(r));
				}
			}
			ddao.create(duelista);
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, null, "Duelista inserido com sucesso."));
			facesContext.getExternalContext().getFlash().setKeepMessages(true);
		} catch (Exception e) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, null, "Duelista não foi inserido."));
			facesContext.getExternalContext().getFlash().setKeepMessages(true);
		}
		FacesContext.getCurrentInstance().getExternalContext().redirect("../messages.xhtml");
	}
	
	public String buscar() throws IOException {
		duelista = ddao.find(duelista.getNome());
		if(duelista == null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, null, "Duelista não encontrado."));
			facesContext.getExternalContext().getFlash().setKeepMessages(true);
			FacesContext.getCurrentInstance().getExternalContext().redirect("../messages.xhtml");
		}
		return "";
	}
	
	public String atualizar() {
		ddao.update(duelista);
		FacesMessages.info("Successfully updated.");
		return "";
	}
	
	public String excluir() {
		ddao.delete(duelista);
		FacesMessages.info("Successfully deleted.");
		return "";
	}
	
}