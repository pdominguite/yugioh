package br.edu.unifei.ecoe08.yugioh.app;

import br.edu.unifei.ecoe08.yugioh.dao.DataSource;
import br.edu.unifei.ecoe08.yugioh.enumerate.TipoArmadilhaEnum;
import br.edu.unifei.ecoe08.yugioh.enumerate.TipoAtributoEnum;
import br.edu.unifei.ecoe08.yugioh.enumerate.TipoCaraterEnum;
import br.edu.unifei.ecoe08.yugioh.enumerate.TipoDominioEnum;
import br.edu.unifei.ecoe08.yugioh.enumerate.TipoMagiaEnum;
import br.edu.unifei.ecoe08.yugioh.enumerate.TipoMonstroEnum;
import br.edu.unifei.ecoe08.yugioh.enumerate.TipoPosicaoBatalhaEnum;
import br.edu.unifei.ecoe08.yugioh.enumerate.TipoVelocidadeEnum;
import br.edu.unifei.ecoe08.yugioh.model.Armadilha;
import br.edu.unifei.ecoe08.yugioh.model.Baralho;
import br.edu.unifei.ecoe08.yugioh.model.CampoDeDuelo;
import br.edu.unifei.ecoe08.yugioh.model.Carta;
import br.edu.unifei.ecoe08.yugioh.model.DiscoDeDuelo;
import br.edu.unifei.ecoe08.yugioh.model.Duelista;
import br.edu.unifei.ecoe08.yugioh.model.Dupla;
import br.edu.unifei.ecoe08.yugioh.model.Exodia;
import br.edu.unifei.ecoe08.yugioh.model.FabricaDeEfeitos;
import br.edu.unifei.ecoe08.yugioh.model.Farao;
import br.edu.unifei.ecoe08.yugioh.model.ItemDoMilenio;
import br.edu.unifei.ecoe08.yugioh.model.Magica;
import br.edu.unifei.ecoe08.yugioh.model.Monstro;
import br.edu.unifei.ecoe08.yugioh.model.MonstroDeEfeito;
import br.edu.unifei.ecoe08.yugioh.model.MonstroDeFusao;
import br.edu.unifei.ecoe08.yugioh.model.MonstroDeRitual;
import br.edu.unifei.ecoe08.yugioh.model.ReliquiaDoMilenio;
import br.edu.unifei.ecoe08.yugioh.model.Simples;
import br.edu.unifei.ecoe08.yugioh.model.Torneio;

import java.lang.reflect.InvocationTargetException;
import java.sql.Time;

import javax.persistence.EntityManager;


public class AppInsert {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
    	
    	EntityManager em = DataSource.createEntityManager();
    	
        em.getTransaction().begin();
                
        Farao aknadin = new Farao();
        aknadin.setNome("Aknadin");
        aknadin.setProfissao("Sumo Sacerdote e Conselheiro do Faraó");
        aknadin.setCarater(TipoCaraterEnum.MAU);
        aknadin.setGenero("Masculino");
        aknadin.setConquista("Criação das Relíquias do Milênio");
        
        System.out.println(aknadin.getNome()+" é "+aknadin.getProfissao()+" e responsável pela "+aknadin.getConquista()
                           +". Seu caráter é "+aknadin.getCarater()+".");
        
        em.persist(aknadin);
        
        Farao atem = new Farao();
        atem.setNome("Atem");
        atem.setProfissao("Faraó do Antigo Egito");
        atem.setCarater(TipoCaraterEnum.BOM);
        atem.setGenero("Masculino");
        atem.setConquista("Derrotou Zorc Necrophades, restaurando a paz no Antigo Egito");
        
        System.out.println(atem.getNome()+" é "+atem.getProfissao()+". "+atem.getConquista()
                           +". Seu caráter é "+atem.getCarater()+".");
        
        em.persist(atem);
        
        ItemDoMilenio pedraDoMilenio = new ItemDoMilenio();
        pedraDoMilenio.setNome("Pedra do Milênio");
        pedraDoMilenio.setCriador(aknadin);
        pedraDoMilenio.setCriacao("Há 5000 anos, antes dos eventos atuais");
        pedraDoMilenio.setFuncao("Manter pretegidas todas as Relíquias do Milênio");
        
