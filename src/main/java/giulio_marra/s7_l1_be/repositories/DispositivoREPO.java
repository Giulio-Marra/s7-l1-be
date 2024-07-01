package giulio_marra.s7_l1_be.repositories;

import giulio_marra.s7_l1_be.entites.Dispositivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DispositivoREPO extends JpaRepository<Dispositivo, Long> {
    boolean existsByNome(String nome);
}
