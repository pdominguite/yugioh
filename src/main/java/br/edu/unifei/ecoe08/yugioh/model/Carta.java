package br.edu.unifei.ecoe08.yugioh.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;

@Data
@Entity
public abstract class Carta implements Serializable {
	private static final long serialVersionUID = 8344799779704878104L;
	@Id
	@GeneratedValue
	private int id;
    private String nome;
    
    @ManyToMany(mappedBy = "cartas", cascade = CascadeType.ALL)
    private List<Baralho> baralho;
}
