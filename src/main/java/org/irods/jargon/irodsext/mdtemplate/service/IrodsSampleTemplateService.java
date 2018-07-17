package org.irods.jargon.irodsext.mdtemplate.service;

import java.util.UUID;

import org.irods.jargon.metadatatemplate.model.MDTemplate;

public interface IrodsSampleTemplateService {

		public MDTemplate findTemplateByUUID(UUID uuid);
	
}
