

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
    
    @Test
    public void elfoNoturnoMorreApos45Flechas()
    {
        ElfoNoturno elfo = new ElfoNoturno("Um elfo qualquer");
        Orc umOrc = new Orc();
        elfo.atirarVariasFlechas(umOrc, 45);
        Status statusEsperado = Status.MORTO;
        Status statusEncontrado = elfo.getStatus();
        assertEquals(statusEsperado, statusEncontrado);
    }
    
    @Test
    public void elfoNaoAtiraSeEstiverMorto()
    {
        ElfoNoturno elfo = new ElfoNoturno("Um elfo qualquer", 100);
        Orc umOrc = new Orc();
        elfo.atirarVariasFlechas(umOrc, 45);
        int flechasEsperadas = 55;
        int flechasEncontradas = elfo.getFlechas();
        assertEquals(flechasEsperadas, flechasEncontradas);
    }
}
