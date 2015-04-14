import java.util.*;
/**
 * Write a description of class ExercitoDeElfos here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ExercitoDeElfos
{
   private HashMap<String, Elfo> exercito= new HashMap<>();
   
   public void alistaElfo(Elfo elfo)
   {
       boolean elfoValido = elfo instanceof ElfoComCor || elfo instanceof ElfoNoturno;
       if(elfoValido)
       {
           String nome = elfo.getNome();
           exercito.put(nome, elfo);
       }
   }
   
   public Elfo buscar(String nome)
   {
       return exercito.get(nome);
   }
   
   public int getQuantidadeAlistados()
   {
       return exercito.size();
   }
}
