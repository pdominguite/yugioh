package br.edu.unifei.ecoe08.yugioh.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import br.edu.unifei.ecoe08.yugioh.enumerate.TipoMagiaEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class Magica extends Efeito implements Serializable {
	private static final long serialVersionUID = -2693083890724474109L;
	@Enumerated(EnumType.STRING)
	private TipoMagiaEnum tipo;

    protected Magica() {}
    
}
