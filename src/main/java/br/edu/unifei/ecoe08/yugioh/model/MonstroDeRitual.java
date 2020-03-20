package br.edu.unifei.ecoe08.yugioh.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class MonstroDeRitual extends Monstro implements Serializable {
	private static final long serialVersionUID = -5275336994475903098L;
	@OneToMany
	@JoinTable(name = "Monstro_Ritual")
	private List<Monstro> monstros = new ArrayList<>();
	@OneToOne
    private Magica cartaDeRitual;

    protected MonstroDeRitual() {}
    
    public MonstroDeRitual(Monstro m1, Monstro m2, Magica cartaDeRitual) {
        monstros.add(m1);
        monstros.add(m2);
        this.cartaDeRitual = cartaDeRitual;
    }
    public MonstroDeRitual(Monstro m1, Monstro m2, Monstro m3, Magica cartaDeRitual) {
        monstros.add(m1);
        monstros.add(m2);
        monstros.add(m3);
        this.cartaDeRitual = cartaDeRitual;
    }
    
    public MonstroDeRitual (List<Monstro> monstros, Magica cartaDeRitual) {
        this.monstros = monstros;
        this.cartaDeRitual = cartaDeRitual;
    }

    public MonstroDeRitual clone() {
        MonstroDeRitual mr = new MonstroDeRitual(this.getMonstros(), this.getCartaDeRitual());
        super.clone();    
        return mr;
    }
    
}
