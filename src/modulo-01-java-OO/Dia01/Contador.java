
/**
 * Write a description of class Contador here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Contador
{
   private static int contadorElfos;
   
   public static void contaElfo()
   {
       contadorElfos++;
   }
   
   public static int getElfosCriados()
   {
       return contadorElfos;
   }
   
   public static void resetContador()
   {
       contadorElfos = 0;
   }
}
