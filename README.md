# animal-shop

[![Build Status](https://travis-ci.com/mlehotsky13/animal-shop.svg?branch=main)](https://travis-ci.com/mlehotsky13/animal-shop) [![Codacy Badge](https://app.codacy.com/project/badge/Grade/bf8fcbac083048de8d89bd26f2d8fd95)](https://www.codacy.com/gh/mlehotsky13/animal-shop/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=mlehotsky13/animal-shop&amp;utm_campaign=Badge_Grade)

Backend service for eshop selling animal products.

## Building
Run `./gradlew clean build`
  - in `build/libs` subfolder runnable and deployable fat jar `app.jar` will be created

## Running
For local run, use `java -jar -Dspring.profiles.active=local app.jar`
  - mongodb service needs to be running on default port `27017`

## API documentation
To see API documentation, visit: `/swagger-ui.html` endpoint.
