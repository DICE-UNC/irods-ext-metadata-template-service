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
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-08-03T18:46:26.530Z")

@Controller
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

	public ResponseEntity<MDTemplate> addTemplate(@ApiParam(value = "Template object that needs to be added to the system" ,required=true )  @Valid @RequestBody MDTemplate templateData) {
		String accept = request.getHeader("Accept");
		MDTemplate mdTemplate = new MDTemplate();
		logger.info("Adding new template !!" +templateData.getTemplateName());

		try {
			boolean isExist = abstractMetadataService.isTemplateExist(templateData.getTemplateName());
			logger.info("Template already exists :: " +isExist);
			if(isExist) {
				return new ResponseEntity<MDTemplate>(HttpStatus.INTERNAL_SERVER_ERROR);	
			}else {

				templateData.setGuid(UUID.randomUUID().toString());
				mdTemplate = abstractMetadataService.saveTemplate(templateData);
				
			}
		} catch (MetadataTemplateException e1) {
			e1.printStackTrace();
			return new ResponseEntity<MDTemplate>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<MDTemplate>(mdTemplate, HttpStatus.CREATED);
	}

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


	public ResponseEntity<MDTemplate> updateTemplate(@ApiParam(value = "Template object that needs to be added to the system" ,required=true )  @Valid @RequestBody MDTemplate templateData) {
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
				MDTemplate template = abstractMetadataService.updateTemplate(templateData);
				return new ResponseEntity<MDTemplate>(template, HttpStatus.OK);
			} 
		}catch(Exception e){
			logger.error("Could not modify template {}.", templateData.getTemplateName());
			return new ResponseEntity<MDTemplate>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	public ResponseEntity<Void> deleteTemplate(@ApiParam(value = "template guid to delete",required=true) @PathVariable("guid") String guid) {
		String accept = request.getHeader("Accept");
		logger.info("Deleting a template for GUID :: " +guid);
		try {
			abstractMetadataService.deleteTemplateByGuid(UUID.fromString(guid));
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (MetadataTemplateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}   
	}

	 public ResponseEntity<List<MDTemplate>> getAllTemplate() {
	        String accept = request.getHeader("Accept");
	        logger.info("get templates");
	        if (accept != null && accept.contains("application/json")) {
	        	logger.info("getting all templates");
	            List<MDTemplate> templates = abstractMetadataService.listAllTemplates();
				return new ResponseEntity<List<MDTemplate>>(templates, HttpStatus.OK);
	        }
	        return new ResponseEntity<List<MDTemplate>>(HttpStatus.NOT_IMPLEMENTED);
	    }


	/****************************************************************Elements Operation *********************************************************************/

	
	public ResponseEntity<MDTemplateElement> addElement(@ApiParam(value = "unique object task name",required=true) @PathVariable("templateGuid") String templateGuid,@ApiParam(value = "Created Element object" ,required=true )  @Valid @RequestBody MDTemplateElement body) {
		
		logger.info("Saving Element for templateGuid :: " +templateGuid);
		body.setGuid(UUID.randomUUID().toString());
		logger.info("body :: " +body);
		MDTemplateElement mdElement = new MDTemplateElement();
		
		try {	
			mdElement = abstractMetadataService.saveElement(UUID.fromString(templateGuid), body);			
		} catch (MetadataTemplateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<MDTemplateElement>(mdElement, HttpStatus.INTERNAL_SERVER_ERROR);	
		}	
		return new ResponseEntity<MDTemplateElement>(mdElement, HttpStatus.OK);
	}
	
	public ResponseEntity<MDTemplateElement> getElementByGuid(@ApiParam(value = "The Template Guid. ",required=true) @PathVariable("templateGuid") String templateGuid,@ApiParam(value = "The Element guid needs to be fetched",required=true) @PathVariable("elementGuid") String elementGuid) {
		String accept = request.getHeader("Accept");
		MDTemplateElement mdElement = new MDTemplateElement();
		try {
			mdElement = abstractMetadataService.findElementByGuid(UUID.fromString(templateGuid), UUID.fromString(elementGuid));
			logger.info("Element :: " +mdElement);
			
		} catch (MetadataTemplateException e) {
			logger.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<MDTemplateElement>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return ResponseEntity.accepted().body(mdElement);
	}

	public ResponseEntity<MDTemplateElement> updateElement(@ApiParam(value = "Element that need to be updated",required=true) @PathVariable("templateGuid") String templateGuid,@ApiParam(value = "Updated Element object" ,required=true )  @Valid @RequestBody MDTemplateElement body) {
	
			logger.info("Updating element !!" +body.getName()+ " , and guid is :: " +body.getGuid() + ", and the template guid is :: " + templateGuid );
			MDTemplateElement existedElement = null;
			try {				
				existedElement = abstractMetadataService.findElementByGuid(UUID.fromString(templateGuid), UUID.fromString(body.getGuid()));
				logger.info("element :: " +existedElement);
				if (existedElement == null) {
					throw new Exception("This element {} " +body.getGuid() + " does not exist") ;
				}else {
					logger.info("updating element");
					MDTemplateElement element = abstractMetadataService.updateElement(UUID.fromString(templateGuid), body);
					return new ResponseEntity<MDTemplateElement>(element , HttpStatus.OK);
				} 
			}catch(Exception e){
				logger.error("Could not modify element {}.", body.getName());
				return new ResponseEntity<MDTemplateElement>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
	}

	public ResponseEntity<Void> deleteElement(@ApiParam(value = "The Template Guid. ",required=true) @PathVariable("templateGuid") String templateGuid,@ApiParam(value = "The Element guid needs to be fetched",required=true) @PathVariable("elementGuid") String elementGuid) {

		try {
			abstractMetadataService.deleteElementByGuid(UUID.fromString(templateGuid), UUID.fromString(elementGuid));
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (MetadataTemplateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}   
	}


	public ResponseEntity<List<MDTemplateElement>> getAllElements(@ApiParam(value = "unique object task name",required=true) @PathVariable("templateGuid") String templateGuid) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            List<MDTemplateElement> elements = abstractMetadataService.listAllElements(UUID.fromString(templateGuid));
			return new ResponseEntity<List<MDTemplateElement>>(elements, HttpStatus.OK);
        }

        return new ResponseEntity<List<MDTemplateElement>>(HttpStatus.NOT_IMPLEMENTED);
    }

   




}
