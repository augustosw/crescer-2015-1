/**
 * Write a description of class Orcs here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Orc
{
    // instance variables - replace the example below with your own
    private int vida;    

    /**
     * Constructor for objects of class Orcs
     */
    public Orc()
    {
        vida = 110;
    }
    
    public int getVida()
    {
        return vida;
    }

    public void levarDano()
    {
        vida -=10;
    }
    
    /**
     * Imprime a vida atual do Orc
     * 
     * @return String coma vida atual do orc. Ex:
     * 
     * "Vida atual: 110"
     */
    public String toString()
    {
        return "Vida atual: " +this.vida;
    }
}
