Additional Requirement solution:
	For implement this search, I would implement inside the loan-application-service micro service, once the entities and repositories that I need are located there. 
	First of all I would set the request in the model package, containing the maxAmount, minAmount and status. Inside the repository interface of Loan, an method of
	search should be implemented using the notation @Querry, in other to retrieve the data according to the parameters. Finally, inside the package “config”, the service 
	implementation will be implemented in order to process the data that the querry retrieve, and parse to the response. Finally, create a method get in the controller, 
	in order to call his search method.
