package ua.cv.vacancy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.cv.vacancy.model.Vacansion;
import ua.cv.vacancy.repository.VacansionRepository;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

@Service
public class VacansionService {

    private final VacansionRepository repository;

    @Autowired
    public VacansionService(VacansionRepository repository) {
        this.repository = repository;
    }

    public List<Vacansion> findAllVacansion(){
        List<Vacansion> vacansionList = repository.findAll();
        vacansionList.sort(Comparator.comparing(Vacansion::getPosada));
        return vacansionList;
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
        vacansion.setCreated_on(LocalDateTime.now());
        vacansion.setStatus(true);
        repository.save(vacansion);
    }

    public void updateVacansion(Vacansion vacansion){
        Vacansion vac = repository.getById(vacansion.getId());
        vac.setDepartment(vacansion.getDepartment());
        vac.setDyrekcija(vacansion.getDyrekcija());
        vac.setViddil(vacansion.getViddil());
        vac.setPosada(vacansion.getPosada());
        vac.setCount(vacansion.getCount());
        vac.setCreated_on(LocalDateTime.now());
        vac.setStatus(true);
        repository.save(vac);
    }
}