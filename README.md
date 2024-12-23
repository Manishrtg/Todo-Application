Todo Assignment Application

This is a simple API that helps you manage to-do notes. You can create, update, delete, and view your notes through HTTP requests.

---

 How to Set Up and Run the Application

 1. Requirements

     Before running this application, make sure you have the following installed:

      - Java 17 or higher
      - Maven (to build and run the project)
      - PostgreSQL (or any database supported by Spring Boot)

2. Setting Up

  1. Clone the repository:
     ```bash
     git clone https://github.com/Manishrtg/Todo-Application.git
     cd Todo-Application
     ```
  
  2. Set up your database**:
     - Create a database in PostgreSQL (or your preferred database).
     - Open `src/main/resources/application.properties` and update the database settings (like username and password).
     
     Example:
     ```properties
      spring.application.name=Todo_assignment
      spring.datasource.url=jdbc:postgresql://localhost:5432/Todo_officebanao
      spring.datasource.username = postgres
      spring.datasource.password = Lodjadcjn4

     ```

3. Build and run the application:
   Run this command to start the application:
   ```bash
   mvn spring-boot:run
   ```

4. Application URL :
   The application will be available at `http://localhost:8080`.

---

 
 Available Endpoints

1. Create a New Note

- Endpoint: `POST /notes`
- Description: Create a new note. The `title` is required, but `description` is optional.

      Example Request:
      ```json
      POST /notes
      {
        "title": "Test New Feature",
        "description": "Testing the new feature with sample data."
      }
      ```
      
      Example Response:
      ```json
      {
        "id": 7,
        "title": "Test New Feature",
        "description": "Testing the new feature with sample data.",
        "createdAt": "2024-12-23T17:00:00"
      }
      ```

---

2.  Update an Existing Note

- Endpoint: `PUT /notes/{id}`
- **Description**: Update an existing note by its `id`. The `title` is required.

Example Request:
```json
PUT /notes/2
{
  "title": "Updated: Sample Note 2",
  "description": "Updated description for the second note"
}
```

Example Response:
```json
{
  "id": 2,
  "title": "Updated: Sample Note 2",
  "description": "Updated description for the second note",
  "createdAt": "2024-12-23T15:58:49.538599"
}
```

---

 3. Get All Notes

- Endpoint: `GET /notes`
- Description: Get a list of all notes.

#### Example Request:
```json
GET /notes
```

#### Example Response:
```json
[
  {
    "id": 2,
    "title": "Sample Note 2",
    "description": "This is the description for the second note",
    "createdAt": "2024-12-23T15:58:49.538599"
  },
  {
    "id": 3,
    "title": "Fix bugs in user login module",
    "description": "Debug the user login feature, fix issues with authentication failure.",
    "createdAt": "2024-12-23T16:49:46.712793"
  }
]
```

---

### 4. Get a Single Note by ID

- **Endpoint**: `GET /notes/{id}`
- **Description**: Get a specific note by its `id`.

#### Example Request:
```json
GET /notes/2
```

#### Example Response:
```json
{
  "id": 2,
  "title": "Sample Note 2",
  "description": "This is the description for the second note",
  "createdAt": "2024-12-23T15:58:49.538599"
}
```

---

### 5. Delete a Note by ID

- Endpoint: `DELETE /notes/{id}`
- Description: Delete a specific note by its `id`.

#### Example Request:
```json
DELETE /notes/2
```

 Example Response:
- **Status Code**: `204 No Content`

---

 Error Handling

If something goes wrong, the application will return an error:

- **400 Bad Request**: The request is missing required fields (e.g., title).
- **404 Not Found**: The note with the given ID does not exist.
- **500 Internal Server Error**: Something went wrong on the server.

---

 Example Notes Data

Here is some sample data already in the system:

```json
[
  {
    "id": 2,
    "title": "Sample Note 2",
    "description": "This is the description for the second note",
    "createdAt": "2024-12-23T15:58:49.538599"
  },
  {
    "id": 3,
    "title": "Fix bugs in user login module",
    "description": "Debug the user login feature, fix issues with authentication failure.",
    "createdAt": "2024-12-23T16:49:46.712793"
  }
]
```

You can use these sample notes to test the API.

---
