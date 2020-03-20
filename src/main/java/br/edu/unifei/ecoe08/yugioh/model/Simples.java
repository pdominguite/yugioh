package br.edu.unifei.ecoe08.yugioh.model;

import java.io.Serializable;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class Simples extends Duelo implements Serializable {
	private static final long serialVersionUID = 4474496507280240253L;
	public Simples() {
        //No duelo simples, temos apenas 1x1
        camposDeDuelo.add(new CampoDeDuelo());
        camposDeDuelo.add(new CampoDeDuelo());
        
        //No duelo simples, o jogador é "sua própria dupla"
        camposDeDuelo.get(0).setCampoDupla(camposDeDuelo.get(0));
        camposDeDuelo.get(1).setCampoDupla(camposDeDuelo.get(1));
    }        
    @Override
    public void atualizaCamposDeDuelo() {
        camposDeDuelo.get(0).setDuelista(getParticipantes().get(0));
        camposDeDuelo.get(1).setDuelista(getParticipantes().get(1));
    }
    
    public void atualizaDuplas() {
    	camposDeDuelo.get(0).setCampoDupla(camposDeDuelo.get(0));
        camposDeDuelo.get(1).setCampoDupla(camposDeDuelo.get(1));
    }
}
