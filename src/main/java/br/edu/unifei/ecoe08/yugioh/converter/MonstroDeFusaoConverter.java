package br.edu.unifei.ecoe08.yugioh.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.edu.unifei.ecoe08.yugioh.dao.MonstroDeFusaoDAO;
import br.edu.unifei.ecoe08.yugioh.model.MonstroDeFusao;

@FacesConverter(value = "monstroDeFusaoConverter")
public class MonstroDeFusaoConverter implements Converter<MonstroDeFusao> {
	
	MonstroDeFusaoDAO mdao = new MonstroDeFusaoDAO();

	@Override
	public MonstroDeFusao getAsObject(FacesContext context, UIComponent component, String value) {
		System.out.println("getAsObject:" + value);
		if(value == null || value.isEmpty()){
		        return null;
		} else {
		    Integer id = Integer.parseInt(value);
		    MonstroDeFusao monstro = mdao.find(id);
		    return monstro;
		}	            
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, MonstroDeFusao value) {
		MonstroDeFusao monstro = (MonstroDeFusao) value;
		System.out.println("getAsString:" + monstro);
        if(monstro != null){
            return String.valueOf(monstro.getId());
        } else {
            return null;
        }
	}
	
}
