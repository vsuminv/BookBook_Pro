package com.proj.bookbook.DTO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@ToString
@Getter @Setter
public class ResponseDTO {

    private String error;
    private int result;
}
