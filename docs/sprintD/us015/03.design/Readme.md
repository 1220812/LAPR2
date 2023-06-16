# US 013 - To create a Task 

## 3. Design - User Story Realization 

### 3.1. Rationale

**SSD - Alternative 1 is adopted.**

| Interaction ID | Question: Which class is responsible for...                                               | Answer                | Justification (with patterns) |
|:---------------|:------------------------------------------------------------------------------------------|:----------------------|:------------------------------|
| Step 1  	      | 	Intend to list all booking requests for properties managed by the agent?                 | ListRequestsGUI       | Pure Fabrication              |
| Step 2		       | 	Requesting a specific period (begin date)?                                               | ListRequestController | Controller                    |
| Step 3 	       | 	Selecting specific period (begin date)?                                                  | ListRequestsGUI       | Pure Fabrication              |
| Step 4         | Requesting a specific period (end date)?                                                  | ListRequestController | Controller                    |
| Step 5  		     | Selecting specific period (end date)?				                                                 | ListRequestsGUI       | Pure Fabrication              |
| Step 6  	      | 	Showing a list for a specific period sorted in ascending gorder (begin date, end date)?  | ListRequestsGUI       | Pure Fabrication              |


### Systematization ##

According to the taken rationale, the conceptual classes promoted to software classes are: 

 * Message
 * Agent

Other software classes (i.e. Pure Fabrication) identified: 

 * ListRequestsGUI
 * ListRequestsController
 


## 3.2. Sequence Diagram (SD)

### Main Sequence Diagram

This diagram shows the main sequence of interactions between the classes involved in the realization of this user story.

![Main Sequence Diagram](us015-main-sequence-diagram.puml)

### Alternative flux (sorting methods)

![Alternative Flux (sorting methods)](us015-alternative flux sorting methods.puml)

## 3.3. Class Diagram (CD)

![Class Diagram](us015-class-diagram.puml)