package rustamscode.library_api.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import com.fasterxml.jackson.annotation.JsonBackReference;


import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private OperationType operationType;
    private LocalDateTime operationTime;

    @ManyToOne
    @JoinColumn(name = "reader_phone_number", referencedColumnName = "phoneNumber")
    @JsonBackReference
    private Reader reader;

    @ManyToOne
    private Book book;

}
