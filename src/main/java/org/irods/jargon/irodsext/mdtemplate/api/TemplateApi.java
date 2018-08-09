package org.irods.jargon.irodsext.mdtemplate.api;

import io.swagger.annotations.*;

import org.irods.jargon.metadatatemplate.model.MDTemplate;
import org.irods.jargon.metadatatemplate.model.MDTemplateElement;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-08-03T18:46:26.530Z")

@Api(value = "template", description = "the template API")
public interface TemplateApi {

    @ApiOperation(value = "Create Element", nickname = "addElement", notes = "Add element for template.", response = MDTemplateElement.class, tags={ "Element", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Template Successfully Created.", response = MDTemplateElement.class),
        @ApiResponse(code = 400, message = "Invalid Element supplied"),
        @ApiResponse(code = 404, message = "Element not found") })
    @RequestMapping(value = "/template/{templateGuid}/element",
        produces = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<MDTemplateElement> addElement(@ApiParam(value = "unique object task name",required=true) @PathVariable("templateGuid") String templateGuid,@ApiParam(value = "Created Element object" ,required=true )  @Valid @RequestBody MDTemplateElement body);


    @ApiOperation(value = "Add a new Template", nickname = "addTemplate", notes = "Adding a new metadata template", response = MDTemplate.class, tags={ "Templates", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Template Successfully Created.", response = MDTemplate.class),
        @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/template",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<MDTemplate> addTemplate(@ApiParam(value = "Template object that needs to be added to the system" ,required=true )  @Valid @RequestBody MDTemplate templateData);


    @ApiOperation(value = "Delete Element", nickname = "deleteElement", notes = "", tags={ "Element", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation"),
        @ApiResponse(code = 400, message = "Invalid guid supplied"),
        @ApiResponse(code = 404, message = "Element not found") })
    @RequestMapping(value = "/template/{templateGuid}/element/{elementGuid}",
        produces = { "application/json" }, 
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteElement(@ApiParam(value = "The Template Guid. ",required=true) @PathVariable("templateGuid") String templateGuid,@ApiParam(value = "The Element guid needs to be fetched",required=true) @PathVariable("elementGuid") String elementGuid);


    @ApiOperation(value = "Delete a Template", nickname = "deleteTemplate", notes = "", tags={ "Templates", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Template Successfully Deleted."),
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "Template not found") })
    @RequestMapping(value = "/template/{guid}",
        produces = { "application/json" }, 
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteTemplate(@ApiParam(value = "template guid to delete",required=true) @PathVariable("guid") String guid);


    @ApiOperation(value = "Get template by id", nickname = "findTemplateByGuid", notes = "By passing in the appropriate options, you can search for available templates ", tags={ "Templates", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "search results matching criteria"),
        @ApiResponse(code = 400, message = "bad input parameter") })
    @RequestMapping(value = "/template/{guid}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<MDTemplate> findTemplateByGuid(@ApiParam(value = "pass an a guid to get template",required=true) @PathVariable("guid") String guid);


    @ApiOperation(value = "Get Element by guid", nickname = "getElementByGuid", notes = "", response = MDTemplateElement.class, tags={ "Element", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = MDTemplateElement.class),
        @ApiResponse(code = 400, message = "Invalid guid supplied"),
        @ApiResponse(code = 404, message = "Element not found") })
    @RequestMapping(value = "/template/{templateGuid}/element/{elementGuid}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<MDTemplateElement> getElementByGuid(@ApiParam(value = "The Template Guid. ",required=true) @PathVariable("templateGuid") String templateGuid,@ApiParam(value = "The Element guid needs to be fetched",required=true) @PathVariable("elementGuid") String elementGuid);


    @ApiOperation(value = "Updated Element", nickname = "updateElement", notes = "", response = MDTemplateElement.class, tags={ "Element", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Template Successfully Created.", response = MDTemplateElement.class),
        @ApiResponse(code = 400, message = "Invalid Element supplied"),
        @ApiResponse(code = 404, message = "Element not found") })
    @RequestMapping(value = "/template/{templateGuid}/element",
        produces = { "application/json" }, 
        method = RequestMethod.PUT)
    ResponseEntity<MDTemplateElement> updateElement(@ApiParam(value = "Element that need to be updated",required=true) @PathVariable("templateGuid") String templateGuid,@ApiParam(value = "Updated Element object" ,required=true )  @Valid @RequestBody MDTemplateElement body);


    @ApiOperation(value = "Update an existing Template", nickname = "updateTemplate", notes = "", response = MDTemplate.class, tags={ "Templates", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Template Successfully Updated.", response = MDTemplate.class),
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "Template not found"),
        @ApiResponse(code = 405, message = "Validation exception") })
    @RequestMapping(value = "/template",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    ResponseEntity<MDTemplate> updateTemplate(@ApiParam(value = "Template object that needs to be added to the system" ,required=true )  @Valid @RequestBody MDTemplate templateData);

}
