package local.repository;

import local.model.Usuario;
import org.apache.tomcat.jni.Local;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
    Optional<Usuario> findByEmail(String email);
    List<Usuario> findByCreatedAtBetween(LocalDate dataInicial, LocalDate dataFinal);
}
