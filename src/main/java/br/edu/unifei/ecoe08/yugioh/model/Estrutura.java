package br.edu.unifei.ecoe08.yugioh.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public abstract class Estrutura implements Serializable {
	private static final long serialVersionUID = -3010019305174103415L;
	@Id
	@GeneratedValue
	private int id;
}
