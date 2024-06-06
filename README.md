# Employee Management Service

This service is designed to handle HTTP requests and manage data related to personnel. It serves as a database for tracking employees categorized by departments and job roles. Additionally, it facilitates the assignment and removal of tasks for employees through a REST API.

## Phase 1: Employee Management

For the initial phase, the service will focus on employee management only.

### Endpoints:

- **POST /employee**
  - This endpoint accepts a POST request containing a JSON object with employee data. The provided data will be stored in the database. If an employee with the same identifier already exists, the information will be updated with the new data.

- **GET /employee**
  - This endpoint returns the list of all employees stored in the database.

- **DELETE /employee**
  - This endpoint allows the deletion of a specific employee from the database.
