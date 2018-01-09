package main.java.ru.inbox.savinov_vu.d_executorFramework.firstResult;

import java.util.concurrent.Callable;

public class TaskValidator implements Callable<String> {
    private final UserValidator validator;
    private final String user;
    private final String password;

    public TaskValidator(UserValidator validator, String user, String password) {
        this.validator = validator;
        this.user = user;
        this.password = password;
    }

    @Override
    public String call() throws Exception {
        if (!validator.validate(user, password)) {
            System.out.printf("%s:The user has not been found\n", validator.getName());
            throw new Exception("Error validating user");
        } else {
            System.out.printf("%s: The usr has been found\n", validator.getName());
            return validator.getName();
        }
    }
}
