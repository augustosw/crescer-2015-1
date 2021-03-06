
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

 /**
 * Testes unitários para a classe Elfo.
 *
 * @author  CWI Software
 */
public class ElfoTest
{
    @Test
    public void elfoNasceComNomeInformado() {
        // Arrange
        String esperado = "Celeborn";        
        // Act
        Elfo elfo = new Elfo(esperado);
        // Assert
        assertEquals(esperado, elfo.getNome());
    }
    
    @Test
    public void elfoNasceComNomeVazio() {
        // Arrange
        String esperado = "";        
        // Act
        Elfo elfo = new Elfo(esperado);
        // Assert
        assertEquals(esperado, elfo.getNome());
    }
    
    @Test
    public void elfoNasceComNomeNulo() {
        // Arrange
        String esperado = null;        
        // Act
        Elfo elfo = new Elfo(esperado);
        // Assert
        assertEquals(esperado, elfo.getNome());
    }
    
    @Test
    public void elfoNasceCom42FlechasPorPadrao() {
        // Arrange
        int esperado = 42;
        // Act
        Elfo elfo = new Elfo("um nome qualquer");
        // Assert
        assertEquals(esperado, elfo.getFlechas());
    }
    
    @Test
    public void elfoNasceComNomeEMuitasFlechasInformados() {
        // Arrange
        String nomeEsperado = "Robin";
        int flechasEsperadas = 567853;
        // Act
        Elfo elfo = new Elfo(nomeEsperado, flechasEsperadas);
        // Assert
        assertEquals(nomeEsperado, elfo.getNome());
        assertEquals(flechasEsperadas, elfo.getFlechas());
    }
    
    @Test
    public void elfoNasceComNomeEPoucasFlechasInformados() {
        // Arrange
        String nomeEsperado = "Robin";
        int flechasEsperadas = 12;
        // Act
        Elfo elfo = new Elfo(nomeEsperado, flechasEsperadas);
        // Assert
        assertEquals(nomeEsperado, elfo.getNome());
        assertEquals(flechasEsperadas, elfo.getFlechas());
    }
    
    @Test
    public void elfoNasceComNomeEFlechasNegativasInformados() {
        // Arrange
        String nomeEsperado = "Robin";
        int flechasEsperadas = -567853;
        // Act
        Elfo elfo = new Elfo(nomeEsperado, flechasEsperadas);
        // Assert
        assertEquals(nomeEsperado, elfo.getNome());
        assertEquals(flechasEsperadas, elfo.getFlechas());
    }

    @Test
    public void elfoAtiraFlechaEmUmOrc() {
        // Arrange
        Elfo elfo = new Elfo("Legolas");
        Orc orc = new Orc("Azog");
        // Act
        elfo.atirarFlecha(orc);
        // Assert
        int experienciaEsperada = 1;
        int flechasEsperadas = 41;
        
        assertEquals(experienciaEsperada, elfo.getExperiencia());
        assertEquals(flechasEsperadas, elfo.getFlechas());
    }
    
    @Test
    public void elfoAtiraFlechasDuasVezesNoMesmoOrc() {
        // Arrange
        Elfo elfo = new Elfo("Legolas");
        Orc orc = new Orc("Azog");
        // Act
        elfo.atirarFlecha(orc);
        elfo.atirarFlecha(orc);
        // Assert
        int experienciaEsperada = 2;
        int flechasEsperadas = 40;
        
        assertEquals(experienciaEsperada, elfo.getExperiencia());
        assertEquals(flechasEsperadas, elfo.getFlechas());
    }
    
    @Test
    public void elfoAtiraFlechasCincoVezesNoMesmoOrc() {
        // Arrange
        Elfo elfo = new Elfo("Legolas", 4);
        Orc orc = new Orc("Azog");
        // Act
        elfo.atirarFlecha(orc);
        elfo.atirarFlecha(orc);
        elfo.atirarFlecha(orc);
        elfo.atirarFlecha(orc);
        elfo.atirarFlecha(orc);
        // Assert
        int experienciaEsperada = 4;
        int flechasEsperadas = 0;
        
        assertEquals(experienciaEsperada, elfo.getExperiencia());
        assertEquals(flechasEsperadas, elfo.getFlechas());
    }
    
    @Test
    public void elfoToStringRetornaStringCorretaAtirando1Flecha()
    {
        Elfo e = new Elfo("Legolas");
        Orc o = new Orc("Azog");
        e.atirarFlecha(o);
        String esperado = "Legolas possui 41 flechas e 1 nível de experiência.";
        assertEquals(esperado, e.toString());
    }
    
    @Test
    public void elfoToStringPadrao() {
        // Arrange
        Elfo elfo = new Elfo("Faustão");
        String resultadoEsperado = "Faustão possui 42 flechas e 0 níveis de experiência.";
        // Act
        String resultadoObtido = elfo.toString();
        // Assert
        assertEquals(resultadoEsperado, resultadoObtido);
    }
    
    
    @Test
    public void elfoToStringRetornaStringCorreta()
    {
        Elfo e = new Elfo("Legolas");
        String esperado = "Legolas possui 42 flechas e 0 níveis de experiência.";
        assertEquals(esperado, e.toString());
    }
    
    @Test
    public void elfoToStringRetornaStringCorretaAtirando5Flechas()
    {
        Elfo e = new Elfo("Legolas");
        Orc o = new Orc("Azog");
        e.atirarFlecha(o);
        e.atirarFlecha(o);
        e.atirarFlecha(o);
        e.atirarFlecha(o);
        e.atirarFlecha(o);
        String esperado = "Legolas possui 37 flechas e 5 níveis de experiência.";
        assertEquals(esperado, e.toString());
    }
    
    @Test
    public void testaQuantidadeDeElfosCriados()
    {
        Elfo.resetContador();
        Elfo normal = new Elfo("Nome");
        ElfoNoturno noturno = new ElfoNoturno("Outro Nome");
        ElfoComCor cor = new ElfoComCor("Não Importa o Nome");
        int qtdeEsperada = 3;
        int qtdeEncontrada = Elfo.getElfosCriados();
        assertEquals(qtdeEsperada, qtdeEncontrada);
    }
    
    @Test
    public void testaResetDeContadorDeElfos()
    {
        Elfo.resetContador();
        Elfo normal = new Elfo("Nome");
        ElfoNoturno noturno = new ElfoNoturno("Outro Nome");
        ElfoComCor cor = new ElfoComCor("Não Importa o Nome");
        Elfo.resetContador();
        int qtdeEsperada = 0;
        int qtdeEncontrada = Elfo.getElfosCriados();
        assertEquals(qtdeEsperada, qtdeEncontrada);        
    }
}

