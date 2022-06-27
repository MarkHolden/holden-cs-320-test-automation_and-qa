package com.holden.app.tasks;

import com.holden.app.exceptions.ArgumentException;

public class Task {
    private final String id;
    private String name;
    private String description;

    public Task(String taskId, String name, String description) throws ArgumentException {
        if (taskId == null || taskId.length() < 1)
           throw new ArgumentException("Task Id must not be null or empty.");
        
        if (taskId.length() > 10)
            throw new ArgumentException("Task Id must be less than or equal to ten characters.");

        this.id = taskId;
        setName(name);
        setDescription(description);
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) throws ArgumentException {
        if (description == null || description.length() < 1)
            throw new ArgumentException("Description must not be null or empty.");

        if (description.length() > 50)
            throw new ArgumentException("Description must be less than or equal to 50 characters.");

        this.description = description;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) throws ArgumentException {
        if (name == null || name.length() < 1)
            throw new ArgumentException("Name must not be null or empty.");

        if (name.length() > 20)
            throw new ArgumentException("Name must be less than or equal to 20 characters.");

        this.name = name;
    }

    public String getId() {
        return this.id;
    }
}
