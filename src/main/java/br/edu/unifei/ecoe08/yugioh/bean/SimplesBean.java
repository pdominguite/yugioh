package br.edu.unifei.ecoe08.yugioh.bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.edu.unifei.ecoe08.yugioh.dao.CampoDeDueloDAO;
import br.edu.unifei.ecoe08.yugioh.dao.DuelistaDAO;
import br.edu.unifei.ecoe08.yugioh.dao.SimplesDAO;
import br.edu.unifei.ecoe08.yugioh.model.CampoDeDuelo;
import br.edu.unifei.ecoe08.yugioh.model.Duelista;
import br.edu.unifei.ecoe08.yugioh.model.Simples;
import lombok.Data;
import net.bootsfaces.utils.FacesMessages;

@Data
@Named
@ViewScoped
public class SimplesBean implements Serializable {
	
	private static final long serialVersionUID = 6836495448795042292L;
	private SimplesDAO sdao = new SimplesDAO();
	private Simples simples = new Simples();
	private CampoDeDueloDAO cdao = new CampoDeDueloDAO();
	private DuelistaDAO ddao = new DuelistaDAO();
	private String participante1 = new String();
	private String participante2 = new String();
	private List<Duelista> vencedores = new ArrayList<Duelista>();
	private Date date = new Date();
	private Duelista vencedor = new Duelista();
	
	public List<String> participantes() {
		List<String> participantes = new ArrayList<String>();
		participantes.add(participante1);
		participantes.add(participante2);
		return participantes;
	}

	public void inserir() throws IOException {
		try {			
			if(simples.getObjetivo().isBlank()) {
				FacesContext facesContext = FacesContext.getCurrentInstance();
				facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, null, "Duelo Simples possui objetivo em branco."));
				facesContext.getExternalContext().getFlash().setKeepMessages(true);
				throw new Exception();
			}
			simples.getVencedores().add(vencedor);
			simples.getParticipantes().add(ddao.find(participante1));	
			simples.getParticipantes().add(ddao.find(participante2));
			//Builder will match the IDs
			simples.atualizaCamposDeDuelo();
			//Builder creates the entities and match the necessary IDs, but we have to persist the entities CampoDeDuelo anyway
			for(CampoDeDuelo cdd : simples.getCamposDeDuelo()) {
				cdao.create(cdd);
			}
			sdao.create(simples);
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, null, "Duelo Simples inserido com sucesso."));
			facesContext.getExternalContext().getFlash().setKeepMessages(true);
		} catch (Exception e) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, null, "Duelo Simples não foi inserido."));
			facesContext.getExternalContext().getFlash().setKeepMessages(true);
		}
		FacesContext.getCurrentInstance().getExternalContext().redirect("../messages.xhtml");
	}
	
	public void buscar() throws IOException {
		simples = sdao.find(simples.getObjetivo());
		if(simples == null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, null, "Duelo Simples não encontrada."));
			facesContext.getExternalContext().getFlash().setKeepMessages(true);
			FacesContext.getCurrentInstance().getExternalContext().redirect("../messages.xhtml");
		}
		vencedor = simples.getVencedores().get(0);
		participante1 = simples.getParticipantes().get(0).getNome();
		participante2 = simples.getParticipantes().get(1).getNome();
	}

	public String atualizar() {
		sdao.update(simples);
		FacesMessages.info("Successfully updated.");
		return "";
	}
	
	public String excluir() {
		sdao.delete(simples);
		FacesMessages.info("Successfully deleted.");
		return "";
	}
	
}
