import java.util.*;

/**
 * Write a description of class Orcs here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.ArrayList;
public class Orc extends Personagem
{
    
    {
        vida = 110;
    }
  
    /**
     * Constructor for objects of class Orcs
     */
    public Orc(String nome)
    {
        super(nome);
    }
    public Orc()
    {
        this("");
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
                    
            double danoVida = 10.0;
            
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
    
    public void setStatus(Status novoStatus) {
        this.status = novoStatus;
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

}
