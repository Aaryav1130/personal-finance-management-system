package com.aaryav.finance.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class CategoryResponse {
    private String name;
    private String type;

    @JsonProperty("isCustom")
    private boolean custom;
}
