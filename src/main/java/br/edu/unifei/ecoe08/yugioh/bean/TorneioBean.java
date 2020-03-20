package br.edu.unifei.ecoe08.yugioh.bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.edu.unifei.ecoe08.yugioh.dao.DuelistaDAO;
import br.edu.unifei.ecoe08.yugioh.dao.PessoaDAO;
import br.edu.unifei.ecoe08.yugioh.dao.TorneioDAO;
import br.edu.unifei.ecoe08.yugioh.model.Estrutura;
import br.edu.unifei.ecoe08.yugioh.model.Torneio;
import lombok.Data;
import net.bootsfaces.utils.FacesMessages;

@Data
@Named
@ViewScoped
public class TorneioBean implements Serializable {
	
	private static final long serialVersionUID = -4199148952900759042L;
	private TorneioDAO tdao = new TorneioDAO();
	private Torneio torneio = new Torneio();
	private DuelistaDAO ddao = new DuelistaDAO();
	private String participantesNome = new String();
	private String vencedores = new String();
	private List<Estrutura> estruturas = new ArrayList<Estrutura>();
	private PessoaDAO pdao = new PessoaDAO();
	
	
	public List<String> participantes() {
		List<String> p2 = new ArrayList<String>();
		String p[] = participantesNome.split(",");
		if(p[0] != "") {
			for(String s : p) {
				p2.add(s);
			}
		}
		return p2;
	}
	
	public String buscar() throws IOException {
		torneio = tdao.find(torneio.getObjetivo());
		if(torneio == null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, null, "Torneio não encontrado."));
			facesContext.getExternalContext().getFlash().setKeepMessages(true);
			FacesContext.getCurrentInstance().getExternalContext().redirect("../messages.xhtml");
		}
		return "";
	}
	
	public void inserir() throws IOException {
		try {
			if(torneio.getObjetivo().isBlank()) {
				FacesContext facesContext = FacesContext.getCurrentInstance();
				facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, null, "Torneio possui nome em branco."));
				facesContext.getExternalContext().getFlash().setKeepMessages(true);
				throw new Exception();
			}
			String participantesArray[] = participantesNome.split(",");
			if(participantesArray[0] != "") {
				for(String s : participantesArray) {
					torneio.getParticipantes().add(ddao.find(s));
				}
			}
			String vencedoresArray[] = vencedores.split(",");
			if(vencedoresArray[0] != "") {
				for(String s : vencedoresArray) {
					torneio.getVencedores().add(ddao.find(s));
				}
			}			
			tdao.create(torneio);
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, null, "Torneio inserido com sucesso."));
			facesContext.getExternalContext().getFlash().setKeepMessages(true);
		} catch (Exception e) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, null, "Torneio não foi inserido."));
			facesContext.getExternalContext().getFlash().setKeepMessages(true);
		}
		FacesContext.getCurrentInstance().getExternalContext().redirect("../messages.xhtml");
	}
	
	public String atualizar() {
		tdao.update(torneio);
		FacesMessages.info("Successfully updated.");
		return "";
	}
	
	public String excluir() {
		tdao.delete(torneio);
		FacesMessages.info("Successfully deleted.");
		return "";
	}
}
