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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-07-17T12:26:03.800Z")

@RestController
public class TemplateApiController implements TemplateApi {

	private static final Logger logger = LoggerFactory.getLogger(TemplateApiController.class);

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	@Autowired
	public AbstractMetadataService abstractMetadataService;

	@org.springframework.beans.factory.annotation.Autowired
	public TemplateApiController(ObjectMapper objectMapper, HttpServletRequest request) {
		this.objectMapper = objectMapper;
		this.request = request;
	}

	@Override
	public ResponseEntity<String> addTemplate(@ApiParam(value = "Template object that needs to be added to the system" ,required=true )  @Valid @RequestBody MDTemplate templateData) {
		String accept = request.getHeader("Accept");
		
		logger.info("Adding new template !!" +templateData.getTemplateName());
		
		try {
			boolean isExist = abstractMetadataService.isTemplateExist(templateData.getTemplateName());
			logger.info("Template already exists :: " +isExist);
			if(isExist) {
				return new ResponseEntity<String>("Template with this name "+templateData.getTemplateName()+" already exist", HttpStatus.INTERNAL_SERVER_ERROR);	
			}else {
				
				templateData.setGuid(UUID.randomUUID().toString());
				abstractMetadataService.saveTemplate(templateData);
				return new ResponseEntity<String>(templateData.getGuid(), HttpStatus.OK);
			}
		} catch (MetadataTemplateException e1) {
			e1.printStackTrace();
			return new ResponseEntity<String>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
		}
					
	}

	@Override
	public ResponseEntity<MDTemplate> findTemplateByGuid(@ApiParam(value = "pass an a guid to get template",required=true) @PathVariable("guid") String guid) {
		String accept = request.getHeader("Accept");
		MDTemplate mdTemplate = new MDTemplate();      
		logger.info("Find the template for GUID :: " +guid);
		try {
			mdTemplate = abstractMetadataService.findTemplateByGuid(UUID.fromString(guid));
		} catch (MetadataTemplateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}        
		return ResponseEntity.accepted().body(mdTemplate);
	}


