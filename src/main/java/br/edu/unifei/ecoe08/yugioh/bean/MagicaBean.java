package br.edu.unifei.ecoe08.yugioh.bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.edu.unifei.ecoe08.yugioh.dao.MagicaDAO;
import br.edu.unifei.ecoe08.yugioh.enumerate.TipoMagiaEnum;
import br.edu.unifei.ecoe08.yugioh.enumerate.TipoVelocidadeEnum;
import br.edu.unifei.ecoe08.yugioh.model.FabricaDeEfeitos;
import br.edu.unifei.ecoe08.yugioh.model.Magica;
import lombok.Data;
import net.bootsfaces.utils.FacesMessages;

@Data
@Named
@ViewScoped
public class MagicaBean implements Serializable {
	
	private static final long serialVersionUID = 6961048480203918731L;
	MagicaDAO mdao = new MagicaDAO();
	FabricaDeEfeitos fEfeitos = new FabricaDeEfeitos();
	Magica magica = fEfeitos.getNewCartaMagica();
	List<Magica> magicas = mdao.findAll();
	List<Magica> magicasRitual = mdao.findAllRitual();
	List<Magica> m = new ArrayList<Magica>();
	
	public void inserir() throws IOException {
		try {
			if(magica.getNome().isBlank()) {
				FacesContext facesContext = FacesContext.getCurrentInstance();
				facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, null, "Carta Mágica possui nome em branco."));
				throw new Exception();
			}
			mdao.create(magica);
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, null, "Carta Mágica inserida com sucesso."));
			facesContext.getExternalContext().getFlash().setKeepMessages(true);
		} catch (Exception e) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, null, "Carta Mágica não foi inserida."));
			facesContext.getExternalContext().getFlash().setKeepMessages(true);
		}
		FacesContext.getCurrentInstance().getExternalContext().redirect("../messages.xhtml");
	}
	 
	public String findByName() throws IOException {
		m = mdao.findByName(magica.getNome());
		if(m.isEmpty()) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, null, "Carta Mágica não encontrada"));
			facesContext.getExternalContext().getFlash().setKeepMessages(true);
			FacesContext.getCurrentInstance().getExternalContext().redirect("../messages.xhtml");
		} else {
			magica = m.get(0);
		}
		return "";
	}	
	
	public List<Magica> findPolimerizacao() {
		Magica m = fEfeitos.getNewCartaMagica();
		List<Magica> magicas = mdao.findByName("Polimerização");
		if(magicas.isEmpty()) {
			m = fEfeitos.getNewCartaMagica();
			m.setNome("Polimerização");
			m.setTipo(TipoMagiaEnum.NORMAL);
			m.setEfeito("Permite invocar um monstro a partir da fusão de outros monstros.");
			m.setVelocidade(TipoVelocidadeEnum.UM);
			mdao.create(m);
			//m = mdao.findByName("Polimerizacao").get(0);
			magicas.add(m);
		}
		return magicas;
	}

	public String atualizar() {
		mdao.update(magica);
		FacesMessages.info("Successfully updated.");
		return "";
	}
	
	public String excluir() {
		//Need to get the reference to delete because an object return from find is detached, not managed.
		Magica m = mdao.getEntityManager().getReference(Magica.class, magica.getId());
		mdao.delete(m);
		FacesMessages.info("Successfully deleted.");
		return "";
	}
	
}
