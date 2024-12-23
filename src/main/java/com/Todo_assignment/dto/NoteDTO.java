package com.Todo_assignment.dto;

import javax.validation.constraints.NotBlank;

public class NoteDTO {

    @NotBlank(message = "Title is required") // Ensures title cannot be null or empty
    private String title;

    private String description;

    // Constructors
    public NoteDTO() {}

    public NoteDTO(String title, String description) {
        this.title = title;
        this.description = description;
    }

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
