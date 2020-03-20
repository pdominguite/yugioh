package br.edu.unifei.ecoe08.yugioh.bean;

import java.io.IOException;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.edu.unifei.ecoe08.yugioh.dao.ExodiaDAO;
import br.edu.unifei.ecoe08.yugioh.dao.MonstroDAO;
import br.edu.unifei.ecoe08.yugioh.model.Exodia;
import br.edu.unifei.ecoe08.yugioh.model.Monstro;
import lombok.Data;
import net.bootsfaces.utils.FacesMessages;

@Data
@Named
@RequestScoped
public class ExodiaBean {
	
	private ExodiaDAO edao = new ExodiaDAO();
	private Exodia exodia = Exodia.getExodia();
	private MonstroDAO mdao = new MonstroDAO();
	private List<Monstro> allMonstros = mdao.findAll();
	
	public void inserir() throws IOException {
		if(edao.findExodia() == null) {
			edao.create(exodia);
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, null, "Exodia inserido com sucesso."));
			facesContext.getExternalContext().getFlash().setKeepMessages(true);
		} else {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Singleton!", "Exodia já existe no banco de dados."));
			facesContext.getExternalContext().getFlash().setKeepMessages(true);
		}
		FacesContext.getCurrentInstance().getExternalContext().redirect("../messages.xhtml");
	}
	
	public String buscar() throws IOException {
		exodia = edao.findExodia();
		if(exodia == null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, null, "Exodia não encontrado."));
			facesContext.getExternalContext().getFlash().setKeepMessages(true);
			FacesContext.getCurrentInstance().getExternalContext().redirect("../messages.xhtml");
		}
		return "";
	}

	public String atualizar() {
		edao.update(exodia);
		FacesMessages.info("Successfully updated.");
		return "";
	}
	
	public String excluir() {
		edao.delete(exodia);
		FacesMessages.info("Successfully deleted.");
		return "";
	}
}
