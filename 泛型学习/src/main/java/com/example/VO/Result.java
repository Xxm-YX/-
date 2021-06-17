package com.example.VO;

//import com.example.domain.ExceptionCodeEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class Result<T> implements Serializable {

    private Integer code;
    private String message;
    private T data;

    public Result(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Result(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 带数据成功返回
     * 虽然泛型方也用了T，但和Result<T>里的没关系，这里之所以这么写
     * 是因为实际开发时会见到很多这种“迷惑性”的写法
     * @param data
     * @param <T>
     * @return
     */
//    public static <T> Result<T> success(T data){
//        return new Result<>(ExceptionCodeEnum.SUCCESS.getCode(),ExceptionCodeEnum.SUCCESS.getDesc(),data);
//    }
}
