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
package it.nextworks.nfvmano.libs.records.vnfinfo;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import it.nextworks.nfvmano.libs.common.DescriptorInformationElement;
import it.nextworks.nfvmano.libs.common.elements.ResourceHandle;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * This information element provides information about a port of a VNF's internal VL.
 * 
 * REF IFA 007 v2.3.1 - 8.5.11
 * 
 * @author nextworks
 *
 */
@Entity
public class VnfLinkPort implements DescriptorInformationElement {

	@Id
    @GeneratedValue
    @JsonIgnore
    private Long id;
	
	@ManyToOne
	@JsonIgnore
	private ExtManagedVirtualLinkInfo extMngVlInfo;
	
	@ManyToOne
	@JsonIgnore
	private VirtualLinkResourceInfo vlri;
	
	private String vnfLinkPortId;
	
	@Embedded
	private ResourceHandle resourceHandle;
	
	private String cpInstanceId;
	
	public VnfLinkPort() {
		// JPA only
	}
	
	
	/**
	 * Constructor
	 * 
	 * @param extMngVlInfo Externally managed VL info this VNF link port belongs to
	 * @param vnfLinkPortId Identifier of this link port as provided by the entity that has created the link port.
	 * @param resourceHandle Identifier of the virtualised network resource realizing this link port.
	 * @param cpInstanceId External CP of the VNF to be connected to this link port.
	 */
	public VnfLinkPort(ExtManagedVirtualLinkInfo extMngVlInfo,
			String vnfLinkPortId,
			ResourceHandle resourceHandle,
			String cpInstanceId) {
		this.extMngVlInfo = extMngVlInfo;
		this.vnfLinkPortId = vnfLinkPortId;
		this.resourceHandle = resourceHandle;
		this.cpInstanceId = cpInstanceId;
	}
	
	/**
	 * Constructor
	 * 
	 * @param vlri VL resource info this VNF link port belongs to
	 * @param vnfLinkPortId Identifier of this link port as provided by the entity that has created the link port.
	 * @param resourceHandle Identifier of the virtualised network resource realizing this link port.
	 * @param cpInstanceId External CP of the VNF to be connected to this link port.
	 */
	public VnfLinkPort(VirtualLinkResourceInfo vlri,
			String vnfLinkPortId,
			ResourceHandle resourceHandle,
			String cpInstanceId) {
		this.vlri = vlri;
		this.vnfLinkPortId = vnfLinkPortId;
		this.resourceHandle = resourceHandle;
		this.cpInstanceId = cpInstanceId;
	}
	
	/**
	 * @return the resourceHandle
	 */
	public ResourceHandle getResourceHandle() {
		return resourceHandle;
	}
	
	

	/**
	 * @return the vnfLinkPortId
	 */
	public String getVnfLinkPortId() {
		return vnfLinkPortId;
	}

	/**
	 * @return the cpInstanceId
	 */
	public String getCpInstanceId() {
		return cpInstanceId;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (vnfLinkPortId == null) throw new MalformattedElementException("VNF link port without ID");
		if (resourceHandle == null) throw new MalformattedElementException("VNF link port without resource handle");
		else resourceHandle.isValid();
	}

}
