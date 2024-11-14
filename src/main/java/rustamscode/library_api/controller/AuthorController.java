package rustamscode.library_api.controller;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import rustamscode.library_api.model.Author;
import rustamscode.library_api.service.AuthorService;


import java.time.LocalDate;

@RestController
@RequestMapping("/author")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthorController {
    final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/most-popular")
    public Author getMostPopularAuthor(@RequestParam LocalDate startDate, @RequestParam LocalDate endDate) {
        return authorService.getMostPopularAuthor(startDate, endDate);
    }
}
