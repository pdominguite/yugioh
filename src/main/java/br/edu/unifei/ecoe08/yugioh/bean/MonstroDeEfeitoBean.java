package br.edu.unifei.ecoe08.yugioh.bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.edu.unifei.ecoe08.yugioh.dao.MonstroDeEfeitoDAO;
import br.edu.unifei.ecoe08.yugioh.model.MonstroDeEfeito;
import lombok.Data;
import net.bootsfaces.utils.FacesMessages;

@Data
@Named
@ViewScoped
public class MonstroDeEfeitoBean implements Serializable {
	
	private static final long serialVersionUID = 7005733202227574966L;
	private MonstroDeEfeitoDAO mdao = new MonstroDeEfeitoDAO();
	private MonstroDeEfeito monstro = new MonstroDeEfeito();
	private List<MonstroDeEfeito> monstros = new ArrayList<MonstroDeEfeito>();
	
	public void inserir() throws IOException {
		try {
			if(monstro.getNome().isBlank()) {
				FacesContext facesContext = FacesContext.getCurrentInstance();
				facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, null, "Carta Monstro de Efeito possui nome em branco."));
				throw new Exception();
			}
			mdao.create(monstro);
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, null, "Carta Monstro de Efeito inserida com sucesso."));
			facesContext.getExternalContext().getFlash().setKeepMessages(true);
		} catch (Exception e) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, null, "Carta Monstro de Efeito não foi inserida."));
			facesContext.getExternalContext().getFlash().setKeepMessages(true);
		}
		FacesContext.getCurrentInstance().getExternalContext().redirect("../messages.xhtml");
	}
	
	public String findByName() throws IOException {
		monstros.clear();
		monstros = mdao.findByName(monstro.getNome());
		if(monstros.isEmpty()) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, null, "Carta Monstro de Efeito não encontrada"));
			facesContext.getExternalContext().getFlash().setKeepMessages(true);
			FacesContext.getCurrentInstance().getExternalContext().redirect("../messages.xhtml");
		}
		monstro = monstros.get(0);
		return "";
	}

	public String atualizar() {
		mdao.update(monstro);
		FacesMessages.info("Successfully updated.");
		return "";
	}
	
	public String excluir() {
		//Need to get the reference to delete because a object return from find is detached, not managed.
		MonstroDeEfeito m = mdao.getEntityManager().getReference(MonstroDeEfeito.class, monstro.getId());
		mdao.delete(m);
		FacesMessages.info("Successfully deleted.");
		return "";
	}
}
