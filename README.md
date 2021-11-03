# Geolocation_REST_API

## Table of Contents
* [General Information](#general-information)
* [Technologies Used](#technologies-used)
* [Functions](#functions)
* [How to use](#how-to-use)
* [Contact](#contact)

## General Information

Rest application that allows you to save and receive information about the positions of a device.


## Technologies Used
- JDK 11
- Spring(Security, Boot, Data JPA, MVC)
- Lombok


## Functions

GET http://localhost:8080/api/geolocation/device - get all devices

GET http://localhost:8080/api/geolocation/device/{id} - get device with given id

POST http://localhost:8080/api/geolocation/addDevice - create new device

GET http://localhost:8080/api/geolocation/positions - get all positions

GET http://localhost:8080/api/geolocation/position/{id} - get position with given id

POST http://localhost:8080/api/geolocation/addPosition - create new position


## How to use
$ git clone https://github.com/LukaszStojecki/Geolocation_Rest_Api

$ cd geolocation_rest_api

$ mvn spring-boot:run


## Contact
Created by [lukasz.stojecki@o2.pl] - feel free to contact me!

