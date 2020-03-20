package br.edu.unifei.ecoe08.yugioh.bean;

import java.io.IOException;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.edu.unifei.ecoe08.yugioh.dao.ArenaDeDueloDAO;
import br.edu.unifei.ecoe08.yugioh.model.ArenaDeDuelo;
import lombok.Data;

@Data
@Named
@RequestScoped
public class ArenaDeDueloBean {
	ArenaDeDueloDAO adao = new ArenaDeDueloDAO();
	ArenaDeDuelo arena = new ArenaDeDuelo();
	List<ArenaDeDuelo> arenas = adao.findAll();
	
	public void inserir() throws IOException {
		try {
			adao.create(arena);
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Yes!", "Arena de Duelo inserida com sucesso."));
			facesContext.getExternalContext().getFlash().setKeepMessages(true);
		} catch (Exception e) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Oops!", "Arena de Duelo não foi inserida."));
			facesContext.getExternalContext().getFlash().setKeepMessages(true);
		}
		FacesContext.getCurrentInstance().getExternalContext().redirect("../messages.xhtml");
	}

	public String buscar() {
		arena = adao.find(arena.getId());
		return "";
	}
	
	public void atualizar() throws IOException {
		try {
			adao.update(arena);
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Yes!", "Arena de Duelo atualizada com sucesso."));
			facesContext.getExternalContext().getFlash().setKeepMessages(true);
		} catch (Exception e) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Oops!", "Arena de Duelo não foi atualizada."));
			facesContext.getExternalContext().getFlash().setKeepMessages(true);
		}
		FacesContext.getCurrentInstance().getExternalContext().redirect("../messages.xhtml");
	}
	
	public void excluir() throws IOException {
		try {
			//Need to get the reference to delete because an object return from find is detached, not managed.
			ArenaDeDuelo a = adao.getEntityManager().getReference(ArenaDeDuelo.class, arena.getId());
			adao.delete(a);
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Yes!", "Arena de Duelo removida com sucesso."));
			facesContext.getExternalContext().getFlash().setKeepMessages(true);
		} catch (Exception e) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Oops!", "Arena de Duelo não foi removida."));
			facesContext.getExternalContext().getFlash().setKeepMessages(true);
		}
		FacesContext.getCurrentInstance().getExternalContext().redirect("../messages.xhtml");
	}

}
