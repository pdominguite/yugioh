package br.edu.unifei.ecoe08.yugioh.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import br.edu.unifei.ecoe08.yugioh.enumerate.TipoAtributoEnum;
import br.edu.unifei.ecoe08.yugioh.enumerate.TipoMonstroEnum;
import br.edu.unifei.ecoe08.yugioh.enumerate.TipoPosicaoBatalhaEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class Monstro extends Carta implements Serializable {
	private static final long serialVersionUID = 5641398367686312778L;
	private int nivel;
    private int ataque;
    private int defesa;
    @Enumerated(EnumType.STRING)
    private TipoMonstroEnum tipo;
    @Enumerated(EnumType.STRING)
    private TipoAtributoEnum atributo;
    @Enumerated(EnumType.STRING)
    private TipoPosicaoBatalhaEnum posicaoDeBatalha;
    private String nomePoder;

    public Monstro clone() {
        Monstro m = new Monstro();   
        m.setNome(this.getNome());
        m.setAtaque(this.getAtaque());
        m.setAtributo(this.getAtributo());
        m.setDefesa(this.getDefesa());
        m.setNivel(this.getNivel());
        m.setNomePoder(this.getNomePoder());
        m.setPosicaoDeBatalha(this.getPosicaoDeBatalha());
        m.setTipo(this.getTipo());        
        return m;
    }
    
}
