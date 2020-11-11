package entities;

public class ProdutoImportado extends Produto {

	private Double taxa;

	public ProdutoImportado() {
		super();
	}

	public ProdutoImportado(String name, Double price, Double taxa) {
		super(name, price);
		this.taxa = taxa;
	}

	public Double getTaxa() {
		return taxa;
	}

	public void setTaxa(Double taxa) {
		this.taxa = taxa;
	}

	public double total() {
		return super.getPreco() + taxa;
	}

	@Override
	public String etiquetaPreco() {
		return super.getNome() + String.format(" $ %.2f", total()) + String.format(" (Taxa: $ %.2f", taxa) + ")";
	}

}
