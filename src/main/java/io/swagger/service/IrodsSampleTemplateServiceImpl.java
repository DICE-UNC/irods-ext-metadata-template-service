package io.swagger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.UUID;

import org.irods.jargon.core.query.MetaDataAndDomainData.MetadataDomain;

import io.swagger.model.Element;
import io.swagger.model.Template;



public class IrodsSampleTemplateServiceImpl implements IrodsSampleTemplateService {

	@Override
	public Template findTemplateByUUID(UUID uuid) {
		Template template = new Template();
		
		template.setTemplateName("Template1");
		template.setAccessType("OWNER");
		template.setDescription("This is Test Template");
		Element element = new Element();
		element.setAttribute("Location");
		element.setDefaultValue("New York");
		
		Element childMetadataCity = new Element();
		childMetadataCity.setAttribute("city");
		childMetadataCity.setDefaultValue("NYC");
		Element childMetadataCounty = new Element();
		childMetadataCounty.setAttribute("County");
		childMetadataCounty.setDefaultValue("Bronxs");
		
		List<Element> MetadataElementsList = new ArrayList();
		MetadataElementsList.add(childMetadataCity);
		MetadataElementsList.add(childMetadataCounty);
		element.setElements(MetadataElementsList);
		
		List<Element> templateElementsList = new ArrayList();
		templateElementsList.add(element);
		template.setElements(templateElementsList);
		
		return template;
	}

}
