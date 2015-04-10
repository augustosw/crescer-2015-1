<<<<<<< HEAD

/**
 * Write a description of class ContadorDeNumeros here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ContadorDeNumeros
{
   public void contaAte3()
   {
       for(int i = 1; i <= 3; i++)
       {
           System.out.println(i);
       }
   }
   
   public void contar(int numero)
   {
       for(int i = 1; i<= numero; i++)
       {
           System.out.println(i);
       }
   }
=======
/**
 * Objeto que sabe contar números em ordem!
 * 
 * @author CWI Software
 */
public class ContadorDeNumeros
{
    public void contarAte3() {
        
        for (int i = 0; i < 3; i++) {
            // execute tudo que tem aqui dentro
            //System.out.println(i + 1);
        }
        
        for (int i = 1; i <= 3; i++) {
            // execute tudo que tem aqui dentro
            //System.out.println(i);
        }
        
        for (int i = 1; i < 4; i++) {
            // execute tudo que tem aqui dentro
            //System.out.println(i);
        }
    } 
    
    public void contarAte(int numero) {
        for (int i = 0; i < numero; i++) {
            // execute tudo que tem aqui dentro
            System.out.println(i + 1);
        }
    }
    
    public void contarRegressivamente(int numero) {
        for (int i = numero; i > 0; i--) {
            // execute tudo que tem aqui dentro
            System.out.println(i);
        }
    }
    
    
    
    
    
    
    
    
    
>>>>>>> 79aaa82ced409757736478a24fc213dc9bab719d
}