        System.out.println("A "+pedraDoMilenio.getNome()+" é um Item do Milênio. Foi criada "+pedraDoMilenio.getCriacao()
                            +" por "+pedraDoMilenio.getCriador().getNome()+" com o objetivo de "+pedraDoMilenio.getFuncao()+".");
        
        em.persist(pedraDoMilenio);
        
        ReliquiaDoMilenio enigmaDoMilenio = new ReliquiaDoMilenio();
        enigmaDoMilenio.setNome("Enigma do Milênio");
        enigmaDoMilenio.setCriador(aknadin);
        enigmaDoMilenio.setCriacao("Há 5000 anos, antes dos eventos atuais");
        enigmaDoMilenio.setEspirito(atem);
        enigmaDoMilenio.setFuncao("Auxiliar o faraó na restauração da paz do Antigo Egito");
        enigmaDoMilenio.getPoderes().add("Contém as almas do Faraó Atem e de Zorc Necrophades");
        enigmaDoMilenio.getPoderes().add("Invoca e controla Monstros de Duelo, incluindo os Deuses Egípcios");
        enigmaDoMilenio.getPoderes().add("Garante, a quem que o resolver, Inteligência e o Poder das Trevas"); 
        
        System.out.println("A "+enigmaDoMilenio.getNome()+" é um Item do Milênio. Foi criada "+enigmaDoMilenio.getCriacao()
                            +" por "+enigmaDoMilenio.getCriador().getNome()+" com o objetivo de "+enigmaDoMilenio.getFuncao()
                            +". Ele "+enigmaDoMilenio.getPoderes());        
        
        em.persist(enigmaDoMilenio);
        
        Exodia exodia = Exodia.getExodia();
        exodia.setNome("Exodia");
        exodia.setAtaque(1000);
        exodia.setDefesa(1000);
        exodia.setAtributo(TipoAtributoEnum.TREVAS);
        exodia.setTipo(TipoMonstroEnum.MAGO);
        exodia.setNivel(3);
        exodia.setEfeito("Ao invocar Exodia completo, você vence o duelo");
        exodia.setPosicaoDeBatalha(TipoPosicaoBatalhaEnum.DEFESA);
        
        em.persist(exodia);
        
        Monstro magoNegro = new Monstro();
        magoNegro.setNome("Mago Negro");
        magoNegro.setAtaque(2500);
        magoNegro.setDefesa(2100);
        magoNegro.setAtributo(TipoAtributoEnum.TREVAS);        
        magoNegro.setTipo(TipoMonstroEnum.MAGO);
        magoNegro.setNivel(7);
        magoNegro.setNomePoder("Magia Negra");
        magoNegro.setPosicaoDeBatalha(TipoPosicaoBatalhaEnum.ATAQUE);
        
        em.persist(magoNegro);
        
        MonstroDeEfeito magoNegroDoCaos = new MonstroDeEfeito();
        magoNegroDoCaos.setNome("Mago Negro do Caos");
        magoNegroDoCaos.setAtaque(2800);
        magoNegroDoCaos.setDefesa(2600);
        magoNegroDoCaos.setAtributo(TipoAtributoEnum.TREVAS);
        magoNegroDoCaos.setTipo(TipoMonstroEnum.MAGO);
        magoNegroDoCaos.setNivel(8);
        magoNegroDoCaos.getEfeitos().add("Adicione à sua mão uma carta mágica do cemitério ao final do turno");
        magoNegroDoCaos.getEfeitos().add("Se esse monstro destruir outro monstro, bana o monstro destruído do jogo");
        magoNegroDoCaos.setVelocidade(TipoVelocidadeEnum.UM);
        
        em.persist(magoNegroDoCaos);
        
        FabricaDeEfeitos fabricaDeEfeitos = new FabricaDeEfeitos();
        
        Magica polimerizacao = (Magica) fabricaDeEfeitos.getCarta("Polimerizacao", Magica.class);
        polimerizacao.setNome("Polimerização");
        polimerizacao.setTipo(TipoMagiaEnum.NORMAL);
        polimerizacao.setVelocidade(TipoVelocidadeEnum.UM);
        polimerizacao.setEfeito("Permite invocar um monstro de fusão usando monstros da sua mão e/ou que estejam no seu campo de duelo");
        
