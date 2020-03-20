/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unifei.ecoe08.yugioh.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public abstract class Duelo extends Evento implements Serializable {
	private static final long serialVersionUID = -6464804413460796846L;
	@Temporal(TemporalType.TIME)
	private Date duracao;
	@OneToMany(mappedBy = "duelo", cascade = CascadeType.REMOVE)
    protected List<CampoDeDuelo> camposDeDuelo = new ArrayList<>();
    
    public abstract void atualizaCamposDeDuelo();
    
}
