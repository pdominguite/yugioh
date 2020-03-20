package br.edu.unifei.ecoe08.yugioh.bean;

import java.io.IOException;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.edu.unifei.ecoe08.yugioh.dao.DiscoDeDueloDAO;
import br.edu.unifei.ecoe08.yugioh.model.DiscoDeDuelo;
import lombok.Data;
import net.bootsfaces.utils.FacesMessages;

@Data
@Named
@RequestScoped
public class DiscoDeDueloBean {
	private DiscoDeDueloDAO ddao = new DiscoDeDueloDAO();
	private DiscoDeDuelo disco = new DiscoDeDuelo();
	private List<DiscoDeDuelo> discos = ddao.findAll();
	
	public void inserir() throws IOException {
		try {
			ddao.create(disco);
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, null, "Disco de Duelo inserido com sucesso."));
			facesContext.getExternalContext().getFlash().setKeepMessages(true);
		} catch (Exception e) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, null, "Disco de Duelo não foi inserido."));
			facesContext.getExternalContext().getFlash().setKeepMessages(true);
		}
		FacesContext.getCurrentInstance().getExternalContext().redirect("../messages.xhtml");
	}
	
	public String buscar() {
		ddao.find(disco.getId());
		return "";
	}

	public String atualizar() {
		ddao.update(disco);
		FacesMessages.info("Successfully updated.");
		return "";
	}
	
	public String excluir() {
		ddao.delete(disco);
		FacesMessages.info("Successfully deleted.");
		return "";
	}
}
