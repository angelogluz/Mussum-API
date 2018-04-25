package local.repository;

import local.model.Unidade;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnidadeRepository extends JpaRepository<Unidade, Integer> {
	List<Unidade> findByNomeIgnoreCase(String nome);
}
