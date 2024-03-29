package ro.pao.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ro.pao.model.abstracts.Account;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Member extends Account {
    // inherits from AbstractEntity: id, createdDate, updatedDate, deletedDate
    // inherits from Person: name, address, email, phoneNumber
    // inherits from Account: userName, password, status
    private LocalDate dateOfMembership;
    private int totalOfBooksBorrowed;
    private List<BookCopy> borrowedBooks;

    public Member(String username, String password, String name, String address, String email, String phoneNumber) {
        super(username, password, name, address, email, phoneNumber);
        this.dateOfMembership = LocalDate.now();
        this.totalOfBooksBorrowed = 0;
        borrowedBooks = new ArrayList<BookCopy>();
    }
}
