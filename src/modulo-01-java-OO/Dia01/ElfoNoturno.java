
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
        if(status != Status.MORTO)
        {
            vida = (vida -= vida*0.05);
            experiencia+=2;
            super.atirarFlecha(umOrc);
            if((int)vida == 0)
            {
                status = Status.MORTO;
            }
        }
   }
   
   protected void atirarVariasFlechas(Orc umOrc, int vezes)
   {
       if(vezes>0)
       {
           for(int i = 1; i <= vezes; i++)
           {
               this.atirarFlecha(umOrc);
           }
       }
   }
   
   protected void morre(Orc umOrc)
   {
       int contador = 0;
       while(status != Status.MORTO)
       {
           this.atirarFlecha(umOrc);
           contador++;
       }
       System.out.println(contador);
   }
}
