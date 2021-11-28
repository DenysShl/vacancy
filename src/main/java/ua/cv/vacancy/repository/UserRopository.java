package ua.cv.vacancy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.cv.vacancy.model.User;

/**
 * @version 1.0
 * @autor shd
 * @created by 28/11/2021 - 11:05
 * @project vacancy
 */
@Repository
public interface UserRopository extends JpaRepository<User, Long> {
}
