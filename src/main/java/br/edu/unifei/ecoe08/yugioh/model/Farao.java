package br.edu.unifei.ecoe08.yugioh.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import br.edu.unifei.ecoe08.yugioh.enumerate.TipoCaraterEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class Farao extends Pessoa implements Serializable {
	private static final long serialVersionUID = 7680359206153312141L;
	@Enumerated(EnumType.STRING)
	private TipoCaraterEnum carater;
    private String conquista;
    
}
