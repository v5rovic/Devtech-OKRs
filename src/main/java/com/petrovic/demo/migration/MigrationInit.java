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
public class MigrationInit {

    private final UserRepo userRepo;

    @Execution
    public void seedDatabase() {
        User admin = new User("admin@email.com", "John", "Doe", "123456", Role.ADMIN);
        User user = new User("user@email.com", "Mark", "Yoe", "654321", Role.USER);

        userRepo.insert(admin);
        userRepo.insert(user);
    }

    @RollbackExecution
    public void rollback() {
        userRepo.deleteAll();
    }

}
