package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ProdutoUsado extends Produto {

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	private Date dataManufatura;

	public ProdutoUsado() {
		super();
	}

	public ProdutoUsado(String name, Double price, Date dataManufatura) {
		super(name, price);
		this.dataManufatura = dataManufatura;
	}

	public Date getDataManufatura() {
		return dataManufatura;
	}

	public void setDataManufatura(Date dataManufatura) {
		this.dataManufatura = dataManufatura;
	}

	@Override
	public String etiquetaPreco() {
		return super.getNome() + " (usado) " + String.format("$ %.2f", super.getPreco()) + " Data Manufatura: ("
				+ sdf.format(dataManufatura) + ")";
	}

}
