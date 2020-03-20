package br.edu.unifei.ecoe08.yugioh.bean;

import java.io.IOException;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.edu.unifei.ecoe08.yugioh.dao.ItemDoMilenioDAO;
import br.edu.unifei.ecoe08.yugioh.dao.PessoaDAO;
import br.edu.unifei.ecoe08.yugioh.model.ItemDoMilenio;
import br.edu.unifei.ecoe08.yugioh.model.Pessoa;
import lombok.Data;
import net.bootsfaces.utils.FacesMessages;

@Data
@Named
@RequestScoped
public class ItemDoMilenioBean {
	ItemDoMilenioDAO idao = new ItemDoMilenioDAO();
	ItemDoMilenio item = new ItemDoMilenio();
	PessoaDAO pdao = new PessoaDAO();
	Pessoa criador = new Pessoa();
	List<ItemDoMilenio> itens = idao.findAll();
	
	public void inserir() throws IOException {
		try {
			criador = pdao.find(item.getCriador().getNome());
			if(criador == null || item.getNome().isBlank())
				throw new Exception();
			item.setCriador(criador);
			if(item.getNome().isBlank()) {
				FacesContext facesContext = FacesContext.getCurrentInstance();
				facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, null, "Item do Milênio possui nome em branco."));
				facesContext.getExternalContext().getFlash().setKeepMessages(true);
				throw new Exception();
			}
			idao.create(item);
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, null, "Item do Milênio inserido com sucesso."));
			facesContext.getExternalContext().getFlash().setKeepMessages(true);
		} catch (Exception e) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, null, "Item do Milênio não foi inserido."));
			facesContext.getExternalContext().getFlash().setKeepMessages(true);
		}
		FacesContext.getCurrentInstance().getExternalContext().redirect("../messages.xhtml");
	}
	
	public String buscar() throws IOException {
		item = idao.find(item.getNome());
		if(item == null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, null, "Item do Milênio não encontrado."));
			facesContext.getExternalContext().getFlash().setKeepMessages(true);
			FacesContext.getCurrentInstance().getExternalContext().redirect("../messages.xhtml");
		}
		return "";
	}

	public String atualizar() {
		idao.update(item);
		FacesMessages.info("Successfully updated.");
		return "";
	}
	
	public String excluir() {
		idao.delete(item);
		FacesMessages.info("Successfully deleted.");
		return "";
	}
}

