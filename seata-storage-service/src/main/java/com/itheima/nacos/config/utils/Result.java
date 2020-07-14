package com.itheima.nacos.config.utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by macro on 2019/8/29.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T>
{
    private Integer code;
    private String  message;
    private T       data;

    public Result(Integer code, String message)
    {
        this(code,message,null);
    }
}