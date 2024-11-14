package rustamscode.library_api.service;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rustamscode.library_api.model.*;
import rustamscode.library_api.repository.*;

import java.time.LocalDateTime;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TransactionService {
    final TransactionRepository transactionRepository;
    final BookRepository bookRepository;
    final ReaderRepository readerRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository, BookRepository bookRepository, ReaderRepository readerRepository) {
        this.transactionRepository = transactionRepository;
        this.bookRepository = bookRepository;
        this.readerRepository = readerRepository;
    }

    public Transaction createTransaction(String readerPhoneNumber, Long bookId, OperationType operationType) {
        Reader reader = readerRepository.findById(readerPhoneNumber).orElseThrow(() -> new RuntimeException("Reader not found"));
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new RuntimeException("Book not found"));

        Transaction transaction = new Transaction();
        transaction.setOperationType(operationType);
        transaction.setOperationTime(LocalDateTime.now());
        transaction.setReader(reader);
        transaction.setBook(book);

        return transactionRepository.save(transaction);
    }
}
