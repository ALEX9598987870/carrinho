import java.util.Collection;
import java.util.HashMap;

public class ClasseCarrinho {

	private HashMap<String, ItemCarrinho<Produto>> conteudo = null;
	private int totalItens = 0;
	private int totalProdutos = 0;

	public ClasseCarrinho() {
		conteudo = new HashMap<String, ItemCarrinho<Produto>>();
	}

	private void add(String idProduto, Produto produto) {
		if (conteudo.containsKey(idProduto)) {
			ItemCarrinho item = conteudo.get(idProduto);
			item.setQuantidade(item.getQuantidade() + 1);
		} else {
			ItemCarrinho<Produto> item = new ItemCarrinho<Produto>(produto);
			conteudo.put(idProduto, item);
			totalProdutos++;
		}
		totalItens++;
	}

	private void remove(String idProduto) {
		if (conteudo.containsKey(idProduto)) {
			ItemCarrinho item = conteudo.get(idProduto);
			item.setQuantidade(item.getQuantidade() - 1);
			totalItens--;
			if (item.getQuantidade() <= 0) {
				conteudo.remove(idProduto);
				totalProdutos--;
			}
		}
	}

	public Collection<ItemCarrinho<Produto>> getConteudo() {
		return conteudo.values();
	}

	protected void finalize() throws Throwable {
		super.finalize();
		clear();
	}

	private void clear() {
		conteudo.clear();
		totalItens = 0;
		totalProdutos = 0;
	}

	public int getTotalProdutos() {
		return totalProdutos;
	}

	private double getValorTotal() {
		double total = 0.0;

		for (ItemCarrinho item : getConteudo()) {
			Produto produto = (Produto) item.getItem();
			total += item.getQuantidade() * produto.getPreco();
		}

		return Math.round(total * 100) / 100.0;
	}

}
