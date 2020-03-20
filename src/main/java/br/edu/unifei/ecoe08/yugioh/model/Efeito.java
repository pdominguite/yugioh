package br.edu.unifei.ecoe08.yugioh.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import br.edu.unifei.ecoe08.yugioh.enumerate.TipoVelocidadeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public abstract class Efeito extends Carta implements Serializable {
	private static final long serialVersionUID = -6952107669565460949L;
	private String efeito;
	@Enumerated(EnumType.ORDINAL)
    private TipoVelocidadeEnum velocidade;
    
}
