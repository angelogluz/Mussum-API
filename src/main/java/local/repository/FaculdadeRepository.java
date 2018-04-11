package local.repository;

import local.model.Faculdade;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import local.model.Aula;

@Repository
public interface FaculdadeRepository extends JpaRepository<Faculdade, Integer>{
	
}
