package org.irods.jargon.irodsext.mdtemplate.api;

@javax.annotation.Generated(value = "org.irods.jargon.irodsext.mdtemplate.codegen.languages.SpringCodegen", date = "2018-07-16T19:45:57.555Z")

public class ApiException extends Exception{
    private int code;
    public ApiException (int code, String msg) {
        super(msg);
        this.code = code;
    }
}
