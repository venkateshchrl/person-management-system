/*
 * Person Record Managment API
 * API for person management system
 *
 * OpenAPI spec version: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package com.demo.pms.gen.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Structure for error response
 */
@Schema(description = "Structure for error response")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2020-01-19T07:43:12.012Z[GMT]")public class ErrorResponse   {
  @JsonProperty("code")
  private String code = null;

  @JsonProperty("errorMessage")
  private String errorMessage = null;

  @JsonProperty("link")
  private String link = null;

  @JsonProperty("correlationId")
  private String correlationId = null;

  public ErrorResponse code(String code) {
    this.code = code;
    return this;
  }

  /**
   * Internal code for the response
   * @return code
   **/
  @JsonProperty("code")
  @Schema(description = "Internal code for the response")
  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public ErrorResponse errorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
    return this;
  }

  /**
   * Internal message for the response
   * @return errorMessage
   **/
  @JsonProperty("errorMessage")
  @Schema(description = "Internal message for the response")
  public String getErrorMessage() {
    return errorMessage;
  }

  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }

  public ErrorResponse link(String link) {
    this.link = link;
    return this;
  }

  /**
   * Web link for the error documentation
   * @return link
   **/
  @JsonProperty("link")
  @Schema(description = "Web link for the error documentation")
  public String getLink() {
    return link;
  }

  public void setLink(String link) {
    this.link = link;
  }

  public ErrorResponse correlationId(String correlationId) {
    this.correlationId = correlationId;
    return this;
  }

  /**
   * The unique identifier for the transaction to debug failure
   * @return correlationId
   **/
  @JsonProperty("correlationId")
  @Schema(description = "The unique identifier for the transaction to debug failure")
  public String getCorrelationId() {
    return correlationId;
  }

  public void setCorrelationId(String correlationId) {
    this.correlationId = correlationId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ErrorResponse errorResponse = (ErrorResponse) o;
    return Objects.equals(this.code, errorResponse.code) &&
        Objects.equals(this.errorMessage, errorResponse.errorMessage) &&
        Objects.equals(this.link, errorResponse.link) &&
        Objects.equals(this.correlationId, errorResponse.correlationId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, errorMessage, link, correlationId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ErrorResponse {\n");
    
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    errorMessage: ").append(toIndentedString(errorMessage)).append("\n");
    sb.append("    link: ").append(toIndentedString(link)).append("\n");
    sb.append("    correlationId: ").append(toIndentedString(correlationId)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
