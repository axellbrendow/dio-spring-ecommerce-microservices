# dio-spring-product-catalog

## Running the project

```sh
docker run -d \
    --name elasticsearch \
    -p 9200:9200 \
    -p 9300:9300 \
    -e "discovery.type=single-node" \
    elasticsearch:7.6.2

gradle bootRun
```

In another terminal, when elasticsearch is ready, run:

```sh
# Avoids elasticsearch entering in read-only mode if your disk is almost full
curl http://localhost:9200/_all/_settings \
    -X PUT \
    -H "Content-Type: application/json" \
    -d '{"index.blocks.read_only_allow_delete": null}'
```

## Testing the project

### First, check if service is up:

```sh
curl http://localhost:8080/actuator/health
# Output should be {"status":"UP"}
```

### Querying the product index information from Elasticsearch:

```sh
curl http://localhost:9200/product\?pretty
```

### Inserting a product on Elasticsearch:

```sh
curl http://localhost:8080/product \
    -X POST \
    -H "Content-Type: application/json" \
    -d '{"id": 1, "description": "product1", "price": 7.99}'
```

### Querying the product index data from Elasticsearch:

```sh
curl http://localhost:9200/product/_search\?pretty
```

### Get a product by id from Elasticsearch:

```sh
curl http://localhost:8080/product/1
```

### Get all products from Elasticsearch:

```sh
curl http://localhost:8080/product
```
