package ua.cv.vacancy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ua.cv.vacancy.model.Vacansion;
import ua.cv.vacancy.repository.VacansionRepository;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

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
        Optional<Vacansion> optional = repository.findById(id);
        Vacansion vacansion = null;
        if (optional.isPresent()) {
            vacansion = optional.get();
        } else {
            throw new RuntimeException(" Vacansion not found for id :: " + id);
        }
        return vacansion;
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
        vac.setStatus(vacansion.isStatus());
        vac.setCreated_on(LocalDateTime.now());
        repository.save(vac);
    }

    public Page<Vacansion> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.repository.findAll(pageable);
    }
}