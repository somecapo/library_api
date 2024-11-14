package rustamscode.library_api.controller;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import rustamscode.library_api.model.OperationType;
import rustamscode.library_api.model.Transaction;
import rustamscode.library_api.service.TransactionService;


@RestController
@RequestMapping("/transaction")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TransactionController {
    final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/transaction")
    public Transaction createTransaction(@RequestParam String readerPhoneNumber, @RequestParam Long bookId, @RequestParam OperationType operationType) {
        return transactionService.createTransaction(readerPhoneNumber, bookId, operationType);
    }
}
