package rustamscode.library_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import rustamscode.library_api.model.OperationType;
import rustamscode.library_api.model.Transaction;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findAllByOperationTimeBetween(LocalDateTime startTime, LocalDateTime endTime);

    @Query("SELECT t FROM Transaction t WHERE t.operationType = :operationType")
    List<Transaction> findAllByOperationType(@Param("operationType") OperationType operationType);
}
