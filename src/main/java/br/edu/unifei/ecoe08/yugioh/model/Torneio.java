package br.edu.unifei.ecoe08.yugioh.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class Torneio extends Evento implements Serializable {
	private static final long serialVersionUID = -2514763838353964838L;
	private String nome;
    private String premio;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Estrutura estrutura;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Duelo> duelos = new ArrayList<>();
    @ManyToOne(cascade = CascadeType.ALL)
    private Duelista organizador = new Duelista();
        
}
