
/**
 * Define objetos Elfo
 * 
 * @author CWI Software
 */
public class Elfo
{
    // Versão correção do tema!!
    
    private String nome;
    private int flechas, experiencia;

    // type initializer
    {
        flechas = 42;
    }
    
    /**
     * Cria objetos Elfo
     * 
     * @param umNome Nome que o elfo receberá
     * @param flechas Quantidade inicial de flechas
     */
    public Elfo(String umNome, int flechas)
    {
        this(umNome);
        // this.nome = nome;
        this.flechas = flechas;
    }
    
    //Contrutor
    public Elfo(String nome) {
        this.nome = nome;
    }
    
    //GETs
    public int getFlechas()
    {
        return flechas;
    }
    public int getExp()
    {
        return experiencia;
    }
    
    /**
     * Atira uma flecha e perde uma unidade.
     */
    public void atirarFlecha() {
        //flechas = flechas - 1;
        if(flechas>0)
        {
            flechas--;
            experiencia++;
        }
        else
        {
            System.out.println ("Você está sem Flechas!!!");
        }
    }
    
    /**
     * Atira flecha em um orc
     */
    public void atirarFlechaOrc(Orc o)
    {
        this.atirarFlecha();
        o.levarDano();
    }
    
    
    
    
    
    
    
    
    
    
    
    /*public void setFlechas(int novaQtdFlechas) {
        if (novaQtdFlechas > flechas) {
            flechas = novaQtdFlechas;
        }
    }*/
    
    // camelCase: public void atirarFlechaDourada
    // PascalCase: public void AtirarFlechaDourada
    
    
    
    
    
    
}
