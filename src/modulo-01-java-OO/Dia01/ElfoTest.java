

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * A classe de teste ElfoTest.
 *
 * @author  (seu nome)
 * @version (um número de versão ou data)
 */
public class ElfoTest
{     
    //Testes Classe Elfo
    @Test
    public void elfoNasceCom42Flechas()
    {
        Elfo e;
        e = new Elfo("Legolas");
        assertEquals(42, e.getFlechas());
    }
    
    @Test
    public void expAumentaAoAtirarFlecha()
    {
        Elfo e;
        e = new Elfo("Teste");
        int expAtual = e.getExp();
        e.atirarFlecha();
        assertEquals(expAtual+1, e.getExp());
    }
    
    @Test
    public void vidaDeOrcDiminuiAoAtirar()
    {
        Elfo e;
        Orc o;
        e = new Elfo("Teste"); 
        o = new Orc();
        int vidaAtual = o.getVida();
        e.atirarFlechaOrc(o);
        assertEquals(vidaAtual, o.getVida()+10);
    }
    
    @Test
    public void numeroFlechasDiminiuAoAtirar()
    {
        Elfo e;
        e = new Elfo("Teste");
        int f = e.getFlechas();
        e.atirarFlecha();
        assertEquals(f-1, e.getFlechas());
    }
}
