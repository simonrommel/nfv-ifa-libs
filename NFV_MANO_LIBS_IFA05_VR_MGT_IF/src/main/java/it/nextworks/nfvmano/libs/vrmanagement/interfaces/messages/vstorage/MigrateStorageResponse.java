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
package it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vstorage;


import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.vstorage.VirtualStorage;

/**
 * Response to a migrate virtual storage request.
 * 
 * REF IFA 005 v2.3.1 - sect. 7.5.1.8
 * 
 * @author nextworks
 *
 */
public class MigrateStorageResponse implements InterfaceMessage {

	private VirtualStorage storageData;
	
	public MigrateStorageResponse() { }
	
	public MigrateStorageResponse(VirtualStorage storageData) {
		this.storageData = storageData;
	}

	/**
	 * @return the storageData
	 */
	public VirtualStorage getStorageData() {
		return storageData;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (storageData == null) throw new MalformattedElementException("Migrate storage response without storage data.");
		else storageData.isValid();
	}

}
