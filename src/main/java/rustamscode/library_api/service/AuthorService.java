package rustamscode.library_api.service;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rustamscode.library_api.model.Author;
import rustamscode.library_api.model.Transaction;
import rustamscode.library_api.repository.TransactionRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthorService {
   final TransactionRepository transactionRepository;

    @Autowired
    public AuthorService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Author getMostPopularAuthor(LocalDate startDate, LocalDate endDate) {
        List<Transaction> transactions = transactionRepository.findAllByOperationTimeBetween(startDate.atStartOfDay(), endDate.atTime(23, 59, 59));
        return transactions.stream()
                .flatMap(transaction -> transaction.getBook().getAuthors().stream())
                .collect(Collectors.groupingBy(author -> author, Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }
}
