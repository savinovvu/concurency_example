package main.java.ru.inbox.savinov_vu.e_fork_joinFramework.asyncExecute;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountedCompleter;

import static java.util.Objects.nonNull;

public class FolderProcessor extends CountedCompleter<List<String>> {
    private String path;
    private List<FolderProcessor> tasks;
    private List<String> resultList;
    private String extension;

    protected FolderProcessor(CountedCompleter<?> completer, String path, String extension) {
        super(completer);
        this.path = path;
        this.extension = extension;
    }

    public FolderProcessor(String path, String extension) {
        this.path = path;
        this.extension = extension;
    }

    @Override
    public void compute() {
        resultList = new ArrayList<>();
        tasks = new ArrayList<>();
        File startFile = new File(path);
        File[] content = startFile.listFiles();
        if (nonNull(content)) {
            for (File file : content) {
                if (file.isDirectory()) {
                    FolderProcessor task = new FolderProcessor(this, file.getAbsolutePath(), extension);
                    task.fork();
                    addToPendingCount(1);
                    tasks.add(task);
                } else if (checkFile(file.getName())) {
                    resultList.add(file.getAbsolutePath());
                }
            }
            if (tasks.size() > 50) {
                System.out.printf("%s: %d tasks ran. \n", startFile.getAbsoluteFile(), tasks.size());
            }
        }
        tryComplete();
    }

    private boolean checkFile(String name) {
        return name.endsWith(extension);
    }

    @Override
    public void onCompletion(CountedCompleter<?> caller) {
        for (FolderProcessor childTask :tasks) {
            resultList.addAll(childTask.getResultList());
        }
    }

    public List<String> getResultList() {
        return resultList;
    }
}
