package rustamscode.library_api.config;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rustamscode.library_api.model.Author;
import rustamscode.library_api.model.Book;
import rustamscode.library_api.model.Reader;
import rustamscode.library_api.model.Transaction;
import rustamscode.library_api.model.OperationType;
import rustamscode.library_api.repository.AuthorRepository;
import rustamscode.library_api.repository.BookRepository;
import rustamscode.library_api.repository.ReaderRepository;
import rustamscode.library_api.repository.TransactionRepository;
import org.springframework.boot.CommandLineRunner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DataLoader implements CommandLineRunner {

    final BookRepository bookRepository;
    final AuthorRepository authorRepository;
    final ReaderRepository readerRepository;
    final TransactionRepository transactionRepository;

    @Autowired
    public DataLoader(BookRepository bookRepository, AuthorRepository authorRepository, ReaderRepository readerRepository, TransactionRepository transactionRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.readerRepository = readerRepository;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public void run(String... args) {
        // Создание авторов
        Author author1 = new Author();
        author1.setFirstName("John");
        author1.setLastName("Doe");
        author1.setBirthDate(LocalDate.of(1980, 1, 1));
        authorRepository.save(author1);

        Author author2 = new Author();
        author2.setFirstName("Jane");
        author2.setLastName("Smith");
        author2.setBirthDate(LocalDate.of(1990, 2, 2));
        authorRepository.save(author2);

        // Создание книг
        Book book1 = new Book();
        book1.setTitle("Book 1");
        book1.setPublicationYear(2000);
        book1.setAuthors(Arrays.asList(author1));
        bookRepository.save(book1);

        Book book2 = new Book();
        book2.setTitle("Book 2");
        book2.setPublicationYear(2010);
        book2.setAuthors(Arrays.asList(author2));
        bookRepository.save(book2);

        // Создание читателей
        Reader reader1 = new Reader();
        reader1.setPhoneNumber("1234567890");
        reader1.setFirstName("Alice");
        reader1.setLastName("Johnson");
        reader1.setGender("Female");
        reader1.setBirthDate(LocalDate.of(1995, 3, 3));
        readerRepository.save(reader1);

        Reader reader2 = new Reader();
        reader2.setPhoneNumber("0987654321");
        reader2.setFirstName("Bob");
        reader2.setLastName("Brown");
        reader2.setGender("Male");
        reader2.setBirthDate(LocalDate.of(1998, 4, 4));
        readerRepository.save(reader2);

        // Создание транзакций
        Transaction transaction1 = new Transaction();
        transaction1.setOperationType(OperationType.TAKE);
        transaction1.setOperationTime(LocalDateTime.now());
        transaction1.setReader(reader1);
        transaction1.setBook(book1);
        transactionRepository.save(transaction1);

        Transaction transaction2 = new Transaction();
        transaction2.setOperationType(OperationType.TAKE);
        transaction2.setOperationTime(LocalDateTime.now());
        transaction2.setReader(reader2);
        transaction2.setBook(book2);
        transactionRepository.save(transaction2);
    }
}

