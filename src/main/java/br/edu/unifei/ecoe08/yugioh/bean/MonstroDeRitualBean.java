package br.edu.unifei.ecoe08.yugioh.bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.edu.unifei.ecoe08.yugioh.dao.MonstroDeRitualDAO;
import br.edu.unifei.ecoe08.yugioh.model.FabricaDeEfeitos;
import br.edu.unifei.ecoe08.yugioh.model.Magica;
import br.edu.unifei.ecoe08.yugioh.model.Monstro;
import br.edu.unifei.ecoe08.yugioh.model.MonstroDeRitual;
import lombok.Data;
import net.bootsfaces.utils.FacesMessages;

@Data
@Named
@ViewScoped
public class MonstroDeRitualBean implements Serializable {
	
	private static final long serialVersionUID = -3067530347692259453L;
	private MonstroDeRitualDAO mrdao = new MonstroDeRitualDAO();
	private Monstro monstro1 = new Monstro();
	private Monstro monstro2 = new Monstro();
	private Monstro monstro3 = new Monstro();
	//private List<MonstroDeRitual> monstros = mrdao.findAll();
	private List<MonstroDeRitual> monstros = new ArrayList<MonstroDeRitual>();
	private FabricaDeEfeitos fEfeitos = new FabricaDeEfeitos();
	private Magica cartaDeRitual = fEfeitos.getNewCartaMagica();
	private MonstroDeRitual monstro = new MonstroDeRitual(monstro1, monstro2, monstro3, cartaDeRitual);
	
	public void inserir() throws IOException {
		try {
			if(monstro.getNome().isBlank()) {
				FacesContext facesContext = FacesContext.getCurrentInstance();
				facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, null, "Carta Monstro de Ritual possui nome em branco."));
				throw new Exception();
			}
			monstro.getMonstros().set(0, monstro1);
			monstro.getMonstros().set(1, monstro2);
			monstro.getMonstros().set(2, monstro3);
			mrdao.create(monstro);
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, null, "Carta Monstro de Ritual inserida com sucesso."));
			facesContext.getExternalContext().getFlash().setKeepMessages(true);
		} catch (Exception e) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, null, "Carta Monstro de Ritual não foi inserida."));
			facesContext.getExternalContext().getFlash().setKeepMessages(true);
		}
		FacesContext.getCurrentInstance().getExternalContext().redirect("../messages.xhtml");;
	}
	
	public String findByName() throws IOException {
		monstros = mrdao.findByName(monstro.getNome());
		if(monstros.isEmpty()) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, null, "Carta Monstro de Ritual não encontrada"));
			facesContext.getExternalContext().getFlash().setKeepMessages(true);
			FacesContext.getCurrentInstance().getExternalContext().redirect("../messages.xhtml");
		} 
		monstro = monstros.get(0);
		return "";
	}

	public String atualizar() {
		mrdao.update(monstro);
		FacesMessages.info("Successfully updated.");
		return "";
	}
	
	public String excluir() {
		//Need to get the reference to delete because an object return from find is detached, not managed.
		MonstroDeRitual m = mrdao.getEntityManager().getReference(MonstroDeRitual.class, monstro.getId());
		mrdao.delete(m);
		FacesMessages.info("Successfully deleted.");
		return "";
	}

}
