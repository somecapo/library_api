package rustamscode.library_api.service;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rustamscode.library_api.model.OperationType;
import rustamscode.library_api.model.*;
import rustamscode.library_api.repository.ReaderRepository;
import rustamscode.library_api.repository.TransactionRepository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReaderService {
    final ReaderRepository readerRepository;
    final TransactionRepository transactionRepository;

    @Autowired
    public ReaderService(ReaderRepository readerRepository, TransactionRepository transactionRepository) {
        this.readerRepository = readerRepository;
        this.transactionRepository = transactionRepository;
    }

    public Reader getMostReadingClient() {
        return transactionRepository.findAll()
                .stream()
                .collect(Collectors.groupingBy(Transaction::getReader, Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    public List<Reader> getReadersWithMostUnreturnedBooks() {
        return transactionRepository.findAllByOperationType(OperationType.TAKE)
                .stream()
                .collect(Collectors.groupingBy(Transaction::getReader, Collectors.counting()))
                .entrySet().stream()
                .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}
