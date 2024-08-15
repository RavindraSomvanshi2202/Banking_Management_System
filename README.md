# Banking_Management_System
In this project, we will learn how to build REST APIs for a simple Banking application using Spring Boot, Spring Data JPA (Hibernate) and MySQL database. 

#  Test Application Commands

### 1. Login Method
HTTP Method: POST 

URL: http://localhost:9091/api/account/login

Body: (JSON) 

    {
    "email": "example@example.com",
    "password": "yourPassword"
    }
_______________________________________________________________

### 2. Create Account Method
HTTP Method: POST

URL: http://localhost:9091/api/account/create

Body: (JSON)

  {
    "email": "example@example.com",
    "password": "yourPassword",
    "accountHolderName": "John Doe",
    "balance": 1000.0,
    "contact": "1234567890",
    "address": "123 Street, City, Country"
  }
_______________________________________________________________

### 3. Get Account Details
HTTP Method: GET

URL: http://localhost:9091/api/account/{id}

### Note: Replace {id} with the actual account ID.

_______________________________________________________________

### 4. Update Account Details
HTTP Method: PUT

URL: http://localhost:9091/api/account/{id}/update

Body: (JSON)

{
    "email": "newEmail@example.com",
    "password": "newPassword",
    "accountHolderName": "John Doe Updated",
    "balance": 2000.0,
    "contact": "0987654321",
    "address": "456 New Street, New City, New Country"
}
  
### Note: Replace {id} with the actual account ID.
_______________________________________________________________

### 5. Deposit Money
HTTP Method: POST

URL: http://localhost:9091/api/account/{id}/deposite

Body: (JSON)

  {
    "amount": 500.0
  }
  
### Note: Replace {id} with the actual account ID.
_______________________________________________________________

### 6. Withdraw Money
HTTP Method: POST

URL: http://localhost:9091/api/account/{id}/withdraw

Body: (JSON)

  {
    "amount": 200.0
  }
  
### Note: Replace {id} with the actual account ID.
_______________________________________________________________

### 7. Delete Account
HTTP Method: DELETE

URL: http://localhost:9091/api/account/{id}/delete

### Note: Replace {id} with the actual account ID.







   
