package br.edu.unifei.ecoe08.yugioh.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.edu.unifei.ecoe08.yugioh.enumerate.TipoArmadilhaEnum;
import br.edu.unifei.ecoe08.yugioh.enumerate.TipoAtributoEnum;
import br.edu.unifei.ecoe08.yugioh.enumerate.TipoCaraterEnum;
import br.edu.unifei.ecoe08.yugioh.enumerate.TipoDominioEnum;
import br.edu.unifei.ecoe08.yugioh.enumerate.TipoMagiaEnum;
import br.edu.unifei.ecoe08.yugioh.enumerate.TipoMonstroEnum;
import br.edu.unifei.ecoe08.yugioh.enumerate.TipoPosicaoBatalhaEnum;
import br.edu.unifei.ecoe08.yugioh.enumerate.TipoTerrenoEnum;
import br.edu.unifei.ecoe08.yugioh.enumerate.TipoVelocidadeEnum;
import lombok.Data;

@Data
@Named
@ViewScoped
public class EnumBean implements Serializable {
	private static final long serialVersionUID = 602422267328808797L;
	private List<String> monstros;
	private List<String> atributos;
	private List<String> armadilhas;
	private List<String> caraters;
	private List<String> dominios;
	private List<String> magias;
	private List<String> terrenos;
	private List<String> velocidades;
	private List<String> posicoes;
	
	public EnumBean() {
		monstros = monstros();
		atributos = atributos();
		armadilhas = armadilhas();
		caraters = caraters();
		dominios = dominios();
		magias = magias();
		terrenos = terrenos();
		velocidades = velocidades();
		posicoes = posicoes();
	}
	
	public List<String> atributos() {
		atributos = new ArrayList<String>();
		for(TipoAtributoEnum tae : TipoAtributoEnum.values()) {
			atributos.add(tae.name());
		}
		return atributos;
	}
	
	public List<String> monstros() {
		monstros = new ArrayList<String>();
		for(TipoMonstroEnum tme : TipoMonstroEnum.values()) {
			monstros.add(tme.name());
		}
		return monstros;
	}
	
	public List<String> armadilhas() {
		armadilhas = new ArrayList<String>();
		for(TipoArmadilhaEnum tae : TipoArmadilhaEnum.values()) {
			armadilhas.add(tae.name());
		}
		return armadilhas;
	}
	
	public List<String> caraters() {
		caraters = new ArrayList<String>();
		for(TipoCaraterEnum tce : TipoCaraterEnum.values()) {
			caraters.add(tce.name());
		}
		return caraters;
	}
	
	public List<String> dominios() {
		dominios = new ArrayList<String>();
		for(TipoDominioEnum tde : TipoDominioEnum.values()) {
			dominios.add(tde.name());
		}
		return dominios;
	}
	
	public List<String> magias() {
		magias = new ArrayList<String>();
		for(TipoMagiaEnum tme : TipoMagiaEnum.values()) {
			magias.add(tme.name());
		}
		return magias;
	}
	
	public List<String> terrenos() {
		terrenos = new ArrayList<String>();
		for(TipoTerrenoEnum tte : TipoTerrenoEnum.values()) {
			terrenos.add(tte.name());
		}
		return terrenos;
	}
	
	public List<String> velocidades() {
		velocidades = new ArrayList<String>();
		for(TipoVelocidadeEnum tte : TipoVelocidadeEnum.values()) {
			velocidades.add(tte.name());
		}
		return velocidades;
	}
	
	public List<String> posicoes() {
		posicoes = new ArrayList<String>();
		for(TipoPosicaoBatalhaEnum tpbe : TipoPosicaoBatalhaEnum.values()) {
			posicoes.add(tpbe.name());
		}
		return posicoes;
	}
}

