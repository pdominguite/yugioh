package br.edu.unifei.ecoe08.yugioh.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class ReliquiaDoMilenio extends ItemDoMilenio implements Serializable {
	private static final long serialVersionUID = -6993577896808444042L;
	@ElementCollection(targetClass = String.class)
	private List<String> poderes = new ArrayList<>();
	@OneToOne
    private Farao espirito;
    
}
