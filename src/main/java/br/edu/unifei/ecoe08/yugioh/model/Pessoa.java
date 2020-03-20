package br.edu.unifei.ecoe08.yugioh.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Pessoa implements Serializable {
	private static final long serialVersionUID = 1199064101766054407L;
	@Id
    private String nome;
    private String nascimento;
    private float altura;
    private float peso;
    private String profissao;
    private String genero;

}
