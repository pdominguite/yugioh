package br.edu.unifei.ecoe08.yugioh.bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.edu.unifei.ecoe08.yugioh.dao.MonstroDAO;
import br.edu.unifei.ecoe08.yugioh.model.Monstro;
import lombok.Data;
import net.bootsfaces.utils.FacesMessages;

@Data
@Named
@ViewScoped
public class MonstroBean implements Serializable {
	private static final long serialVersionUID = 8075492948104324714L;
	private MonstroDAO mdao = new MonstroDAO();
	private Monstro monstro = new Monstro();
	private List<Monstro> monstros = new ArrayList<Monstro>();
	private List<Monstro> allMonstros = mdao.findAll();
	
	public void inserir() throws IOException {
		try {
			if(monstro.getNome().isBlank()) {
				FacesContext facesContext = FacesContext.getCurrentInstance();
				facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, null, "Carta Monstro possui nome em branco."));
				throw new Exception();
			}
			mdao.create(monstro);
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, null, "Carta Monstro inserida com sucesso."));
			facesContext.getExternalContext().getFlash().setKeepMessages(true);
		} catch (Exception e) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, null, "Carta Monstro não foi inserida."));
			facesContext.getExternalContext().getFlash().setKeepMessages(true);
		}
		FacesContext.getCurrentInstance().getExternalContext().redirect("../messages.xhtml");
	}
	
	public String findByName() throws IOException {
		monstros.clear();
		monstros = mdao.findByName(monstro.getNome());
		if(monstros.isEmpty()) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, null, "Carta Monstro não encontrada"));
			facesContext.getExternalContext().getFlash().setKeepMessages(true);
			FacesContext.getCurrentInstance().getExternalContext().redirect("../messages.xhtml");
		} else {
			monstro = monstros.get(0);
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
		//Need to get the reference to delete because an object return from find is detached, not managed.
		Monstro m = mdao.getEntityManager().getReference(Monstro.class, monstro.getId());
		mdao.delete(m);
		FacesMessages.info("Successfully deleted.");
		return "";
	}
}
