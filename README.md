# microservices
- Para monitoreo con zipkin, ejecutar el jar primero

- Para autenticación
> docker run -p 8180:8080 -e KEYCLOAK_ADMIN=admin -e KEYCLOAK_ADMIN_PASSWORD=admin quay.io/keycloak/keycloak:21.0.1 start-dev