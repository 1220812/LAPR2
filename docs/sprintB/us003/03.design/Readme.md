# US 006 - To create a Task

## 3. Design - User Story Realization

### 3.1. Rationale

**SSD - Alternative 1 is adopted.**

| Interaction ID                                              | Question: Which class is responsible for...                  | Answer                                  | Justification (with patterns)                                                                                 |
|:------------------------------------------------------------|:-------------------------------------------------------------|:----------------------------------------|:--------------------------------------------------------------------------------------------------------------|
| Step 1: Ask to regist a new Employee 		                     | 	... interacting with the System Administrator?              | RegisterNewEmployeeUI                   | Pure Fabrication: there is no reason to assign this responsibility to any existing class in the Domain Model. |
| 			  		                                                     | 	... coordinating the US?                                    | RegisterNewEmployeeController           | Controller                                                                                                    |
| 			  		                                                     | 	...knowing the instance of Repository?                      | Repository                              | Creator (Rule 3): App closely uses Singleton.                                                                 |
| 			  		                                                     | ... knowing the user using the system?                       | UserSession                             | IE: cf. A&A component documentation.                                                                          |
| Step 2: Requests Employee data  		                          | 	...displaying for the UI for the actor in input data?						 | RegisterNewEmployeeUI                   | Low Coupling pattern: UI displays the input data                                                              |
| Step 3: Inserts requested data  		                          | 	...saving the inputted data?                                | RegisterNewEmployeeUI                   | Low Coupling pattern: UI holds temporatily the input data                                                     |
| Step 4: Show a list of roles and ask to select one		        | 	...returning the list of roles                              | roleRepository                          | Information Expert pattern: roleRepository holds and knows all roles                                          |
| Step 5: Choose role  		                                     | 	... saving the selected category?                           | RegisterNewEmployeeUI                   | Low Coupling pattern: UI holds temporatily the selected role                                                  |
| Step 6: Show a list of agencies and ask to select one  		   | 	...returnig the list of agencies						              | agencyRepository                        | Information Expert pattern: agencyRepository holds and knows all agencies                                     |              
| Step 7: Choose agency  		                                   | 	... saving the selected category?                           | RegisterNewEmployeeUI                   | Low Coupling pattern: UI holds temporatily the selected agency                                                | 
| Step 8: Show a list of stores and ask to select one 			  		 | 	... returning the list of stores                            | storeRepository                         | Information Expert pattern: storeRepository holds and knows all stores                                        | 
| Step 9: Choose store			  		                                 | 	... saving the selected category?                           | RegisterNewEmployeeUI                                         | Low Coupling pattern: UI holds temporatily the selected store                                                 | 
| Step 10: Save Employee 		                                   | 	... saving all data?                                        | RegisterNewEmployeeController           | Controller.                                                                                                   | 
| Step 11: Generate password		                                | 	...randomly generated password?                             | PasswordGenerator                       | Information Expert pattern: PasswordGenerator creat a password                                                | 
| Step 12: Create user		                                      | 	... saving all data and password?                           | User                                    | Information Expert pattern: User save the user                                                                | 
| Step 13: Send registered user by email 		                   | 	... sending user content for Employee email?                | UserRepository                          | Information Expert pattern: UserRepository send a email                                                       | 
| Step 14: Informs operations sucess		                        | 	... informing operation sucess?                             | RegisterNewEmployeeUI                   | Low Coupling pattern: UI displays operation sucess                                                            | 


### Systematization ##

According to the taken rationale, the conceptual classes promoted to software classes are:

* Organization
* Task

Other software classes (i.e. Pure Fabrication) identified:

* CreateRequestUI
* CreateRequestController

## 3.2. Sequence Diagram (SD)

### Alternative - Full Diagram

![Sequence Diagram - split](svg/us004-sequence-diagram.svg)

## 3.3. Class Diagram (CD)

![Class Diagram](svg/us004-class-diagram.svg)