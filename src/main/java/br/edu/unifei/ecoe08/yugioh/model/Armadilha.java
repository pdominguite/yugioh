package br.edu.unifei.ecoe08.yugioh.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import br.edu.unifei.ecoe08.yugioh.enumerate.TipoArmadilhaEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class Armadilha extends Efeito implements Serializable {
	private static final long serialVersionUID = 5866204402766589838L;
	@Enumerated(EnumType.STRING)
	private TipoArmadilhaEnum tipo;

    protected Armadilha() {};
    
}
