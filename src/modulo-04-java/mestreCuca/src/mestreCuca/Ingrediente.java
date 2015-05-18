package mestreCuca;

public class Ingrediente {
	String nome;
	double quantidade;
	Medida medida;
	
	{
		medida = Medida.G;
	}
	
	public Medida getMedida() {
		return medida;
	}
	public String getNome() {
		return nome;
	}
	public double getQuantidade() {
		return quantidade;
	}
		
}
