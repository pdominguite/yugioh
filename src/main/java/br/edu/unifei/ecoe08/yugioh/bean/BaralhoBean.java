package br.edu.unifei.ecoe08.yugioh.bean;

import java.io.IOException;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.edu.unifei.ecoe08.yugioh.dao.BaralhoDAO;
import br.edu.unifei.ecoe08.yugioh.dao.CartaDAO;
import br.edu.unifei.ecoe08.yugioh.model.Baralho;
import lombok.Data;

@Data
@Named
@RequestScoped
public class BaralhoBean {
	BaralhoDAO bdao = new BaralhoDAO();
	Baralho baralho = new Baralho();
	List<Baralho> baralhos = bdao.findAll();
	CartaDAO cdao = new CartaDAO();
	String cartas = new String();
	
	public void inserir() throws IOException {
		try {
			if(cartas.isBlank() || cartas.isEmpty()) {
				throw new Exception();
			} else {
				String cartasArray[] = cartas.split(",");
				if(cartasArray[0] != "") {
					for(String c : cartasArray) {
						baralho.getCartas().add(cdao.find(Integer.parseInt(c)));
					}
				} else {
					throw new Exception();
				}
				baralho.atualizaQuantidadeCartas();
				bdao.create(baralho);
				FacesContext facesContext = FacesContext.getCurrentInstance();
				facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, null, "Baralho inserido com sucesso."));
				facesContext.getExternalContext().getFlash().setKeepMessages(true);
			}
		} catch (Exception e) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, null, "Baralho não foi inserido."));
			facesContext.getExternalContext().getFlash().setKeepMessages(true);
		}
		FacesContext.getCurrentInstance().getExternalContext().redirect("../messages.xhtml");
	}
	
	public String buscar() {
		baralho = bdao.find(baralho.getId());
		return "";
	}
	
	public void atualizar() throws IOException {
		try {
			String cartasArray[] = cartas.split(",");
			if(cartasArray[0] != "") {
				baralho.getCartas().clear();
				for(String c : cartasArray) {
					baralho.getCartas().add(cdao.find(Integer.parseInt(c)));
				}
			}
			baralho.atualizaQuantidadeCartas();
			bdao.update(baralho);
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Yes!", "Baralho atualizado com sucesso."));
			facesContext.getExternalContext().getFlash().setKeepMessages(true);
		} catch (Exception e) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Oops!", "Baralho não foi atualizado."));
			facesContext.getExternalContext().getFlash().setKeepMessages(true);
		}
		FacesContext.getCurrentInstance().getExternalContext().redirect("../messages.xhtml");
	}
	
	public String excluir() throws IOException {
		//try {
			Baralho b = bdao.getEntityManager().getReference(Baralho.class, baralho.getId());
			bdao.delete(b);/*
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Yes!", "Baralho removido com sucesso."));
			facesContext.getExternalContext().getFlash().setKeepMessages(true);
		} catch (Exception e) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Oops!", "Baralho não foi removido."));
			facesContext.getExternalContext().getFlash().setKeepMessages(true);
		}
		FacesContext.getCurrentInstance().getExternalContext().redirect("../messages.xhtml");*/
		return "";
	}
	
}
