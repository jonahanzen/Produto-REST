package br.com.rest.produto;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service com a 'logica de negocio' de {@link Produto}
 * @see Service
 *  
 *
 */
@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	private Produto produto = new Produto();

	public Produto novoProduto(@Valid Produto produto) {
		return produtoRepository.save(produto);
	}

	public List<Produto> consultarTodosProdutos() {
		return produtoRepository.findAll();
	}

	public Optional<Produto> consultarProdutoId(Long id) {
		return produtoRepository.findById(id);
	}

	public Iterable<Produto> consultarProdutoNome(String nome) {
		return produtoRepository.findByNomeContainingIgnoreCase(nome);
	}

	public void deletarProduto(Long idProduto) {
		produtoRepository.deleteById(idProduto);
	}

	public void editarProduto(Long idProduto, Produto novoProduto) {
		//TODO tratar excecao e/ou mudar comportamento caso nao ache o produto por id
		produto = produtoRepository.findById(idProduto).orElse(null);
		produto = novoProduto;
		produtoRepository.save(produto);
	}

}
