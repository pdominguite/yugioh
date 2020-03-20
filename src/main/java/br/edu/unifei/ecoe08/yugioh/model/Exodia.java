package br.edu.unifei.ecoe08.yugioh.model;

import java.io.Serializable;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class Exodia extends Monstro implements Serializable {
	private static final long serialVersionUID = -3200282236318961772L;
	private static Exodia exodia = new Exodia();
    private String efeito;
    
    //It is a Sigleton, but Hibernate complains if private constructor is used.
    protected Exodia() {
    }

	public static Exodia getExodia() {
    	exodia.setNome("Exodia");
		return exodia;
	}
    
}
