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
package it.nextworks.nfvmano.libs.vrmanagement.interfaces;

import it.nextworks.nfvmano.libs.common.exceptions.FailedOperationException;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.common.exceptions.MethodNotImplementedException;
import it.nextworks.nfvmano.libs.common.exceptions.NotExistingEntityException;
import it.nextworks.nfvmano.libs.common.messages.GeneralizedQueryRequest;
import it.nextworks.nfvmano.libs.common.messages.SubscribeRequest;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vcompute.AllocateComputeRequest;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vcompute.AllocateComputeResponse;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vcompute.MigrateComputeRequest;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vcompute.MigrateComputeResponse;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vcompute.OperateComputeRequest;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vcompute.OperateComputeResponse;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vcompute.QueryComputeResponse;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vcompute.ScaleComputeRequest;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vcompute.ScaleComputeResponse;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vcompute.TerminateComputeRequest;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vcompute.TerminateComputeResponse;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vcompute.UpdateComputeRequest;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vcompute.UpdateComputeResponse;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vresources.CreateResourceAffinityGroupRequest;

/**
 * This interface allows an authorized consumer functional block 
 * to perform operations on virtualised compute resources available 
 * to the consumer functional block. 
 * 
 * The interface includes operations for allocating, querying, updating and
 * terminating virtualised compute resources as well as operations for 
 * scaling, migrating and operating the administrative status of a virtualised 
 * compute resource.
 * 
 * This interface implements the provider side; it must be implemented by a VIM plugin
 * and invoked by the NFVO (IFA 005) or the VNFM (IFA 006).
 * 
 * REF IFA 005 v2.3.1 - sect. 7.3.1-2-5
 * 
 * @author nextworks
 *
 */
public interface VirtualComputeResourceManagementProviderInterface {

	/**
	 * This operation allows requesting the allocation of virtual 
	 * compute resources as indicated by the consumer functional block.
	 * 
	 * REF IFA 005 v2.3.1 - sect. 7.3.1.2
	 * 
	 * @param request request to allocate a virtual compute resource
	 * @return the response
	 * @throws MethodNotImplementedException if the method is not implemented
	 * @throws FailedOperationException if the operation fails
	 * @throws MalformattedElementException if the request is malformatted
	 */
	public AllocateComputeResponse allocateVirtualisedComputeResource(AllocateComputeRequest request)
			throws MethodNotImplementedException, FailedOperationException, MalformattedElementException;
	
	/**
	 * This operation allows querying information about instantiated 
	 * virtualised compute resources.
	 * 
	 * REF IFA 005 v2.3.1 - sect. 7.3.1.3
	 * 
	 * @param request query for a virtual compute resource
	 * @return the queried virtual compute resource
	 * @throws MethodNotImplementedException if the method is not implemented
	 * @throws FailedOperationException if the operation fails
	 * @throws NotExistingEntityException if the requested resource does not exist
	 * @throws MalformattedElementException if the request is malformatted
	 */
	public QueryComputeResponse queryVirtualisedComputeResource(GeneralizedQueryRequest request)
			throws MethodNotImplementedException, FailedOperationException, NotExistingEntityException, MalformattedElementException;
	
	/**
	 * This operation allows updating the configuration and/or parameters of 
	 * an instantiated virtual compute resource. This can include, 
	 * for instance, updating metadata adding extra virtual network 
	 * interfaces to a compute resource, or attaching a virtual network 
	 * interface to a specific network port. 
	 * 
	 * REF IFA 005 v2.3.1 - sect. 7.3.1.4
	 * 
	 * @param request request to update a virtual compute resource
	 * @return response
	 * @throws MethodNotImplementedException if the method is not implemented
	 * @throws FailedOperationException if the operation fails
	 * @throws NotExistingEntityException if the resource to be updated does not exist
	 * @throws MalformattedElementException if the request is malformatted
	 */
	public UpdateComputeResponse updateVirtualisedComputeResource(UpdateComputeRequest request)
			throws MethodNotImplementedException, FailedOperationException, NotExistingEntityException, MalformattedElementException;
	
	/**
	 * This operation allows de-allocating and terminating one or more 
	 * instantiated virtual compute resource(s). When the operation 
	 * is done on multiple resources, it is assumed to be best-effort, 
	 * i.e. it can succeed for a subset of the resources, and fail for the remaining ones.
	 * 
	 * REF IFA 005 v2.3.1 - sect. 7.3.1.5
	 * 
	 * @param request request to terminate a virtual compute resource
	 * @return response
	 * @throws MethodNotImplementedException if the method is not implemented
	 * @throws FailedOperationException if the operation fails
	 * @throws NotExistingEntityException if the resource to be deleted does not exist
	 * @throws MalformattedElementException if the request is malformatted
	 */
	public TerminateComputeResponse terminateVirtualisedComputeResource(TerminateComputeRequest request)
			throws MethodNotImplementedException, FailedOperationException, NotExistingEntityException, MalformattedElementException;
	
