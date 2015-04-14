

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
    private static final double DELTA = 0.005;
    @Test
    public void elfoNoturnoPerde5PorCentoDeVidaAoAtirar()
    {
        ElfoNoturno elfo = new ElfoNoturno("Um elfo qualquer");
        Orc umOrc = new Orc();
        elfo.atirarFlecha(umOrc);
        double vidaEsperada = 95;
        double vidaEncontrada = elfo.getVida();
        assertEquals(vidaEsperada, vidaEncontrada, DELTA);
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
        double vidaEsperada = 73.5091;
        double vidaEncontrada = elfo.getVida();
        assertEquals(vidaEsperada, vidaEncontrada, DELTA);
    }
    
    @Test
    public void elfoNoturnoMorreAposMuitasFlechas()
    {
        ElfoNoturno elfo = new ElfoNoturno("Um elfo qualquer");
        Orc umOrc = new Orc();
        elfo.atirarVariasFlechas(umOrc, 100);
        Status statusEsperado = Status.MORTO;
        Status statusEncontrado = elfo.getStatus();
        assertEquals(statusEsperado, statusEncontrado);
    }
    
    @Test
    public void elfoNaoAtiraSeEstiverMorto()
    {
        ElfoNoturno elfo = new ElfoNoturno("Um elfo qualquer", 100);
        Orc umOrc = new Orc();
        elfo.atirarVariasFlechas(umOrc, 90);
        int flechasEsperadas = 10;
        int flechasEncontradas = elfo.getFlechas();
        assertEquals(flechasEsperadas, flechasEncontradas);
    }
}
