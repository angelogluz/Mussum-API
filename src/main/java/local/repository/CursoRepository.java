package local.repository;

import local.model.Curso;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer>{
	List<Curso> findByNomeIgnoreCase(String nome);
}