        em.persist(polimerizacao);
        
        Monstro reiCaveira = new Monstro();
        reiCaveira.setNome("Rei Caveira");
        reiCaveira.setAtaque(2500);
        reiCaveira.setDefesa(1200);
        reiCaveira.setAtributo(TipoAtributoEnum.TREVAS);
        reiCaveira.setTipo(TipoMonstroEnum.DEMONIO);
        reiCaveira.setNivel(6);
        reiCaveira.setPosicaoDeBatalha(TipoPosicaoBatalhaEnum.ATAQUE);
        
        em.persist(reiCaveira);
        
        Monstro dragaoNegroDeOlhosVermelhos = new Monstro();
        dragaoNegroDeOlhosVermelhos.setNome("Dragão Negro de Olhos Vermelhos");
        dragaoNegroDeOlhosVermelhos.setAtaque(2400);
        dragaoNegroDeOlhosVermelhos.setDefesa(2000);
        dragaoNegroDeOlhosVermelhos.setAtributo(TipoAtributoEnum.TREVAS);
        dragaoNegroDeOlhosVermelhos.setTipo(TipoMonstroEnum.DRAGAO);
        dragaoNegroDeOlhosVermelhos.setNivel(7);
        dragaoNegroDeOlhosVermelhos.setPosicaoDeBatalha(TipoPosicaoBatalhaEnum.ATAQUE);
        
        em.persist(dragaoNegroDeOlhosVermelhos);
        
        MonstroDeFusao dragaoCaveiraNegro = new MonstroDeFusao(reiCaveira, dragaoNegroDeOlhosVermelhos, polimerizacao);
        dragaoCaveiraNegro.setNome("Dragão Caveira Negro");
        dragaoCaveiraNegro.setAtaque(3200);
        dragaoCaveiraNegro.setDefesa(2500);
        dragaoCaveiraNegro.setAtributo(TipoAtributoEnum.TREVAS);
        dragaoCaveiraNegro.setTipo(TipoMonstroEnum.DRAGAO);
        dragaoCaveiraNegro.setNivel(9);
        dragaoCaveiraNegro.setPosicaoDeBatalha(TipoPosicaoBatalhaEnum.ATAQUE);  
        
        em.persist(dragaoCaveiraNegro);
        
        Magica ritualDoLustroNegro = (Magica) fabricaDeEfeitos.getCarta("Ritual do Lustro Negro", Magica.class);
        ritualDoLustroNegro.setNome("Ritual do Lustro Negro");
        ritualDoLustroNegro.setTipo(TipoMagiaEnum.RITUAL);
        ritualDoLustroNegro.setVelocidade(TipoVelocidadeEnum.UM);
        ritualDoLustroNegro.setEfeito("Permite invocar o Soldado do Lustro Negro ao sacrificar dois monstros cujos níveis somem 8");
        
        em.persist(ritualDoLustroNegro);
        
        Monstro kuriboh = new Monstro();
        kuriboh.setNome("Kuriboh");
        kuriboh.setAtaque(300);
        kuriboh.setDefesa(200);
        kuriboh.setAtributo(TipoAtributoEnum.TREVAS);
        kuriboh.setTipo(TipoMonstroEnum.DEMONIO);
        kuriboh.setNivel(1);
        kuriboh.setPosicaoDeBatalha(TipoPosicaoBatalhaEnum.DEFESA);
        
        em.persist(kuriboh);
        
        MonstroDeRitual soldadoDoLustroNegro = new MonstroDeRitual(reiCaveira, kuriboh, ritualDoLustroNegro);
        soldadoDoLustroNegro.setNome("Soldado do Lustro Negro");
        soldadoDoLustroNegro.setAtaque(3000);
        soldadoDoLustroNegro.setDefesa(2500);
        soldadoDoLustroNegro.setAtributo(TipoAtributoEnum.LUZ);
        soldadoDoLustroNegro.setTipo(TipoMonstroEnum.GUERREIRO);
        soldadoDoLustroNegro.setNivel(8);
        soldadoDoLustroNegro.setPosicaoDeBatalha(TipoPosicaoBatalhaEnum.ATAQUE);
        
