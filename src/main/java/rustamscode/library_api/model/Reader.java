package rustamscode.library_api.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Reader {
    @Id
    private String phoneNumber;

    private String firstName;
    private String lastName;
    private String gender;
    private LocalDate birthDate;

    @OneToMany(mappedBy = "reader")
    private List<Transaction> transactions;

}
