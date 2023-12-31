# US 003 - To register an employee

## 1. Requirements Engineering


### 1.1. User Story Description


As an organization employee, I want to register a new employee .



### 1.2. Customer Specifications and Clarifications


**From the specifications document:**

> Each employee is characterized by the name, the citizen number, the tax number, the adress, the email address, the telephone number and the agency to which it is assigned.
> Each employee has his own role.
> For each employee a random password is generated for him.

**From the client clarifications:**

> **Question:** The administrator when registering a new employee will also have to specify the category/office that he will perfom ?
>
> **Answer:** The administrator has to specify the role of the employee.


> **Question:** When a System Administrator (admin) makes a request to register a new employee or a new network branch (or any other alteration), does the System ask for the admin credentials (login, password)?
>
> **Answer:** The System Administrator should be logged in the application.


> **Question:** When registering a new employee, will the administrator set the respective employee password?
> 
> **Answer:** The password should have eight characters in length and should be generated automatically. The password is sent to the employee by e-mail.


> **Question:** Does the System Administrator have permission to create, edit, delete, or just create new employee registrations?
>
> **Answer:** For now, the System Administrator can only do what is specified in the Project Requirements.

> **Question:** Can an employee be registered to more than one agency?
>
> **Answer:** No.

> **Question:**  What would be the attributes of the System Administrator, Agency and the Roles?
> 
> **Answer:** The System Administrator is an employee. You can get the roles from the project description. Please check the project description.
Moreover, I just answered a question to clarify what are the attributes of an agency/store.

### 1.3. Acceptance Criteria


* **AC1:** The password of the new employee should have eight characters in length.
* **AC2:** 
* **AC3:** 

### 1.4. Found out Dependencies


* There is a dependency to "US005 Register a store " because you need a store to be possible to register an employee.


### 1.5 Input and Output Data


**Input Data:**

* Typed data:
    * the name of the employee
    * the citizen number of the employee
    * the tax number of the employee
    * the adress of the employee
    * the email address of the employee
    * the telephone number of the employee
    * the agency to which the employee is assigned.
   

* Selected data:
    * Classifying the role of the employee


**Output Data:**

* list of all registered employees
* Generate a passoword to the new employee
* (In)Success of the operation

### 1.6. System Sequence Diagram (SSD)

![System Sequence Diagram - Alternative One](svg/us003-system-sequence-diagram-alternative-one-System_Sequence_Diagram__SSD_.svg)

### 1.7 Other Relevant Remarks

* The state of the employee stays in "unregisterd" state in order to distinguish from "registered" state.