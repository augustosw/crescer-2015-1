
/**
 * Write a description of class ElfosComCor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ElfoComCor extends Elfo
{
    Cor cor;
    
    {
        cor = Cor.BRANCO;
    }
    
    //Contrutores
    public ElfoComCor(String nome, Cor novaCor)
    {
        super(nome);
        cor = novaCor;
    }
    protected ElfoComCor(String nome, int flechas, Cor novaCor)
    {
        super(nome, flechas);
        cor = novaCor;
    }
    protected ElfoComCor(String nome)
    {
        super(nome);
    }
    protected ElfoComCor(String nome, int flechas)
    {
        super(nome, flechas);
    }
    
    //GETs
    public Cor getCor()
    {
        return cor;
    }
    
    protected void atirarFlecha(Orc umOrc)
    {
        if(cor == Cor.VERDE){this.experiencia++;}
        super.atirarFlecha(umOrc);
    }
    
    protected void adicionarItem(ItemDoInventario item)
    {
        if(cor == Cor.VERDE)
        {
            boolean itemValido = item.getDescricao() == "Espada de aço valiriano" || item.getDescricao() == "Arco e Flecha de vidro";
            if(itemValido)
            {
                super.adicionarItem(item);
            }
        }
        else
        {
            super.adicionarItem(item);
        }
    }
}
