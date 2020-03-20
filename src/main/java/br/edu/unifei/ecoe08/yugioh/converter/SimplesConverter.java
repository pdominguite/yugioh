package br.edu.unifei.ecoe08.yugioh.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.edu.unifei.ecoe08.yugioh.dao.SimplesDAO;
import br.edu.unifei.ecoe08.yugioh.model.Simples;

@FacesConverter(value = "simpleConverter")
public class SimplesConverter implements Converter<Simples>{
	
	SimplesDAO sdao = new SimplesDAO();
	
	@Override
	public Simples getAsObject(FacesContext context, UIComponent component, String value) {
		System.out.println("getAsObject:" + value);
		if(value == null || value.isEmpty()){
		        return null;
		} else {
		    Simples simples = sdao.find(value);
		    return simples;
		}	            
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Simples value) {
		Simples simples = (Simples) value;
		System.out.println("getAsString:" + simples);
        if(simples != null){
            return String.valueOf(simples.getObjetivo());
        } else {
            return null;
        }
	}

}
