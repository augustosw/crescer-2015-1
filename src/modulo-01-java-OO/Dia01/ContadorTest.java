

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ContadorTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ContadorTest
{
    @Test
    public void testaQuantidadeDeElfosCriados()
    {
        Elfo normal = new Elfo("Nome");
        ElfoNoturno noturno = new ElfoNoturno("Outro Nome");
        ElfoComCor cor = new ElfoComCor("Não Importa o Nome");
        int qtdeEsperada = 3;
        int qtdeEncontrada = Contador.getElfosCriados();
        assertEquals(qtdeEsperada, qtdeEncontrada);
    }
    
    @Test
    public void testaResetDeContadorDeElfos()
    {
        Elfo normal = new Elfo("Nome");
        ElfoNoturno noturno = new ElfoNoturno("Outro Nome");
        ElfoComCor cor = new ElfoComCor("Não Importa o Nome");
        Contador.resetContador();
        int qtdeEsperada = 0;
        int qtdeEncontrada = Contador.getElfosCriados();
        assertEquals(qtdeEsperada, qtdeEncontrada);        
    }
}
