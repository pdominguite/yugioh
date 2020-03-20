package br.edu.unifei.ecoe08.yugioh.model;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public class FabricaDeEfeitos {
    HashMap<String, Efeito> cartas = new HashMap<>();
    
    public Efeito getCarta(String nome, Class <? extends Efeito> clazz) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
        Efeito c = cartas.get(nome);
        if(c == null) {
                //c = clazz.newInstance();
        		c = clazz.getDeclaredConstructor().newInstance();
        }
        c.setNome(nome);
        cartas.put(nome, c);
        return c;
    }
    
    public Magica getNewCartaMagica() {
    	return new Magica();
    }

    public Armadilha getNewCartaArmadilha() {
    	return new Armadilha();
    }
    
    public HashMap<String, Efeito> getCartas() {
        return cartas;
    }

    public void setCartas(HashMap<String, Efeito> cartas) {
        this.cartas = cartas;
    }
    
}
