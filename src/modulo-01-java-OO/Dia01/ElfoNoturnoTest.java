

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ElfoNoturnoTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ElfoNoturnoTest
{
    @Test
    public void elfoNoturnoPerde5PorCentoDeVidaAoAtirar()
    {
        ElfoNoturno elfo = new ElfoNoturno("Um elfo qualquer");
        Orc umOrc = new Orc();
        elfo.atirarFlecha(umOrc);
        int vidaEsperada = 95;
        int vidaEncontrada = elfo.getVida();
        assertEquals(vidaEsperada, vidaEncontrada);
    }
    
    @Test
    public void elfoNoturnoGanha3DeExperienciaAoAtirar()
    {
        ElfoNoturno elfo = new ElfoNoturno("Um elfo qualquer");
        Orc umOrc = new Orc();
        elfo.atirarFlecha(umOrc);
        int expEsperada = 3;
        int expEncontrada = elfo.getExperiencia();
        assertEquals(expEsperada, expEncontrada);
    }
    
    @Test
    public void testaVidaDoElfoApos6FlehcasAtiradas()
    {
        ElfoNoturno elfo = new ElfoNoturno("Um elfo qualquer");
        Orc umOrc = new Orc();
        elfo.atirarFlecha(umOrc);
        elfo.atirarFlecha(umOrc);
        elfo.atirarFlecha(umOrc);
        elfo.atirarFlecha(umOrc);
        elfo.atirarFlecha(umOrc);
        elfo.atirarFlecha(umOrc);
        int vidaEsperada = 72;
        int vidaEncontrada = elfo.getVida();
        assertEquals(vidaEsperada, vidaEncontrada);
    }
}
