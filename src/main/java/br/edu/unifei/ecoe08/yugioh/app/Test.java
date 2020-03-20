package br.edu.unifei.ecoe08.yugioh.app;

import java.util.List;

import br.edu.unifei.ecoe08.yugioh.bean.CampoDeDueloBean;
import br.edu.unifei.ecoe08.yugioh.bean.EnumBean;
import br.edu.unifei.ecoe08.yugioh.bean.EstruturaBean;
import br.edu.unifei.ecoe08.yugioh.bean.MagicaBean;
import br.edu.unifei.ecoe08.yugioh.bean.MonstroDeFusaoBean;
import br.edu.unifei.ecoe08.yugioh.dao.CampoDeDueloDAO;
import br.edu.unifei.ecoe08.yugioh.dao.EstruturaDAO;
import br.edu.unifei.ecoe08.yugioh.dao.ExodiaDAO;
import br.edu.unifei.ecoe08.yugioh.dao.MonstroDAO;
import br.edu.unifei.ecoe08.yugioh.dao.MonstroDeFusaoDAO;
import br.edu.unifei.ecoe08.yugioh.enumerate.TipoAtributoEnum;
import br.edu.unifei.ecoe08.yugioh.enumerate.TipoMonstroEnum;
import br.edu.unifei.ecoe08.yugioh.enumerate.TipoPosicaoBatalhaEnum;
import br.edu.unifei.ecoe08.yugioh.model.Magica;
import br.edu.unifei.ecoe08.yugioh.model.Monstro;
import br.edu.unifei.ecoe08.yugioh.model.MonstroDeFusao;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EstruturaDAO edao = new EstruturaDAO();
		MonstroDAO mdao = new MonstroDAO();
		MonstroDeFusaoDAO mfdao = new MonstroDeFusaoDAO();
		ExodiaDAO exdao = new ExodiaDAO();
		CampoDeDueloBean cbean = new CampoDeDueloBean();
		EstruturaBean ebean = new EstruturaBean();
		CampoDeDueloDAO cdao = new CampoDeDueloDAO();
		/*
		for(String e : l) {
			System.out.println(e);
		}
		for(String e : l2) {
			System.out.println(e);
		}
		MagicaBean mb = new MagicaBean();
		Magica m = mb.findPolimerização();
		System.out.println(m.getNome());
		System.out.println(m.getId());
		
		Monstro reiCaveira = new Monstro();
        reiCaveira.setNome("Rei Caveira");
        reiCaveira.setAtaque(2500);
        reiCaveira.setDefesa(1200);
        reiCaveira.setAtributo(TipoAtributoEnum.TREVAS);
        reiCaveira.setTipo(TipoMonstroEnum.DEMONIO);
        reiCaveira.setNivel(6);
        reiCaveira.setPosicaoDeBatalha(TipoPosicaoBatalhaEnum.ATAQUE);
        
        mdao.create(reiCaveira);
        
        Monstro dragaoNegroDeOlhosVermelhos = new Monstro();
        dragaoNegroDeOlhosVermelhos.setNome("Dragão Negro de Olhos Vermelhos");
        dragaoNegroDeOlhosVermelhos.setAtaque(2400);
        dragaoNegroDeOlhosVermelhos.setDefesa(2000);
        dragaoNegroDeOlhosVermelhos.setAtributo(TipoAtributoEnum.TREVAS);
        dragaoNegroDeOlhosVermelhos.setTipo(TipoMonstroEnum.DRAGAO);
        dragaoNegroDeOlhosVermelhos.setNivel(7);
        dragaoNegroDeOlhosVermelhos.setPosicaoDeBatalha(TipoPosicaoBatalhaEnum.ATAQUE);
        
        mdao.create(dragaoNegroDeOlhosVermelhos);
        
        MonstroDeFusao dragaoCaveiraNegro = new MonstroDeFusao(reiCaveira, dragaoNegroDeOlhosVermelhos, null, m);
        dragaoCaveiraNegro.setNome("Dragão Caveira Negro");
        dragaoCaveiraNegro.setAtaque(3200);
        dragaoCaveiraNegro.setDefesa(2500);
        dragaoCaveiraNegro.setAtributo(TipoAtributoEnum.TREVAS);
        dragaoCaveiraNegro.setTipo(TipoMonstroEnum.DRAGAO);
        dragaoCaveiraNegro.setNivel(9);
        dragaoCaveiraNegro.setPosicaoDeBatalha(TipoPosicaoBatalhaEnum.ATAQUE);
        
        mfdao.create(dragaoCaveiraNegro);
        
        System.out.println(dragaoCaveiraNegro.getMonstros());
        */
		System.out.println(edao.findCamposDeDuelo());
		
		

	}

}
