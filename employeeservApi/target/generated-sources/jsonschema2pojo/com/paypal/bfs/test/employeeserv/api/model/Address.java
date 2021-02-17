
package com.paypal.bfs.test.employeeserv.api.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * Address resource
 * <p>
 * Address resource object
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "addressLine1",
    "addressLine2",
    "city",
    "state",
    "country",
    "zipCode"
})
public class Address {

    /**
     * First line of address
     * 
     */
    @JsonProperty("addressLine1")
    @JsonPropertyDescription("First line of address")
    private String addressLine1;
    /**
     * Second line of address
     * 
     */
    @JsonProperty("addressLine2")
    @JsonPropertyDescription("Second line of address")
    private String addressLine2;
    /**
     * city
     * (Required)
     * 
     */
    @JsonProperty("city")
    @JsonPropertyDescription("city")
    private String city;
    /**
     * state
     * (Required)
     * 
     */
    @JsonProperty("state")
    @JsonPropertyDescription("state")
    private String state;
    /**
     * country
     * (Required)
     * 
     */
    @JsonProperty("country")
    @JsonPropertyDescription("country")
    private String country;
    /**
     * zipCode
     * (Required)
     * 
     */
    @JsonProperty("zipCode")
    @JsonPropertyDescription("zipCode")
    private Integer zipCode;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * First line of address
     * 
     */
    @JsonProperty("addressLine1")
    public String getAddressLine1() {
        return addressLine1;
    }

    /**
     * First line of address
     * 
     */
    @JsonProperty("addressLine1")
    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    /**
     * Second line of address
     * 
     */
    @JsonProperty("addressLine2")
    public String getAddressLine2() {
        return addressLine2;
    }

    /**
     * Second line of address
     * 
     */
    @JsonProperty("addressLine2")
    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    /**
     * city
     * (Required)
     * 
     */
    @JsonProperty("city")
    public String getCity() {
        return city;
    }

    /**
     * city
     * (Required)
     * 
     */
    @JsonProperty("city")
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * state
     * (Required)
     * 
     */
    @JsonProperty("state")
    public String getState() {
        return state;
    }

    /**
     * state
     * (Required)
     * 
     */
    @JsonProperty("state")
    public void setState(String state) {
        this.state = state;
    }

    /**
     * country
     * (Required)
     * 
     */
    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    /**
     * country
     * (Required)
     * 
     */
    @JsonProperty("country")
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * zipCode
     * (Required)
     * 
     */
    @JsonProperty("zipCode")
    public Integer getZipCode() {
        return zipCode;
    }

    /**
     * zipCode
     * (Required)
     * 
     */
    @JsonProperty("zipCode")
    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Address.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("addressLine1");
        sb.append('=');
        sb.append(((this.addressLine1 == null)?"<null>":this.addressLine1));
        sb.append(',');
        sb.append("addressLine2");
        sb.append('=');
        sb.append(((this.addressLine2 == null)?"<null>":this.addressLine2));
        sb.append(',');
        sb.append("city");
        sb.append('=');
        sb.append(((this.city == null)?"<null>":this.city));
        sb.append(',');
        sb.append("state");
        sb.append('=');
        sb.append(((this.state == null)?"<null>":this.state));
        sb.append(',');
        sb.append("country");
        sb.append('=');
        sb.append(((this.country == null)?"<null>":this.country));
        sb.append(',');
        sb.append("zipCode");
        sb.append('=');
        sb.append(((this.zipCode == null)?"<null>":this.zipCode));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null)?"<null>":this.additionalProperties));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
