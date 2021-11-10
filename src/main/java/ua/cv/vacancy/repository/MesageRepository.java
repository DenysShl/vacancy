package ua.cv.vacancy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.cv.vacancy.model.Message;

public interface MesageRepository extends JpaRepository<Message, Long> {
}
