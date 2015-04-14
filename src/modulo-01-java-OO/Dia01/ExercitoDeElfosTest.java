

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
        Elfo elfo1 = new Elfo("Nome");
        ElfoComCor elfo2 = new ElfoComCor("Nome");
        ElfoNoturno elfo3 = new ElfoNoturno("Nome");
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.alistaElfo(elfo1);
        exercito.alistaElfo(elfo2);
        exercito.alistaElfo(elfo3);
        int qtdeEsperada = 2;
        int qtdeEncontrada = exercito.getQuantidadeAlistados();
        assertEquals(qtdeEsperada, qtdeEncontrada);
    }
}
