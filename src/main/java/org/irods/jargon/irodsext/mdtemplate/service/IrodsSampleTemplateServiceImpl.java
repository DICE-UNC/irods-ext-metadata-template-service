package org.irods.jargon.irodsext.mdtemplate.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.irods.jargon.metadatatemplate.model.MDTemplate;
import org.irods.jargon.metadatatemplate.model.MDTemplateElement;



public class IrodsSampleTemplateServiceImpl implements IrodsSampleTemplateService {

	@Override
	public MDTemplate findTemplateByUUID(UUID uuid) {
		MDTemplate MDTemplate = new MDTemplate();
		
		MDTemplate.setTemplateName("MDTemplate1");
		MDTemplate.setAccessType("OWNER");
		MDTemplate.setDescription("This is Test MDTemplate");
		MDTemplateElement MDTemplateElement = new MDTemplateElement();
		MDTemplateElement.setName("Location");
		MDTemplateElement.setDefaultValue("New York");
		
		MDTemplateElement childMetadataCity = new MDTemplateElement();
		childMetadataCity.setName("city");
		childMetadataCity.setDefaultValue("NYC");
		MDTemplateElement childMetadataCounty = new MDTemplateElement();
		childMetadataCounty.setName("County");
		childMetadataCounty.setDefaultValue("Bronxs");
		
		List<MDTemplateElement> MetadataMDTemplateElementsList = new ArrayList();
		MetadataMDTemplateElementsList.add(childMetadataCity);
		MetadataMDTemplateElementsList.add(childMetadataCounty);
		MDTemplateElement.setElements(MetadataMDTemplateElementsList);
		
		List<MDTemplateElement> sList = new ArrayList();
		sList.add(MDTemplateElement);
		MDTemplate.setElements(sList);
		
		return MDTemplate;
	}

	

}
