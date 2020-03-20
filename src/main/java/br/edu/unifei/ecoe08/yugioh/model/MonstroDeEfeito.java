package br.edu.unifei.ecoe08.yugioh.model;

import br.edu.unifei.ecoe08.yugioh.enumerate.TipoVelocidadeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class MonstroDeEfeito extends Monstro implements Serializable {
	private static final long serialVersionUID = 5337608260658475696L;
	@ElementCollection(targetClass = String.class)
	private List<String> efeitos = new ArrayList<>();
	@Enumerated(EnumType.ORDINAL)
    private TipoVelocidadeEnum velocidade;

    public MonstroDeEfeito clone() {
        MonstroDeEfeito me = new MonstroDeEfeito();        
        super.clone();
        me.setEfeitos(this.getEfeitos());
        me.setVelocidade(this.getVelocidade());        
        return me;
    }
    
}
