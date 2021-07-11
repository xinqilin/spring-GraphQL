package com.bill.graphql.controller;

import com.bill.graphql.dto.GraphQLRequestBody;
import graphql.ExecutionInput;
import graphql.ExecutionResult;
import graphql.GraphQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.Map;

/**
 * @author Bill.Lin on 2021/7/11
 */

@RestController
public class GraphQLController {


    private GraphQL graphQL;

    @Autowired(required = false)
    public GraphQLController(GraphQL graphQL) {
        this.graphQL = graphQL;
    }

    @PostMapping(value = "/graphQL", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Map<String, Object>> execute(@RequestBody GraphQLRequestBody body) {
        return Mono
                .fromCompletionStage(graphQL.executeAsync(ExecutionInput.newExecutionInput().query(body.getQuery())
                        .operationName(body.getOperationName()).variables(body.getVariables()).build()))
                .map(ExecutionResult::toSpecification);

    }
}
