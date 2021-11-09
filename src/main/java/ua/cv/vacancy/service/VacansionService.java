package ua.cv.vacancy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.cv.vacancy.model.Vacansion;
import ua.cv.vacancy.repository.VacansionRepository;

import java.util.List;

@Service
public class VacansionService {

    private final VacansionRepository repository;

    @Autowired
    public VacansionService(VacansionRepository repository) {
        this.repository = repository;
    }

    public List<Vacansion> findAllVacansion(){
        return repository.findAll();
    }

    public List<Vacansion> findByKeyword(String keyword){
        return repository.findByKeyword(keyword);
    }

    public Vacansion findById(Long id){
        return repository.getById(id);
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }

    public void createNewVacansion(Vacansion vacansion){
        repository.save(vacansion);
    }

    public void updateVacansion(Vacansion vacansion){
        repository.save(vacansion);
    }
}