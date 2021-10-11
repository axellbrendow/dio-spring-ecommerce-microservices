## Running the project

```sh
gradle bootRun
```

## Testing the project

### First, guarantee that elasticsearch is not on read-only mode:

```sh
# Avoids elasticsearch entering in read-only mode if your disk is almost full
curl http://localhost:9200/_all/_settings \
    -X PUT \
    -H "Content-Type: application/json" \
    -d '{"index.blocks.read_only_allow_delete": null}'
```

### Insert a product on the product-catalog microservice through the gateway:

```sh
curl http://localhost:8081/product-catalog/product \
    -X POST \
    -H "Content-Type: application/json" \
    -d '{"id": 1, "description": "product1", "price": 7.99}'
```

### Now, get the list of products:

```sh
curl http://localhost:8081/product-catalog/product
```

### Add this product to a cart on the shopping-cart microservice through the gateway:

```sh
curl http://localhost:8081/shopping-cart/cart/1/add-item \
    -X POST \
    -H "Content-Type: application/json" \
    -d '{"productId": 1, "amount": 5}'
```

### Query that cart:

```sh
curl http://localhost:8081/shopping-cart/cart/1
```
