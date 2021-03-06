import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;


/**
 * A classe de teste OrcTest.
 *
 * @author  (seu nome)
 * @version (um número de versão ou data)
 */
public class OrcTest
{
    private static final double DELTA = 0.005;
    //Testes Classe Orc
    @Test
    public void orcNascecom110Vida()
    {
        //Arrage - Montagem dos dados de teste
        Orc o;
        //Act - Execução da ação de testes
        o = new Orc();
        //Assert - Verificação se o resultado é o esperado
        assertEquals(110.0, o.getVida(), DELTA);
    }
    
    @Test
    public void orcPerde10Vida()
    {
        Orc o;
        o = new Orc("Nome Grandee");
        double vidaEsperada = 100.0;
        o.recebeAtaque();
        assertEquals(vidaEsperada, o.getVida(), DELTA);
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
        double esperado = 100;
        double resultadoObtido = umOrc.getVida();
        
        assertEquals(esperado, resultadoObtido, DELTA);
    }
    
    @Test
    public void orcRecebeAtaqueDuasVezes() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc = new Orc("Urukhai");
        // Act
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        // Assert - Verificação
        double esperado = 90;
        double resultadoObtido = umOrc.getVida();
        
        assertEquals(esperado, resultadoObtido, DELTA);
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
        double esperado = 60;
        double resultadoObtido = umOrc.getVida();
        
        assertEquals(esperado, resultadoObtido, DELTA);
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
        double esperado = 0;
        double resultadoObtido = umOrc.getVida();
        
