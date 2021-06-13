package com.crud.tasks.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@JsonIgnoreProperties
public class Trello {

    @JsonProperty("board")
    private int board;

    @JsonProperty("card")
    public int card;
}
