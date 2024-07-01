package giulio_marra.s7_l1_be.services;

import giulio_marra.s7_l1_be.entites.Dipendente;
import giulio_marra.s7_l1_be.payloads.DipendenteLoginDTO;
import giulio_marra.s7_l1_be.security.JWTTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private DipendenteSERVICES dipendenteSERVICES;

    @Autowired
    private JWTTools jwtTools;

    public String generateToken(DipendenteLoginDTO dipendenteLoginDTO) {
        Dipendente dipendente = dipendenteSERVICES.findByEmail(dipendenteLoginDTO.email());
        return jwtTools.createToken(dipendente);
    }
}
