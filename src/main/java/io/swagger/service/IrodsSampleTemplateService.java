package io.swagger.service;

import java.util.UUID;

import io.swagger.model.Template;

public interface IrodsSampleTemplateService {

		public Template findTemplateByUUID(UUID uuid);
	
}
