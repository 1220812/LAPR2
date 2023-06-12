# US 016

## 1. Requirements Engineering


### 1.1. User Story Description


As an agent, when viewing a booking request, I want to respond to the user that scheduled the visit.


### 1.2. Customer Specifications and Clarifications 


**From the specifications document:**


> The real estate agent reviews advertisement requests (...) it is **visible to all clients** who visit the agency and use the application.

> All registered information, except the agency commission, can be accessed by the client who intends to buy or rent the property.


**From the client clarifications:**

1st June 

> **Question:** In AC2, what is DEI's email service? Are you referring to Outlook?
> 
> **Answer:** Different email services can send the message. These services must be configured using a configuration file to enable using different platforms (e.g.: gmail, DEI's email service, etc.). DEI email service is an email service like gmail or Outlook. These are only examples, and you should prepare your system to support any email service.

> **Question:** When the agent is responding to the user that created the request, what should the answer be? Because accepting or declining the request is already done in US011.
> 
> **Answer:**  In US11 the agent wants to accept or decline a purchase order for a property. In US16 the agent wants to answer visit requests.
Please discuss the requirements with your team and professors before making a question.

> **Question:** When the agent requests the booking requests list to contact the client, that list should ONLY contain the requests related to that agent?
> 
> **Answer:** Yes. Listing is a feature described in US15.
Important: In US15 the Agent gets a list of booking requests (made to him). Then, the agent, may want to respond to the user (as defined in US16). US15 and US16 are executed sequentially. Even so, the agent should be able to see a list of all booking requests made to him (US15) without answer any booking request.

> **Question:** Our team is having trouble understanding US016's AC2. Until now, the email has been sent in the form of a text file, however, with this AC, a configuration file that allows the use of different platforms has been introduced. How should the sending of emails be carried out then?
> 
> **Answer:** The configuration file defines the email service to be used. The URI of the email service should be defined in the configuration file. The URI can be the path of a file. Please discuss this question with your ESOFT teatchers.

2nd June 

> **Question:**  In this US16, will it be necessary : save the message for could be in future list in the application or for audit action or isn´t necessary save, is only to send and the complete message (email) will not be auditable not even possible consult in the application in the future?
>  
> **Answer:** The system should record typed text messages. Regarding other messages, that only use information that is already registered in the system, the system should only record that the message was sent.

7th June 

> **Question:**  The US15 does the listing and in US16 we are already responsing to one booking request. That said, were is the selection part being done?
>  
> **Answer:** In US15 the Agent gets a list of booking requests (made to him). Then, the agent, may want to respond to the user (as defined in US16). US15 and US16 are executed sequentially. Even so, the agent should be able to see a list of all booking requests made to him (US15) without answer any booking request. In US16 the agent selects the booking request.

9th June 

> **Question:** Should the email with the reply be sent as a file, for example txt, or should it be sent as an email?
> 
> **Answer:** You should send/write the e-mail message to a file named email.txt. All e-mails to be send should be written to this file. We will not use real world e-mail services and this file is used to replace the real world e-mail services.

> **Question:** What should be the difference between Gmail and Dei email service?
> 
> **Answer:** These services must be configured using a configuration file to enable using different platforms. Please study ESOFT and discuss these questions with your ESOFT teachers.

12th June

> **Question:** Regarding the AC4, it is stated "The response should include the property identification and location.". Is the property identification the same as the location? If not, how should we handle it in the legacy file since there isn't a specific column for each?
> 
> **Answer:** The response should include only the property location. US16 is not related with the legacy file!!! I think you have to study a little more ESOFT!

> **Question:** To send an email, we must have a configuration file with the data: host, port, user, password, in which, the host will have a URL or a path to the text file, or should we have only the host field?
> 
> **Answer:** In the configuration file you should only define the email service name (example: gmail) and the host address. The host address is a URI. As students did not take a course where they learn how to setup and use and email server, the URI to use is the path to the local email.txt file. All email messages must be written to this file.

### 1.3. Acceptance Criteria

**AC1:** The list of employee should be alphabetically sorted and grouped by store.


**AC2:** Stores should be sorted according to their property listings, from the one with more listings .


**AC3:** Each store should state how many property listings it has.

### 1.4. Found out Dependencies


* There could be a dependency in US002 since publishing a sale announcement would eventually require the listed properties to be shown.


### 1.5 Input and Output Data


**Input Data:**

* Typed data:
	* parish
    * price
* Selected data:
	* sale/rental
	* area
	* distance from center
	* price
	* property type
		* apartment
			* number of bedrooms
			* number of bathrooms
			* number of parking spaces
			* available equipment
		* house
			* number of bedrooms
			* number of bathrooms
			* number of parking spaces
			* available equipment
			* existence of a sun exposure
			* existence of a basement
			* existence of an inhabitable loft

**Output Data:**

* Listed properties that correspond to the inserted data or (by default) from most recently added.

### 1.6. System Sequence Diagram (SSD)

![System Sequence Diagram](svg/us013-system-sequence-diagram.svg)

### 1.7 Other Relevant Remarks