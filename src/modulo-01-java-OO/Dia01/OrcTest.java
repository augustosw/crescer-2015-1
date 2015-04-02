

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class OrcTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class OrcTest
{
   @Test
   public void orcNasceCom110Vida()
   {
       // Arrange - Montagem dos dados de teste
       Orc o;
       // Act - Execução da ação de testes
       o = new Orc();
       // Assert - Verificação se o resultado é esperado
       int esperado = 110;
       int resultadoObtido = o.getVida();
       
       assertEquals(esperado, resultadoObtido);
   }
}
