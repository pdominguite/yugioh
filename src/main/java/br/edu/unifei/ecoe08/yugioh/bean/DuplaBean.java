package br.edu.unifei.ecoe08.yugioh.bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.edu.unifei.ecoe08.yugioh.dao.CampoDeDueloDAO;
import br.edu.unifei.ecoe08.yugioh.dao.DuelistaDAO;
import br.edu.unifei.ecoe08.yugioh.dao.DuplaDAO;
import br.edu.unifei.ecoe08.yugioh.model.CampoDeDuelo;
import br.edu.unifei.ecoe08.yugioh.model.Duelista;
import br.edu.unifei.ecoe08.yugioh.model.Dupla;
import lombok.Data;
import net.bootsfaces.utils.FacesMessages;

@Data
@Named
@ViewScoped
public class DuplaBean implements Serializable {
	
	private static final long serialVersionUID = 1416324664198230053L;
	private DuplaDAO sdao = new DuplaDAO();
	private Dupla dupla = new Dupla();
	private CampoDeDueloDAO cdao = new CampoDeDueloDAO();
	private DuelistaDAO ddao = new DuelistaDAO();
	private Duelista participante1 = new Duelista();
	private Duelista participante2 = new Duelista();
	private Duelista participante3 = new Duelista();
	private Duelista participante4 = new Duelista();
	private int duplaVencedora;
	private Date date = new Date();
	private Duelista vencedor1 = new Duelista();
	private Duelista vencedor2 = new Duelista();
	
	public void inserir() throws IOException {
		try {
			dupla.getParticipantes().add(participante1);
			dupla.getParticipantes().add(participante2);
			dupla.getParticipantes().add(participante3);
			dupla.getParticipantes().add(participante4);
			if(duplaVencedora == 0) {
				dupla.getVencedores().add(participante1);
				dupla.getVencedores().add(participante2);
			} else {
				if(duplaVencedora == 1) {
					dupla.getVencedores().add(participante3);
					dupla.getVencedores().add(participante4);
				}
			}
			//Build Method will match the IDs
			dupla.atualizaCamposDeDuelo();
			//Build Method create the entities and match the necessary IDs, but we have to persist the entities CampoDeDuelo anyway
			for(CampoDeDuelo cdd : dupla.getCamposDeDuelo()) {
				cdao.create(cdd);
			}
			dupla.atualizaCamposDupla();
			for(CampoDeDuelo cdd : dupla.getCamposDeDuelo()) {
				cdao.update(cdd);
			}
			//dupla.getDuracao().setHours(date.getHours());
			//dupla.getDuracao().setMinutes(date.getMinutes());
			//dupla.getDuracao().setSeconds(date.getSeconds());
			sdao.create(dupla);
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, null, "Duelo de dupla inserido com sucesso."));
			facesContext.getExternalContext().getFlash().setKeepMessages(true);
		} catch (Exception e) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, null, "Duelo de dupla não foi inserido."));
			facesContext.getExternalContext().getFlash().setKeepMessages(true);
		}
		FacesContext.getCurrentInstance().getExternalContext().redirect("../messages.xhtml");
	}

	public String buscar() throws IOException {
		dupla = sdao.find(dupla.getObjetivo());
		if(dupla == null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, null, "Duelo de dupla não encontrado."));
			facesContext.getExternalContext().getFlash().setKeepMessages(true);
			FacesContext.getCurrentInstance().getExternalContext().redirect("../messages.xhtml");
		} else {
			participante1 = dupla.getParticipantes().get(0);
			participante2 = dupla.getParticipantes().get(1);
			participante3 = dupla.getParticipantes().get(2);
			participante4 = dupla.getParticipantes().get(3);
			vencedor1 = dupla.getVencedores().get(0);
			vencedor2 = dupla.getVencedores().get(1);
		}
		return "";
	}
	
	public String atualizar() {
		sdao.update(dupla);
		FacesMessages.info("Successfully updated.");
		return "";
	}
	
	public String excluir() {
		sdao.delete(dupla);
		FacesMessages.info("Successfully deleted.");
		return "";
	}

}
