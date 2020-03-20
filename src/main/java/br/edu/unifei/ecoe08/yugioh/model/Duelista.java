package br.edu.unifei.ecoe08.yugioh.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class Duelista extends Pessoa implements Serializable {
	private static final long serialVersionUID = 8756701780577740724L;
	private String deck;
    private int pontosDeVida;
    private int duelosGanhos;
    private String classificacao;
    private int ranking;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private Baralho baralho;
    @OneToMany
    private List<ReliquiaDoMilenio> reliquias = new ArrayList<>();
    
    @OneToOne(mappedBy = "duelista", cascade = CascadeType.ALL)
    private CampoDeDuelo campo;
    @ManyToMany(mappedBy = "participantes", cascade = CascadeType.ALL)
    private List<Evento> eventos;
    @ManyToMany(mappedBy = "vencedores", cascade = CascadeType.ALL)
    private List<Evento> eventosGanhos;
}
