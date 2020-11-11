package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Produto;
import entities.ProdutoImportado;
import entities.ProdutoUsado;

public class Programn {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		List<Produto> produtos = new ArrayList<>(); // lista

		System.out.print("Entre com a quantidade de produtos: ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println("Produto #" + i + " dados:");

			System.out.print("Comum, usado ou importado (c,u,i)?: ");
			char op = sc.next().charAt(0);

			System.out.print("Nome:");
			sc.nextLine();
			String nome = sc.nextLine();

			System.out.print("Preço:");
			double preco = sc.nextDouble();

			/* Compara se o produto é usado, importado ou comum */
			if (op == 'c') {
				produtos.add(new Produto(nome, preco));
			} else if (op == 'u') {
				System.out.print("Data da Manufatura (dd/MM/yyyy):");
				Date data = sdf.parse(sc.next());
				produtos.add(new ProdutoUsado(nome, preco, data));
			} else {
				System.out.print("Taxa: ");
				double taxa = sc.nextDouble();
				produtos.add(new ProdutoImportado(nome, preco, taxa));
			}

		} // fim for

		System.out.println();
		System.out.println("Produtos e preços");
		for (Produto produto : produtos) {
			System.out.println(produto.etiquetaPreco());
		}

		sc.close();

	}

}
