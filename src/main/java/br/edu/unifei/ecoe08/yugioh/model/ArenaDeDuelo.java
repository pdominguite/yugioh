package br.edu.unifei.ecoe08.yugioh.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import br.edu.unifei.ecoe08.yugioh.enumerate.TipoTerrenoEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class ArenaDeDuelo extends Estrutura implements Serializable {
	private static final long serialVersionUID = -3902541324358556974L;
	@Enumerated(EnumType.STRING)
    private TipoTerrenoEnum terreno;
    private float largura;
    private float comprimento;
    
}
