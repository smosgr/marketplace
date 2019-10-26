## Description

Supermarket kata written as part of an interview process, following TDD and using the technologies I mention in the `Technologies/Tools` section. 
See `requirements.md` for requirements.



### -> Notes

- double / Double / BigDecimal:

```I decided to use Double to meet the requirements of the specification. BigDecimal was used to deal with the rounding of the total. ```


- The promotions will be applied on '001' products first and then the amount above 60.

```The promotions can be added or removed as per the decision of the cashier or manager. My assumption is that the 'over60' promotion will be considered first.```


- Open/closed principle:

``As per the open/closed principle of SOLID, the code can be extended when new functionality is needed. However the current functionality will stay as it is without affecting the old use cases.``

- No unused methods/namings:

``I have made a good cleanup and ensured that the principle of clean code is applied. So there are no unused methods and the naming of methods and variables are correct and descriptive. Also the 'CheckoutTest' class was cleaned up and structured correctly with the aim of using the test class as documentation.``


- Inheritance vs overloaded constructors:

``I have decided to overload the constructor instead of using inheritance for the promotions due to the small number of promotions (only 2). If different types of promotion need to be added, the PromotionRule class can become a base class and the overloaded constructors will be extracted to separate children classes. e.g. PromotionRule<-ItemPromotionRule, 
PromotionRule<-AmountPromotionRule``

- Separation of concerns:

``I have tried to organise the functionality as much as possible in order to avoid unreadable code and also aim for extendable code.``


### -> Running

1. Build: 
```
- gradle wrapper --gradle-version 5.1
- ./gradlew clean build
- ./gradlew test (optional)
```


2. Run: 
```
./gradlew run`
```


### -> Technologies/Tool
```
- IntelliJ IDEA 
- openJDK 12 (compatible with Java8 and upwards)
- Gradle
- JUnit 4.12
- Git
```
