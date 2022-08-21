# Bank_Rest_Api
## Core Banking System Rest Api / JAVA + JAVA SPRING BOOT

I just uploaded the src of my code so you can check quality and my coding style.

The time i took on the creation of the whole project was 2:50 mins + 20 mins reading libraries.

The idea of this project is to use Postman or a similar platform to interact with the database. Many of my functions are explained within the code.

It starts with the creation of the costumer:
Use Postman or similar app to send requests.

We will start the request using     **localhost:8080/customer**

**POST**
/customer
```
{
     "acctID": "1",
	"custName": "Daniel",
	"city": "Terrassa",
	"state": "Barcelona",
	"country": "Spain",
	"phoneNo": "623134",
	"password": "daniel3"
}
```

For the next customer you will have to change the ID, copy this example:
```
{
     "acctID": "2",
	"custName": "Laura",
	"city": "Vigo",
	"state": "Pontevedra",
	"country": "Spain",
	"phoneNo": "32156",
	"password": "Laura2"
}
```

**GET** for this request type you have to use the Get type and the id of the customer or customer's account  

- this request will get the information of a specific customer ------  **localhost:8080/customer/{acctID}**   

- this request will get the balance information of a specific customer's account ------ **localhost:8080/account/{acctID}/balance**   

- this request will get the information of a specific account ------ **localhost:8080/account/{acctID}**

- this request will get the information of the transaction history of the customer ------ **localhost:8080/account/{acctID}/logs**

**DELETE** for this type of request:

- this request will delete the customer information and the customer's account ------ **localhost:8080/customer/{acctID}**   

- this request will delete the customer's account ------ **localhost:8080/account/{acctID}**


**PUT** for this type of request:

- this request will deposit an amount into the customer's account of your choice ------ **localhost:8080/account/{acctID}/deposit/{amount}**  

- this request will withdraw an amont from the customer's acount of your choice  ------ **localhost:8080/account/{acctID}/withdraw/{amount}**  

- this request will transfer an amount from the customer's account to another one of your choice ------ **localhost:8080/account/{acctID}/transfer/{destAcctID}/{amount}**
