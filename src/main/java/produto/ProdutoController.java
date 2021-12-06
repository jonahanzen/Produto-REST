package produto;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("api/v1/produto")
public class ProdutoController {

	@Inject
	private ProdutoService service;

	@GET
	@Produces(value = MediaType.APPLICATION_JSON)
	public List<Produto> teste() {
		return service.todosProdutos();
	}

	@GET
	@Produces(value = MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Produto produtoId(@PathParam("id") int id) {
		return service.produtoPorId(id);
	}

	@POST
	@Path("/{nome}/{preco}")
	public void novoProduto(@PathParam("nome") String nome, @PathParam("preco") Double preco) {
		service.novoProduto(nome, preco);
	}

	@PUT
	@Path("/{id}/{nome}/{preco}")
	public void alterarProduto(@PathParam("id") Integer id, @PathParam("nome") String nome,
			@PathParam("preco") Double preco) {
		
		Produto produto = new Produto(id, nome, preco);
		service.alterarProduto(produto);
	}
	
	@DELETE
	@Path("/{id}")
	public void deletarProduto(@PathParam("id") Integer id) {
		service.deletarProduto(id);
	}
	

}
