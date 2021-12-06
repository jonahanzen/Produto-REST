package produto;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ProdutoRepository {

	@PersistenceContext
	private EntityManager em;

	public void novoProduto(Produto produto) {
		em.persist(produto);
	}

	public List<Produto> todosProdutos() {
		return em.createQuery("Select p from Produto p order by id", Produto.class).getResultList();
	}

	public Produto acharProdutoPorId(int id) {
		return em.find(Produto.class, id);
	}

	public void deletarProdutoPorId(int id) {
		Produto produto = em.find(Produto.class, id);
		em.remove(produto);
	}

	public void alterarProduto(Produto produto) {
		Produto velhoProduto = em.merge(produto);
		em.persist(velhoProduto);
	}

}
