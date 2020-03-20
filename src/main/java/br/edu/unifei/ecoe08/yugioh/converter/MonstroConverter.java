package br.edu.unifei.ecoe08.yugioh.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.edu.unifei.ecoe08.yugioh.dao.MonstroDAO;
import br.edu.unifei.ecoe08.yugioh.model.Monstro;

@FacesConverter(value = "monstroConverter")
public class MonstroConverter implements Converter<Monstro> {
	
	MonstroDAO mdao = new MonstroDAO();

	@Override
	public Monstro getAsObject(FacesContext context, UIComponent component, String value) {
		System.out.println("getAsObject:" + value);
		if(value == null || value.isEmpty()){
		        return null;
		} else {
		    Integer id = Integer.parseInt(value);
		    Monstro monstro = mdao.find(id);
		    return monstro;
		}	            
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Monstro value) {
		Monstro monstro = (Monstro) value;
		System.out.println("getAsString:" + monstro);
        if(monstro != null){
            return String.valueOf(monstro.getId());
        } else {
            return null;
        }
	}
	
}