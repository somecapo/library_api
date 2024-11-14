package rustamscode.library_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rustamscode.library_api.model.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
