/*package io.swagger.model;

import java.util.Objects;
import java.util.Set;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

*//**
 * Metadata
 *//*
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-07-05T15:04:12.117Z")

public class Metadata   {
	  @JsonProperty("id")
	  private Long id = null;

	  @JsonProperty("attribute")
	  private String attribute = null;

	  @JsonProperty("defaultValue")
	  private String defaultValue = null;

	  @JsonProperty("attributeUnit")
	  private String attributeUnit = null;

	  @JsonProperty("type")
	  private String type = null;

	  @JsonProperty("required")
	  private Boolean required = null;

	  @JsonProperty("options")
	  private String options = null;

	  @JsonProperty("validation_exp")
	  private String validationExp = null;

	  @JsonProperty("guid")
	  private UUID guid = null;

	  @JsonProperty("metadata")
	  private Set<Metadata> metadata = null;

  public Metadata id(Long id) {
    this.id = id;
    return this;
  }

  *//**
   * Get id
   * @return id
  **//*
  @ApiModelProperty(value = "")


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Metadata attribute(String attribute) {
    this.attribute = attribute;
    return this;
  }

  *//**
   * Get attribute
   * @return attribute
  **//*
  @ApiModelProperty(value = "")


  public String getAttribute() {
    return attribute;
  }

  public void setAttribute(String attribute) {
    this.attribute = attribute;
  }

  public Metadata defaultValue(String defaultValue) {
    this.defaultValue = defaultValue;
    return this;
  }

  *//**
   * Get defaultValue
   * @return defaultValue
  **//*
  @ApiModelProperty(value = "")


  public String getDefaultValue() {
    return defaultValue;
  }

  public void setDefaultValue(String defaultValue) {
    this.defaultValue = defaultValue;
  }

  public Metadata attributeUnit(String attributeUnit) {
    this.attributeUnit = attributeUnit;
    return this;
  }

  *//**
   * Get attributeUnit
   * @return attributeUnit
  **//*
  @ApiModelProperty(value = "")


  public String getAttributeUnit() {
    return attributeUnit;
  }

  public void setAttributeUnit(String attributeUnit) {
    this.attributeUnit = attributeUnit;
  }

  public Metadata type(String type) {
    this.type = type;
    return this;
  }

  *//**
   * Get type
   * @return type
  **//*
  @ApiModelProperty(value = "")


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Metadata required(Boolean required) {
    this.required = required;
    return this;
  }

  *//**
   * Get required
   * @return required
  **//*
  @ApiModelProperty(value = "")


  public Boolean isRequired() {
    return required;
  }

  public void setRequired(Boolean required) {
    this.required = required;
  }

  public Metadata options(String options) {
    this.options = options;
    return this;
  }

  *//**
   * Get options
   * @return options
  **//*
  @ApiModelProperty(value = "")


  public String getOptions() {
    return options;
  }

  public void setOptions(String options) {
    this.options = options;
  }

  public Metadata validationExp(String validationExp) {
    this.validationExp = validationExp;
    return this;
  }

  *//**
   * Get validationExp
   * @return validationExp
  **//*
  @ApiModelProperty(value = "")


  public String getValidationExp() {
    return validationExp;
  }

  public void setValidationExp(String validationExp) {
    this.validationExp = validationExp;
  }

  public Metadata guid(UUID guid) {
    this.guid = guid;
    return this;
  }

  *//**
   * Get guid
   * @return guid
  **//*
  @ApiModelProperty(value = "")


  public UUID getGuid() {
    return guid;
  }

  public void setGuid(UUID guid) {
    this.guid = guid;
  }

  public Metadata metadata(Set<Metadata>  metadata) {
    this.metadata = metadata;
    return this;
  }

  *//**
   * Template Elements
   * @return metadata
  **//*
  @ApiModelProperty(value = "Template Elements")


  public Set<Metadata>  getMetadata() {
    return metadata;
  }

  public void setMetadata(Set<Metadata>  metadata) {
    this.metadata = metadata;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Metadata metadata = (Metadata) o;
    return Objects.equals(this.id, metadata.id) &&
        Objects.equals(this.attribute, metadata.attribute) &&
        Objects.equals(this.defaultValue, metadata.defaultValue) &&
        Objects.equals(this.attributeUnit, metadata.attributeUnit) &&
        Objects.equals(this.type, metadata.type) &&
        Objects.equals(this.required, metadata.required) &&
        Objects.equals(this.options, metadata.options) &&
        Objects.equals(this.validationExp, metadata.validationExp) &&
        Objects.equals(this.guid, metadata.guid) &&
        Objects.equals(this.metadata, metadata.metadata);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, attribute, defaultValue, attributeUnit, type, required, options, validationExp, guid, metadata);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Metadata {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    attribute: ").append(toIndentedString(attribute)).append("\n");
    sb.append("    defaultValue: ").append(toIndentedString(defaultValue)).append("\n");
    sb.append("    attributeUnit: ").append(toIndentedString(attributeUnit)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    required: ").append(toIndentedString(required)).append("\n");
    sb.append("    options: ").append(toIndentedString(options)).append("\n");
    sb.append("    validationExp: ").append(toIndentedString(validationExp)).append("\n");
    sb.append("    guid: ").append(toIndentedString(guid)).append("\n");
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  *//**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   *//*
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

*/