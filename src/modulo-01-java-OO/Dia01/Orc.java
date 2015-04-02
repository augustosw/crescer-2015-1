
/**
 * Write a description of class Orcs here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Orc
{
    // instance variables - replace the example below with your own
    private String nome;
    private int vida;
    private boolean vivo;
    

    /**
     * Constructor for objects of class Orcs
     */
    public Orc(String n)
    {
        nome = n;
        vida = 110;
        vivo = true;
    }

    public void receberFlechada()
    {
        if(vivo == true)
        {
            vida = vida-10;
            if(vida == 0)
            {
                vivo = false;
                System.out.println ('\f'+"Este Orc morreu!!");
            }
        }
        else 
        {
            System.out.println ('\f'+"Este Orc já está morto!!");
        }        
    }
}
