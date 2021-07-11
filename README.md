# GraphQL

### Dependency

- web reactive
- r2dbc
- h2 database

extra
```xml

    <dependency>
        <groupId>com.graphql-java</groupId>
        <artifactId>graphql-java</artifactId>
        <version>15.0</version>
    </dependency>

```

### Test GraphQL Client

- Altair (https://altair.sirmuel.design/)
- Postman


### API

- POST Request -> http://localhost:8080/graphQL

```graphql

    {
      getBooks{
        id
        name
        pages
      }
    }

```

```graphql

    mutation{
      createBook(
            bookName:"Bill_Book", 
            pages:500, 
            category:FANTASY, 
            authorName:"Bill.Lin", 
            age:1000
        )
    }

```
