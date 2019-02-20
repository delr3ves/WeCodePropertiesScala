# WeCodePropertiesScala

Welcome to the Scala implementation of WeCodeFest's property based testing workshop.

## Working with the project

The most important thing you'll want to do with this project is just running the tests. To do so, you just have to execute:

```
sbt test
```

## Libraries: 

To implement this project, we'll use:
 * [ScalaTest](http://www.scalatest.org/) as the runner
 * [ScalaCheck](https://www.scalacheck.org/) for properties. In fact, we'll use the  [ScalaTest's integration of ScalaCheck](http://www.scalatest.org/user_guide/property_based_testing). For this reason we won't have access to the full list of features ScalaCheck would offer us.


## Branches:

This project contains a few branches in order to help you with irrelevant implementation details that could be time consuming but don't add any value to this Workshop.  

### Project scafolding:
Just a simple scafolding of a Scala project in order to run the tests 

```
git checkout scafolding
```

### Sum properties:
* sum-properties
* sum-properties-solved

### Know your tooling
* playing-with-library
* playing-with-library-solved

### Fibonacci properties:
* fibonacci-properties
* fibonacci-properties-solve

### Collection properties:
* collection-properties
* collection-properties-solve