        em.persist(soldadoDoLustroNegro);
        
        Armadilha cartolasMagicas = (Armadilha) fabricaDeEfeitos.getCarta("Cartolas Mágicas", Armadilha.class);
        cartolasMagicas.setNome("Cartolas Mágicas");
        cartolasMagicas.setTipo(TipoArmadilhaEnum.NORMAL);
        cartolasMagicas.setVelocidade(TipoVelocidadeEnum.DOIS);
        cartolasMagicas.setEfeito("Escolha duas cartas de efeito do baralho e uma carta monstro. "
                                + "Embaralhe-as. Ao final da fase de batalha do oponente, as cartas do baralho são destruídas.");
        
        em.persist(cartolasMagicas);
        
        Baralho baralhoYugi = new Baralho();
        baralhoYugi.setMonstroPrincipal(magoNegro);
        baralhoYugi.getCartas().add(exodia);
        baralhoYugi.getCartas().add(magoNegro);
        baralhoYugi.getCartas().add(magoNegroDoCaos);
        baralhoYugi.getCartas().add(polimerizacao);
        baralhoYugi.getCartas().add(reiCaveira);
        baralhoYugi.getCartas().add(dragaoNegroDeOlhosVermelhos);
        baralhoYugi.getCartas().add(dragaoCaveiraNegro);
        baralhoYugi.getCartas().add(ritualDoLustroNegro);
        baralhoYugi.getCartas().add(kuriboh);
        baralhoYugi.getCartas().add(soldadoDoLustroNegro);
        baralhoYugi.getCartas().add(cartolasMagicas);
        baralhoYugi.atualizaQuantidadeCartas();
        
        em.persist(baralhoYugi);
                
        Duelista yugi = new Duelista();
        yugi.setNome("Yugi Muto");
        yugi.setNascimento("4 de Junho");
        yugi.setAltura(1.53f);
        yugi.setPeso(42);
        yugi.setDeck("Estratégia");
        yugi.setClassificacao("Duelador de Elite");
        yugi.setDuelosGanhos(200);
        yugi.setProfissao("Estudante");
        yugi.setRanking(1);
        yugi.getReliquias().add(enigmaDoMilenio);
        yugi.setBaralho(baralhoYugi);
        yugi.setPontosDeVida(2000);
        yugi.setGenero("Maculino");
        
        em.persist(yugi);
        
        Monstro dragaoBrancoDeOlhosAzuis = new Monstro();
        dragaoBrancoDeOlhosAzuis.setNome("Dragão Branco de Olhos Azuis");
        dragaoBrancoDeOlhosAzuis.setAtaque(3000);
        dragaoBrancoDeOlhosAzuis.setDefesa(2500);
        dragaoBrancoDeOlhosAzuis.setAtributo(TipoAtributoEnum.LUZ);
        dragaoBrancoDeOlhosAzuis.setTipo(TipoMonstroEnum.DRAGAO);
        dragaoBrancoDeOlhosAzuis.setNivel(8);
        dragaoBrancoDeOlhosAzuis.setNomePoder("Luz Branca");
        dragaoBrancoDeOlhosAzuis.setPosicaoDeBatalha(TipoPosicaoBatalhaEnum.ATAQUE);
        
        em.persist(dragaoBrancoDeOlhosAzuis);
        
        Baralho baralhoKaiba = new Baralho();
        baralhoKaiba.getCartas().add(dragaoBrancoDeOlhosAzuis);
        baralhoKaiba.getCartas().add(dragaoBrancoDeOlhosAzuis.clone());
        baralhoKaiba.getCartas().add(dragaoBrancoDeOlhosAzuis.clone());
        baralhoKaiba.atualizaQuantidadeCartas();
        
        for(Carta c : baralhoKaiba.getCartas()) {
        	em.persist(c);
        }
        
        em.persist(baralhoKaiba);
                
        Duelista kaiba = new Duelista();
        kaiba.setNome("Seto Kaiba");
        kaiba.setNascimento("25 de Outubro");
        kaiba.setAltura(1.86f);
        kaiba.setPeso(65);
        kaiba.setDeck("Poder");
        kaiba.setClassificacao("Duelador de Elite");
        kaiba.setDuelosGanhos(190);
        kaiba.setProfissao("Empresário");
        kaiba.setRanking(2);
        kaiba.setPontosDeVida(2000);
        kaiba.setGenero("Maculino");
        kaiba.setBaralho(baralhoKaiba);
        