	@Override
	public  ResponseEntity<String> updateTemplate(@ApiParam(value = "Template object that needs to be added to the system" ,required=true )  @Valid @RequestBody MDTemplate templateData) {
		String accept = request.getHeader("Accept");
		logger.info("Updating template !!" +templateData.getTemplateName()+ " , and guid is :: " +templateData.getGuid());
		MDTemplate mdTemplate  = null;
		try {
			mdTemplate = abstractMetadataService.findTemplateByGuid(UUID.fromString(templateData.getGuid()));
			logger.info("mdtemplate :: " +mdTemplate);
			if (mdTemplate == null) {
				throw new Exception("Cannot modify a non-existent template");
			}else {
				//templateData.setGuid(UUID.randomUUID().toString());
				logger.info("updating template");
				abstractMetadataService.updateTemplate(templateData);
				return new ResponseEntity<String>(templateData.getGuid(), HttpStatus.OK);
			} 
		}catch(Exception e){
			logger.error("Could not modify template {}.", templateData.getTemplateName());
			return new ResponseEntity<String>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@Override
	public ResponseEntity<String> deleteTemplate(@ApiParam(value = "template guid to delete",required=true) @PathVariable("guid") String guid) {
		String accept = request.getHeader("Accept");
		logger.info("Deleting a template for GUID :: " +guid);
		try {
			abstractMetadataService.deleteTemplateByGuid(UUID.fromString(guid));
			return new ResponseEntity<String>("The guid - "+guid+ "data is deleted successfully", HttpStatus.OK);
		} catch (MetadataTemplateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<String>("There is some issue deleting this data" , HttpStatus.INTERNAL_SERVER_ERROR);
		}   
	}


	//Element Operations

      
	@Override
	public ResponseEntity<MDTemplateElement> addElement(@ApiParam(value = "unique object task name",required=true) @PathVariable("templateGuid") String templateGuid,@ApiParam(value = "Created Element object" ,required=true )  @Valid @RequestBody MDTemplateElement body) {
		String accept = request.getHeader("Accept");

		//get template id from guid
		//save elements with the template parent_id (how to add parent id in element table?)

		logger.info("Saving Element for templateGuid :: " +templateGuid);
		body.setGuid(UUID.randomUUID().toString());
		logger.info("body :: " +body);
		
		try {	
			abstractMetadataService.saveElement(UUID.fromString(templateGuid), body);
			return new ResponseEntity<MDTemplateElement>(body, HttpStatus.OK);
		} catch (MetadataTemplateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<MDTemplateElement>(body, HttpStatus.INTERNAL_SERVER_ERROR);	
		}			
	}


	
	@Override
	public ResponseEntity<MDTemplateElement> getElementByGuid(@ApiParam(value = "The Template Guid. ",required=true) @PathVariable("templateGuid") String templateGuid,@ApiParam(value = "The Element guid needs to be fetched",required=true) @PathVariable("elementGuid") String elementGuid) {
		String accept = request.getHeader("Accept");

		if (accept != null && accept.contains("application/xml")) {
			try {
				MDTemplateElement mdElement = abstractMetadataService.findElementByGuid(UUID.fromString(templateGuid), UUID.fromString(elementGuid));
				return ResponseEntity.accepted().body(mdElement);
			} catch (MetadataTemplateException e) {
				logger.error("Couldn't serialize response for content type application/xml", e);
				return new ResponseEntity<MDTemplateElement>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		if (accept != null && accept.contains("application/json")) {
			try {
				MDTemplateElement mdElement = abstractMetadataService.findElementByGuid(UUID.fromString(templateGuid), UUID.fromString(elementGuid));
				return ResponseEntity.accepted().body(mdElement);
			} catch (MetadataTemplateException e) {
				logger.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<MDTemplateElement>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<MDTemplateElement>(HttpStatus.NOT_IMPLEMENTED);      
	}


	@Override
	public ResponseEntity<String> deleteElement(@ApiParam(value = "The Template Guid. ",required=true) @PathVariable("templateGuid") String templateGuid,@ApiParam(value = "The Element guid needs to be fetched",required=true) @PathVariable("elementGuid") String elementGuid) {
		String accept = request.getHeader("Accept");
		
		try {
			abstractMetadataService.deleteElementByGuid(UUID.fromString(templateGuid), UUID.fromString(elementGuid));
			return new ResponseEntity<String>("The Element for this guid - "+elementGuid+ " is deleted successfully", HttpStatus.OK);
		} catch (MetadataTemplateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<String>("There is some issue deleting this data" , HttpStatus.INTERNAL_SERVER_ERROR);
		}   
	}

	  public ResponseEntity<String> updateElement(@ApiParam(value = "Element that need to be updated",required=true) @PathVariable("templateGuid") String templateGuid,@ApiParam(value = "Updated Element object" ,required=true )  @Valid @RequestBody MDTemplateElement body) {
		  String accept = request.getHeader("Accept");
			logger.info("Updating element !!" +body.getName()+ " , and guid is :: " +body.getGuid() + ", and the template guid is :: " + templateGuid );
			MDTemplateElement element = null;
			try {
				logger.info("if the element exist");
				element = abstractMetadataService.findElementByGuid(UUID.fromString(templateGuid), UUID.fromString(body.getGuid()));
				logger.info("element :: " +element);
				if (element == null) {
					throw new Exception("This element {} " +body.getGuid() + " does not exist") ;
				}else {
					logger.info("updating element");
					abstractMetadataService.updateElement(UUID.fromString(templateGuid), body);
					return new ResponseEntity<String>(body.getGuid(), HttpStatus.OK);
				} 
			}catch(Exception e){
				logger.error("Could not modify element {}.", element.getName());
				return new ResponseEntity<String>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
			}
	    }
	
}
