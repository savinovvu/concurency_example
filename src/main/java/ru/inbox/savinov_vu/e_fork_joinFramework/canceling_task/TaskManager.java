package main.java.ru.inbox.savinov_vu.e_fork_joinFramework.canceling_task;

import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ForkJoinTask;

public class TaskManager {
    private final ConcurrentLinkedDeque<SearchNumberTask> tasks;

    public TaskManager() {
        this.tasks = new ConcurrentLinkedDeque<>();
    }

    public void addTask(ForkJoinTask<Integer> task) {
        tasks.add((SearchNumberTask) task);
    }

    public void cancellTasks(SearchNumberTask cancelTask) {
        for (SearchNumberTask task :tasks) {
            if (task != cancelTask) {
                task.cancel(true);
                task.logCancelMessage();
            }

        }

    }
}
