/*
* Copyright 2018 Nextworks s.r.l.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package it.nextworks.nfvmano.libs.descriptors.common.elements;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import it.nextworks.nfvmano.libs.common.DescriptorInformationElement;
import it.nextworks.nfvmano.libs.common.elements.QoS;
import it.nextworks.nfvmano.libs.common.enums.ServiceAvailabilityLevel;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.descriptors.nsd.NsVirtualLinkDesc;
import it.nextworks.nfvmano.libs.descriptors.vnfd.VnfVirtualLinkDesc;


/**
 * The VirtualLinkDf information element specifies properties 
 * for instantiating a VL according to a specific flavour.
 * 
 * Ref. IFA 014 v2.3.1 - 6.5.4
 * 
 * @author nextworks
 *
 */
@Entity
public class VirtualLinkDf implements DescriptorInformationElement {

	@Id
    @GeneratedValue
    @JsonIgnore
    private Long id;
	
	@JsonIgnore
	@ManyToOne
	private NsVirtualLinkDesc nsVld;
	
	@JsonIgnore
	@ManyToOne
	private VnfVirtualLinkDesc vnfVld;
	
	private String flavourId;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@Embedded
	private QoS qos;

	//THIS IS OUT OF THE STANDARD, ADDED FOR 5G-TRANSFORMER SO COMPATIBILITY
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private LinkBitrateRequirements bitrateRequirements;

	private ServiceAvailabilityLevel serviceAvaibilityLevel;
	
	public VirtualLinkDf() {
		// JPA only
	}
	
	/**
	 * Constructor
	 *  
	 * @param nsVld Identifies the virtual link descriptor this VL DF belongs to
	 * @param flavourId Identifies this VirtualLinkDf information element within a VLD.
	 * @param qos	qos of the VL
	 * @param serviceAvaibilityLevel Specifies one of the three levels defined in ETSI GS NFV-REL 001
	 */
	public VirtualLinkDf(NsVirtualLinkDesc nsVld,
			String flavourId,
			QoS qos,
			ServiceAvailabilityLevel serviceAvaibilityLevel) {
		this.nsVld = nsVld;
		this.vnfVld = null;
		this.flavourId = flavourId;
		this.qos = qos;
		this.serviceAvaibilityLevel = serviceAvaibilityLevel;
	}
	
	/**
	 * Constructor
	 *  
	 * @param vnfVld Identifies the virtual link descriptor this VL DF belongs to
	 * @param flavourId Identifies this VirtualLinkDf information element within a VLD.
	 * @param qos	qos of the VL
	 * @param serviceAvaibilityLevel Specifies one of the three levels defined in ETSI GS NFV-REL 001
	 */
	public VirtualLinkDf(VnfVirtualLinkDesc vnfVld,
			String flavourId,
			QoS qos,
			ServiceAvailabilityLevel serviceAvaibilityLevel) {
		this.nsVld = null;
		this.vnfVld = vnfVld;
		this.flavourId = flavourId;
		this.qos = qos;
		this.serviceAvaibilityLevel = serviceAvaibilityLevel;
	}

	/**
	 * Constructor
	 *
	 * @param vnfVld Identifies the virtual link descriptor this VL DF belongs to
	 * @param flavourId Identifies this VirtualLinkDf information element within a VLD.
	 * @param qos	qos of the VL
	 * @param serviceAvaibilityLevel Specifies one of the three levels defined in ETSI GS NFV-REL 001
	 * @param bitrateRequirements Specifies the bitrate requirements for the link
	 */
	public VirtualLinkDf(VnfVirtualLinkDesc vnfVld,
						 String flavourId,
						 QoS qos,
						 ServiceAvailabilityLevel serviceAvaibilityLevel,
						 LinkBitrateRequirements bitrateRequirements) {
		this.nsVld = null;
		this.vnfVld = vnfVld;
		this.flavourId = flavourId;
		this.qos = qos;
		this.serviceAvaibilityLevel = serviceAvaibilityLevel;
		this.bitrateRequirements = bitrateRequirements;
	}



	/**
	 * @return the flavourId
	 */
	@JsonProperty("flavourId")
	public String getFlavourId() {
		return flavourId;
	}

	/**
	 * @return the qos
	 */
	@JsonProperty("qos")
	public QoS getQos() {
		return qos;
	}

	/**
	 * @return the serviceAvaibilityLevel
	 */
	@JsonProperty("serviceAvaibilityLevel")
	public ServiceAvailabilityLevel getServiceAvaibilityLevel() {
		return serviceAvaibilityLevel;
	}
	
	@Override
	public void isValid() throws MalformattedElementException {
		if (this.flavourId == null) throw new MalformattedElementException("VL DF without flavour ID");
		if (this.qos != null) qos.isValid();
	}

	@JsonProperty("bitrateRequirements")
	public LinkBitrateRequirements getBitrateRequirements() {
		return bitrateRequirements;
	}
}
