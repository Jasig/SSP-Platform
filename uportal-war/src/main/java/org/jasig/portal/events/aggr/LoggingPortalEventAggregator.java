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
package org.jasig.portal.events.aggr;

import java.util.Map;

import org.jasig.portal.events.PortalEvent;
import org.jasig.portal.events.aggr.session.EventSession;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Eric Dalquist
 * @version $Revision$
 */
public class LoggingPortalEventAggregator implements IPortalEventAggregator<PortalEvent> {
    protected final Logger logger = LoggerFactory.getLogger(getClass());
    
    @Override
    public boolean supports(Class<? extends PortalEvent> type) {
        return true;
    }

    @Override
    public void aggregateEvent(PortalEvent e, EventSession eventSession,
            EventAggregationContext eventAggregationContext,
            Map<AggregationInterval, AggregationIntervalInfo> currentIntervals) {
        
        logger.debug("EVENT   : {}", e);
    }

    @Override
    public void handleIntervalBoundary(AggregationInterval interval, EventAggregationContext eventAggregationContext,
            Map<AggregationInterval, AggregationIntervalInfo> intervals) {
        
        logger.debug("INTERVAL: {} - {}", interval, intervals.get(interval));
    }

    @Override
    public int cleanUnclosedAggregations(DateTime start, DateTime end, AggregationInterval interval) {
        return 0;
    }
}
