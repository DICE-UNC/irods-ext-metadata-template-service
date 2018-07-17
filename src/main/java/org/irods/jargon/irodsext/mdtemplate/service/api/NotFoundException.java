package org.irods.jargon.irodsext.mdtemplate.service.api;

@javax.annotation.Generated(value = "org.irods.jargon.irodsext.mdtemplate.service.codegen.languages.SpringCodegen", date = "2018-07-16T19:45:57.555Z")

public class NotFoundException extends ApiException {
    private int code;
    public NotFoundException (int code, String msg) {
        super(code, msg);
        this.code = code;
    }
}
