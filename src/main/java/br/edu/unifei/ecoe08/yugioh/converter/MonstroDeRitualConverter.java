package br.edu.unifei.ecoe08.yugioh.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.edu.unifei.ecoe08.yugioh.dao.MonstroDeRitualDAO;
import br.edu.unifei.ecoe08.yugioh.model.MonstroDeRitual;

@FacesConverter(value = "monstroDeRitualConverter")
public class MonstroDeRitualConverter implements Converter<MonstroDeRitual> {
	
	MonstroDeRitualDAO mdao = new MonstroDeRitualDAO();
	
	@Override
	public MonstroDeRitual getAsObject(FacesContext context, UIComponent component, String value) {
		System.out.println("getAsObject:" + value);
		if(value == null || value.isEmpty()){
		        return null;
		} else {
		    Integer id = Integer.parseInt(value);
		    MonstroDeRitual monstro = mdao.find(id);
		    return monstro;
		}	            
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, MonstroDeRitual value) {
		MonstroDeRitual monstro = (MonstroDeRitual) value;
		System.out.println("getAsString:" + monstro);
        if(monstro != null){
            return String.valueOf(monstro.getId());
        } else {
            return null;
        }
	}

}
