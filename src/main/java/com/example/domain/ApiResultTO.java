package com.example.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
public class ApiResultTO<T extends Serializable> extends BaseTO {

    private static final long serialVersionUID = 4785961935752148785L;

    /**
     * 是否操作成功
     */
    @ApiModelProperty(value = "是否操作成功", required = true, example = "true")
    private boolean success;
    /**
     * 错误码
     */
    @ApiModelProperty(value = "错误码", required = true, example = "0001")
    private Integer errorCode;
    /**
     * 错误提示
     */
    @ApiModelProperty(value = "错误提示", required = true, example = "系统错误")
    private String message;
    /**
     * 操作结果
     */
    @ApiModelProperty(value = "操作结果", required = true)
    private T data;

    public void setData(T data) {
        this.data = data;
    }

    public static <K extends Serializable> ApiResultTO<K> buildSuccess(K data) {
        ApiResultTO<K> result = new ApiResultTO<>();
        result.setSuccess(true);
        result.setErrorCode(0);
        result.setData(data);
        return result;
    }

    public static <K extends Serializable> ApiResultTO<K> buildSuccess(K data, String message) {
        ApiResultTO<K> result = new ApiResultTO<>();
        result.setSuccess(true);
        result.setMessage(message);
        result.setErrorCode(0);
        result.setData(data);
        return result;
    }

    public static <K extends Serializable> ApiResultTO<K> buildFailed(Integer code, String message) {
        ApiResultTO<K> result = new ApiResultTO<>();
        result.setSuccess(false);
        result.setErrorCode(code);
        result.setMessage(message);
        return result;
    }

    public static <K extends Serializable> ApiResultTO<K> buildFailed(ExceptionCodeEnum errorCodeEnum) {
        ApiResultTO<K> result = new ApiResultTO<>();
        result.setSuccess(false);
        result.setErrorCode(errorCodeEnum.getCode());
        result.setMessage(errorCodeEnum.getDesc());
        return result;
    }

    public static <K extends Serializable> ApiResultTO<K> buildFailed(ExceptionCodeEnum errorCodeEnum, String message) {
        ApiResultTO<K> result = new ApiResultTO<>();
        result.setSuccess(false);
        result.setErrorCode(errorCodeEnum.getCode());
        result.setMessage(message);
        return result;
    }

}