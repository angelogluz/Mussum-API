package local.repository;

import java.util.List;
import local.model.Aula;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AulaRepository extends JpaRepository<Aula, Integer>{
        
	public List<Aula> findLimitted(Pageable pageable);
        
}
