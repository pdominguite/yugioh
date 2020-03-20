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
public class MonstroDeFusao extends Monstro implements Serializable {
	private static final long serialVersionUID = 2888921351471924055L;
	@OneToMany
	@JoinTable(name = "Monstro_Fusao")
	private List<Monstro> monstros = new ArrayList<>();
	@OneToOne
    private Magica polimerizacao;
	
	//Hibernate complains if a public or protected zero-argument constructor is not provided.
	protected MonstroDeFusao() {}
    
    public MonstroDeFusao(Monstro m1, Monstro m2, Magica polimerizacao) {
        monstros.add(m1);
        monstros.add(m2);
        this.polimerizacao = polimerizacao;
    }
    
    public MonstroDeFusao(Monstro m1, Monstro m2, Monstro m3, Magica polimerizacao) {
        monstros.add(m1);
        monstros.add(m2);
        monstros.add(m3);
        this.polimerizacao = polimerizacao;
    }
    
    public MonstroDeFusao(List<Monstro> monstros, Magica polimerizacao) {
        this.monstros = monstros;
        this.polimerizacao = polimerizacao;
    }

    public MonstroDeFusao clone() {
        MonstroDeFusao mf = new MonstroDeFusao(this.getMonstros(), this.getPolimerizacao());                    
        super.clone();     
        return mf;
    }
    
}
