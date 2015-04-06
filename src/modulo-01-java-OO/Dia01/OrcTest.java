

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * A classe de teste OrcTest.
 *
 * @author  (seu nome)
 * @version (um número de versão ou data)
 */
public class OrcTest
{
    //Testes Classe Orc
    @Test
    public void orcNascecom110Vida()
    {
        //Arrage - Montagem dos dados de teste
        Orc o;
        //Act - Execução da ação de testes
        o = new Orc();
        //Assert - Verificação se o resultado é o esperado
        assertEquals(110, o.getVida());
    }
    
    @Test
    public void orcPerde10Vida()
    {
        Orc o;
        o = new Orc();
        int vidaAtual = o.getVida();
        o.levarDano();
        assertEquals(vidaAtual, o.getVida()+10);
    }
   
}
