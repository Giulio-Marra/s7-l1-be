package giulio_marra.s7_l1_be.payloads;

import giulio_marra.s7_l1_be.enums.Stato_dispositivo;
import giulio_marra.s7_l1_be.enums.Tipo_dispositivo;
import lombok.Getter;

@Getter
public class DispositivoPayload {
    private long id;
    private String identificativo;
    private Stato_dispositivo statoDispositivo;
    private Tipo_dispositivo tipoDispositivo;
    private long id_dipendente;
}
