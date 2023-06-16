# US 002 - Publish a sale announcement

## 1. Requirements Engineering


### 1.1. User Story Description


As an agent, I can publish any sale announcement on the system, for example received through a phone call.


### 1.2. Customer Specifications and Clarifications 


**From the specifications document:**

> “Upon receiving the order, the agent sets the commission and publishes the offer in the system. The commission can be a fixed amount or a percentage. In the case of a request for the sale of a property, the owner must provide information on: the type of property (apartment, house or land), the area in m2, the location, the distance from the city center, the requested price and one or more photographs. If the property is an apartment or a house, the owner also provides: the number of bedrooms, the number of bathrooms, the number of parking spaces and the available equipment, such as central heating and/or air conditioning. In case the property is a house, the existence of a basement, an inhabitable loft, and sun exposure must be registered as well.”


> "The real estate agent reviews advertisement requests, registers the information in the system and publishes the offer so that it is visible to all clients who visit the agency and use the application."


**From the client clarifications:**

21st March

> **Question:** We are having a little issue defining what the sun exposure might be. We are not sure what it will be as a value. If it's a number that defines how much exposure the house has or if it is just a text saying if it has or hasn't sun exposure.
>  
> **Answer:** Sun exposure will take the following values: North, South, East, or West.


> **Question:** Is the phone call the only way the agent can receive the sale announcement? Or he can receive them via e-mail/letter/etc?
>  
> **Answer:** For now this is the only way.


> **Question:** How does the agent determine whether it is a fixed commission or a percentage commission?
> 
> **Answer:** The agent should choose the type of commission and enter the value.


> **Question:** Is the phone call the only way the agent can receive the sale announcement? Or he can receive them via e-mail/letter/etc
>
> **Answer:** For now this is the only way.

23rd March

> **Question:** The act of publishing a sale announcement means that the agent is publishing a new property for sale in the system (receiving the information of the seller and publishing the new property for sale) or is it the buyer giving positive feedback to the agent with intent to buy the property(actually closing a sale, buying a property and de-listing said property)?
>
> **Answer:** In US1 we get "As an agent, I can publish any sale announcement on the system, for example received through a phone call". Additional information related with this question is also avaliable in the project description. Asking the customer something that is clear or has already been clarified is unprofessional.


> **Question:** What would be the attributes of the Owner and Agent?
>
> **Answer:** The Owner attributes are: the name, the citizen's card number, the tax number, the address, the email address and the contact telephone number. The Agent is an employee of the company.


> **Question:** Is there a designated currency for this business, or should we use USD?
>
> **Answer:** Please use USD.


> **Question:** Should we consider that, until the request is reviewed and posted, the request stays in a "not published" state?
>
> **Answer:** This is an implementation detail. For me, as a client, I want the feature implemented as I already described in the project description.


> **Question:** When the request arrives at the agent, are all the essential characteristics of the property in question already present?
>
> **Answer:** Yes.


> **Question:** According to the Project Description, the agent when selling a property can charge a flat price comission or a percentage of the sale value, my question here is wether there is a minimum and/or a maximum to each of these types of comissions?
>
> **Answer:** There is no maximum and the minimum is 0.


> **Question:** So, my question is that, if this interpretation is correct, does the agent actually have two ways of publishing the sales announcement, one where he inputs everything directly with the owners assistance (owner goes to a company branch), and another where he just takes information already in the system, adds the commission data, and then publishes it as a sales announcement instead of a property listing.
>
> **Answer:** In US2 we get "As an agent, I can publish any sale announcement on the system, for example received through a phone call". This will be a feature/functionality of the system. The agent may receive the information by any means.


> **Question:** Does the owner who contacts the company provide the information during the call or is it just for setting up a meeting, "scheduling"?
>
> **Answer:** The owner provides the information. Where did you saw that the goal is "setting up a meeting"?????

24th April

> **Question:** Is it necessary to publish the owner atributes on the sale announcement?
>
> **Answer:** No.


> **Question:** About the agent comission. What is the value for the fixed amount comission? Is it the same for all agents?
>
> **Answer:** The commission is for the agency and for that given property.


> **Question:** If it's a property for lease is the comission value adjusted for the monthly value and contract duration? What is the value or method for calculating the comission?
>
> **Answer:** The commission is one value/percentage paid when the transaction is made.


> **Question:** In the case of listing a land property, shall the owner refer if there is a building permit already approved?
>
> **Answer:** No.


