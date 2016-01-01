/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.lifecycle;

import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;
import org.mule.api.service.Service;
import org.mule.api.service.ServiceAware;

/**
 * @author David Dossot (david@dossot.net)
 */
public class LifecycleTrackerComponentObject extends AbstractLifecycleTracker
        implements ServiceAware, Callable {

    public void springInitialize() {
        getTracker().add("springInitialize");
    }

    public void springDestroy() {
        getTracker().add("springDestroy");
    }

     public void setService(final Service service)
    {
        getTracker().add("setService");
    }

    public Object onCall(final MuleEventContext eventContext) throws Exception {
        // dirty trick to get the component instance that was used for the
        // request
        return this;
    }

}
