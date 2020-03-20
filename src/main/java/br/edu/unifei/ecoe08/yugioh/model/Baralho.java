package br.edu.unifei.ecoe08.yugioh.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Baralho implements Serializable {
	private static final long serialVersionUID = -7320913286240403451L;
	@Id
	@GeneratedValue
	private long id;
	@ManyToOne
    private Monstro monstroPrincipal;
	private int quantidadeCartas;
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Carta> cartas = new ArrayList<>();	
	public void atualizaQuantidadeCartas() {
		quantidadeCartas = cartas.size();
	}

}
