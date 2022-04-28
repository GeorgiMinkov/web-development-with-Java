package eu.dreamix.library.controllers;

import javax.validation.Valid;
import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import eu.dreamix.library.dtos.MagazineDTO;
import eu.dreamix.library.services.MagazineService;

@RestController
@RequestMapping("magazines")
public class MagazineController {

    @Autowired
    private MagazineService magazineService;

    @GetMapping
    public List<MagazineDTO> getAllMagazines() {
        return magazineService.getAllMagazines()
                .stream()
                .map(MagazineDTO::new)
                .collect(Collectors.toList());
    }

    @GetMapping(path = "{isbn}")
    public MagazineDTO getMagazine(@PathVariable("isbn") String isbn) {
        return new MagazineDTO(magazineService.getMagazine(isbn));
    }

    @PostMapping
    public void addMagazine(@Valid @RequestBody MagazineDTO magazineDTO) {
        magazineService.addMagazine(magazineService.toMagazine(magazineDTO));
    }

    @PutMapping
    public void updateMagazine(@Valid @RequestBody MagazineDTO magazineDTO) {
        magazineService.updateMagazine(magazineService.toMagazine(magazineDTO));
    }

    @DeleteMapping(path = "{isbn}")
    public void deleteMagazine(@PathVariable("isbn") String isbn) {
        magazineService.deleteMagazine(isbn);
    }
}
