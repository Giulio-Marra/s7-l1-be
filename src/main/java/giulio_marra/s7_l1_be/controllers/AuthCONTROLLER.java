package giulio_marra.s7_l1_be.controllers;

import giulio_marra.s7_l1_be.exceptions.BadRequestException;
import giulio_marra.s7_l1_be.payloads.DipendenteDTO;
import giulio_marra.s7_l1_be.payloads.DipendenteLoginDTO;
import giulio_marra.s7_l1_be.payloads.DipendenteLoginRespDTO;
import giulio_marra.s7_l1_be.payloads.DipendenteResponseDTO;
import giulio_marra.s7_l1_be.services.AuthService;
import giulio_marra.s7_l1_be.services.DipendenteSERVICES;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthCONTROLLER {
    @Autowired
    private DipendenteSERVICES dipendenteSERVICES;

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public DipendenteLoginRespDTO login(@RequestBody DipendenteLoginDTO payload) {
        return new DipendenteLoginRespDTO(authService.generateToken(payload));
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public DipendenteResponseDTO saveDipendente(@RequestBody @Validated DipendenteDTO body, BindingResult valResult) {
        if (valResult.hasErrors()) {
            System.out.println(valResult.getAllErrors());
            throw new BadRequestException(valResult.getAllErrors().toString());
        }
        return new DipendenteResponseDTO(dipendenteSERVICES.saveDipendente(body).getId());
    }
}
