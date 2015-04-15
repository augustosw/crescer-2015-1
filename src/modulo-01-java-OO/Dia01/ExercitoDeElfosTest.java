

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

/**
 * The test class ExercitoDeElfosTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ExercitoDeElfosTest
{
    @Test
    public void insereApenasElfosValidos()
    {
        ElfoComCor elfo2 = new ElfoComCor("Nome");
        ElfoNoturno elfo3 = new ElfoNoturno("Nome2");
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.alistaElfo(elfo2);
        exercito.alistaElfo(elfo3);
        int qtdeEsperada = 2;
        int qtdeEncontrada = exercito.getQuantidadeAlistados();
        assertEquals(qtdeEsperada, qtdeEncontrada);
    }
    
    @Test
    
    public void elfoNormalNaoAlista()
    {
        Elfo elfo1 = new Elfo("Nome");
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.alistaElfo(elfo1);
        int qtdeEsperada = 0;
        int qtdeEncontrada = exercito.getQuantidadeAlistados();
        assertEquals(qtdeEsperada, qtdeEncontrada);
    }
    
    @Test
    public void buscaNomeNaoAlistadoRetornaNull()
    {
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        Elfo esperado = null;
        Elfo obtido = exercito.buscar("Um nome ai");
        assertEquals(esperado, obtido);
    }
    
    @Test
    public void buscaNomeERetornaEncontrado()
    {
        ElfoComCor elfo2 = new ElfoComCor("Nome");
        ElfoNoturno elfo3 = new ElfoNoturno("Nome2");
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.alistaElfo(elfo2);
        exercito.alistaElfo(elfo3);
        Elfo esperado = elfo2;
        Elfo obtido = exercito.buscar("Nome");
        assertEquals(esperado, obtido);
    }
    
    @Test
    public void buscaElfosPorStatus()
    {
       ElfoComCor elfo2 = new ElfoComCor("Nome");
       ElfoNoturno elfo3 = new ElfoNoturno("Nome2");
       ElfoNoturno elfo1 = new ElfoNoturno("aaa");
       ElfoNoturno elfo4 = new ElfoNoturno("aasas");
       ExercitoDeElfos exercito = new ExercitoDeElfos();
       Orc orc = new Orc();
       exercito.alistaElfo(elfo2);
       exercito.alistaElfo(elfo3); 
       exercito.alistaElfo(elfo1);
       exercito.alistaElfo(elfo4);
       elfo1.morre(orc);
       int qtdeEsperada = 3;
       HashMap<String, Elfo> listaElfos = exercito.listaElfosPorStatus(Status.VIVO);
       int qtdeEncontrada = listaElfos.size();
       assertEquals(qtdeEsperada, qtdeEncontrada);
    }
    
    @Test
    public void buscaElfosPorStatusRetornaVazio()
    {
       ElfoNoturno elfo3 = new ElfoNoturno("Nome2");
       ElfoNoturno elfo1 = new ElfoNoturno("aaa");
       ExercitoDeElfos exercito = new ExercitoDeElfos();
       Orc orc = new Orc();
       exercito.alistaElfo(elfo3); 
       exercito.alistaElfo(elfo1);
       elfo1.morre(orc);
       elfo3.morre(orc);
       int qtdeEsperada = 0;
       HashMap<String, Elfo> listaElfos = exercito.listaElfosPorStatus(Status.VIVO);
       int qtdeEncontrada = listaElfos.size();
       assertEquals(qtdeEsperada, qtdeEncontrada);
    }
    
    @Test
    public void agruparVariosElfosPorStatus() {
        // Arrange
        ElfoComCor elfoVivo1 = new ElfoComCor("Green 1");
        ElfoNoturno elfoVivo2 = new ElfoNoturno("Aa");
        ElfoComCor elfoVivo3 = new ElfoComCor("BB");
        ElfoComCor elfoAtacando1 = new ElfoComCor("Green 2");
        ElfoComCor elfoAtacando2 = new ElfoComCor("Green 3");
        elfoAtacando1.atirarFlecha(new Orc());
        elfoAtacando2.atirarFlecha(new Orc());
        HashMap<Status, ArrayList<Elfo>> esperado = new HashMap<>();
        esperado.put(Status.ATACANDO, new ArrayList<>(
            Arrays.asList(elfoAtacando1, elfoAtacando2)
        ));
        esperado.put(Status.VIVO, new ArrayList<>(
            Arrays.asList(elfoVivo2, elfoVivo3, elfoVivo1)
        ));
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.alistaElfo(elfoAtacando1);
        exercito.alistaElfo(elfoAtacando2);
        exercito.alistaElfo(elfoVivo1);
        exercito.alistaElfo(elfoVivo2);
        exercito.alistaElfo(elfoVivo3);
        // Act
        exercito.agruparPorStatus();
        HashMap<Status, ArrayList<Elfo>> resultado = exercito.getExercitoPorStatus();
        // Assert
        assertEquals(esperado, resultado);
    }
    
    @Test
    public void buscarPorStatusAtacandoComVariosElfos() 
    {
        // Arrange
        ElfoComCor elfoVivo1 = new ElfoComCor("Green 1");
        ElfoNoturno elfoVivo2 = new ElfoNoturno("Aa");
        ElfoComCor elfoVivo3 = new ElfoComCor("BB");
        ElfoComCor elfoAtacando1 = new ElfoComCor("Green 2");
        ElfoComCor elfoAtacando2 = new ElfoComCor("Green 3");
        elfoAtacando1.atirarFlecha(new Orc());
        elfoAtacando2.atirarFlecha(new Orc());
        ArrayList<Elfo> esperado = new ArrayList<>(
            Arrays.asList(elfoAtacando1, elfoAtacando2)
        );
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.alistaElfo(elfoAtacando1);
        exercito.alistaElfo(elfoAtacando2);
        exercito.alistaElfo(elfoVivo1);
        exercito.alistaElfo(elfoVivo2);
        exercito.alistaElfo(elfoVivo3);
        // Act
        ArrayList<Elfo> resultado = exercito.buscar(Status.ATACANDO);
        // Assert
        assertEquals(esperado, resultado);
    }
}
