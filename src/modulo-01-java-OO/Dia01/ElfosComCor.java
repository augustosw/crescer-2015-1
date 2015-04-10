
/**
 * Write a description of class ElfosComCor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ElfosComCor extends Elfo
{
    Cor cor;
    
    protected ElfosComCor(Cor cor, String nome)
    {
        this.cor = cor;
        super(nome);
    }
    protected ElfosComCor(Cor cor, String nome, int flechas)
    {
        this.cor = cor;
        super(nome, flechas);
    }
}
