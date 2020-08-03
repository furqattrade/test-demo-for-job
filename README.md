
# test-demo-for-job
1. posting record:
path:http://localhost/monitor
method:POST
payload: 
{
    "customer":1, //(user id default added by data.sql)
    "service":2,  //(there are 3 services: gas(id:1), cold water(id:2),hot water(id:3)
    "usageOfResource":4, //(in units)
    "payment":800
}
response:
{
    "customerName": "furqat",
    "customerID": 1111,
    "currentBalance": 720.0,
    "serviceName": "cold water"
}
2.getting all recors of customer
path:http://localhost/monitor/{userID}
method:GET
pathvariable: userID 
response:
[
    {
        "customerID": 1,
        "customerName": "furqat",
        "serviceName": "hot water",
        "measurementUnit": "kilograms per cubic metre",
        "costPerUnit": 30.0,
        "paymentDate": "2020-07-29",
        "paymentAmount": 800,
        "debt": 680.0
    },
    {
        "customerID": 2,
        "customerName": "furqat",
        "serviceName": "gas",
        "measurementUnit": "kilograms per cubic metre",
        "costPerUnit": 10.0,
        "paymentDate": "2020-07-29",
        "paymentAmount": 800,
        "debt": 760.0
    },
    {
        "customerID": 3,
        "customerName": "furqat",
        "serviceName": "cold water",
        "measurementUnit": "kilograms per cubic metre",
        "costPerUnit": 20.0,
        "paymentDate": "2020-07-29",
        "paymentAmount": 800,
        "debt": 720.0
    }
]
Thank you!
