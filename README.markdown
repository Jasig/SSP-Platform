<!--

    Licensed to Apereo under one or more contributor license
    agreements. See the NOTICE file distributed with this work
    for additional information regarding copyright ownership.
    Apereo licenses this file to you under the Apache License,
    Version 2.0 (the "License"); you may not use this file
    except in compliance with the License.  You may obtain a
    copy of the License at the following location:

      http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing,
    software distributed under the License is distributed on an
    "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    KIND, either express or implied.  See the License for the
    specific language governing permissions and limitations
    under the License.

-->

# Welcome to the Student Success SSP-Platform (built on uPortal) - Open Source Edition  

### To start...  
 *  developing, look at the documentation in [Developer Install Instructions](https://wiki.jasig.org/display/SSP/SSP+Developer+Installation+Instructions)  
 *  installing, look at the documentation in [Install Docs](https://wiki.jasig.org/display/SSP/SSP+Installation+Documents)  
 
#### For any other help...
Please refer to other documentation in [SSP Wiki Home] (https://wiki.jasig.org/display/SSP/Home) 
and if a solution can't be found the ssp email lists in [SSP Email Lists] (https://wiki.jasig.org/display/SSP/SSP+Email+Lists)

Alternatively, SSP-Platform is built/forked from uPortal and more information on uPortal is found at [uPortal site] (http://www.uportal.org) or [uPortal Wiki] (http://www.ja-sig.org/wiki/display/UPC/Home)


#### Requirements                                                                
*  JDK 1.7.X - Just a JRE may not be sufficient, a full JDK is recommended
*  Servlet 3.0 Container - Tomcat 7.0 is recommended
*  Maven 3.0.3  or later
*  Ant 1.8.2 is recommended
    
    
#### Building and Deploying                                                       
SSP-Platform like uPortal uses Maven for its project configuration and build system. An Ant
build.xml is also provided which handles the initialization and deployment
related tasks. You will likely only ever need to use the Ant tasks. Ant 1.8.2 is required.

Ant tasks (run "ant -p" for a full list) :
    hsql - Starts a HSQL database instance. The default uPortal configuration
        points to this database and it can be used for portal development.

    initportal - Runs the 'deploy-ear' and 'init-db' ant targets, should be the
        first and only task run when setting up a new uPortal instance
        WARNING: This runs 'init-db' which DROPS and re-creates the uPortal
        database
    
    deploy-ear - Ensures the latest changes have been compiled and packaged then
        deploys uPortal, shared libraries and all packaged portlets to the
        container
   
    initdb - Sets up the uPortal database. DROPS ALL EXISTING uPortal tables
        re-creates them and populates them with the default uPortal data
        WARNING: This DROPS and re-creates the uPortal database
    
    deploy-war - Ensures the latest uPortal changes have been compiled and
        packaged then deploys the uPortal WAR to the container.
    
    deployPortletApp - Deploys the specified portlet application to the
        container. This is the required process to deploy any portlet to a
        uPortal instance.
        ex: ant deployPortletApp -DportletApp=/path/to/portlet.war
    

#### Other Notes                                                                 

#####Initial Configuration
----------------------------------------
To deploy SSP-Platform, you must set the server.home variable in the
build.properties file to the instance of Tomcat you want to deploy to.


#####Initial Deployment
----------------------------------------
You must run the initportal target before uPortal is started the first time.
This target will take care of compiling, deploying, database population and
other initial tasks. Running initportal again is similiar to hitting a reset
button on the portal. Any saved configuration in the portal is lost and a clean
version of the portal is configured.

