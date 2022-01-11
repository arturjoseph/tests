package contact.arturneto.courses.springboot.repository;

import contact.arturneto.courses.springboot.model.UserStudent;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface UserRepository extends PagingAndSortingRepository<UserStudent, Long> {
    Optional<UserStudent> findByUsername(String username);
}
