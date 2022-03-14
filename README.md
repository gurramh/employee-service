# Docker Commands

## To build image from Dockerfile.

```shell
docker image build -t gurramh/employee-service:v1.0.0 --no-cahce .
```

## Push the image to docker hub gurramh/department-service

```shell
docker image push gurramh/employee-service:v1.0.0
```

## Run docker image

```shell
docker container run -d --name department-api -p 8082:8082 gurramh/employee-service:v1.0.0
```

## To communicate between two apis deployed in docker in same host

1. We need to create docker network first

```shell
docker network create employee-department-network
```

2. Run the images in the above created network, so you can expose apis inside docker to communicate.

```shell
docker container run -d --network employee-department-network --name employee-api -p 8082:8082 gurramh/employee-service:v1.0.0

docker container run -d --network employee-department-network --name department-api -p 8081:8081 gurramh/department-service:v1.0.0
```

3. You can communicate using container name in the url

```properties
department.api.base.url=http://department-api:8081/departments
```