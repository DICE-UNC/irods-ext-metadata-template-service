package org.irods.jargon.irodsext.mdtemplate.api;


import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;

import org.irods.jargon.metadatatemplate.AbstractMetadataService;
import org.irods.jargon.metadatatemplate.MetadataTemplateException;
import org.irods.jargon.metadatatemplate.model.MDTemplate;
import org.irods.jargon.metadatatemplate.model.MDTemplateElement;
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
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-07-17T12:26:03.800Z")

@Controller
public class TemplateApiController implements TemplateApi {

    private static final Logger log = LoggerFactory.getLogger(TemplateApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    public AbstractMetadataService abstractMetadataService;
    
    @org.springframework.beans.factory.annotation.Autowired
    public TemplateApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> addElement(@ApiParam(value = "unique object task name",required=true) @PathVariable("guid") Integer guid,@ApiParam(value = "Created Element object" ,required=true )  @Valid @RequestBody MDTemplateElement body) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> addTemplate(@ApiParam(value = "Template object that needs to be added to the system" ,required=true )  @Valid @RequestBody MDTemplate templateData) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
	public ResponseEntity<Void> deleteElement(@ApiParam(value = "The Element that needs to be deleted",required=true) @PathVariable("guid") Integer guid) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
	public ResponseEntity<Void> deleteTemplate(@ApiParam(value = "template guid to delete",required=true) @PathVariable("guid") Long guid) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
	public ResponseEntity<MDTemplate> findTemplateByGuid(@ApiParam(value = "pass an a guid to get template",required=true) @PathVariable("guid") String guid) {
        String accept = request.getHeader("Accept");
        MDTemplate mdTemplate = new MDTemplate();      
        System.out.println("GUID is :: " +guid);
        try {
			mdTemplate = abstractMetadataService.findTemplateByUUID(UUID.fromString(guid));
		} catch (MetadataTemplateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}        
        return ResponseEntity.accepted().body(mdTemplate);
    }

    @Override
	public ResponseEntity<MDTemplateElement> getElementByGuid(@ApiParam(value = "The Element that needs to be fetched. ",required=true) @PathVariable("guid") Integer guid) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/xml")) {
            try {
                return new ResponseEntity<MDTemplateElement>(objectMapper.readValue("<MDTemplateElement>  <guid>aeiou</guid>  <name>aeiou</name>  <defaultValue>aeiou</defaultValue>  <type>aeiou</type>  <required>true</required>  <options>aeiou</options>  <access_type>aeiou</access_type>  <validationExp>aeiou</validationExp>  <cardinalityMin>123</cardinalityMin>  <cardinalityMax>123</cardinalityMax></MDTemplateElement>", MDTemplateElement.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/xml", e);
                return new ResponseEntity<MDTemplateElement>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<MDTemplateElement>(objectMapper.readValue("{  \"access_type\" : \"access_type\",  \"defaultValue\" : \"defaultValue\",  \"elements\" : [ null, null ],  \"name\" : \"name\",  \"options\" : \"options\",  \"guid\" : \"guid\",  \"cardinalityMin\" : 1,  \"cardinalityMax\" : 5,  \"type\" : \"type\",  \"required\" : true,  \"validationExp\" : \"validationExp\"}", MDTemplateElement.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<MDTemplateElement>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<MDTemplateElement>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> updateElement(@ApiParam(value = "Element that need to be updated",required=true) @PathVariable("guid") Integer guid,@ApiParam(value = "Updated Element object" ,required=true )  @Valid @RequestBody MDTemplateElement body) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> updateTemplate(@ApiParam(value = "Template object that needs to be added to the system" ,required=true )  @Valid @RequestBody MDTemplate templateData) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

}
