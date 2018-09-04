
public class ItemCarrinho<T> {

	private T item;
	private int quantidade;
	
	public ItemCarrinho(T item) {
		this.item=item;
		quantidade=1;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade=quantidade;
	}

	public T getItem() {
		return item;
	}

}
