package com.holden.app.tasks;

import java.util.*;

import com.holden.app.exceptions.*;

public class TaskService {
    private List<Task> tasks = new ArrayList<>();

    public void addTask(Task task) throws ConflictException {
        if (tasks.stream().anyMatch(c -> c.getId().equals(task.getId())))
            throw new ConflictException(Task.class.getName(), task.getId());

        tasks.add(task);
    }

    public Task getTask(String id) throws NotFoundException {
        Optional<Task> task = tasks.stream()
            .filter(c -> c.getId().equals(id))
            .findFirst();

        if (!task.isPresent())
            throw new NotFoundException(Task.class.getName(), id);

        return task.get();
    }

    public void deleteTask(String id) throws NotFoundException {
        List<Task> toRemove = new ArrayList<>();
        tasks.stream()
            .filter(c -> c.getId().equals(id))
            .forEach(toRemove::add);

        if (toRemove.isEmpty())
            throw new NotFoundException(Task.class.getName(), id);

        tasks.removeAll(toRemove);
    }

    public List<Task> listTasks() {
        return tasks;
    }

    public void updateTask(Task task) throws NotFoundException {
        if (tasks.stream().allMatch(c -> !c.getId().equals(task.getId())))
            throw new NotFoundException(Task.class.getName(), task.getId());

        tasks.stream()
            .filter(c -> c.getId().equals(task.getId()))
            .forEach(c -> {
                try {
                    c.setName(task.getName());
                    c.setDescription(task.getDescription());
                } catch (ArgumentException e) {
                    e.printStackTrace(); // make compiler happy.
                }
            });
    }
}
