
/**
 * Classe para identificar os itens que poderão ser utlizados
 * 
 * @author Augusto Schiller
 */
public class ItemDoInventario
{
   private String descricao;
   private int quantidade;
   
   public ItemDoInventario(String desc, int qtd)
   {
       descricao = desc;
       quantidade = qtd;
   }
   
   //GETs
   public String getDescricao()
   {
       return descricao;
   }
   public int getQuantidade()
   {
       return quantidade;
   }
   
   //SETs
   public void setQuantidade(int qtde)
   {
       quantidade = qtde;
   }
}
