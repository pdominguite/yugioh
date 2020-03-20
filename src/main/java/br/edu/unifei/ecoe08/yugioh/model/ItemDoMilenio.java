package br.edu.unifei.ecoe08.yugioh.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class ItemDoMilenio implements Serializable {
	private static final long serialVersionUID = 5470776947094953294L;
	@Id
	private String nome;
	@ManyToOne
    private Pessoa criador;	
    private String criacao;
    private String funcao;
    
}
