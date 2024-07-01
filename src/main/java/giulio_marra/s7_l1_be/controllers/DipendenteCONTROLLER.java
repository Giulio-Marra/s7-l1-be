package giulio_marra.s7_l1_be.controllers;

import giulio_marra.s7_l1_be.entites.Dipendente;
import giulio_marra.s7_l1_be.payloads.DipendenteDTO;
import giulio_marra.s7_l1_be.services.DipendenteSERVICES;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/dipendenti")
public class DipendenteCONTROLLER {
    @Autowired
    private DipendenteSERVICES dipendenteSERVICES;

    @GetMapping("/{dipendenteId}")
    public Dipendente getDipendenteById(@PathVariable long dipendenteId) {
        return dipendenteSERVICES.getDipendente(dipendenteId);
    }

    @GetMapping
    public Page<Dipendente> getAllDipendenti(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "id") String sortBy) {
        return dipendenteSERVICES.getDipendenti(page, size, sortBy);
    }

    @DeleteMapping("/{dipendenteId}")
    public void getAndDeleteDipendente(@PathVariable long dipendenteId) {
        dipendenteSERVICES.getAndDeleteDipendente(dipendenteId);
    }

    @PutMapping("/{dipendenteId}")
    public Dipendente getAndUpdateDipendente(@PathVariable long dipendenteId, @RequestBody DipendenteDTO body) {
        return dipendenteSERVICES.getAndUpdateDipendente(dipendenteId, body);
    }

    @PostMapping("/{dipendenteId}/avatar")
    public String uploadAvatar(@RequestParam("avatar") MultipartFile image, @PathVariable("dipendenteId") long id) throws IOException {

        return dipendenteSERVICES.uploadImage(id, image);
    }
}