        assertEquals(esperado, resultadoObtido, DELTA);
    }
    
    @Test

    public void orcToStringRetornVidaPadrao()
    {
        Orc o = new Orc();
        String resultadoObtido = o.toString();
        String esperado = "Vida atual: 110.0";
        assertEquals(esperado,resultadoObtido);
    }
    
    @Test
    public void orcToStringRetornaVidaPadrao() {
        // Arrange
        Orc orc = new Orc();
        // Act
        String resultadoObtido = orc.toString();
        // Assert
        String esperado = "Vida atual: 110.0";
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
        String esperado = "Vida atual: 100.0";
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
        String esperado = "Vida atual: 0.0";
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
        
        double vidaEsperada = 110.0;
        int experienciaEsperada = 2;
        
        assertEquals(vidaEsperada, orc.getVida(), DELTA);
        assertEquals(experienciaEsperada, orc.getExperiencia());
    }
    
    @Test
    public void orcRecebeAtaqueComNumeroGeradoEntre0e100() {
        Orc orc = new Orc("Urukhai"); // para somar 65 ao número gerado
        orc.setExp(1); // ímpar e menor que 2 para poder manter entre 0 e 100
        orc.recebeAtaque();
        
        double vidaEsperada = 110.0;
        int experienciaEsperada = 1;
        
        assertEquals(vidaEsperada, orc.getVida(), DELTA);
        assertEquals(experienciaEsperada, orc.getExperiencia());
    }
    
    @Test
    public void orcRecebeAtaqueNormal() {
        Orc orc = new Orc("Urukhai"); // para somar 65 ao número gerado e elevar ao cubo e não estar nos casos acima.
        orc.recebeAtaque();
        
        double vidaEsperada = 100.0;
        Status statusEsperado = Status.FERIDO;
        
        assertEquals(vidaEsperada, orc.getVida(), DELTA);
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
        orc.setExp(3);
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
    
    @Test
    public void orcSemSorte()
    {
        Orc orc = new Orc("NomeGrande");
        ItemDoInventario martelo = new ItemDoInventario("Martelo", 1);   
        ItemDoInventario faca = new ItemDoInventario("Faca", 1);  
        ItemDoInventario espada = new ItemDoInventario("Espada", 1);
        orc.adicionarItem(martelo);
        orc.adicionarItem(faca);
        orc.adicionarItem(espada);
        orc.tentarSorte();
        int valor = 1;
        for(int i =0; i < orc.getInventario().size(); i++)
        {
            int qtde = orc.getInventario().get(i).getQuantidade();
            if(qtde != 1)
            {
                valor = qtde;
            }
        }
        assertEquals(valor, 1);
    }
    
    @Test
    public void pegaItemComMaiorQuantidade()
    {
        Orc orc = new Orc("NomeGrande");
        ItemDoInventario martelo = new ItemDoInventario("Martelo", 10);   
        ItemDoInventario faca = new ItemDoInventario("Faca", 12);  
        ItemDoInventario espada = new ItemDoInventario("Espada", 16);
        orc.adicionarItem(martelo);
        orc.adicionarItem(faca);
        orc.adicionarItem(espada);
        ItemDoInventario itemEsperado = espada;
        ItemDoInventario itemEncontrado = orc.getItemComMaiorQuantidade();
        assertEquals(itemEsperado, itemEncontrado);
    }
    
    @Test 
    public void inventarioDoOrcEstaVazioERetornaNulo()
    {
        Orc orc = new Orc("NomeGrande");
        ItemDoInventario itemEsperado = null;
        ItemDoInventario itemEncontrado = orc.getItemComMaiorQuantidade();
        assertEquals(itemEsperado, itemEncontrado);
    }
    
    @Test
    public void inventarioComApenasUmItem()
    {
        Orc orc = new Orc("NomeGrande");
        ItemDoInventario martelo = new ItemDoInventario("Martelo", 10);   
        orc.adicionarItem(martelo);
        ItemDoInventario itemEsperado = martelo;
        ItemDoInventario itemEncontrado = orc.getItemComMaiorQuantidade();
        assertEquals(itemEsperado, itemEncontrado);
    }
    
    @Test
    public void inventarioComDoisItemComMesmaQuantidade()
    {
        Orc orc = new Orc("NomeGrande");
        ItemDoInventario martelo = new ItemDoInventario("Martelo", 10);   
        ItemDoInventario faca = new ItemDoInventario("Faca", 10);  
        orc.adicionarItem(martelo);
        orc.adicionarItem(faca);
        ItemDoInventario itemEsperado = martelo;
        ItemDoInventario itemEncontrado = orc.getItemComMaiorQuantidade();
        assertEquals(itemEsperado, itemEncontrado);
    }
    
    @Test
    public void ordenaInventarioComVariosItens()
    {
        Orc orc = new Orc();
        ItemDoInventario martelo = new ItemDoInventario("Martelo", 10);   
        ItemDoInventario faca = new ItemDoInventario("Faca", 12);  
        ItemDoInventario espada = new ItemDoInventario("Espada", 16);
        ItemDoInventario outro = new ItemDoInventario("Outro", 9);
        orc.adicionarItem(martelo);
        orc.adicionarItem(faca);
        orc.adicionarItem(espada);
        orc.adicionarItem(outro);
        ArrayList<ItemDoInventario> inventarioEsperado = new ArrayList<>();
        inventarioEsperado.add(outro);
        inventarioEsperado.add(martelo);
        inventarioEsperado.add(faca);
        inventarioEsperado.add(espada);
        orc.ordenarItens();
        ArrayList<ItemDoInventario> inventarioEncontrado = orc.getInventario();
        assertEquals(inventarioEsperado, inventarioEncontrado);
    }
    
    @Test
    public void ordenaComUmItemNoInventario()
    {
        Orc orc = new Orc();
        ItemDoInventario martelo = new ItemDoInventario("Martelo", 10);   
        orc.adicionarItem(martelo);
        ArrayList<ItemDoInventario> inventarioEsperado = new ArrayList<>();
        inventarioEsperado.add(martelo);
        orc.ordenarItens();
        ArrayList<ItemDoInventario> inventarioEncontrado = orc.getInventario();
        assertEquals(inventarioEsperado, inventarioEncontrado);
    }
    
    @Test
    public void ordenaComItemComQuantidadeNegativa()
    {
        Orc orc = new Orc();
        ItemDoInventario martelo = new ItemDoInventario("Martelo", 10);   
        ItemDoInventario faca = new ItemDoInventario("Faca", -12);  
        ItemDoInventario espada = new ItemDoInventario("Espada", 16);
        ItemDoInventario outro = new ItemDoInventario("Outro", 9);
        orc.adicionarItem(martelo);
        orc.adicionarItem(faca);
        orc.adicionarItem(espada);
        orc.adicionarItem(outro);
        ArrayList<ItemDoInventario> inventarioEsperado = new ArrayList<>();
        inventarioEsperado.add(faca);
        inventarioEsperado.add(outro);
        inventarioEsperado.add(martelo);
        inventarioEsperado.add(espada);
        orc.ordenarItens();
        ArrayList<ItemDoInventario> inventarioEncontrado = orc.getInventario();
        assertEquals(inventarioEsperado, inventarioEncontrado);
    }
    
    @Test
    public void ordenaSemItensNoInventario()
    {
        Orc orc = new Orc();
        ArrayList<ItemDoInventario> inventarioEsperado = new ArrayList<>();
        orc.ordenarItens();
        ArrayList<ItemDoInventario> inventarioEncontrado = orc.getInventario();
        assertEquals(inventarioEsperado, inventarioEncontrado);
    }
}

