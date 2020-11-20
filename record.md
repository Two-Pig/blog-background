## 打包
```
mvn clean package -Dmaven.test.skip=true
```

## 部署 ：docker-compose
```
version: '3'
services:
        blog:
                container_name: blog
                restart: always
                image: java:8
                ports:
                        - 8080:8080
                volumes:
                        - /usr/local/docker/java/blog/blog-0.0.1-SNAPSHOT.jar:/blog-0.0.1-SNAPSHOT.jar
                        - ./logs:/logs
                environment:
                        - TZ='Asia/Shanghai'
                entrypoint: java -jar blog-0.0.1-SNAPSHOT.jar
```