# US 007 - To register a user

## 1. Requirements Engineering


### 1.1. User Story Description

As an unregistered user, I want to register in the system to buy, sell or rent properties.

### 1.2. Customer Specifications and Clarifications

**From the specifications document:**

Roles:
* Owner;
* Client (rent or buy).

**From the client clarifications:**

>**Question:** When a user registers in the system, does it need to specify for which transactional activities or all registered users can buy sell and rent?
> 
>**Answer (24 April 2023):** All registered users can buy sell and rent.

>**Question:** After the users fills all the required information, is the user automatically registered in the system, or is there any other role that will review and approve the user registration?
> 
>**Answer (24 April 2023)**: The system should automatically validate the registration.

>**Question:** Does the user also receive the password via email or can he choose a password when registering?
>
>**Answer (12 April 2023):** The owner can choose a password when registering.

>**Question:** When an unregistered user wants to register a new account in the system, the set of parameters that are asked are the following: name, citizen card number, tax number, email, phone number, and password. Do you want any extra parameters/requirements to be asked or just the ones specified above? If so, which ones are mandatory?
>
>**Answer (12 April 2023):** The Owner attributes are: the name, the citizen's card number, the tax number, the address, the email address and the contact telephone number. The address of the owner is not mandatory.

### 1.3. Acceptance Criteria

**AC1: All required fields must be filled in.**

**AC2: Registered account must not exist previously.**

**AC3: When registering an account that already exists, the system must reject such operation.**

### 1.4. Found out Dependencies

* There is no dependency to any other US.

### 1.5 Input and Output Data

**Input Data:**

* Typed data:
      * the name
      * the passport number
      * the tax number
      * the address
      * the email address
      * the telephone number

* Selected data:
     * role type

**Output Data:**

* Role options (Owner or client)

* (In)Success of the operation

### 1.6. System Sequence Diagram (SSD)

![System Sequence Diagram](svg/us007-System_Sequence_Diagram__SSD_.svg)