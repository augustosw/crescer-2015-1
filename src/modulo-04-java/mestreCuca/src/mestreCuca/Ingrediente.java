package mestreCuca;

public class Ingrediente {
	String nome;
	double quantidade;
	Medida medida;
	double preco;
	

	
	public Ingrediente() {
		
	}
	public Ingrediente(String nome, double quantidade, Medida medida, double preco) {
		this.nome = nome != null ? nome : "Sem Nome";
		this.quantidade = quantidade < 0 ? 1.0 : quantidade;
		this.medida = medida != null ? medida : Medida.G;
		this.preco = preco < 0 ? 1.0 : preco;
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
