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
package it.nextworks.nfvmano.libs.catalogues.interfaces.messages;

import java.util.ArrayList;
import java.util.List;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * Message to fetch the artifacts associated to an onboarded VNF package
 * 
 * REF IFA 013 v2.3.1 - 7.2.11
 * 
 * @author nextworks
 *
 */
public class FetchOnboardedVnfPackageArtifactsRequest implements InterfaceMessage {

	private String onboardedVnfPkgInfoId;
	private List<String> artifactAccessInformation = new ArrayList<String>();
	
	public FetchOnboardedVnfPackageArtifactsRequest() {	}
	
	/**
	 * Constructor
	 * 
	 * @param onboardedVnfPkgInfoId Identifier of information held by the NFVO about the specific on-boarded VNF Package.
	 * @param artifactAccessInformation List of selectors to address individual package artifacts.
	 */
	public FetchOnboardedVnfPackageArtifactsRequest(String onboardedVnfPkgInfoId,
			List<String> artifactAccessInformation) {	
		this.onboardedVnfPkgInfoId = onboardedVnfPkgInfoId;
		if (artifactAccessInformation != null) this.artifactAccessInformation = artifactAccessInformation;
	}

	
	
	/**
	 * @return the onboardedVnfPkgInfoId
	 */
	public String getOnboardedVnfPkgInfoId() {
		return onboardedVnfPkgInfoId;
	}

	/**
	 * @return the artifactAccessInformation
	 */
	public List<String> getArtifactAccessInformation() {
		return artifactAccessInformation;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (onboardedVnfPkgInfoId == null) throw new MalformattedElementException("Featch VNF package artifacts without VNF package ID");
		if ((artifactAccessInformation == null) || (artifactAccessInformation.isEmpty())) {
			throw new MalformattedElementException("Featch VNF package artifacts without access information");
		}

	}

}