	/**
	 * This operation allows executing specific operation command on instantiated 
	 * virtualcompute resources.
	 * 
	 * REF IFA 005 v2.3.1 - sect. 7.3.1.6
	 * 
	 * @param request request to execute an operation command on a virtual compute resource
	 * @return the response
	 * @throws MethodNotImplementedException if the method is not implemented
	 * @throws FailedOperationException if the operation fails
	 * @throws NotExistingEntityException if the target resource does not exist
	 * @throws MalformattedElementException if the request is malformatted
	 */
	public OperateComputeResponse operateVirtualisedComputeResource(OperateComputeRequest request)
			throws MethodNotImplementedException, FailedOperationException, NotExistingEntityException, MalformattedElementException;
	
	/**
	 * This operation allows scaling a virtualised compute resource 
	 * by adding or removing capacity in terms of virtual CPUs and virtual memory.
	 * 
	 * REF IFA 005 v2.3.1 - sect. 7.3.1.7
	 * 
	 * @param request request to scale a virtual compute resource
	 * @return the response
	 * @throws MethodNotImplementedException if the method is not implemented
	 * @throws FailedOperationException if the operation fails
	 * @throws NotExistingEntityException if the target resource does not exist
	 * @throws MalformattedElementException if the request is malformatted
	 */
	public ScaleComputeResponse scaleVirtualisedComputeResource(ScaleComputeRequest request)
			throws MethodNotImplementedException, FailedOperationException, NotExistingEntityException, MalformattedElementException;
	
	/**
	 * This operation allows moving a virtualised compute resource between locations. 
	 * For instance, the operation performs the migration of a computing resource from 
	 * one physical machine (host) to another physical machine.
	 * 
	 * REF IFA 005 v2.3.1 - sect. 7.3.1.8
	 * 
	 * @param request request to migrate a virtual compute resource
	 * @return the response
	 * @throws MethodNotImplementedException if the method is not implemented
	 * @throws FailedOperationException if the operation fails
	 * @throws NotExistingEntityException if the target resource does not exist
	 * @throws MalformattedElementException if the request is malformatted
	 */
	public MigrateComputeResponse migrateVirtualisedComputeResource(MigrateComputeRequest request)
			throws MethodNotImplementedException, FailedOperationException, NotExistingEntityException, MalformattedElementException;
	
	/**
	 * This operation allows an authorized consumer functional block to request the creation of a resource affinity or
	 * anti-affinity constraints group. An anti-affinity group contains resources that are not placed in proximity, e.g. that do not
	 * share the same physical NFVI node. An affinity group contains resources that are placed in proximity, e.g. that do share
	 * the same physical NFVI node.
	 * 
	 * REF IFA 005 v2.3.1 - sect. 7.3.1.9
	 * 
	 * @param request request to create an affinity group for virtual compute resource
	 * @return the ID of the affinity group
	 * @throws MethodNotImplementedException if the method is not implemented
	 * @throws FailedOperationException if the operation fails
	 * @throws MalformattedElementException if the request is malformatted
	 */
	public String createComputeResourceAffinityGroup(CreateResourceAffinityGroupRequest request)
			throws MethodNotImplementedException, FailedOperationException, MalformattedElementException;
	
	/**
	 * This operation enables the NFVO to subscribe with a filter for the notifications 
	 * related to virtualised compute resource changes sent by the VIM.
	 * 
	 * REF IFA 005 v2.3.1 - 7.3.2.2
	 * 
	 * @param request subscription request
	 * @param consumer subscriber
	 * @return the subscription ID
	 * @throws MethodNotImplementedException if the method is not implemented
	 * @throws MalformattedElementException if the request is malformatted
	 * @throws FailedOperationException if the subscription fails
	 */
	public String subscribeVirtualComputeResourceChange(SubscribeRequest request, VirtualComputeResourceManagementConsumerInterface consumer) throws MethodNotImplementedException, MalformattedElementException, FailedOperationException;
	
	/**
	 * Method to remove a previous subscription
	 * 
	 * REF IFA 005 v2.3.1 - 7.3.2.2
	 * 
	 * @param subscriptionId	ID of the subscription to be removed
	 * @throws MethodNotImplementedException if the method is not implemented.
	 * @throws MalformattedElementException if the request is malformatted.
	 * @throws NotExistingEntityException if the subscription does not exist.
	 * @throws FailedOperationException if the operation has failed.
	 */
	public void unsubscribeVirtualComputeResourceChange(String subscriptionId) throws MethodNotImplementedException, MalformattedElementException, NotExistingEntityException, FailedOperationException;
	
	
		
}
