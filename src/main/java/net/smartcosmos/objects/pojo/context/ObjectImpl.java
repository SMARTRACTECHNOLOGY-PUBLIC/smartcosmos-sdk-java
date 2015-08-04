package net.smartcosmos.objects.pojo.context;

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

import com.fasterxml.jackson.annotation.JsonView;
import net.smartcosmos.objects.model.context.IObject;
import net.smartcosmos.pojo.base.AccountTypedNamedObject;
import net.smartcosmos.util.json.JsonGenerationView;

public class ObjectImpl extends AccountTypedNamedObject<IObject>implements IObject
{
    @JsonView(JsonGenerationView.Minimum.class)
    protected String objectUrn;

    protected String scopeUri;

    @Override
    public String getObjectUrn()
    {
        return objectUrn;
    }

    @Override
    public void setObjectUrn(String objectUrn)
    {
        this.objectUrn = objectUrn;
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("ObjectImpl [objectUrn=");
        builder.append(objectUrn);
        builder.append(", scopeUri=");
        builder.append(scopeUri);
        builder.append(", toString()=");
        builder.append(super.toString());
        builder.append("]");
        return builder.toString();
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        ObjectImpl other = (ObjectImpl) obj;
        if (objectUrn == null)
        {
            if (other.objectUrn != null)
                return false;
        } else if (!objectUrn.equals(other.objectUrn))
            return false;
        if (scopeUri == null)
        {
            if (other.scopeUri != null)
                return false;
        } else if (!scopeUri.equals(other.scopeUri))
            return false;
        return true;
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((objectUrn == null) ? 0 : objectUrn.hashCode());
        result = prime * result + ((scopeUri == null) ? 0 : scopeUri.hashCode());
        return result;
    }

    @Override
    public String getScopeUri()
    {
        return this.scopeUri;
    }

    @Override
    public void setScopeUri(String scopeUri)
    {
        this.scopeUri = scopeUri;
    }
}
