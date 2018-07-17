package org.irods.jargon.irodsext.mdtemplate.service.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;

import org.irods.jargon.irodsext.mdtemplate.service.model.Element;
import org.irods.jargon.irodsext.mdtemplate.service.model.Template;
import org.irods.jargon.irodsext.mdtemplate.service.service.IrodsSampleTemplateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
@javax.annotation.Generated(value = "org.irods.jargon.irodsext.mdtemplate.service.codegen.languages.SpringCodegen", date = "2018-07-16T19:45:57.555Z")

@Controller
public class TemplateApiController implements TemplateApi {

    private static final Logger log = LoggerFactory.getLogger(TemplateApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;
    
    @Autowired
    public IrodsSampleTemplateService irodsSampleTemplateService;

    @org.springframework.beans.factory.annotation.Autowired
    public TemplateApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> addElement(@ApiParam(value = "unique object task name",required=true) @PathVariable("guid") Integer guid,@ApiParam(value = "Created Element object" ,required=true )  @Valid @RequestBody Element body) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> addTemplate(@ApiParam(value = "Template object that needs to be added to the system" ,required=true )  @Valid @RequestBody Template templateData) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> deleteElement(@ApiParam(value = "The Element that needs to be deleted",required=true) @PathVariable("guid") Integer guid) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> deleteTemplate(@ApiParam(value = "template guid to delete",required=true) @PathVariable("guid") Long guid) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Template> findTemplateByGuid(@ApiParam(value = "pass an a guid to get template",required=true) @PathVariable("guid") String guid) {
    	String accept = request.getHeader("Accept");
        Template template = new Template();
       
         // MdTemplate mdTemplate =  adstractMetadataService.findTemplateByUUID(UUID.fromString(guid));
          //guid = "9f089439-9665-4464-929b-2704d765b588";
          template = irodsSampleTemplateService.findTemplateByUUID (UUID.fromString(guid));
       
        System.out.println("Template Searched is :: " + template.getTemplateName());
        if(template != null)
          return ResponseEntity.accepted().body(template);
        else
          return new ResponseEntity<Template>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Element> getElementByGuid(@ApiParam(value = "The Element that needs to be fetched. ",required=true) @PathVariable("guid") Integer guid) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/xml")) {
            try {
                return new ResponseEntity<Element>(objectMapper.readValue("<Element>  <id>123456789</id>  <attribute>aeiou</attribute>  <defaultValue>aeiou</defaultValue>  <attributeUnit>aeiou</attributeUnit>  <type>aeiou</type>  <required>true</required>  <options>aeiou</options>  <access_type>aeiou</access_type>  <validationExp>aeiou</validationExp>  <guid>aeiou</guid></Element>", Element.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/xml", e);
                return new ResponseEntity<Element>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Element>(objectMapper.readValue("{  \"attributeUnit\" : \"attributeUnit\",  \"access_type\" : \"access_type\",  \"defaultValue\" : \"defaultValue\",  \"elements\" : [ null, null ],  \"options\" : \"options\",  \"guid\" : \"guid\",  \"id\" : 1,  \"attribute\" : \"attribute\",  \"type\" : \"type\",  \"required\" : true,  \"validationExp\" : \"validationExp\"}", Element.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Element>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Element>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> updateElement(@ApiParam(value = "Element that need to be updated",required=true) @PathVariable("guid") Integer guid,@ApiParam(value = "Updated Element object" ,required=true )  @Valid @RequestBody Element body) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> updateTemplate(@ApiParam(value = "Template object that needs to be added to the system" ,required=true )  @Valid @RequestBody Template templateData) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

}
