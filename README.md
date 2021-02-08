# Coding Challenge Svama

## Content

To start with, we provide as part of this repository:


```
.
├── auth
    Default Port: 9180
    To start use: mvn spring-boot:run
├── eureka
    Default Port: 8761
    To start use: mvn spring-boot:run
└── customer-service
    Default Port: 9181
    To start use: mvn spring-boot:run
└── loan-application-service
    Default Port: 9182
    To start use: mvn spring-boot:run
└── gateway
    Default Port: 9080
    To start use: mvn spring-boot:run


```

## Database

```
	The database was externalized, to an AWS MySQL Database, and it is up and initialized with data for test scenario. The credentials can be found in the application properties files, in any of microservices.
```