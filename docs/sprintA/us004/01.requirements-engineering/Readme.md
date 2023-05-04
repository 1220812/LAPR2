# US 004

## 1. Requirements Engineering


### 1.1. User Story Description

As an owner, I intend to submit a request for listing a property sale or rent, choosing the responsible agent.


### 1.2. Customer Specifications and Clarifications 


**From the specifications document:**

> Owner can use the application to sell or rent one or more properties
> The owner must provide property characteristics and the requested price
> The request is sent to an agent of their choosing

> If the owner wants to sell a property, he must provide information about the type of property (apartment, house or land), the area (m2), localization, distance from city centre, price and photos

> For apartments and houses, the owner must also provide the number of bedrooms, bathrooms and parking spaces, as well as any available equipment (central heating and/or air conditioning)

> For houses the owner must additionally register the existence of a basement, inhabitable loft and also register sun exposure

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


> **Question:** Does that imply that a seller can choose the agency/branch/store independently of the localization of the property?
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


* **AC1:** All required files must be filled in.
* **AC2:** When listing a property with an already existing property listed, the system must reject such operation and the user must have the change to modify the typed information.


### 1.4. Found out Dependencies


* There is no dependency to any other US.


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
		* one or more photographs URL

		* Additional Data for apartment or a house:
			* the number of bedrooms
			* the number of bathrooms
			* the number of parking spaces
			* the available equipment (central heating and/or air conditioning)

		* Additional Data for house:
			* the existence of a basement
			* an inhabitable loft
			* sun exposure

* Selected data:
	* Listing options (rent or sale)
	* The type property (apartment, house or land)
	* The Agency
	* The Agent


**Output Data:**
* Listing options (rent or sale)
* Type of properties (apartment, house or land)
* List of Agencies
* List of Agents
* (In)Success of the operation

### 1.6. System Sequence Diagram (SSD)

**Other alternatives might exist.**

#### Property Rent

![System Sequence Diagram - Rent](svg/us004-system-sequence-diagram-rent-System_Sequence_Diagram__SSD____Rent_Property.svg)

#### Property Sell

![System Sequence Diagram - Sell](svg/us004-system-sequence-diagram-sell-System_Sequence_Diagram__SSD____Sell_Property.svg)

### 1.7 Other Relevant Remarks

* There are no other relevant remarks.