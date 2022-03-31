package com.bookstore.restapi.util;

import com.bookstore.restapi.domain.response.ResponseWrapper;
import org.springframework.stereotype.Component;

public class ResponseUtil {

    public static <T> ResponseWrapper<T> buildSuccess(T data) {
        return ResponseWrapper.<T>builder().success(true).data(data).build();
    }

    public static <T> ResponseWrapper<T> buildError() {
        return ResponseWrapper.<T>builder().success(false).data(null).build();
    }
}
