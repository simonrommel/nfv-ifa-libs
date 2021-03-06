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
package it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.nfp;

import java.util.ArrayList;
import java.util.List;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * Response to a change NFP request
 * 
 * REF IFA 005 v2.3.1 - 7.4.5.5
 * 
 * @author nextworks
 *
 */
public class ChangeNfpStateResponse implements InterfaceMessage {

	private List<String> changedNfpId = new ArrayList<String>();
	
	public ChangeNfpStateResponse() { }
	
	/**
	 * Constructor
	 * 
	 * @param changedNfpId Identifiers of the NFPs that have successfully been changed.
	 */
	public ChangeNfpStateResponse(List<String> changedNfpId) { 
		if (changedNfpId != null) this.changedNfpId = changedNfpId;
	}
	
	

	/**
	 * @return the changedNfpId
	 */
	public List<String> getChangedNfpId() {
		return changedNfpId;
	}

	@Override
	public void isValid() throws MalformattedElementException {	}

}
