# jumia-task
Jumia exercise is a application built using spring boot for backend and Thymeleaf as a template engine for front end . <br />
## Note : 
After I have submitted excersise I have noticed that you mentioned in attached pdf create a single page application and framework allowed ,so <br />
I developed another version using Angualr framework for frontend you can find spring boot and angular version through repository link : 
[spring boot & angular excercise](https://github.com/mina-bedier/jumia-task-springboot-angular.git) . <br />

current repository for spring boot and Thymelead version.

## Prerequisite:

Notes : I tried many times to push image to my Dockerhub repo account to make it easy for you to pull image and run it directly , <br /> 
but it was failed due to connections errors (time out) ,I will work on it till it work 
and I will update README file once it's done , so for this moment follow below steps to run app <br />

jumia-app --> app.jar + sample.db

 1-Having docker installed on your machine <br />
 2-Clone project. <br />
 3-Change directory to cloned project where Docker file exist. <br />
 4-Then run below commands in the directory where docker file exist. <br />

## Create Docker image from Dockerfile:
```bash
path/to/Dockerfile > docker build -t jumiatask .
```

## Run docker container from docker image:
```bash
docker run -p8882:8081 jumiatask
```

## Navigate to following URL:
```bash
http://localhost:8882/jumia/search
```


