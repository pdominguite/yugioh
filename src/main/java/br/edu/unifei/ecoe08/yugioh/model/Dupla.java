package br.edu.unifei.ecoe08.yugioh.model;

import java.io.Serializable;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class Dupla extends Duelo implements Serializable {
	private static final long serialVersionUID = -5449224610834854612L;
	public Dupla() {
        //No duelo em duplas, temos 2x2
        camposDeDuelo.add(new CampoDeDuelo());
        camposDeDuelo.add(new CampoDeDuelo());
        camposDeDuelo.add(new CampoDeDuelo());
        camposDeDuelo.add(new CampoDeDuelo());
    }
    @Override
    public void atualizaCamposDeDuelo() {
        camposDeDuelo.get(0).setDuelista(getParticipantes().get(0));
        camposDeDuelo.get(1).setDuelista(getParticipantes().get(1));
        camposDeDuelo.get(2).setDuelista(getParticipantes().get(2));
        camposDeDuelo.get(3).setDuelista(getParticipantes().get(3));
    }
    public void atualizaCamposDupla() {
    	camposDeDuelo.get(0).setCampoDupla(camposDeDuelo.get(1));
        camposDeDuelo.get(1).setCampoDupla(camposDeDuelo.get(0));
        camposDeDuelo.get(2).setCampoDupla(camposDeDuelo.get(3));
        camposDeDuelo.get(3).setCampoDupla(camposDeDuelo.get(2));
    }
}

