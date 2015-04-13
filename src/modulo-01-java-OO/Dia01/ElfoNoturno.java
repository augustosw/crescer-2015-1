
/**
 * Write a description of class ElfoNoturno here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ElfoNoturno extends Elfo
{
   protected ElfoNoturno(String nome)
   {
       super(nome);
   }
   protected ElfoNoturno(String nome, int flechas)
   {
       super(nome,flechas);
   }
   
   protected void atirarFlecha(Orc umOrc)
   {
        vida = (int)(vida -= vida*0.05);
        experiencia+=2;
        super.atirarFlecha(umOrc);
   }
}
