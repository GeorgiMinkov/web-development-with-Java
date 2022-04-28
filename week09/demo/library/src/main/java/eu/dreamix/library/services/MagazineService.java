package eu.dreamix.library.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eu.dreamix.library.dtos.MagazineDTO;
import eu.dreamix.library.models.*;
import eu.dreamix.library.models.enums.Position;
import eu.dreamix.library.repositories.IEmployeeRepository;
import eu.dreamix.library.repositories.IMagazineRepository;

@Service
public class MagazineService {

    private static final String NOT_FOUND_MESSAGE = "Magazine is not found.";

    @Autowired
    private IMagazineRepository magazineRepository;

    @Autowired
    private GenreService genreService;

    @Autowired
    private IEmployeeRepository employeeRepository;

    public List<Magazine> getAllMagazines() {
        LinkedList<Magazine> allMagazines = new LinkedList<>();
        magazineRepository.findAll().forEach(allMagazines::add);
        return allMagazines;
    }

    public Magazine getMagazine(String isbn) {
        return magazineRepository.findById(isbn).orElseThrow(() ->
                new NoSuchElementException (NOT_FOUND_MESSAGE));
    }

    public void addMagazine(Magazine magazine) {
        if (magazineRepository.existsById(magazine.getIsbn())) {
            throw new IllegalArgumentException (
                    String.format("%s already exists.", magazine.getTitle())
            );
        }

        magazineRepository.save(magazine);
    }

    public void updateMagazine(Magazine magazine) {
        if (!magazineRepository.existsById(magazine.getIsbn())) {
            throw new NoSuchElementException (NOT_FOUND_MESSAGE);
        }

        magazineRepository.save(magazine);
    }

    public void deleteMagazine(String isbn) {
        if (!magazineRepository.existsById(isbn)) {
            throw new NoSuchElementException (NOT_FOUND_MESSAGE);
        }

        magazineRepository.deleteById(isbn);
    }

    public Magazine toMagazine(MagazineDTO dto) {
        Employee addedBy = employeeRepository.findByFirstNameAndLastName(dto.addedByFirstName, dto.addedByLastName).orElseGet(() -> {
            Employee employee = new Employee();
            employee.setPosition(Position.valueOf(dto.addedByPosition));
            employee.setFirstName(dto.addedByFirstName);
            employee.setLastName(dto.addedByLastName);
            return employee;
        });

        Genre genre = genreService.findByName(dto.genre).orElseGet(() -> {
            Genre tempGenre = new Genre();
            tempGenre.setName(dto.genre);
            return tempGenre;
        });

        Magazine tempMagazine = new Magazine();

        tempMagazine.setDateOfIssue(dto.dateOfIssue);
        tempMagazine.setAddedBy(addedBy);
        tempMagazine.setTitle(dto.title);
        tempMagazine.setIsbn(dto.isbn);
        tempMagazine.setGenre(genre);

        return tempMagazine;
    }
}
