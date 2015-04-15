

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
}