        em.persist(kaiba);
        
        Simples yugiKaibaSimples = new Simples();
        yugiKaibaSimples.setDominio(TipoDominioEnum.REAL);
        yugiKaibaSimples.setDuracao(new Time(5500000));
        yugiKaibaSimples.setLocal("Domino City");
        yugiKaibaSimples.setObjetivo("Duelo pelo Torneio Batalha da Cidade");
        yugiKaibaSimples.setPontosDeVidaInicial(4000);
        yugiKaibaSimples.getParticipantes().add(yugi);
        yugiKaibaSimples.getParticipantes().add(kaiba);
        yugiKaibaSimples.atualizaCamposDeDuelo();
        yugiKaibaSimples.getVencedores().add(yugi);
        
        for(CampoDeDuelo cdd: yugiKaibaSimples.getCamposDeDuelo()) {
        	em.persist(cdd);
        }
        
        em.persist(yugiKaibaSimples);	
        
        System.out.println();
        System.out.println(yugiKaibaSimples.getCamposDeDuelo().get(0).getCampoDupla().getDuelista().getNome());
        System.out.println(yugiKaibaSimples.getCamposDeDuelo().get(1).getCampoDupla().getDuelista().getNome());
        
        Duelista joey = new Duelista();
        joey.setNome("Joey Wheeler");
        
        em.persist(joey);
        
        Duelista para = new Duelista();
        para.setNome("Para");
        
        em.persist(para);
        
        Duelista dox = new Duelista();
        dox.setNome("Dox");
        
        em.persist(dox);
        
        Dupla yugiJoeyDupla = new Dupla();
        yugiJoeyDupla.setDominio(TipoDominioEnum.REAL);
        yugiJoeyDupla.setLocal("Caverna da Ilha dos Duelistas");
        yugiJoeyDupla.setDuracao(new Time(4500000));
        yugiJoeyDupla.setPontosDeVidaInicial(2000);
        yugiJoeyDupla.setObjetivo("Vencer os Irmãos Para e Dox e continuar do Torneio do Reino dos Duelistas");
        yugiJoeyDupla.getParticipantes().add(yugi);
        yugiJoeyDupla.getParticipantes().add(joey);
        yugiJoeyDupla.getParticipantes().add(para);
        yugiJoeyDupla.getParticipantes().add(dox);
        yugiJoeyDupla.atualizaCamposDeDuelo();
        yugiJoeyDupla.getVencedores().add(yugi);
        yugiJoeyDupla.getVencedores().add(joey);
        
        yugiJoeyDupla.getCamposDeDuelo().get(0).getCartasEmJogo().add(magoNegroDoCaos);
        yugiJoeyDupla.getCamposDeDuelo().get(0).getCartasEmJogo().add(reiCaveira);
        yugiJoeyDupla.getCamposDeDuelo().get(0).getCartasNoCemiterio().add(magoNegro);			
        yugiJoeyDupla.getCamposDeDuelo().get(0).getCartasNoCemiterio().add(dragaoBrancoDeOlhosAzuis);
        
        
        for(CampoDeDuelo cdd : yugiJoeyDupla.getCamposDeDuelo()) {
        	em.persist(cdd);
        }
        
        /*
         * Em dupla, devemos primeiro salvar os CamposDeDuelo no banco para depois fazermos a referência do campo da dupla.
         * Se não, JPA vai persistir um CampoDeDuelo que referencia outro CampoDeDuelo (o campo da dupla) que não foi persistido ainda.
         */
        yugiJoeyDupla.atualizaCamposDupla();
        
        for(CampoDeDuelo cdd : yugiJoeyDupla.getCamposDeDuelo()) {
        	em.merge(cdd);
        }
        
        em.persist(yugiJoeyDupla);
        
