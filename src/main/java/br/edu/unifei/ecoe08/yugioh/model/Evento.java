package br.edu.unifei.ecoe08.yugioh.model;

import br.edu.unifei.ecoe08.yugioh.enumerate.TipoDominioEnum;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Data
@Entity
public abstract class Evento implements Serializable {
	private static final long serialVersionUID = 3880309377113997360L;
	@Id
    private String objetivo;
    private String local;
    private int pontosDeVidaInicial;
    @Enumerated(EnumType.STRING)
    private TipoDominioEnum dominio;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Evento_Participantes")
    private List<Duelista> participantes = new ArrayList<>();
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Evento_Vencedores")
    private List<Duelista> vencedores = new ArrayList<>();
    
}
