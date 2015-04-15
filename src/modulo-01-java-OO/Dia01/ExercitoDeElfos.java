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
   private HashMap<Status, ArrayList<Elfo>> porStatus = new HashMap<>();
   private EstrategiaDeAtaque estrategia = new EstrategiaNormal();
   
   public void alistaElfo(Elfo elfo) throws NaoPodeAlistarException
   {
       boolean elfoValido = elfo instanceof ElfoComCor || elfo instanceof ElfoNoturno;
       if(elfoValido)
       {
           String nome = elfo.getNome();
           exercito.put(nome, elfo);
       }
       else
       {
           ErrosDoJogo.naoPodeAlistar();
       }
   }
   
   public Elfo buscar(String nome)
   {
       return exercito.get(nome);
   }
   
   public ArrayList<Elfo> buscar(Status status) 
   {
       agruparPorStatus();
       return porStatus.get(status);
   }
   
   public HashMap<Status, ArrayList<Elfo>> getExercitoPorStatus()
   {
       return porStatus;
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
   
   public void agruparPorStatus()
   {
       porStatus.clear();
       
       for(Map.Entry<String, Elfo> entry : exercito.entrySet())
       {
           Elfo elfo = entry.getValue();
           Status status = elfo.getStatus();
           
           if(porStatus.containsKey(status))
           {
               porStatus.get(status).add(elfo);
           }
           else
           {
               porStatus.put(status, new ArrayList<>(Arrays.asList(elfo)));
           }
       }
   }
}
