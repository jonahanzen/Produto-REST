package br.com.rest.produto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
	public Iterable<Produto> findByNomeContainingIgnoreCase(String nome);
	
	
}
