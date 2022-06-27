package com.holden.app.tasks;

import com.holden.app.exceptions.ArgumentException;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

public class TaskTests {
    /**
     * System Under Test.
     */
    private Task _sut;

    public TaskTests() throws ArgumentException {
        _sut = new Task("abcde12345", "Do Work", "Do all of the things.");
    }

    /**
     * The task object shall have a required unique task ID string that cannot be longer than 10 characters.
     * The task ID shall not be null and shall not be updatable.
     * @throws ArgumentException
     */
    @ParameterizedTest
    @ValueSource(strings = {"abcde123456"})
    @NullAndEmptySource
    public void constructor_ShouldThrow_WhenTaskId_IsInvalid(String taskId) throws ArgumentException {
        ArgumentException thrown = Assertions.assertThrows(ArgumentException.class, () -> {
            new Task(taskId, "Do Work", "Do all of the things");
        });

        Assertions.assertTrue(thrown.getMessage().contains("Task Id"));
    }

    /**
     * The task object shall have a required unique task ID string that cannot be longer than 10 characters.
     * The task ID shall not be null and shall not be updatable.
     * @throws ArgumentException
     */
    @Test
    public void constructor_ShouldSetId_WhenTaskId_IsValid() throws ArgumentException {
        String id = "abcde12345";

        Task sut = new Task(id, "Do Work", "Do all of the things");

        Assertions.assertEquals(id, sut.getId());
    }

    /**
     * The task object shall have a required name String field that cannot be longer than 20 characters.
     * The name field shall not be null.
     * @throws ArgumentException
     */
    @ParameterizedTest
    @ValueSource(strings = {"abcde123456abcde123456"})
    @NullAndEmptySource
    public void constructor_ShouldThrow_WhenName_IsInvalid(String name) throws ArgumentException {
        ArgumentException thrown = Assertions.assertThrows(ArgumentException.class, () -> {
            new Task("abcde12345", name, "Do all of the things");
        });

        Assertions.assertTrue(thrown.getMessage().contains("Name"));
    }

    /**
     * The task object shall have a required name String field that cannot be longer than 20 characters.
     * The name field shall not be null.
     * @throws ArgumentException
     */
    @Test
    public void constructor_ShouldSetName_WhenName_IsValid() throws ArgumentException {
        String name = "Do Work";
        
        Task sut = new Task("abcde12345", name, "Do all of the things");

        Assertions.assertEquals(name, sut.getName());
    }

    /**
     * The task object shall have a required name String field that cannot be longer than 20 characters.
     * The name field shall not be null.
     * @throws ArgumentException
     */
    @ParameterizedTest
    @ValueSource(strings = {"abcde123456abcde123456"})
    @NullAndEmptySource
    public void setName_ShouldThrow_WhenName_IsInvalid(String name) throws ArgumentException {
        ArgumentException thrown = Assertions.assertThrows(ArgumentException.class, () -> {
            _sut.setName(name);
        });

        Assertions.assertTrue(thrown.getMessage().contains("Name"));
    }

    /**
     * The task object shall have a required name String field that cannot be longer than 20 characters.
     * The name field shall not be null.
     * @throws ArgumentException
     */
    @Test
    public void setName_ShouldSetName_WhenName_IsValid() throws ArgumentException {
        String name = "Do Stuff";
        
        _sut.setName(name);

        Assertions.assertEquals(name, _sut.getName());
    }

    /**
     * The task object shall have a required description String field that cannot be longer than 50 characters.
     * The description field shall not be null.
     * @throws ArgumentException
     */
    @ParameterizedTest
    @ValueSource(strings = {"abcde123456abcde123456abcde123456abcde123456abcde123456"})
    @NullAndEmptySource
    public void constructor_ShouldThrow_WhenDescription_IsInvalid(String name) throws ArgumentException {
        ArgumentException thrown = Assertions.assertThrows(ArgumentException.class, () -> {
            _sut = new Task("abcde12345", "Do Work", name);
        });

        Assertions.assertTrue(thrown.getMessage().contains("Description"));
    }

    /**
     * The task object shall have a required description String field that cannot be longer than 50 characters.
     * The description field shall not be null.
     * @throws ArgumentException
     */
    @Test
    public void constructor_ShouldSetDescription_WhenDescription_IsValid() throws ArgumentException {
        String description = "Do all of the things";
        
        _sut = new Task("abcde12345", "Do Work", description);

        Assertions.assertEquals(description, _sut.getDescription());
    }

    /**
     * The task object shall have a required description String field that cannot be longer than 50 characters.
     * The description field shall not be null.
     * @throws ArgumentException
     */
    @ParameterizedTest
    @ValueSource(strings = {"abcde123456abcde123456abcde123456abcde123456abcde123456"})
    @NullAndEmptySource
    public void setDescription_ShouldThrow_WhenDescription_IsInvalid(String description) throws ArgumentException {
        ArgumentException thrown = Assertions.assertThrows(ArgumentException.class, () -> {
            _sut.setDescription(description);
        });

        Assertions.assertTrue(thrown.getMessage().contains("Description"));
    }

    /**
     * The task object shall have a required description String field that cannot be longer than 50 characters.
     * The description field shall not be null.
     * @throws ArgumentException
     */
    @Test
    public void setDescription_ShouldSetDescription_WhenDescription_IsValid() throws ArgumentException {
        String description = "Braun";
        
        _sut.setDescription(description);

        Assertions.assertEquals(description, _sut.getDescription());
    }
}
