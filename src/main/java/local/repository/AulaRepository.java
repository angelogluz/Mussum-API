package local.repository;

import local.model.Aula;
import local.model.Faculdade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AulaRepository extends JpaRepository<Aula, Integer>{
	
}
