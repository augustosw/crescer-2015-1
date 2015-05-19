package mestreCuca;

public class Ingrediente {
	String nome;
	double quantidade;
	Medida medida;
	double preco;
	
	{
		medida = Medida.G;
	}
	
	public Ingrediente(String nome, double quantidade, Medida medida, double preco) {
		this.nome = nome;
		this.quantidade = quantidade;
		this.medida = medida;
		this.preco = preco;
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
	public double getPreco() {
		return preco;
	}	

	public void setQuantidade(double quantidade) {
		this.quantidade = quantidade;
	}

	public boolean equals(Ingrediente obj) {
		if(this.getNome() == obj.getNome() &&
			this.getMedida() == obj.getMedida()) return true;
		return false;
	}

	
	
}
