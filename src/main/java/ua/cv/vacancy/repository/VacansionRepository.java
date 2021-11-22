package ua.cv.vacancy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ua.cv.vacancy.model.Vacansion;

import java.util.List;
@Repository
public interface VacansionRepository extends JpaRepository<Vacansion, Long> {

    @Query(value = "select vc from Vacansion vc where vc.posada like %:keyword%")
    List<Vacansion> findByKeyword(@Param("keyword") String keyword);
}