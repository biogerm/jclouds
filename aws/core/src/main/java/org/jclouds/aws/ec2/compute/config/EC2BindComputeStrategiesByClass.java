/**
 *
 * Copyright (C) 2010 Cloud Conscious, LLC. <info@cloudconscious.com>
 *
 * ====================================================================
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ====================================================================
 */

package org.jclouds.aws.ec2.compute.config;

import org.jclouds.aws.ec2.compute.strategy.EC2DestroyNodeStrategy;
import org.jclouds.aws.ec2.compute.strategy.EC2GetNodeMetadataStrategy;
import org.jclouds.aws.ec2.compute.strategy.EC2ListNodesStrategy;
import org.jclouds.aws.ec2.compute.strategy.EC2RebootNodeStrategy;
import org.jclouds.aws.ec2.compute.strategy.EC2RunNodesAndAddToSetStrategy;
import org.jclouds.compute.config.BindComputeStrategiesByClass;
import org.jclouds.compute.strategy.AddNodeWithTagStrategy;
import org.jclouds.compute.strategy.DestroyNodeStrategy;
import org.jclouds.compute.strategy.GetNodeMetadataStrategy;
import org.jclouds.compute.strategy.ListNodesStrategy;
import org.jclouds.compute.strategy.RebootNodeStrategy;
import org.jclouds.compute.strategy.RunNodesAndAddToSetStrategy;

/**
 * @author Adrian Cole
 */
public class EC2BindComputeStrategiesByClass extends BindComputeStrategiesByClass {
   @Override
   protected Class<? extends RunNodesAndAddToSetStrategy> defineRunNodesAndAddToSetStrategy() {
      return EC2RunNodesAndAddToSetStrategy.class;
   }

   /**
    * not needed, as {@link EC2RunNodesAndAddToSetStrategy} is used and is already set-based.
    */
   @Override
   protected Class<? extends AddNodeWithTagStrategy> defineAddNodeWithTagStrategy() {
      return null;
   }

   /**
    * not needed, as {@link EC2RunNodesAndAddToSetStrategy} is used and is already set-based.
    */
   @Override
   protected void bindAddNodeWithTagStrategy(Class<? extends AddNodeWithTagStrategy> clazz) {
   }

   @Override
   protected Class<? extends DestroyNodeStrategy> defineDestroyNodeStrategy() {
      return EC2DestroyNodeStrategy.class;
   }

   @Override
   protected Class<? extends GetNodeMetadataStrategy> defineGetNodeMetadataStrategy() {
      return EC2GetNodeMetadataStrategy.class;
   }

   @Override
   protected Class<? extends ListNodesStrategy> defineListNodesStrategy() {
      return EC2ListNodesStrategy.class;
   }

   @Override
   protected Class<? extends RebootNodeStrategy> defineRebootNodeStrategy() {
      return EC2RebootNodeStrategy.class;
   }

}