# US 004 - Readme

## 1. Requirements Engineering

### 1.1. User Story Description

As an owner, I intend to submit a request for listing a property sale or rent, choosing the responsible agent.


### 1.2. Customer Specifications and Clarifications 


**From the specifications document:**

 From time to time, property owners contact Real Estate USA with the aim of selling or renting their
properties. Owners go to one of the company's branches and meet with a real estate agent to sell or
rent one or more properties, or they can use the company's application for the same purposes. The
owner provides property characteristics and the requested price and sends the request to an agent.
 
In the case of a request for the sale of a property, the owner must provide information on: the type of property (apartment, house or land),
the area in m2, the location, the distance from the city centre, the requested price and one or more
photographs. 
 
If the property is an apartment or a house, the owner also provides: the number of
bedrooms, the number of bathrooms, the number of parking spaces and the available equipment,
such as central heating and/or air conditioning. 
 
In case the property is a house, the existence of a
basement, an inhabitable loft, and sun exposure must be registered as well.

**From the client clarifications:**

> **Question:** We are having a little issue defining what the sun exposure might be. We are not sure what it will be as a value. If it's a number that defines how much exposure the house has or if it is jusr a text saying if it has or hasn't sun exposure.
>  
> **Answer:** Sun exposure will take the following values: North, South, East or West.


> **Question:** In the Project description, there are only specifications for a sale. What are the required characteristics for a rental?
>  
> **Answer:** The characteristics for a rental are the same as the ones for the sale of a property. The rent value is per month. Additionally, we have to define the contract duration.


> **Question:** Are there any restrictions on the choice of an Agent
>
> **Answer:** No


> **Question:** In case the submission of the listing is online may the owner choose any agent?
>
> **Answer:** Yes.


> **Question:** Is it possible to submit multiple listing for the same property and type of listing?
>
> **Answer:** No


> **Question:** Does that imply that a seller can choose the agency/branch/store independently of the location of the property?
>
> **Answer:** Yes


> **Question:** Also another question, when publishing a property, if the owner leaves the listing unfinished, can it be saved or stay as a sketch to be finished later?
>
> **Answer:** No


> **Question:** When assigning an agent to a property listing, are the available agents shown by the system for the owner to pick? Or does the owner need to provide the agent's information (name, agency, etc)?
>
> **Answer:** The owner should select one agent from a list of agents that work in the selected agency. The owner should select the agency before selecting the agent.


> **Question:** Does an owner need to be registered in the system to submit a request for a property listing?
> 
> **Answer:** No. When making the request to list a property, the owner should introduce his own data. The Owner attributes are: the name, the citizen's card number, the tax number, the address, the email address and the telephone number.


> **Question:** Is there a designated currency for this business, or should we use USD?
>
> **Answer:** Please use USD.


> **Question:** In the case of listing a land property, shall the owner refer if there is a building permit already approved?
> **Answer:** No.


> **Question:** If the owner doesn't select an agent will the platform randomly assign one or the request cannot move to revision? If not, must we assume that all information slots must be filled?
> 
> **Answer:** When filling the property data, the owner should select one agent from the list of agents working in the selected agency. Moreover, the application should include a feature to randomly assign one agent. The address of the owner is not mandatory.


> **Question:** When renting does the owner have any space to clarify any prohibitions or obligations with the property?
> 
> **Answer:** No.


> **Question:** Does the owner have a limit of requests they can do?
> 
> **Answer:** No.


> **Question:** Regarding the property's photographs, is that considered selected data?
> 
> **Answer:** The owner should input the URI of each file/photograph.
 
> **Question:** Also, since the only way that an agent can receive sale announcement request is through a phone call, wouldn't that contradict what was stated in the project description: "Owners go to one of "
> 
> **Answer:** 
### 1.3. Acceptance Criteria

* **AC1**: All required files must be filled in.
* **AC2**: Must be provided the type of property.
* **AC3**: The area must be in m^2.
* **AC4**: The location and the distance from the city centre must be known.
* **AC5**: Must have the requested price and one or more photographs.
* **AC6**: The photos must be in URI format.
* **AC7**: The prices must be in USD currency.


### 1.4. Found out Dependencies


* There is dependency to the "US3 - register an employee" since that has to be, at least one employee to review the advertisement request, the "US5-register a store" since that has to be , at least, one store (agency) to be selected by the owner, to the "US6-specify states, districts and cities in the System" since that the property listed by the owner has an address (is in a state, in a district and in a city) and to the "US7 -  want to register in the system to buy, sell or rent
  properties."


### 1.5 Input and Output Data


**Input Data:**

* Typed data:
	* Owner data:
		* the name
		* the citizen's card number
		* the tax number
		* the address
		* the email address
		* the telephone number

	* Property Data:
		* the area in m2
		* the address
		* the distance from the city centre
		* the requested price
		* one or more photographs in URI

		* Additional Data for apartment or a house:
			* the number of bedrooms
			* the number of bathrooms
			* the number of parking spaces
			* the available equipment:
               * central heating
               * air conditioning

		* Additional Data for house:
			* the existence of a basement
			* an inhabitable loft

* Selected data:
	* Listing options (rent or sale)
	* The type property (apartment, house or land)
	* The Agency
	* The Agent
    * Sun exposure


**Output Data:**
* Listing options (rent or sale)
* Type of properties (apartment, house or land)
* List of Agencies
* List of Agents
* (In)Success of the operation

### 1.6. System Sequence Diagram (SSD)

![System Sequence Diagram - Rent](svg/us004-system-sequence-diagram.svg)

### 1.7 Other Relevant Remarks

* There are no other relevant remarks.