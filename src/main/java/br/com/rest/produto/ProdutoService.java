package br.com.rest.produto;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service com a 'logica de negocio' de {@link Produto}.
 * @see Service.
 *  
 *
 */
@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;


	/**
	 * Metodo para salvar produto passando a entidade {@link Produto}.
	 * 
	 * @param produto a ser salvo.
	 * @return produto salvo no banco.
	 */
	public Produto novoProduto(@Valid Produto produto) {
		return produtoRepository.save(produto);
	}
	
	/**
	 * Metodo para salvar produto passando nome e preco de {@link Produto}.
	 * 
	 * @param nome do produto a ser salvo no banco
	 * @param preco do produto a ser salvo no banco
	 * @return Produto salvo no banco.
	 */
	public Produto novoProduto(String nome, Double preco) {
		Produto produto = new Produto(nome, preco);
		return produtoRepository.save(produto);
	}

	/**
	 * Metodo para consultar todos os {@link Produto}.
	 * 
	 * @return List de todos os produtos.
	 */
	public List<Produto> consultarTodosProdutos() {
		return produtoRepository.findAll();
	}

	/**
	 * Metodo para consultar {@link Produto} por id.
	 * 
	 * @param id do produto a ser consultado.
	 * @return Optional<Produto> 
	 */
	public Optional<Produto> consultarProdutoId(Long id) {
		return produtoRepository.findById(id);
	}

	/**TODO implementar a consulta de produto por nome
	 * Metodo para consultar {@link Produto} por Nome
	 * O metodo ignora uppercase/lowercase, e acha produto "contendo"
	 *  a string passada.
	 * 
	 * @param nome do produto a ser consultado.
	 * @return Iterable<Produto>
	 */
	public Iterable<Produto> consultarProdutoNome(String nome) {
		return produtoRepository.findByNomeContainingIgnoreCase(nome);
	}

	/**
	 * Metodo para deletar {@link Produto}.
	 * 
	 * @param idProduto a ser deletado.
	 */
	public void deletarProduto(Long idProduto) {
		produtoRepository.deleteById(idProduto);
	}

	/**
	 * Metodo para editar {@link Produto}
	 * O metodo recebe a id do produto que se queira editar
	 * e um objeto do tipo Produto que sera entao o novo produto.
	 * 
	 * @param idProduto a ser editado
	 * @param novoProduto contendo as novas informações
	 */
	public void editarProduto(Long idProduto, Produto novoProduto) {
		//TODO tratar excecao e/ou mudar comportamento caso nao ache o produto por id
		Produto produto = produtoRepository.findById(idProduto).orElse(null);
		produto = novoProduto;
		produtoRepository.save(produto);
	}

}
