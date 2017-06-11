# raster-poc

Has a Order and Payment service. 

## Order 
Exposes /order endpoint which is used to create Order

Order Json
```json
{
  "orderId": 100,
  "customerFirstName" : "Palanivelrajan",
  "customerLastName" : "Balasubramanian",
  "customerEmail" : "praveen12bnitt@gmail.com",
  "customerPhoneNumber" : "xxx-xxx-xxxx",
  "orderLineList" : [ {
  	"orderLineId" : 1,
    "item" : "pants",
    "itemDesc" : null,
    "quantity" : 1.0,
    "unitPrice" : 19.99
  } ],
  "paymentInfo" : {
  	"cardType" : "VISA",
  	"cardNumber" : "123456789"
  }
}
```


## Payment
Exposes /payment endpoint which saves and will process payment for a given order.