> **Question:** Is it mandatory for the agent to input the commission value before publishing an announcement?
>
> **Answer:** Yes.


> **Question:** Are there only 2 types of commission or can the Administrator define more types of commission?
>
> **Answer:** For now we only have two types of commissions.


> **Question:** When renting, does the owner have any space to clarify any prohibitions or obligations with the property?
>
> **Answer:** No.


> **Question:** Regarding the property’s photographs, is that considered selected data?
>
> **Answer:** The owner should input the URI of each file/photograph.

29th April

> **Question:** In one of the previous questions you have stated that for now the only way that a agent can receive the request to publish an announcement is through a phone call, however in the primary data necessary to create an announcement it's said that it's necessary to upload at least one photo of the property. Taking that into consideration, the announcement can't be fully made by only communicating with the owner through a phone call, how is it possible for an agent to publish an announcement without all the necessary data?
>
> **Answer:** The owner can send the photograph by e-mail or any other means. The owner can even deliver the photograph to the store.


> **Question:** Another doubt that has emmerged is related to the identification of the owner of the property, isn't it required that the owner identifies themselves in the announcement?
>
> **Answer:** Info about the owner is not published.


> **Question:** If so, should it be possible to change each value/detail on its own, or would the only options be to cancel or submit the request?
>
> **Answer:** If there are any errors, the application should allow the owner to correct the errors.


> **Question:** Also, since the only way that an agent can receive sale announcement request is through a phone call, wouldn't that contradict what was stated in the project description: "Owners go to one of the company's branches and meet with a real estate agent to sell or rent one or more properties, or they can use the company's application for the same purposes."?
>
> **Answer:** US2: As an agent, I can publish any sale announcement on the system, for example received through a phone call. For example...


> **Question:** In one of the previous questions you have stated that for now the only way that an agent can receive the sale announcement request is through a phone call. However, US004 states that "As an owner, I intend to submit a request for listing a property sale or rent, choosing the responsible agent". Isn't submitting a request for listing a property the same as a sale announcement request? If not, can you clarify?
>
> **Answer:** In my previous answer, when I said "...the only way that an agent can receive the sale announcement..." I was talking about the agent as an actor of the system that introduces in the system property data.

4th May

> **Question:** In USS02 are all the criteria for publishing the sale of a property in the system mandatory, or is there any data that the owner can choose not to give? such as not saying the direction of sun exposure in the case of a house.
>
> **Answer:** The number of bathrooms, the available equipment and the sun exposure are not mandatory. At least one photograph is required.


> **Question:** What are the attributes of an announcement? Should the announcement have a publication date, and a defined type of announcement embeded (sale or rent)?
>
> **Answer:** Please check the project description available in moodle. Please show the publication date.


> **Question:** When the agent receives the phone call (as mentioned in US002) is it the agent who registers the order in the system or has the order already been entered into the system by the owner? Or is the phone call just for the owner to tell the agent that he registered a request in the system?
>
> **Answer:** The agent registers the order in the system.

29th May

> **Question:** When the agent receives the phone call (as mentioned in US002) is it the agent who registers the order in the system or has the order already been entered into the system by the owner? Or is the phone call just for the owner to tell the agent that he registered a request in the system?
>
> **Answer:** The agent registers the order in the system.


> **Question:** Are the SMSs created the same way as the emails? The emails are made through a text file, are the SMS notifications the same way?
>
> **Answer:** A file named SMS.txt should be used.


> **Question:** Which number should be used to send the SMS, the responsible agent's number or the agency where the agent works?
>
> **Answer:** The responsible agent phone number.


### 1.3. Acceptance Criteria


* **AC1:** The user must be a real estate agent to proceed with a property registration.
* **AC2:** All required fields must be filled in.
* **AC3:** The property can't already exist in the system.


### 1.4. Found out Dependencies


* US3 - US2 needs the agent to exist


### 1.5 Input and Output Data


**Input Data:**

* Typed data:
    * Area in m2
    * Location
    * Distance from the city centre
    * Requested price
    * Number of bedrooms
    * Number of bathrooms
    * Number of parking spaces
    * Available equipment
    * Comission
	
* Selected data:
	* Type of property
    * Existence of a basement
    * Existence of an inhabitable loft
    * Sun exposure
    * Type of comission

* Other data:
    * One or more photographs


**Output Data:**

* All the data
* Success message


### 1.6. System Sequence Diagram (SSD)

![System Sequence Diagram](svg/us002-system-sequence-diagram.svg)

### 1.7 Other Relevant Remarks