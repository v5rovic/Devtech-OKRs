package com.petrovic.demo.migration;

import com.petrovic.demo.model.Role;
import com.petrovic.demo.model.User;
import com.petrovic.demo.repository.UserRepo;
import io.mongock.api.annotations.ChangeUnit;
import io.mongock.api.annotations.Execution;
import io.mongock.api.annotations.RollbackExecution;
import lombok.RequiredArgsConstructor;


@ChangeUnit(order = "1", id = "seedDatabase", author = "v5rovic")
@RequiredArgsConstructor
public class DbChangeLog {

    private final UserRepo userRepo;

    @Execution
    public void seedDatabase() {
        User u1 = new User("admin@email.com", "John", "Doe", "$2a$12$avci1V1t2gYeO7uw7ZvUceN82S1qPX8qOmgCVpbLkiFnjIOImSw7e", Role.ADMIN);
        User u2 = new User("user@email.com", "Mark", "Yoe", "$2a$12$N1al8t/YDYA1U3hsk4GiPuWMu/UGn/66pClZ4kqclIWQIxjs0lDcy", Role.USER);

        userRepo.insert(u1);
        userRepo.insert(u2);
    }

    @RollbackExecution
    public void rollback() {
        userRepo.deleteAll();
    }

}
