# WeCodePropertiesScala ![Build Status](https://travis-ci.org/delr3ves/WeCodePropertiesScala.svg?branch=master)

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

### Sum properties (15'):
In this branch, you'll find the definition of each test we'll need to implement in order to test a sum. 
Just find the test in [WeCodePlaygroundSpec.scala](src/test/scala/com/emaginalabs/wecodeproperties/WeCodePlaygroundSpec.scala)

```
git checkout sum-properties
```
In case you want solved exercises:
```
git checkout sum-properties-solved
```

### Know your tooling (15')
It's time to know about the internals of the library, so we'll just play with the tool.
Just find the test in [PlayingWithLibrarySpec.scala](src/test/scala/com/emaginalabs/wecodeproperties/PlayingWithLibrarySpec.scala)

```
git checkout playing-with-library
```

```
git checkout playing-with-library-solved
```

### Fibonacci properties (5'):
What do you think is the main property fibonacci should keep? 
Find the test in [FibonacciSpec.scala](src/test/scala/com/emaginalabs/wecodeproperties/FibonacciSpec.scala)

```
git checkout fibonacci-properties
```
```
git checkout fibonacci-properties-solved
```

### Collection properties (20'):
Lets find the main properties every collection should keep  
Find the test in [CollectionsSpec.scala](src/test/scala/com/emaginalabs/wecodeproperties/CollectionsSpec.scala)

```
git checkout collection-properties
```
```
git checkout collection-properties-solved
```

### Kata Maxibon 

The kata definition can be found in the original repo: [https://github.com/delr3ves/MaxibonKataScala](https://github.com/delr3ves/MaxibonKataScala) 

```
git checkout maxibon-kata
```
```
git checkout maxibon-kata-implemented
```

