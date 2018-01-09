package main.java.ru.inbox.savinov_vu.d_executorFramework.firstResult;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        System.out.println();
        String username = "test";
        String password = "test";
        UserValidator ldapValidator = new UserValidator("LDAP");
        UserValidator dataBaseValidator = new UserValidator("DataBase");
        TaskValidator ldapTask = new TaskValidator(ldapValidator, username, password);
        TaskValidator dbTask = new TaskValidator(dataBaseValidator, username, password);
        List<TaskValidator> taskList = new ArrayList<>();
        taskList.add(ldapTask);
        taskList.add(dbTask);
        ExecutorService executorService = Executors.newCachedThreadPool();
        String result;
        try {
            result = executorService.invokeAny(taskList);
            System.out.printf("Main: Result: %s\n", result);
        } catch (InterruptedException | ExecutionException e) {
//            e.printStackTrace();
        }
        executorService.shutdown();
        System.out.printf("Main: End of the Execution\n");
    }
}
