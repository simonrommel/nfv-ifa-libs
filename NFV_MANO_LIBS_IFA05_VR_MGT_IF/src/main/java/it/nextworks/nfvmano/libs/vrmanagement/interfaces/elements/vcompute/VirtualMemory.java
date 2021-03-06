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
package it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.vcompute;


import it.nextworks.nfvmano.libs.common.InterfaceInformationElement;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * REF IFA 005 v2.3.1 - 8.4.3.5
 * 
 * @author nextworks
 *
 */
public class VirtualMemory implements InterfaceInformationElement {

	private int virtualMemSize;
	private String virtualMemOversubscriptionPolicy; 
	private boolean numaEnabled;
	
	public VirtualMemory() { }
	
	/**
	 * Constructor
	 * 
	 * @param virtualMemSize Amount of virtual Memory
	 * @param virtualMemOversubscriptionPolicy The memory core oversubscription policy in terms of virtual memory to physical memory on the platform.
	 * @param numaEnabled It specifies the memory allocation to be cognisant of the relevant process/core allocation.
	 */
	public VirtualMemory(int virtualMemSize,
			String virtualMemOversubscriptionPolicy,
			boolean numaEnabled) {
		this.virtualMemSize = virtualMemSize;
		this.virtualMemOversubscriptionPolicy = virtualMemOversubscriptionPolicy;
		this.numaEnabled = numaEnabled;
	}
	
	

	/**
	 * @return the virtualMemSize
	 */
	public int getVirtualMemSize() {
		return virtualMemSize;
	}

	/**
	 * @return the virtualMemOversubscriptionPolicy
	 */
	public String getVirtualMemOversubscriptionPolicy() {
		return virtualMemOversubscriptionPolicy;
	}

	/**
	 * @return the numaEnabled
	 */
	public boolean isNumaEnabled() {
		return numaEnabled;
	}

	@Override
	public void isValid() throws MalformattedElementException { }

}
