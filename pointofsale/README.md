Spring Integration AMQP & WS Point Of Sale Application
================================================================================

The purpose of this project is provide a 2 REST controllers to handle POST http request that 
simulate grocery shopping baskets.
The intention is to demonstrate the sequential/transactional nature of a typical web service and
the parrallel nature of a messaging service such as Rabbit AMQP

Basket.XML is a simple file which contains a sample transaciton header and can be posted to both REST controllers
using the following CURL commands: 

--------------------------------------------------------------------------------
curl -X POST -H "Content-Type: application/json" -d @basket.json http://localhost/pointofsale/amqprest/basket

curl -X POST -H "Content-Type: application/xml" -d @basket.xml http://localhost/pointofsale/wsrest/basket