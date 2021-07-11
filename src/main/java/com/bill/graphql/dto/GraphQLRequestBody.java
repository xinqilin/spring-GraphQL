package com.bill.graphql.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;

/**
 * @author Bill.Lin on 2021/7/11
 */

@Data
public class GraphQLRequestBody {

    private String query;
    private String operationName;

    @Getter(AccessLevel.NONE)
    private Map<String, Object> variables;

    public Map<String, Object> getVariables() {
        return Objects.requireNonNullElseGet(variables, Collections::emptyMap);
    }

}
