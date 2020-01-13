package com.aieener.anglee.user.vo;

import com.aieener.anglee.user.enums.ResultEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class ResultVO<T> {
    private Integer code;
    private String msg;
    private T data;

    @JsonIgnore
    public boolean isSuccess() {
        return this.code == ResultEnum.SUCCESS.getCode();
    }
}
