package ua.cv.vacancy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.cv.vacancy.model.Message;

@Repository
public interface MesageRepository extends JpaRepository<Message, Long> {
}
