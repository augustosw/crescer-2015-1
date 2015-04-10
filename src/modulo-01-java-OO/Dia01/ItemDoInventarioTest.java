
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Classe de testes unitários para a Classe ItemDoInventário.
 *
 * @author Augusto Schiller
 */
public class ItemDoInventarioTest
{
    @Test
    public void criaItemComDescricaoEQuantidade()
    {
        ItemDoInventario item = new ItemDoInventario("Teste de Descrição", 12);
        
        String descricaoEsperada = "Teste de Descrição";
        int quantidadeEsperada = 12;
        
        assertEquals(descricaoEsperada, item.getDescricao());
        assertEquals(quantidadeEsperada, item.getQuantidade());        
    }
    
    @Test
    public void criaItemComDescricaoNulaEQuantidadeNegativa()
    {
        ItemDoInventario item = new ItemDoInventario(null, -12);
        
        String descricaoEsperada = null;
        int quantidadeEsperada = -12;
        
        assertEquals(descricaoEsperada, item.getDescricao());
        assertEquals(quantidadeEsperada, item.getQuantidade());  
    }
    
    @Test
    public void criarItemComQuantidadeNegativaDescricaoNula() {
        // Arrange
        int quantidadeEsperada = -3456;
        String descricaoEsperada = null;
        // Act
        ItemDoInventario item = new ItemDoInventario(descricaoEsperada, quantidadeEsperada);
        // Assert
        assertEquals(quantidadeEsperada, item.getQuantidade());
        assertEquals(descricaoEsperada, item.getDescricao());

    }
}
