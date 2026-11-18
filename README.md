# Employee Management REST API

A small Spring Boot REST API that stores employees in an `ArrayList` in memory. It uses Java 17 and has no database dependency. All data is cleared when the application stops.

## IntelliJ project structure

```text
employee-management/
├── pom.xml
├── README.md
└── src/
    └── main/
        └── java/
            └── com/example/employeemanagement/
                ├── EmployeeManagementApplication.java
                ├── controller/
                │   └── EmployeeController.java
                ├── model/
                │   └── Employee.java
                └── service/
                    └── EmployeeService.java
```

## Run in IntelliJ IDEA

1. Install/use JDK 17 or newer and Maven 3.6.3 or newer.
2. Open the project folder (the folder containing `pom.xml`) in IntelliJ and load it as a Maven project.
3. Run `EmployeeManagementApplication`, or run `mvn spring-boot:run` from the project terminal.
4. The server listens at `http://localhost:8080`.

## API and Postman requests

Use `http://localhost:8080/api/employees` as the base URL. For requests with JSON bodies, select **Body → raw → JSON** in Postman and send `Content-Type: application/json`.

| Method | URL | Expected success status | Purpose |
|---|---|---:|---|
| POST | `/api/employees` | 201 Created | Add employee |
| GET | `/api/employees` | 200 OK | List all employees |
| GET | `/api/employees/{id}` | 200 OK | Find one employee |
| PUT | `/api/employees/{id}` | 200 OK | Replace employee details |
| DELETE | `/api/employees/{id}` | 204 No Content | Delete employee |

### 1. Create an employee

Postman: **POST** `http://localhost:8080/api/employees`

```json
{
  "name": "Asha Rao",
  "department": "Engineering",
  "salary": 65000.0
}
```

The response is `201 Created` and includes the new employee. IDs are assigned by the server starting at 1; any `id` supplied in a POST body is overwritten.

### 2. Get all employees

Postman: **GET** `http://localhost:8080/api/employees`

Returns `200 OK` and a JSON array. It is `[]` when no employees have been added.

### 3. Get an employee by ID

Postman: **GET** `http://localhost:8080/api/employees/1`

Returns `200 OK` and the matching employee, or `404 Not Found` when the ID does not exist.

### 4. Update an employee

Postman: **PUT** `http://localhost:8080/api/employees/1`

```json
{
  "name": "Asha Rao",
  "department": "Platform",
  "salary": 70000.0
}
```

Returns `200 OK` and the updated employee. The ID comes from the URL. If it does not exist, the response is `404 Not Found`.

### 5. Delete an employee

Postman: **DELETE** `http://localhost:8080/api/employees/1`

Returns `204 No Content` on success (no response body), or `404 Not Found` if the ID does not exist. Try GET by that ID afterward to confirm it was removed.