        System.out.println();
        System.out.println(yugiJoeyDupla.getCamposDeDuelo().get(0).getCampoDupla().getDuelista().getNome());
        System.out.println(yugiJoeyDupla.getCamposDeDuelo().get(1).getCampoDupla().getDuelista().getNome());
        System.out.println(yugiJoeyDupla.getCamposDeDuelo().get(2).getCampoDupla().getDuelista().getNome());
        System.out.println(yugiJoeyDupla.getCamposDeDuelo().get(3).getCampoDupla().getDuelista().getNome());
        
        DiscoDeDuelo discoDeDuelo = new DiscoDeDuelo();
        discoDeDuelo.setFormato("Padrão");
        discoDeDuelo.setFabricante("Kaiba Corporation");
        
        em.persist(discoDeDuelo);
        
        Torneio batalhaDaCidade = new Torneio();
        batalhaDaCidade.setNome("Batalha da Cidade");
        batalhaDaCidade.setOrganizador(kaiba);
        batalhaDaCidade.setPremio("A cada duelo o vencedor obtém a carta mais rara de seu oponente");
        batalhaDaCidade.setLocal("Domino City");
        batalhaDaCidade.setDominio(TipoDominioEnum.REAL);
        batalhaDaCidade.setPontosDeVidaInicial(4000);
        batalhaDaCidade.setObjetivo("Encontrar as três cartas de Deuses Egípcios");
        batalhaDaCidade.getVencedores().add(yugi);
        batalhaDaCidade.setEstrutura(discoDeDuelo);
        batalhaDaCidade.getDuelos().add(yugiKaibaSimples);
        
        em.persist(batalhaDaCidade);
        
        ReliquiaDoMilenio olhoDoMilenio = new ReliquiaDoMilenio();
        olhoDoMilenio.setNome("Olho do Milênio");
        olhoDoMilenio.setCriacao("Há 5000 anos, antes dos eventos atuais");
        olhoDoMilenio.setCriador(aknadin);
        olhoDoMilenio.setFuncao("Auxiliar o faraó na restauração da paz do Antigo Egito");
        olhoDoMilenio.getPoderes().add("Ler mentes");
        olhoDoMilenio.getPoderes().add("Olhar dentro da alma de uma pessoa");
        olhoDoMilenio.getPoderes().add("Selar a alma de uma pessoa em uma carta de duelo");
        
        em.persist(olhoDoMilenio);
        
        Baralho baralhoPegasus = new Baralho();
        baralhoPegasus.getCartas().add(fabricaDeEfeitos.getCarta("Mundo da Fantasia", Magica.class));
        baralhoPegasus.atualizaQuantidadeCartas();
        
        for(Carta c : baralhoPegasus.getCartas()) {
        	em.persist(c);
        }
        em.persist(baralhoPegasus);
        
        Duelista pegasus = new Duelista();
        pegasus.setNome("Maximillion Pegasus");
        pegasus.setNascimento("8 de Outubro");
        pegasus.setAltura(1.87f);
        pegasus.setPeso(65f);
        pegasus.setProfissao("Presidente da Companhia Ilusões Industriais");
        pegasus.setDuelosGanhos(100);
        pegasus.setClassificacao("Vencedor do Reino dos Duelistas dos Estados Unidos");
        pegasus.setDeck("Fantasia");
        pegasus.getReliquias().add(olhoDoMilenio);
        pegasus.setBaralho(baralhoPegasus);
        pegasus.setGenero("Masculino");
        
        em.persist(pegasus);
        
        Simples yugiPegasus = new Simples();
        yugiPegasus.setDominio(TipoDominioEnum.TREVAS);
        yugiPegasus.setDuracao(new Time(3500000));
        yugiPegasus.setLocal("Mundo das Trevas");
        yugiPegasus.setObjetivo("Vencer Pegasus e impedi-lo de capturar a alma de seu avô");
        yugiPegasus.setPontosDeVidaInicial(2000);
        yugiPegasus.getParticipantes().add(yugi);
        yugiPegasus.getParticipantes().add(pegasus);
        yugiPegasus.atualizaCamposDeDuelo();
        yugiPegasus.getVencedores().add(pegasus);
        
        for(CampoDeDuelo cdd : yugiPegasus.getCamposDeDuelo()) {
        	em.persist(cdd);
        }
        
        em.persist(yugiPegasus);
        
        em.getTransaction().commit();
        em.close();
        DataSource.closeFactory();
        
    }
}
