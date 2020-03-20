package br.edu.unifei.ecoe08.yugioh.model;

import java.io.Serializable;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class DiscoDeDuelo extends Estrutura implements Serializable {
	private static final long serialVersionUID = -4784453738060129108L;
    private String formato;
    private String fabricante;
    
}
