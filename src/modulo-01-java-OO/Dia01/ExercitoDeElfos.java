import java.util.*;
/**
 * Write a description of class ExercitoDeElfos here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ExercitoDeElfos
{
   private HashMap<String, Elfo> exercito = new HashMap<>();
   
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
   
   public HashMap<String, Elfo> listaElfosPorStatus(Status status)
   {
       HashMap<String, Elfo> listaStatus = new HashMap<>();
       for(Map.Entry<String, Elfo> entry : exercito.entrySet())
       {
           Elfo elfoAtual = entry.getValue();
           if(elfoAtual.getStatus() == status)
           {
               String nome =  elfoAtual.getNome();
               listaStatus.put(nome, elfoAtual);
           }
       }
       return listaStatus;
   }
}
