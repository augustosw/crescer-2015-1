
import java.util.*;
/**
 * Write a description of class Personagem here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Personagem
{
   protected String nome;
   protected double vida;
   protected int experiencia;
   protected Status status = Status.VIVO;
   protected ArrayList<ItemDoInventario> inventario = new ArrayList<>();

   protected Personagem(String nome)
   {
       this.nome = nome;
       this.vida = vida;
   }
   
   protected Status getStatus()
   {
       return status;
   }
   protected double getVida()
   {
       return vida;
   }
   protected String getNome()
   {
       return nome;
   }
   protected ArrayList<ItemDoInventario> getInventario()
   {
       return inventario;
   }
   protected int getExperiencia()
   {
       return experiencia;
   }
   
      /**
     * Ordena itens do inventário por quantidade ascendente.
     * 
     * Algoritmo atual: Bubblesort
     */
   protected void ordenarItensVariaveis() {
        
        /*for (int i = 0; i < this.itens.size(); i++) {
            for (int j = 0; j < this.itens.size() - 1; j++) {
                ItemDoInventario itemAtual = this.itens.get(j);
                ItemDoInventario proximo = this.itens.get(j + 1);
                
                boolean precisaTrocar = 
                    itemAtual.getQuantidade() > proximo.getQuantidade();
                
                if (precisaTrocar) {
                    this.itens.set(j, proximo);
                    this.itens.set(j + 1, itemAtual);
                }
            }
        }*/
        
        Collections.sort(this.inventario, new Comparator<ItemDoInventario>() {
            public int compare(ItemDoInventario item, ItemDoInventario outroItem) {
                return Integer.compare(item.getQuantidade(), outroItem.getQuantidade());
            }
        });
        
        
        // C#:
        // return this.itens.OrderBy(x => x.getQuantidade());
        
        // Ruby:
        // this.itens.sort_by { |x| x.get_quantidade }
        
   }
   
   protected String getDescricoesItens()
    {
        String texto="Itens: ";
        for(int i = 0; i < inventario.size(); i++)
        {
            String complemento = i < inventario.size()-1 ? ", " : "";
            texto = texto + inventario.get(i).getDescricao() +complemento;
        }
        System.out.println("\f"+texto);
        return texto;
    }
    
   protected ItemDoInventario getItemComMaiorQuantidade()
    {
        ItemDoInventario item;
        ItemDoInventario itemNovo;
        if(inventario.isEmpty() == false)
        {
            item = inventario.get(0);
            for(int i = 0; i < inventario.size(); i++)
            {
                itemNovo = inventario.get(i);
                if(itemNovo.getQuantidade() > item.getQuantidade())
                {
                    item = itemNovo;
                }
            }
            System.out.println(item.getQuantidade());
            return item;
        }
        return null;
    }
    
   protected void ordenarItens()
    {
        if(inventario.isEmpty() == false)
        {
            ArrayList<ItemDoInventario> backup= new ArrayList<>();
            int tamanho = inventario.size();
            for(int i = 0; i < tamanho; i++)
            {
                ItemDoInventario itemMenor = inventario.get(0);
                for(int f = 0; f < inventario.size(); f++)
                {
                    ItemDoInventario itemAtual = inventario.get(f);
                    if(itemAtual.getQuantidade() < itemMenor.getQuantidade())
                    {
                        itemMenor = itemAtual;
                    }
                }
                backup.add(itemMenor);
                inventario.remove(itemMenor);
            }
            inventario = backup;
        }
        else
        {
            System.out.println("O Inventario está vazio!!");
        }
    }
   protected void adicionarItem(ItemDoInventario i)
   {
       inventario.add(i);
   }
    
   protected void perderItem(ItemDoInventario i)
   {
       inventario.remove(i);
   }  
   
}
