

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
}
