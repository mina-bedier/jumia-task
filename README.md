# jumia-task

## Prerequisite:

 Install Docker on your machine.
 Clone project.
 Change directory to cloned project and where Docker file exist.

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
