package br.com.rest.produto;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *Controller com os Endpoints de {@link Produto}
 * @see RestController 
 * 
 */
@RestController
@RequestMapping("/api/v1")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;

	@GetMapping(path = {"/produto/{id}","/produto"})
	public List<Produto> produtoId(@RequestParam(required = false) Long id) {
		if (id != null) {
			return List.of(produtoService.consultarProdutoId(id).orElse(null));
		} else {
			return produtoService.consultarTodosProdutos();
		}
	}

	@PostMapping("/produto")
	public Produto novoProduto(@Valid @RequestBody Produto produto) {
		return produtoService.novoProduto(produto);
	}

	@PutMapping(path = "/produto/{id}/{nome}/{preco}")
	public Produto alterarProduto(
			@PathVariable Long id,
			@PathVariable String nome,
			@PathVariable Double preco) {
		Produto produto = produtoService.consultarProdutoId(id).orElse(null);
		produto.setNome(nome);
		produto.setPreco(preco);
		return produtoService.novoProduto(produto);
	}
	
	@DeleteMapping(path = "/produto/{id}")
	public void deletarProduto(@PathVariable Long id) {
		produtoService.deletarProduto(id);
	}

}
