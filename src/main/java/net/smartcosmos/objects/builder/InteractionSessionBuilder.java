package net.smartcosmos.objects.builder;

/*
 * *#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*
 * SMART COSMOS Platform Core SDK
 * ===============================================================================
 * Copyright (C) 2013 - 2015 SMARTRAC Technology Fletcher, Inc.
 * ===============================================================================
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#
 */

import com.google.common.base.Preconditions;
import net.smartcosmos.builder.AbstractNamedObjectBuilder;
import net.smartcosmos.objects.model.context.IObjectInteractionSession;
import net.smartcosmos.objects.pojo.context.ObjectInteractionSession;

/**
 * Convenience Builder pattern class for creating new
 * {@link net.smartcosmos.objects.model.context.IObjectInteractionSession}
 * instances.
 * <p/>
 * The minimum fields required to define a new instance are:
 * <ul>
 * <li>{@link net.smartcosmos.Field#NAME_FIELD}</li>
 * <li>{@link net.smartcosmos.Field#TYPE_FIELD}</li>
 * <li>{@link net.smartcosmos.Field#START_TIMESTAMP_FIELD}</li>
 * </ul>
 */
public class InteractionSessionBuilder
        extends AbstractNamedObjectBuilder<IObjectInteractionSession, InteractionSessionBuilder>
{
    public InteractionSessionBuilder(long startTimestamp)
    {
        super(new ObjectInteractionSession());
        instance.setStartTimestamp(startTimestamp);
    }

    public InteractionSessionBuilder setType(String type)
    {
        instance.setType(type);
        return this;
    }

    @Override
    protected void onValidate()
    {
        Preconditions.checkNotNull(instance.getType(), "type must not be null");
        Preconditions.checkNotNull(instance.getName(), "name must not be null");
        Preconditions.checkState(instance.getStartTimestamp() > 0, "start timestamp must be a positive value");
    }
}

