/**
 * Write a description of class Orcs here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.ArrayList;
public class Orc
{

    // instance variables - replace the example below with your own
    private int experiencia, vida = 110;
    private String nome;
    private Status status = Status.VIVO;
    private ArrayList<ItemDoInventario> inventario = new ArrayList<ItemDoInventario>();

    /**
     * Constructor for objects of class Orcs
     */
    public Orc()
    {
    }
    
    public int getVida()
    {
        return vida;
    }
    /**
     * Construtor para objetos da classe Orc
     */ 
    public Orc(String nome)
    {
        //vida = 110;
        this.nome = nome;
    }
        
    /**
     * Faz o Orc sofrer um ataque.
     * Atualmente 10 de dano será decrementado.
     */
    public void recebeAtaque() {
        
        double numeroGerado = gerarNumero();
        
        if (numeroGerado < 0) {
            this.experiencia += 2;
            return;
        } else if (numeroGerado >= 0 && numeroGerado <= 100) {
            return;
        } else {
                    
            int danoVida = 10;
            
            if (this.vida >= danoVida) {
                this.vida -= danoVida;
                // this.vida = this.vida - 10;
                this.status = Status.FERIDO;
            } 
            
            if (this.vida == 0) {
                this.status = Status.MORTO;
            }
        }

    }
    
    public String getNome() {
        return this.nome;
    }    
    public int getExperiencia() {
        return this.experiencia;
    }    
    public Status getStatus() {
        return this.status;
    }
    public ArrayList<ItemDoInventario> getInventario()
    {
        return inventario;
    }
    
    public void setStatus(Status novoStatus) {
        this.status = novoStatus;
    }    
    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
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
    
    private double gerarNumero() {
        
        double numeroGerado = 0.0;
        
        // A. Se o orc possuir nome e o mesmo tiver mais de 5 letras, some 65 ao número. Caso contrário, subtraia 60.
        boolean possuiNome = this.nome != null && this.nome.length() > 5;
        
        if (possuiNome && this.nome.length() > 5) {
            numeroGerado += 65;
        } else {
            numeroGerado -= 60;
        }
        
        // B. Se o orc possuir vida entre 30 e 60, multiple o número por dois,
        // senão se a vida for menor que 20 multiplique por 3.
        boolean possuiVidaEntre30e60 = this.vida >= 30 && this.vida <= 60;
        
        if (possuiVidaEntre30e60) {
            numeroGerado *= 2;
        } else if (this.vida < 20) {
            numeroGerado *= 3;
        }
        
        // C. Se o orc estiver fugindo, divida o número por 2. Senão se o orc estiver caçando ou dormindo adicione 1 ao número.
        if (this.status == Status.FUGINDO) {
            numeroGerado /= 2;
        } else if (this.status == Status.CAÇANDO || this.status == Status.DORMINDO) { 
            numeroGerado += 1;
        }
        
        // D. Se a experiência do orc for par, eleve o número ao cubo. 
        // Se for ímpar e o orc tiver mais que 2 de experiência, eleve o número ao quadrado.
        boolean experienciaÉPar = this.experiencia % 2 == 0;
        if (experienciaÉPar) {
            numeroGerado = numeroGerado * numeroGerado * numeroGerado;
        } else if (this.experiencia > 2) {
            numeroGerado = Math.pow(numeroGerado, 2);
        }
  
        return numeroGerado;
    }
    
    public void adicionarItem(ItemDoInventario i)
    {
        inventario.add(i);
    }
    
    public void perderItem(ItemDoInventario i)
    {
        inventario.remove(i);
    }
    
    public String getDescricoesItens()
    {
        String texto="Itens: ";
        for(int i = 0; i < inventario.size(); i++)
        {
            String complemento = i < inventario.size()-1 ? ", " : "";
            texto = texto + inventario.get(i).getDescricao() +complemento;
        }
        System.out.println("\f"+texto);
        return texto;
    }
    
    public void tentarSorte()
    {
        if(this.gerarNumero()== 3481)
        {
            for(int i = 0; i < inventario.size(); i++)
            {
                int qtde = inventario.get(i).getQuantidade();
                inventario.get(i).setQuantidade(qtde + 1000);
            }
        }
    }
    
    public void setExp(int exp)
    {
        experiencia = exp;
    }
    
    public ItemDoInventario getItemComMaiorQuantidade()
    {
        ItemDoInventario item;
        ItemDoInventario itemNovo;
        if(inventario.isEmpty() == false)
        {
            item = inventario.get(0);
            for(int i = 0; i < inventario.size(); i++)
            {
                itemNovo = inventario.get(i);
                if(itemNovo.getQuantidade() > item.getQuantidade())
                {
                    item = itemNovo;
                }
            }
            System.out.println(item.getQuantidade());
            return item;
        }
        return null;
    }
    
    
}
