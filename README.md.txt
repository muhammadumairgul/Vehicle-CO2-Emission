

This task has a number of functional requirements that are listed below. 

CO2 data
For the calculation, please use the following average values.
Transportation methods in CO2e per passenger per km:
Small cars:
small-diesel-car : 142g
small-petrol-car : 154g
small-plugin-hybrid-car : 73g
small-electric-car : 50g
Medium cars:
medium-diesel-car : 171g
medium-petrol-car : 192g
medium-plugin-hybrid-car : 110g
medium-electric-car : 58g
Large cars:
large-diesel-car : 209g
large-petrol-car : 282g
large-plugin-hybrid-car : 126g
large-electric-car : 73g
bus : 27g
train : 6g

Source: BEIS/Defra Greenhouse Gas Conversion Factors 2019 Acceptance Criteria

Functional requirements:
The tool can be called with a numeric distance , a unit-of-distance (kilometer km or meter m ) and a transportationmethod

$ ./co2-calculator --transportation-method medium-diesel-car --distance 15 --unit-of-distance km
Your trip caused 2.6kg of CO2-equivalent.

The default value for unit is kilometer km .
$ ./co2-calculator --distance 1800.5 --transportation-method large-petrol-car
Your trip caused 507.7kg of CO2-equivalent.

The output shows the amount of CO2-equivalent in kilogram kg or gram g .
$ ./co2-calculator --transportation-method train --distance 14500 --unit-of-distance m
Your trip caused 87g of CO2-equivalent.

$ ./co2-calculator --transportation-method train --distance 14500 --unit-of-distance m --output kg
Your trip caused 0.1kg of CO2-equivalent.

Named parameters can be put in any order and either use a space ( ) or equal sign ( = ) between key and value.
$ ./co2-calculator --unit-of-distance=km --distance 15 --transportation-method=medium-diesel-car
Your trip caused 2.6kg of CO2-equivalent.


Execution: 
use com.vehicle_emission as package for this program
*. The tool first show the given CO2 emission relative to Transportation mode.
*. Followed by request for Functional Requirement query.
*. It is important to have --transportation-method and --distance in the query. Otherwise it will prompt to enter query again.
*. End the program with any number other than 1.
