package br.edu.unifei.ecoe08.yugioh.bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.edu.unifei.ecoe08.yugioh.dao.MonstroDeFusaoDAO;
import br.edu.unifei.ecoe08.yugioh.model.FabricaDeEfeitos;
import br.edu.unifei.ecoe08.yugioh.model.Magica;
import br.edu.unifei.ecoe08.yugioh.model.Monstro;
import br.edu.unifei.ecoe08.yugioh.model.MonstroDeFusao;
import lombok.Data;
import net.bootsfaces.utils.FacesMessages;

@Data
@Named
@ViewScoped
public class MonstroDeFusaoBean implements Serializable {
	
	private static final long serialVersionUID = 7552667136691948583L;
	private MonstroDeFusaoDAO mfdao = new MonstroDeFusaoDAO();
	private Monstro monstro1 = new Monstro();
	private Monstro monstro2 = new Monstro();
	private Monstro monstro3 = new Monstro();
	private List<MonstroDeFusao> monstros = mfdao.findAll();
	private MagicaBean mbean = new MagicaBean();
	private List<Magica> polimerizacoes = mbean.findPolimerizacao();
	private FabricaDeEfeitos fEfeitos = new FabricaDeEfeitos();
	private Magica polimerizacao = fEfeitos.getNewCartaMagica();
	private MonstroDeFusao monstro = new MonstroDeFusao(monstro1, monstro2, monstro3, polimerizacao);
	
	public void inserir() throws IOException {
		try {
			if(monstro.getNome().isBlank()) {
				FacesContext facesContext = FacesContext.getCurrentInstance();
				facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, null, "Carta Monstro de Fusão possui nome em branco."));
				throw new Exception();
			}
			monstro.getMonstros().set(0, monstro1);
			monstro.getMonstros().set(1, monstro2);
			monstro.getMonstros().set(2, monstro3);
			monstro.setPolimerizacao(polimerizacao);
			mfdao.create(monstro);
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, null, "Carta Monstro de Fusão inserida com sucesso."));
			facesContext.getExternalContext().getFlash().setKeepMessages(true);
		} catch (Exception e) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, null, "Carta Monstro de Fusão não foi inserida."));
			facesContext.getExternalContext().getFlash().setKeepMessages(true);
		}
		FacesContext.getCurrentInstance().getExternalContext().redirect("../messages.xhtml");;
	}
	
	public String findByName() throws IOException {
		List<MonstroDeFusao> m = new ArrayList<MonstroDeFusao>();
		m = mfdao.findByName(monstro.getNome());
		if(monstros.isEmpty()) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, null, "Carta Monstro de Fusão não encontrada"));
			facesContext.getExternalContext().getFlash().setKeepMessages(true);
			FacesContext.getCurrentInstance().getExternalContext().redirect("../messages.xhtml");
		} 
		monstro = m.get(0);
		return "";
	}

	public String atualizar() {
		mfdao.update(monstro);
		FacesMessages.info("Successfully updated.");
		return "";
	}
	
	public String excluir() {
		//Need to get the reference to delete because an object return from find is detached, not managed.
		MonstroDeFusao m = mfdao.getEntityManager().getReference(MonstroDeFusao.class, monstro.getId());
		mfdao.delete(m);
		FacesMessages.info("Successfully deleted.");
		return "";
	}

}
