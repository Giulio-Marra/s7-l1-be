package giulio_marra.s7_l1_be.payloads;

import jakarta.validation.constraints.NotEmpty;

public record DispositivoDTO(
        @NotEmpty(message = "Inserire identificativo dispositivo")
        String identificativo_dispositivo,
        @NotEmpty(message = "Inserire tipo dispositivo")
        String tipo_dispositivo,
        @NotEmpty(message = "Inserire stato dispositivo")
        String stato_dispositivo

) {
}
