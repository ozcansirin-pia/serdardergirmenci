#Vodafone Car 
To run the application, cd into the `Vodafone-car` folder and run:
```bash
mvn spring-boot:run
```

#Request
<b>Request url :</b> /produce-car
<br>
<b>Request Method :</b> Post
<br>
<b>Required parameter (form-data) :</b> `car_type` (Options : Cabrio, Hatchback, Sedan)

#Postman
You can use the Vodafone.postman_collection.json file to make a request via Postman.

#Test
There are 2 test classes named "ProduceCarTest" and "CarFactoryTest" in the Vodafone-car project.
