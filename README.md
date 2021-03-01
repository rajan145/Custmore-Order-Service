# Custmore-Order-Service

# Start Application:

    1. Start Wiremock Server using below command in your WireMockServer Directory
        java -jar wiremock-standalone-2.27.2.jar  -port 8081

    2. Start Application Using
        mvn install



# WireMock Server
    WireMock Server will mock below API's
    1. IndexSerach Server
    - search/customer/

    2. Order Service
    - /order/{orderId}

    3. Catalog Service
    - /catalog/sku/{skuId}
    - /catalog/hardsku/{skuId}


# Custmore-Order-Service
    Expose below API's
    1. Get Order summaries

        GET "{customerId}/orderSummary"

        Exmaple: http://localhost:8080/user134/orderSummary

        [
            {
           "orderId": "198772",
            "status": "ordered",
            "items": [
                        {
                            "name": "IPhone XR",
                            "color": "Yellow",
                            "size": "64 GB",
                            "planName": "AT&T Unlimited Extra",
                            "shippingDate": "2020-09-06T13:39:52.774-05:00",
                            "arrivaleDate": "2020-09-06T13:39:52.774-05:00",
                            "status": "ordered",
                            "quntity": 1
                        },
                        {
                            "name": "IPhone XR",
                            "color": "Yellow",
                            "size": "64 GB",
                            "planName": "AT&T Unlimited Extra",
                            "shippingDate": "2020-09-06T13:39:52.774-05:00",
                            "arrivaleDate": "2020-09-06T13:39:52.774-05:00",
                            "status": "ordered",
                            "quntity": 1
                        }
                    ],
            "shippingStatus": "ordered"
            }
        ]


    2. GET order details for orderId

        GET  {customerId}/order/{orderId}

        Example:

            http://localhost:8080/user134/order/198772

        {
        "orderId": "198772",
        "customerId": "user134",
        "status": "ordered",
        "compelete": false,
        "shipingAddress": {
            "street": "437 Lytton",
            "city": "Palo Alto",
            "state": "CA",
            "zip": "94301"
        },
        "orderItem": [
                        {
                        "name": "Apple Iphone XR",
                        "planId": "skup1234",
                        "quantity": 1,
                        "telephoneNumber": "409.406.3322",
                        "status": "ordered",
                        "skuId": null,
                        "complete": true,
                        "estimatedShipDateRange": {
                        "fromDate": "2020-09-06T13:39:52.774-05:00",
                        "toDate": "2020-09-06T13:39:52.774-05:00"
                        },
                        "newEstimatedShipDateRange": {
                        "fromDate": "2020-09-06T13:39:52.774-05:00",
                        "toDate": "2020-09-06T13:39:52.774-05:00"
                        },
                        "userAcceptedDelay": true,
                        "delayAcceptedDate": null,
                        "hardCatalog": {
                        "type": "plan",
                        "name": "AT&T Unlimited Extra",
                        "model": "IPhone XR",
                        "manufacturer": "Apple",
                        "color": "Yellow",
                        "size": "64 GB",
                        "id": "sku1234"
                        },
                        "id": "100000"
                        },
                         {
                        "name": "Apple Iphone 11",
                        "planId": "skup1234",
                        "quantity": 1,
                        "telephoneNumber": "409.406.3322",
                        "status": "ordered",
                        "skuId": null,
                        "complete": true,
                        "estimatedShipDateRange": {
                        "fromDate": "2020-09-06T13:39:52.774-05:00",
                        "toDate": "2020-09-06T13:39:52.774-05:00"
                        },
                        "newEstimatedShipDateRange": {
                        "fromDate": "2020-09-06T13:39:52.774-05:00",
                        "toDate": "2020-09-06T13:39:52.774-05:00"
                        },
                        "userAcceptedDelay": true,
                        "delayAcceptedDate": null,
                        "hardCatalog": {
                        "type": "plan",
                        "name": "AT&T Unlimited Extra",
                        "model": "IPhone XR",
                        "manufacturer": "Apple",
                        "color": "Yellow",
                        "size": "64 GB",
                        "id": "sku1234"
                        },
                        "id": "100001"
                        }
                       ],
        "shipments": null
        }


        if order is shipped then it will group by the Itmes by shipment ID

        {
        "orderId": "198772",
        "customerId": "user134",
        "status": "shipped",
        "compelete": false,
        "shipingAddress": {
                            "street": "437 Lytton",
                            "city": "Palo Alto",
                            "state": "CA",
                            "zip": "94301"
                            },
        "orderItem": null,
        "shipments": [
        {
            "items": [
                    {
                        "name": "Apple Iphone XR",
                        "planId": "skup1234",
                        "quantity": 1,
                        "telephoneNumber": "409.406.3322",
                        "status": "ordered",
                        "skuId": null,
                        "complete": true,
                        "estimatedShipDateRange": {
                        "fromDate": "2020-09-06T13:39:52.774-05:00",
                        "toDate": "2020-09-06T13:39:52.774-05:00"
                        },
                        "newEstimatedShipDateRange": {
                        "fromDate": "2020-09-06T13:39:52.774-05:00",
                        "toDate": "2020-09-06T13:39:52.774-05:00"
                        },
                        "userAcceptedDelay": true,
                        "delayAcceptedDate": null,
                        "hardCatalog": {
                        "type": "plan",
                        "name": "AT&T Unlimited Extra",
                        "model": "IPhone XR",
                        "manufacturer": "Apple",
                        "color": "Yellow",
                        "size": "64 GB",
                        "id": "sku1234"
                        },
                        "id": "100000"
                    },
                    {
                        "name": "Apple Iphone 11",
                        "planId": "skup1234",
                        "quantity": 1,
                        "telephoneNumber": "409.406.3322",
                        "status": "ordered",
                        "skuId": null,
                        "complete": true,
                        "estimatedShipDateRange": {
                        "fromDate": "2020-09-06T13:39:52.774-05:00",
                        "toDate": "2020-09-06T13:39:52.774-05:00"
                        },
                        "newEstimatedShipDateRange": {
                        "fromDate": "2020-09-06T13:39:52.774-05:00",
                        "toDate": "2020-09-06T13:39:52.774-05:00"
                        },
                        "userAcceptedDelay": true,
                        "delayAcceptedDate": null,
                        "hardCatalog": {
                        "type": "plan",
                        "name": "AT&T Unlimited Extra",
                        "model": "IPhone XR",
                        "manufacturer": "Apple",
                        "color": "Yellow",
                        "size": "64 GB",
                        "id": "sku1234"
                        },
                        "id": "100001"
                        }
                        ],
                        "carrier": "USPS",
                        "trackingNumber": "9400100000000000000000",
                        "trackingUrl": "https://tools.usps.com/go/TrackConfirmAction?tRef=fullpage&tLc=2&text28777=&tLabels=9400100000000000000000%2C",
                        "estimatedDeliveryDate": "2020-10-06T13:39:52.774-05:00",
                        "shipDate": "2020-10-02T13:39:52.774-05:00",
                        "id": "1"
                    }
                    ]
        }


        3. Get Latest Order Summary

        GET {customerId}/orderSummary/latest"

        Example:
        http://localhost:8080/user134/orderSummary/latest

        {
                "orderId": "198772",
                "status": "shipped",
                "items": [
                            {
                            "name": "IPhone XR",
                            "color": "Yellow",
                            "size": "64 GB",
                            "planName": "AT&T Unlimited Extra",
                            "shippingDate": "2020-09-06T13:39:52.774-05:00",
                            "arrivaleDate": "2020-09-06T13:39:52.774-05:00",
                            "status": "ordered",
                            "quntity": 1
                            },
                            {
                            "name": "IPhone XR",
                            "color": "Yellow",
                            "size": "64 GB",
                            "planName": "AT&T Unlimited Extra",
                            "shippingDate": "2020-09-06T13:39:52.774-05:00",
                            "arrivaleDate": "2020-09-06T13:39:52.774-05:00",
                            "status": "ordered",
                            "quntity": 1
                            }
                         ],
                    "shippingStatus": "shipped"
        }

