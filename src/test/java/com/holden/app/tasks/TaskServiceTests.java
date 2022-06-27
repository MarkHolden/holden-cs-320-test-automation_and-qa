package com.holden.app.tasks;

import com.holden.app.exceptions.*;

import org.junit.jupiter.api.*;

public class TaskServiceTests {
    /**
     * System Under Test.
     */
    private TaskService _sut;
    
    public TaskServiceTests() {
        _sut = new TaskService();
    }

    /**
     * The task service shall be able to add tasks with a unique ID.
     */
    @Test
    public void addTask_ShouldAddTask_WhenIdIsUnique() throws ConflictException, NotFoundException {
        String id = "id";
        _sut.addTask(getValidTask(id));

        Assertions.assertNotNull(_sut.getTask(id));
    }

    /**
     * The task service shall be able to add tasks with a unique ID.
     */
    @Test
    public void addTask_ShouldThrow_WhenIdIsNotUnique() throws ConflictException {
        _sut.addTask(getValidTask("id"));

        Assertions.assertThrows(ConflictException.class, () -> {
            _sut.addTask(getValidTask("id"));
        });
    }

    /**
     * The task service shall be able to delete tasks per task ID.
     */
    @Test
    public void deleteTask_ShouldRemoveTask_WhenIdExists() throws ConflictException, NotFoundException {
        String id = "id";
        _sut.addTask(getValidTask(id));

        _sut.deleteTask(id);
        Assertions.assertEquals(0, _sut.listTasks().size());
    }

    /**
     * The task service shall be able to delete tasks per task ID.
     */
    @Test
    public void deleteTask_ShouldThrow_WhenIdDoesNotExist() {
        Assertions.assertThrows(NotFoundException.class, () -> {
            _sut.deleteTask("id");
        });
    }

    /**
     * The task service shall be able to delete tasks per task ID.
     */
    @Test
    public void updateTask_ShouldUpdateTaskFields_WhenIdExists() throws ConflictException, NotFoundException, ArgumentException {
        String id = "id"; 
        Task original = getValidTask(id);
        _sut.addTask(original);
        String updatedName = "name";
        String updatedDescription = "description";
        Task update = new Task(id, updatedName, updatedDescription);

        _sut.updateTask(update);

        Task result = _sut.getTask(id);
        Assertions.assertEquals(updatedName, result.getName());
        Assertions.assertEquals(updatedDescription, result.getDescription());
    }

    /**
     * The task service shall be able to delete tasks per task ID.
     */
    @Test
    public void updateTask_ShouldThrow_WhenIdDoesNotExist() {
        Assertions.assertThrows(NotFoundException.class, () -> {
            _sut.updateTask(getValidTask("id"));
        });
    }

    @Test
    public void getTask_ShouldReturnTask_WhenIdExists() throws ConflictException, NotFoundException {
        String id = "AB1001";
        _sut.addTask(getValidTask(id));

        Assertions.assertNotNull(_sut.getTask(id));
    }

    @Test
    public void getTask_ShouldThrow_WhenIdDoesNotExist() throws NotFoundException {
        Assertions.assertThrows(NotFoundException.class, () -> {
            _sut.getTask("AB1001");
        });
    }

    @Test
    public void listTasks_ShouldReturnTaskList() throws ConflictException {
        _sut.addTask(getValidTask("AB1001"));
        _sut.addTask(getValidTask("AB1002"));
        _sut.addTask(getValidTask("AB1003"));

        Assertions.assertEquals(3, _sut.listTasks().size());
    }

    @Test
    public void listTasks_ShouldReturnEmptyList_WhenThereAreNoTasks() {
        Assertions.assertEquals(0, _sut.listTasks().size());
    }

    private Task getValidTask(String id) {
        try {
            return new Task(id, "Do Work", "Do all of the things");
        }
        catch (Exception e) {
            Assertions.assertFalse(true, "getValidTask should return valid task.");
            return null;
        }
    }
}
