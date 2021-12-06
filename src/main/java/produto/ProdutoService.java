package produto;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.validation.Valid;

@Stateless
public class ProdutoService {

	@Inject
	private ProdutoRepository repository;

	public void novoProduto(@Valid Produto produto) {
		repository.novoProduto(produto);
	}

	public void novoProduto(@Valid String nome, @Valid Double preco) {
		Produto produto = new Produto(nome, preco);
		repository.novoProduto(produto);
	}

	public List<Produto> todosProdutos() {
		return repository.todosProdutos();
	}

	public Produto produtoPorId(int id) {
		return repository.acharProdutoPorId(id);
	}

	public void deletarProduto(int idProduto) {
		repository.deletarProdutoPorId(idProduto);
	}

	public void alterarProduto(@Valid Produto produto) {
		repository.alterarProduto(produto);
	}

}
