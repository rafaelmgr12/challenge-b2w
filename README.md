# Challenge B2W BIT
Challenge proposed by the [B2W](https://github.com/b2w-marketplace/challenge-backend). 

## 1. First Task
The first task was built a rest Service that use this Order API([link](http://www.mocky.io/v2/5817803a1000007d01cc7fc9)) and, based on the result, filters by data according to he parameters sent by HTTP request. The service must follow this definition:

**Request**
```
GET http://localhost:8080/challenge-backend/item?begindate=05-10-2016&finaldate=10-10-2016

```
**Response**
```json
[
  {
    "name": "Impressora",
    "code": "5",
    "date": "2016-10-05T14:30:37.040Z",
    "dimension": {
      "weight": 10.5,
      "height": 10.5,
      "width": 10.5,
      "length": 10.5
    }
  },
  {
    "name": "Fifa2017",
    "code": "6",
    "date": "2016-10-06T14:30:37.040Z",
    "dimension": {
      "weight": 10.5,
      "height": 10.5,
      "width": 10.5,
      "length": 10.5
    }
  },
  .
  .
  .
]
```
## About the project
It is a Spring Boot based application exposing a REST API to get orders filters by data.
### Technology
The application is based on the following project:
* Spring boot 2.7.3
* Maven 3.8.1
* Java 17 

## How to run 
There are two option to run this application. The firs is using the Maven and Java installed Locally on your machine.

1. Clone the repo :
  ``` bash
  git clone git@github.com:rafaelmgr12/challenge-b2w.git
 ```
2. Use the Maven to run the following command:
```bash
mvn spring-boot:run
```
The other option using the docker. To do containerization with Docker, you need to build the application in a jar package. Therefore, we can run the following commands to upload the container: 
1. `docker build -f .\Dockerfile -t challenge-b2w:api .`
2. `docker run -p 8080:8080 -d challenge-b2w:api `

At the end, we can access the answer of the first task in the following **Request**
```
http://localhost:8080/challenge-backend/item?begindate=05-10-2016&finaldate=10-10-2016
```

# 2. Second Task
Given a table of events with the following structure: 
```sql
create table events (
  event_type integer not null,
  value integer not null,
  time timestamp not null,
  unique (event_type, time)
);
```
write an SQL (MySQL) query that, for each event_type that has been registered more than once,
returns the difference between the penultimate and the oldest value (in terms of time) . The table
should be ordered by event_type (in ascending order).
For example, given the following data:

|event_type  | value  | time                |
|----------- | -----  | -------------------
|2           | 5      | 2015-05-09 12:42:00 |
|4           | -42    | 2015-05-09 13:19:57 |
|2           | 2      | 2015-05-09 14:48:30 |
|2           | 7      | 2015-05-09 12:54:39 |
|3           | 16     | 2015-05-09 13:19:57 |
|3           | 20     | 2015-05-09 15:01:09 |


Your query should return the following rowset:

|event_type | value |
|---------- | -----
|2          | 2     |
|3          | 0     |

For example, for the event_type 2, the penultimate value is a 7 and the oldest value is 5, so the
difference between them is 2.
The name of the columns in the rowset don’t matter, but their order does.

## Solution
The query that solves this tasks is:
```sql
select o.event_type, 
((select value from events pen where o.event_type = pen.event_type order by time desc limit 1,1)- (o.value)) value
from events o
where o.time = (select min(time) from events aux  where aux.event_type = o.event_type)
and 1 < (select count(1) from events aux where aux.event_type = o.event_type)
order by o.event_type asc;

```
