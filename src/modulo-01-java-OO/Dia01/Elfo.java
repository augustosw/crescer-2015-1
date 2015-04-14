
/**
 * Define objetos Elfo
 * 
 * @author CWI Software
 */
public class Elfo extends Personagem
{
    // Versão correção do tema!!
    

    private int flechas;

    // type initializer
    {
        flechas = 42;
        vida = 100;
        Contador.contaElfo();
    }
    
    /**
     * Cria objetos Elfo
     * 
     * @param umNome Nome que o elfo receberá
     * @param flechas Quantidade inicial de flechas
     */
    
    //Contrutor

    /**
     * Cria um elfo informando nome.
     * 
     * @param nome Nome a ser dado para o Elfo.
     */
    protected Elfo(String nome) {
        super(nome);
    }
    protected Elfo(String nome, int flechas)
    {
        super(nome);
        this.flechas = flechas;
    }
    
    //GETs
    public int getFlechas()
    {
        return flechas;
    }

    
    /**
     * Atira uma flecha e perde uma unidade.
     * 
     * @param umOrc Orc que receberá uma flechada.
     */
    protected void atirarFlecha(Orc umOrc) {
        //flechas = flechas - 1;
        if(flechas>0)
        {
            flechas--;
            experiencia++;
            umOrc.recebeAtaque();
        }
    }
    
    
    /**
     * Retorna o nome do elfo, sua quantidade de flechas e seus níveis de experiência.
     * 
     * @return Informações gerais sobre o elfo, ex:
     * 
     * "Legolas possui 42 flechas e 0 níveis de experiência."
     */
    public String toString() {
        
        /*StringBuilder builder = new StringBuilder();
        
        builder.append(
            String.format("%s possui %d %s e %d %s de experiência.",
                this.nome,
                this.flechas,
                this.flechas == 1 ? "flecha" : "flechas",
                this.experiencia,
                this.experiencia == 1 ? "nível" : "níveis"
            )
        );

        return builder.toString();
        
        */
        
        return String.format("%s possui %d %s e %d %s de experiência.",
                this.nome,
                this.flechas,
                this.flechas == 1 ? "flecha" : "flechas",
                this.experiencia,
                this.experiencia == 1 ? "nível" : "níveis"
            );
       
        // Ruby ou CoffeeScript:
        //"#{nome} possui #{flechas} #{textoFlechas} e #{experiencia} #{textoNiveis} de experiência."
       
        // C# null-coalsing:
        // String texto = this.nome ?? "Sem Nome";
                
        /*if (this.flechas == 1) {
            textoFlechas = "flecha";
        } else {
            textoFlechas = "flechas";
        }*/
        
        /*builder.append(this.nome);
        builder.append(" possui ");
        builder.append(this.flechas);
        builder.append(" ");
        builder.append(textoFlechas);
        builder.append(" e ");
        builder.append(this.experiencia);
        builder.append(" ");
        builder.append(textoNiveis);
        builder.append(" de experiência.");*/
    }
    // camelCase: public void atirarFlechaDourada
    // PascalCase: public void AtirarFlechaDourada
}
