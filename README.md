# Employee Management Service

This project is an Employee Management Service designed to handle HTTP requests and manage provided data. It serves as a personnel accounting database where employees are categorized by departments and specialties, and can have tasks assigned to them. The goal is to automate the process of tracking hired, fired, and transferred employees, as well as the process of assigning and removing tasks via a REST API.

## Phase 1

In Phase 1, we will implement functionality to work only with employees.

## Endpoints

The service provides several endpoints to interact with:

### 1. Create/Update Employee

**POST /employee**

- This endpoint accepts a JSON object with employee data.
- The object will be saved in the database.
- If an object with the same data already exists in the database, the fields will be updated with the new data.

**Example Request:**
```json
{
  "firstName": "John",
  "lastName": "Doe",
  "department": "IT",
  "salary": 1000.0
}
