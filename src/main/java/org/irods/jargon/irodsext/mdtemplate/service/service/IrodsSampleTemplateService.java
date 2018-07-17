package org.irods.jargon.irodsext.mdtemplate.service.service;

import java.util.UUID;

import org.irods.jargon.irodsext.mdtemplate.service.model.Template;

public interface IrodsSampleTemplateService {

		public Template findTemplateByUUID(UUID uuid);
	
}
