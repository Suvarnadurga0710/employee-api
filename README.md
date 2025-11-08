# Employee API

A Spring Boot RESTful API to manage employee information. Supports basic CRUD operations and search functionality.

## Base URL

http://localhost:8081/


## Endpoints

| Method | Endpoint                  | Description                                      | Request Body / Params |
|--------|---------------------------|-------------------------------------------------|---------------------|
| GET    | `/employees`              | Fetch all employees                             | -                   |
| GET    | `/employees/email`        | Fetch employee by email                         | `?email=example`    |
| GET    | `/employees/name`         | Fetch employees by first name (partial match)  | `?name=example`     |
| POST   | `/employees`              | Create a new employee                           | JSON body            |
| PUT    | `/employees/{id}`         | Update employee details (full update)          | JSON body            |
| PATCH  | `/employees/{id}/phone`   | Update only phone                               | JSON body            |
| DELETE | `/employees/email`        | Delete employee by email                        | `?email=example`    |

## Example Request (POST)

```json
{
    "firstName": "Neha",
    "lastName": "Gupta",
    "email": "neha@example.com",
    "phone": "9001122334",
    "address": "Kolkata"
}
[
  {
    "id": 1,
    "firstName": "Suvarna",
    "lastName": "Moka",
    "email": "suvarna@example.com",
    "phone": "9999999999",
    "address": "Pune"
  },
  {
    "id": 2,
    "firstName": "Ravi",
    "lastName": "Kumar",
    "email": "ravi@example.com",
    "phone": "9123456780",
    "address": "Mumbai"
  }
]
# Employee API

## Features

- Spring Boot + Spring Data JPA  
- H2 in-memory database  
- CRUD operations for employee records  
- Search by email and name  
- Full and partial updates  
- Delete by email  

## Testing

- Use **Postman** to test all endpoints.  
- Exported Postman collection: `EmployeeAPI.postman_collection.json`.  

