package net.smartcosmos.objects.model.context;

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

import net.smartcosmos.model.base.IAccountDomainResource;
import net.smartcosmos.model.base.ITypedObject;

/**
 * Captures a political address for a specific {@link IObject}. The
 * addresses differ from {@link net.smartcosmos.model.geo.IGeospatialEntry} in that these
 * addresses are in the context of street, city, state, country and not latitude and longitude.
 */
public interface IObjectAddress extends IAccountDomainResource<IObjectAddress>, ITypedObject
{
    IObject getObject();

    void setObject(IObject object);

    String getLine1();

    void setLine1(String line1);

    String getLine2();

    void setLine2(String line2);

    String getCity();

    void setCity(String city);

    String getStateProvince();

    void setStateProvince(String stateProvince);

    String getPostalCode();

    void setPostalCode(String postalCode);

    String getCountryAbbreviation();

    void setCountryAbbreviation(String countryAbbreviation);

    long getTimestamp();

    void setTimestamp(long timestamp);
}
