package giulio_marra.s7_l1_be.repositories;

import giulio_marra.s7_l1_be.entites.Dipendente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DipendenteREPO extends JpaRepository<Dipendente, Long> {

    Optional<Dipendente> findByEmail(String email);

    boolean existsByEmail(String email);

}
