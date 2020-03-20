package br.edu.unifei.ecoe08.yugioh.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class CampoDeDuelo extends Estrutura implements Serializable {
	private static final long serialVersionUID = 3550091366188974919L;
	@OneToOne(cascade = CascadeType.ALL)
	@ToString.Exclude
    private CampoDeDuelo campoDupla;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "CampoDeDuelo_Cemiterio")
    private List<Carta> cartasNoCemiterio = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "CampoDeDuelo_CartasEmJogo")
    private List<Carta> cartasEmJogo = new ArrayList<>();
	@OneToOne(cascade = CascadeType.ALL)
	@ToString.Exclude
	private Duelista duelista = new Duelista();
	@ManyToOne(cascade = CascadeType.ALL)
	private Duelo duelo;
    
}
