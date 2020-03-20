package br.edu.unifei.ecoe08.yugioh.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.edu.unifei.ecoe08.yugioh.dao.MonstroDeEfeitoDAO;
import br.edu.unifei.ecoe08.yugioh.model.MonstroDeEfeito;

@FacesConverter(value = "monstroDeEfeitoConverter")
public class MonstroDeEfeitoConverter implements Converter<MonstroDeEfeito> {

	MonstroDeEfeitoDAO mdao = new MonstroDeEfeitoDAO();

	@Override
	public MonstroDeEfeito getAsObject(FacesContext context, UIComponent component, String value) {
		System.out.println("getAsObject:" + value);
		if(value == null || value.isEmpty()){
		        return null;
		} else {
		    Long id = Long.parseLong(value);
		    MonstroDeEfeito monstro = mdao.find(id);
		    return monstro;
		}	            
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, MonstroDeEfeito value) {
		MonstroDeEfeito monstro = (MonstroDeEfeito) value;
		System.out.println("getAsString:" + monstro);
        if(monstro != null){
            return String.valueOf(monstro.getId());
        } else {
            return null;
        }
	}
	
}
