

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ElfoComCorTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ElfoComCorTest
{
    @Test
    public void elfoComCorNasceComCorInformada()
    {
        ElfoComCor elfo = new ElfoComCor("Um nome Whatever", Cor.VERMELHO);
        Cor corEsperada = Cor.VERMELHO;
        Cor corEncontrada = elfo.getCor();
        assertEquals(corEsperada, corEncontrada);
    }
    
    @Test
    public void elfoComCorNasceSemCorInformada()
    {
        ElfoComCor elfo = new ElfoComCor("Um nome Whatever");
        Cor corEsperada = Cor.VERDE;
        Cor corEncontrada = elfo.getCor();
        assertEquals(corEsperada, corEncontrada);
    }
    
    @Test
    public void elfoVerdeGanhaDobroDeExperiencia()
    {
        ElfoComCor elfo = new ElfoComCor("Um nome Whatever", Cor.VERDE);
        Orc umOrc = new Orc();
        elfo.atirarFlecha(umOrc);
        int expEsperada = 2;
        int expEncontrada = elfo.getExperiencia();
        assertEquals(expEsperada, expEncontrada);
    }
    
    @Test
    public void elfoNaoVerdeGanhaExperienciaNormal()
    {
        ElfoComCor elfo = new ElfoComCor("Um nome Whatever", Cor.VERMELHO);
        Orc umOrc = new Orc();
        elfo.atirarFlecha(umOrc);
        int expEsperada = 1;
        int expEncontrada = elfo.getExperiencia();
        assertEquals(expEsperada, expEncontrada);
    }
    
    @Test
    public void elfoVerdeSoPodeAdicionarItensComDeterminadoNome()
    {
        ElfoComCor elfo = new ElfoComCor("Um nome Whatever", Cor.VERDE);
        ItemDoInventario item1 = new ItemDoInventario("Espada de aço valiriano", 10);
        ItemDoInventario item2 = new ItemDoInventario("Arco e Flecha de vidro", 5);
        elfo.adicionarItem(item1);
        elfo.adicionarItem(item2);
        int itensEsperados = 2;
        int itensEncontrados = elfo.getInventario().size();
        assertEquals(itensEsperados, itensEncontrados);
    }
    
    @Test
    public void elfoVerdeNãoPodeAdicionarItensComOutrosNomes()
    {
        ElfoComCor elfo = new ElfoComCor("Um nome Whatever", Cor.VERDE);
        ItemDoInventario item1 = new ItemDoInventario("Adaga", 10);
        ItemDoInventario item2 = new ItemDoInventario("Abridor de Latas", 5);
        elfo.adicionarItem(item1);
        elfo.adicionarItem(item2);
        int itensEsperados = 0;
        int itensEncontrados = elfo.getInventario().size();
        assertEquals(itensEsperados, itensEncontrados);
    }
}
