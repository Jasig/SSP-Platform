/**
 * Licensed to Apereo under one or more contributor license
 * agreements. See the NOTICE file distributed with this work
 * for additional information regarding copyright ownership.
 * Apereo licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License.  You may obtain a
 * copy of the License at the following location:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.jasig.portal.version.om;

/**
 * Describes a version number, based on http://apr.apache.org/versioning.html
 * <br/>
 * Versions MUST implement equality as checking if the Major, Minor and Patch versions ALL match
 * 
 * 
 * @author Eric Dalquist
 */
public interface Version extends Comparable<Version> {
    /**
     * @return The major part
     */
    int getMajor();
    
    /**
     * @return The minor part
     */
    int getMinor();
    
    /**
     * @return The patch part
     */
    int getPatch();
    
    /**
     * @return true if this version comes before the other version
     */
    boolean isBefore(Version other);
    
    /**
     * @return true if this version comes after the other version
     */
    boolean isAfter(Version other);
}
