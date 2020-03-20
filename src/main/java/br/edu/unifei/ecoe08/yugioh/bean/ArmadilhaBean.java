package br.edu.unifei.ecoe08.yugioh.bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.edu.unifei.ecoe08.yugioh.dao.ArmadilhaDAO;
import br.edu.unifei.ecoe08.yugioh.model.Armadilha;
import br.edu.unifei.ecoe08.yugioh.model.FabricaDeEfeitos;
import lombok.Data;

@Data
@Named
@ViewScoped
public class ArmadilhaBean implements Serializable {	
	private static final long serialVersionUID = -5878528757415104976L;
	ArmadilhaDAO adao = new ArmadilhaDAO();
	FabricaDeEfeitos fEfeitos = new FabricaDeEfeitos();
	Armadilha armadilha = fEfeitos.getNewCartaArmadilha();
	List<Armadilha> armadilhas = new ArrayList<Armadilha>();
	
	public void inserir() throws IOException {
		try {
			if(armadilha.getNome().isBlank()) {
				FacesContext facesContext = FacesContext.getCurrentInstance();
				facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Oops!", "Carta Armadilha possui nome em branco."));
				throw new Exception();
			}
			adao.create(armadilha);
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Yes!", "Carta Armadilha inserida com sucesso."));
			facesContext.getExternalContext().getFlash().setKeepMessages(true);
		} catch (Exception e) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Oops!", "Carta Armadilha não foi inserida."));
			facesContext.getExternalContext().getFlash().setKeepMessages(true);
		}
		FacesContext.getCurrentInstance().getExternalContext().redirect("../messages.xhtml");
	}
	 
	public String findByName() throws IOException {
		armadilhas.clear();
		armadilhas = adao.findByName(armadilha.getNome());
		if(armadilhas.isEmpty()) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Oops!", "Carta Armadilha não encontrada"));
			facesContext.getExternalContext().getFlash().setKeepMessages(true);
			FacesContext.getCurrentInstance().getExternalContext().redirect("../messages.xhtml");
		} else {
			armadilha = armadilhas.get(0);
		}
		armadilha = armadilhas.get(0);
		return "";
	}

	public void atualizar() throws IOException {
		try {
			adao.update(armadilha);
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Yes!", "Carta Armadilha atualizada com sucesso."));
			facesContext.getExternalContext().getFlash().setKeepMessages(true);
		} catch (Exception e) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Oops!", "Carta Armadilha não foi atualizada."));
			facesContext.getExternalContext().getFlash().setKeepMessages(true);
		}
		FacesContext.getCurrentInstance().getExternalContext().redirect("../messages.xhtml");
	}
	
	public void excluir() throws IOException {
		try {
			//Need to get the reference to delete because an object return from find is detached, not managed.
			Armadilha a = adao.getEntityManager().getReference(Armadilha.class, armadilha.getId());
			adao.delete(a);
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Yes!", "Carta Armadilha removida com sucesso."));
			facesContext.getExternalContext().getFlash().setKeepMessages(true);
		} catch (Exception e) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Oops!", "Carta Armadilha não foi removida."));
			facesContext.getExternalContext().getFlash().setKeepMessages(true);
		}
		FacesContext.getCurrentInstance().getExternalContext().redirect("../messages.xhtml");
	}
}
