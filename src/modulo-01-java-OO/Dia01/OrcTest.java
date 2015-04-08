

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

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
        o = new Orc("Nome Grandee");
        int vidaAtual = o.getVida();
        o.recebeAtaque();
        assertEquals(vidaAtual, o.getVida()+10);
    }
   
    @Test
    public void orcNasceVivo() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc;
        // Act - Execução da ação de testes
        umOrc = new Orc();
        // Assert - Verificação
        Status esperado = Status.VIVO;
        Status obtido = umOrc.getStatus();
        
        assertEquals(esperado, obtido);
    }
    
    @Test
    public void orcRecebeAtaqueUmaVez() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc = new Orc("Urukhai");
        // Act
        umOrc.recebeAtaque();
        // Assert - Verificação
        int esperado = 100;
        int resultadoObtido = umOrc.getVida();
        
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcRecebeAtaqueDuasVezes() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc = new Orc("Urukhai");
        // Act
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        // Assert - Verificação
        int esperado = 90;
        int resultadoObtido = umOrc.getVida();
        
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcRecebeAtaqueCincoVezes() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc = new Orc("Urukhai");
        // Act
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        // Assert - Verificação
        int esperado = 60;
        int resultadoObtido = umOrc.getVida();
        
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcFicaFeridoAoReceberAtaque() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc = new Orc("Urukhai");
        // Act
        umOrc.recebeAtaque();
        // Assert - Verificação
        Status esperado = Status.FERIDO;
        Status resultadoObtido = umOrc.getStatus();
        
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcRecebeAtaqueDozeVezes() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc = new Orc("Urukhai");
        // Act
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        // Assert - Verificação
        int esperado = 0;
        int resultadoObtido = umOrc.getVida();
        
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test

    public void orcToStringRetornVidaPadrao()
    {
        Orc o = new Orc();
        String resultadoObtido = o.toString();
        String esperado = "Vida atual: 110";
        assertEquals(esperado,resultadoObtido);
    }
    
    @Test
    public void orcToStringRetornaVidaPadrao() {
        // Arrange
        Orc orc = new Orc();
        // Act
        String resultadoObtido = orc.toString();
        // Assert
        String esperado = "Vida atual: 110";
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcToStringAposReceberAtaque() {
        // Arrange
        Orc orc = new Orc("Urukhai");
        // Act
        orc.recebeAtaque();
        String resultadoObtido = orc.toString();
        // Assert
        String esperado = "Vida atual: 100";
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcToStringAposReceberDozeAtaques() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc = new Orc("Urukhai");
        // Act
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        String resultadoObtido = umOrc.toString();
        // Assert
        String esperado = "Vida atual: 0";
        assertEquals(esperado, resultadoObtido);
    }   
    
    @Test
    public void orcNasceComNomeInformado() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc;
        String esperado = "Urukhai";    
        // Act - Execução da ação de testes
        umOrc = new Orc(esperado);
        // Assert - Verificação
        String resultadoObtido = umOrc.getNome();
        
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcNasceComNomeVazioInformado() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc;
        String esperado = "";   
        // Act - Execução da ação de testes
        umOrc = new Orc(esperado);
        // Assert - Verificação
        String resultadoObtido = umOrc.getNome();
        
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcNasceComNomeNuloInformado() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc;
        String esperado = null; 
        // Act - Execução da ação de testes
        umOrc = new Orc(esperado);
        // Assert - Verificação
        String resultadoObtido = umOrc.getNome();
        
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcMorreAposDozeFlechadas() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc = new Orc("Urukhai");
        Status esperado = Status.MORTO;
        // Act
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        Status resultadoObtido = umOrc.getStatus();
        // Assert
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcRecebeAtaqueComNumeroGeradoMenorQueZero() {
        Orc orc = new Orc("Tom");
        orc.recebeAtaque();
        
        int vidaEsperada = 110;
        int experienciaEsperada = 2;
        
        assertEquals(vidaEsperada, orc.getVida());
        assertEquals(experienciaEsperada, orc.getExperiencia());
    }
    
    @Test
    public void orcRecebeAtaqueComNumeroGeradoEntre0e100() {
        Orc orc = new Orc("Urukhai"); // para somar 65 ao número gerado
        orc.setExperiencia(1); // ímpar e menor que 2 para poder manter entre 0 e 100
        orc.recebeAtaque();
        
        int vidaEsperada = 110;
        int experienciaEsperada = 1;
        
        assertEquals(vidaEsperada, orc.getVida());
        assertEquals(experienciaEsperada, orc.getExperiencia());
    }
    
    @Test
    public void orcRecebeAtaqueNormal() {
        Orc orc = new Orc("Urukhai"); // para somar 65 ao número gerado e elevar ao cubo e não estar nos casos acima.
        orc.recebeAtaque();
        
        int vidaEsperada = 100;
        Status statusEsperado = Status.FERIDO;
        
        assertEquals(vidaEsperada, orc.getVida());
        assertEquals(statusEsperado, orc.getStatus());
    }
    
    @Test
    public void orcTemItemPassadoParaInventario()
    {
        Orc orc = new Orc("Urukhai");
        ItemDoInventario martelo = new ItemDoInventario("Martelo", 1);
        orc.adicionarItem(martelo);
        ItemDoInventario itemEsperado = orc.getInventario().get(0);
        assertEquals(martelo, itemEsperado);
    }
    
    @Test
    public void orcPerdeItemInformado()
    {
        Orc orc = new Orc("Urukhai");
        ItemDoInventario martelo = new ItemDoInventario("Martelo", 1);   
        ItemDoInventario faca = new ItemDoInventario("Faca", 1);
        orc.adicionarItem(martelo);
        orc.adicionarItem(faca);
        ItemDoInventario itemEsperado = faca;
        orc.perderItem(martelo);
        ItemDoInventario itemEncontrado = orc.getInventario().get(0);
        assertEquals(itemEsperado, itemEncontrado);
    }
    
    @Test
    public void orcTemDoisItensIguaisEPerdeUm()
    {
        Orc orc = new Orc("Urukhai");
        ItemDoInventario martelo = new ItemDoInventario("Martelo", 1);   
        ItemDoInventario faca = new ItemDoInventario("Faca", 1);
        orc.adicionarItem(martelo);
        orc.adicionarItem(faca);
        orc.adicionarItem(martelo);
        ItemDoInventario itemEsperado = martelo;
        orc.perderItem(martelo);
        ItemDoInventario itemEncontrado = orc.getInventario().get(1);
        assertEquals(itemEsperado, itemEncontrado);
    }
    
    @Test
    public void imprimeDescricoesDosItens()
    {
        Orc orc = new Orc("Urukhai");
        ItemDoInventario martelo = new ItemDoInventario("Martelo", 1);   
        ItemDoInventario faca = new ItemDoInventario("Faca", 1);  
        ItemDoInventario espada = new ItemDoInventario("Espada", 1); 
        orc.adicionarItem(martelo);
        orc.adicionarItem(faca);
        orc.adicionarItem(espada);
        String textoEsperado = "Itens: Martelo, Faca, Espada";
        String textoObtido = orc.getDescricoesItens();
        assertEquals(textoEsperado, textoObtido);
    }
    
    @Test
    public void imprimeApenasUmItem()
    {
        Orc orc = new Orc("Urukhai");
        ItemDoInventario martelo = new ItemDoInventario("Martelo", 1); 
        orc.adicionarItem(martelo);
        String textoEsperado = "Itens: Martelo";
        String textoObtido = orc.getDescricoesItens();
        assertEquals(textoEsperado, textoObtido);
    }
    
    @Test
    public void orcSortudo()
    {
        Orc orc = new Orc("Nome");
        ItemDoInventario martelo = new ItemDoInventario("Martelo", 1);   
        ItemDoInventario faca = new ItemDoInventario("Faca", 1);  
        ItemDoInventario espada = new ItemDoInventario("Espada", 1);
        orc.adicionarItem(martelo);
        orc.adicionarItem(faca);
        orc.adicionarItem(espada);
        orc.setStatus(Status.DORMINDO);
        orc.setExperiencia(3);
        orc.tentarSorte();
        int valor = 1001;
        for(int i =0; i < orc.getInventario().size(); i++)
        {
            int qtde = orc.getInventario().get(i).getQuantidade();
            if(qtde != 1001)
            {
                valor = qtde;
            }
        }
        assertEquals(valor, 1001);
    }
}
