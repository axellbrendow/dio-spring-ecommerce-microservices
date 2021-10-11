## Running the project

```sh
docker run -d \
    --name redis \
    -p 6379:6379 \
    redis

gradle bootRun
```

## Testing the project

### First, check if service is up:

```sh
curl http://localhost:8082/actuator/health
# Output should be {"status":"UP"}
```

### Inserting an item into a cart:

```sh
curl http://localhost:8082/cart/1/add-item \
    -X POST \
    -H "Content-Type: application/json" \
    -d '{"productId": 1, "amount": 5}'
```

### Querying a cart:

```sh
curl http://localhost:8082/cart/1
```

### Deleting a cart:

```sh
curl http://localhost:8082/cart/1 -X DELETE
```
