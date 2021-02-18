<br />
<p align="center">
  <a href="https://github.com/mpx9411/RockPaperScissors">
  </a>

  <h3 align="center">RockPaperScissors</h3>

  <p align="center">
    Game of Rock Paper Scissors played via Spring REST API 
    <br />
    <a href="https://github.com/mpx9411/RockPaperScissors"><strong>Explore the docs »</strong></a>
    <br />
    <br />
    <a href="https://github.com/mpx9411/RockPaperScissors">View Demo</a>
    ·
    <a href="https://github.com/mpx9411/RockPaperScissors">Report Bug</a>
    ·
    <a href="https://github.com/mpx9411/RockPaperScissors">Request Feature</a>
  </p>
</p>



<!-- TABLE OF CONTENTS -->
<details open="open">
  <summary><h2 style="display: inline-block">Table of Contents</h2></summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#java">Java</a></li>
        <li><a href="#maven">Maven</a></li>
        <li><a href="#spring-boot">Spring Boot</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#roadmap">Roadmap</a></li>
    <li><a href="#contact">Contact</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project

This is my own implementation of a Rock Paper Scissors game that is played using requests in REST format.


### Built With

* IntelliJ IDEA Ultimate 2020
* Java 11
* Spring Boot 2.4.2
* Apache Maven 4.0.0

<!-- GETTING STARTED -->
## Getting Started

### Java

Java 11 or higher is required.

### Maven

Apache Maven 4.0.0 or higher is required.

### Spring Boot

Spring Boot 2.4.2 or higher is required.

### Installation

1. Clone the repo
   ```sh
   git clone https://github.com/mpx9411/RockPaperScissors.git
   ```
2. In project folder, start a command line and run 
   ```sh
   mvnw spring-boot:run
   ```
   Alternatively, run RockPaperScissors.jar using
   java -jar RockPaperScissors.jar


<!-- USAGE EXAMPLES -->
## Usage
Get info on active game using a string representing a UUID. (Example UUID: 2fab950f-52b7-4051-aeb2-9b52f81ac7f1)
```sh
$ curl localhost:8080/{2fab950f-52b7-4051-aeb2-9b52f81ac7f1}
```
Create new game with example player Bob.
```sh
$ curl --request POST -d "name=Bob" localhost:8080/games/
```
Join game as example player Alice.

```sh
$ curl --request POST -d "name=alice" localhost:8080/games/{2fab950f-52b7-4051-aeb2-9b52f81ac7f1}/join
```
Make move as example player Bob.

```sh
$ curl --request POST -d "name=bob&move=ROCK" localhost:8080/games/{2fab950f-52b7-4051-aeb2-9b52f81ac7f1}/move
```


Magnus Palmstierna - olemagnuspalmstierna@gmail.com

Project Link: [https://github.com/github_username/repo_name](https://github.com/mpx9411/RockPaperScissors)
