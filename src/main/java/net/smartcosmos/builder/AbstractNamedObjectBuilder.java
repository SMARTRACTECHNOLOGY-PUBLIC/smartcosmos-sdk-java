/*
 * SMART COSMOS SDK
 * (C) Copyright 2013-2014, Smartrac Technology Fletcher, Inc.
 * 267 Cane Creek Rd, Fletcher, NC, 28732, USA
 * All Rights Reserved.
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

package net.smartcosmos.builder;

import net.smartcosmos.model.base.INamedObject;

public abstract class AbstractNamedObjectBuilder<T extends INamedObject, E> extends AbstractMonikerBuilder<T, E>
{
    protected AbstractNamedObjectBuilder(T instance)
    {
        super(instance);
        instance.setActive(true);
    }

    @SuppressWarnings("unchecked")
    public E setName(String name)
    {
        instance.setName(name);
        return (E) this;
    }

    @SuppressWarnings("unchecked")
    public E setDescription(String description)
    {
        instance.setDescription(description);
        return (E) this;
    }

    @SuppressWarnings("unchecked")
    public E setActive(boolean flag)
    {
        instance.setActive(flag);
        return (E) this;
    }
}
