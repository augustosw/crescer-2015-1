import java.util.*;
/**
 * Write a description of class EstrategiaNormal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EstrategiaNormal implements EstrategiaDeAtaque
{
    public void atacarOrcs(ArrayList<Elfo> elfos, ArrayList<Orc> orcs)
    {
        System.out.println("Estratégia qualquer");
        
        for(Elfo elfo : elfos)
        {
            for(Orc orc : orcs)
            {
                elfo.atirarFlecha(orc);
            }
        }
    }
}
