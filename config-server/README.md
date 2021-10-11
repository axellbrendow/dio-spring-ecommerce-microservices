## Running the project

```sh
gradle bootRun
```

## Testing the project

### First, check if service is up:

```sh
curl http://localhost:8888/actuator/health
# Output should be {"status":"UP"}
```

### Querying product-catalog and shopping-cart configuration:

```sh
curl http://localhost:8888/product-catalog/default | json_pp
curl http://localhost:8888/shopping-cart/default | json_pp
```
