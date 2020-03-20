package br.edu.unifei.ecoe08.yugioh.bean;

import java.io.IOException;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.edu.unifei.ecoe08.yugioh.dao.PessoaDAO;
import br.edu.unifei.ecoe08.yugioh.model.Pessoa;
import lombok.Data;
import net.bootsfaces.utils.FacesMessages;

@Data
@Named
@RequestScoped
public class PessoaBean {
	PessoaDAO pdao = new PessoaDAO();
	Pessoa pessoa = new Pessoa();
	List<Pessoa> pessoas = pdao.findAll();
	
	public void inserir() throws IOException {
		try {			
			if(pessoa.getNome().isBlank()) {
				FacesContext facesContext = FacesContext.getCurrentInstance();
				facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, null, "Pessoa possui nome em branco."));
				facesContext.getExternalContext().getFlash().setKeepMessages(true);
				throw new Exception();
			}
			pdao.create(pessoa);
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, null, "Pessoa inserida com sucesso."));
			facesContext.getExternalContext().getFlash().setKeepMessages(true);
		} catch (Exception e) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, null, "Pessoa não foi inserida."));
			facesContext.getExternalContext().getFlash().setKeepMessages(true);
		}
		FacesContext.getCurrentInstance().getExternalContext().redirect("../messages.xhtml");
	}
	
	public String buscar() throws IOException {
		pessoa = pdao.find(pessoa.getNome());
		if(pessoa == null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, null, "Pessoa não encontrada."));
			facesContext.getExternalContext().getFlash().setKeepMessages(true);
			FacesContext.getCurrentInstance().getExternalContext().redirect("../messages.xhtml");
		}
		return "";
	}
	
	public String atualizar() {
		pdao.update(pessoa);
		FacesMessages.info("Successfully updated.");
		return "";
	}
	
	public String excluir() {
		pdao.delete(pessoa);
		FacesMessages.info("Successfully deleted.");
		return "";
	}
	
}
