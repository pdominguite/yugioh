package br.edu.unifei.ecoe08.yugioh.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.edu.unifei.ecoe08.yugioh.dao.MagicaDAO;
import br.edu.unifei.ecoe08.yugioh.model.Magica;

@FacesConverter(value = "magicaConverter")
public class MagicaConverter implements Converter<Magica> {

	MagicaDAO mdao = new MagicaDAO();
	
	@Override
	public Magica getAsObject(FacesContext context, UIComponent component, String value) {
		System.out.println("getAsObject:" + value);
		if(value == null || value.isEmpty()){
		        return null;
		} else {
		    int id = Integer.parseInt(value);
		    Magica magica = mdao.find(id);
		    return magica;
		}	            
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Magica value) {
		Magica magica = (Magica) value;
		System.out.println("getAsString:" + magica);
        if(magica != null){
            return String.valueOf(magica.getId());
        } else {
            return null;
        }
	}
	
}
