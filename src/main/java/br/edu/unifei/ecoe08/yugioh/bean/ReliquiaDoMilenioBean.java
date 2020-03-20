package br.edu.unifei.ecoe08.yugioh.bean;

import java.io.IOException;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.edu.unifei.ecoe08.yugioh.dao.FaraoDAO;
import br.edu.unifei.ecoe08.yugioh.dao.PessoaDAO;
import br.edu.unifei.ecoe08.yugioh.dao.ReliquiaDoMilenioDAO;
import br.edu.unifei.ecoe08.yugioh.model.ReliquiaDoMilenio;
import lombok.Data;
import net.bootsfaces.utils.FacesMessages;

@Data
@Named
@RequestScoped
public class ReliquiaDoMilenioBean {
	ReliquiaDoMilenioDAO rdao = new ReliquiaDoMilenioDAO();
	ReliquiaDoMilenio reliquia = new ReliquiaDoMilenio();
	List<ReliquiaDoMilenio> reliquias = rdao.findAll();
	List<String> reliquiasNomes = rdao.reliquiasNomes();
	PessoaDAO pdao = new PessoaDAO();
	FaraoDAO fdao = new FaraoDAO();
	
	public void inserir() throws IOException {
		try {			
			if(reliquia.getNome().isBlank()) {
				FacesContext facesContext = FacesContext.getCurrentInstance();
				facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, null, "Relíquia do Milênio possui nome em branco."));
				facesContext.getExternalContext().getFlash().setKeepMessages(true);
				throw new Exception();
			}
			reliquia.setCriador(pdao.find(reliquia.getCriador().getNome()));
			reliquia.setEspirito(fdao.find(reliquia.getEspirito().getNome()));
			rdao.create(reliquia);
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, null, "Relíquia do Milênio inserida com sucesso."));
			facesContext.getExternalContext().getFlash().setKeepMessages(true);
		} catch (Exception e) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, null, "Relíquia do Milênio não foi inserida."));
			facesContext.getExternalContext().getFlash().setKeepMessages(true);
		}
		FacesContext.getCurrentInstance().getExternalContext().redirect("../messages.xhtml");
	}

	public String buscar() throws IOException {
		reliquia = rdao.find(reliquia.getNome());
		if(reliquia == null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, null, "Relíquia do Milênio não encontrada."));
			facesContext.getExternalContext().getFlash().setKeepMessages(true);
			FacesContext.getCurrentInstance().getExternalContext().redirect("../messages.xhtml");
		}
		return "";
	}
	
	public String atualizar() {
		rdao.update(reliquia);
		FacesMessages.info("Successfully updated.");
		return "";
	}
	
	public String excluir() {
		rdao.delete(reliquia);
		FacesMessages.info("Successfully deleted.");
		return "";
	}
}
