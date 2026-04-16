package com.whistlestop.common.api;

/*
 Generic success response used by customer endpoints.

 Wraps the response in a consistent structure so the frontend
 can always expect the same fields.
*/
public class ApiResponse<T> {
    private boolean success;
    private String message;
    private T data;

    /*
     Empty constructor used by Jackson when converting JSON.
    */
    public ApiResponse() {
    }

    /*
     Creates a response object with the given values.
    */
    public ApiResponse(boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    /*
     Builds a successful response for normal API calls.
    */
    public static <T> ApiResponse<T> success(String message, T data) {
        return new ApiResponse<>(true, message, data);
    }

    /*
     Builds a failed response when the request cannot be completed.
    */
    public static <T> ApiResponse<T> fail(String message, T data) {
        return new ApiResponse<>(false, message, data);
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
