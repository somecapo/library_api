package rustamscode.library_api.controller;


import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rustamscode.library_api.model.Reader;
import rustamscode.library_api.service.ReaderService;

import java.util.List;

@RestController
@RequestMapping("/reader")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReaderController {
    final ReaderService readerService;

    @Autowired
    public ReaderController(ReaderService readerService) {
        this.readerService = readerService;
    }


    @GetMapping("/most-reading")
    public Reader getMostReadingClient() {
        return readerService.getMostReadingClient();
    }

    @GetMapping("/with-most-unreturned-books")
    public List<Reader> getReadersWithMostUnreturnedBooks() {
        return readerService.getReadersWithMostUnreturnedBooks();
    }
}
