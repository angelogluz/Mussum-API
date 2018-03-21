package local.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import local.model.Unidade;

@Repository
public interface UnidadeRepository extends JpaRepository<Unidade, Integer>{
	
}
