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
package it.nextworks.nfvmano.libs.swimages.interfaces.messages;

import java.util.ArrayList;
import java.util.List;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.swimages.interfaces.elements.SoftwareImageInformation;

/**
 * Response to a query sw images request.
 * 
 * REF IFA 006 - v2.3.1 - 7.2.3.3
 * 
 * @author nextworks
 *
 */
public class QueryImagesResponse implements InterfaceMessage {

	private List<SoftwareImageInformation> softwareImageInformation = new ArrayList<>();
	
	public QueryImagesResponse() {	}
	
	/**
	 * Constructor
	 * 
	 * @param softwareImageInformation The information of all software images matching the query.
	 */
	public QueryImagesResponse(List<SoftwareImageInformation> softwareImageInformation) {
		if (softwareImageInformation != null) this.softwareImageInformation = softwareImageInformation;
	}
	
	/**
	 * @return the softwareImageInformation
	 */
	public List<SoftwareImageInformation> getSoftwareImageInformation() {
		return softwareImageInformation;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		for (SoftwareImageInformation sii : softwareImageInformation) sii.isValid();
	}
	
}
