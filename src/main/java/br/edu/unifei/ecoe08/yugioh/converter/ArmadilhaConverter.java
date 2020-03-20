package br.edu.unifei.ecoe08.yugioh.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.edu.unifei.ecoe08.yugioh.dao.ArmadilhaDAO;
import br.edu.unifei.ecoe08.yugioh.model.Armadilha;

@FacesConverter(value = "armadilhaConverter")
public class ArmadilhaConverter implements Converter<Armadilha> {
	
	ArmadilhaDAO adao = new ArmadilhaDAO();

	@Override
	public Armadilha getAsObject(FacesContext context, UIComponent component, String value) {
		System.out.println("getAsObject:" + value);
		if(value == null || value.isEmpty()){
		        return null;
		} else {
		    int id = Integer.parseInt(value);
		    Armadilha armadilha = adao.find(id);
		    return armadilha;
		}	            
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Armadilha value) {
		Armadilha armadilha = (Armadilha) value;
		System.out.println("getAsString:" + armadilha);
        if(armadilha != null){
            return String.valueOf(armadilha.getId());
        } else {
            return null;
        }
	}
	
}