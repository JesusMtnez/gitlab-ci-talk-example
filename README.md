# "GitLab CI: Automation with Docker" Talk Example

- **Author**: [JesusMtnez](https://jesusmtnez.gitlab.io/)
- **Date**: March 16, 2017
- **Event**: [TryIT! 2017](http://tryit.fi.upm.es/activities/#/125)
- **Slides**: https://goo.gl/vUhKDE

## Description

This repository contains a simple project in Scala with using SBT and Akka HTTP that has been automated in a CI / CD pipeline using GitLab CI.

## Application

### Akka HTTP service example

This project demonstrates the [Akka HTTP](http://doc.akka.io/docs/akka-stream-and-http-experimental/current/scala.html) library and Scala to write a simple REST (micro)service. The project shows the following tasks that are typical for most Akka HTTP-based projects:

* starting standalone HTTP server,
* handling file-based configuration,
* logging,
* routing,
* deconstructing requests,
* unmarshalling JSON entities to Scala's case classes,
* marshaling Scala's case classes to JSON responses,
* error handling,
* issuing requests to external services,
* testing with mocking of external services.

The service in the template provides two REST endpoints - one which gives GeoIP info for given IP and another for calculating geographical distance between given pair of IPs. The project uses the service [ip-api](http://ip-api.com/) which offers JSON IP and GeoIP REST API for free for non-commercial use.

#### Usage

Start services with sbt:

```
$ sbt
> ~re-start
```

With the service up, you can start sending HTTP requests:

```
$ curl http://localhost:9000/ip/8.8.8.8
{
  "city": "Mountain View",
  "query": "8.8.8.8",
  "country": "United States",
  "lon": -122.0881,
  "lat": 37.3845
}
```

```
$ curl -X POST -H 'Content-Type: application/json' http://localhost:9000/ip -d '{"ip1": "8.8.8.8", "ip2": "93.184.216.34"}'
{
  "distance": 4347.624347494718,
  "ip1Info": {
    "city": "Mountain View",
    "query": "8.8.8.8",
    "country": "United States",
    "lon": -122.0881,
    "lat": 37.3845
  },
  "ip2Info": {
    "city": "Norwell",
    "query": "93.184.216.34",
    "country": "United States",
    "lon": -70.8228,
    "lat": 42.1508
  }
}
```

#### Testing

Execute tests using `test` command:

```
$ sbt test
```

## Author & license

This project is based on https://github.com/theiterators/akka-http-microservice

For licensing info see [LICENSE](/LICENSE.md) file in project's root directory.
