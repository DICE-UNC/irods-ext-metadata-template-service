package org.irods.jargon.irodsext.mdtemplate.api;


@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-07-24T19:51:38.241Z")

public class ApiException extends Exception{
    private int code;
    public ApiException (int code, String msg) {
        super(msg);
        this.code = code;
    }
}
