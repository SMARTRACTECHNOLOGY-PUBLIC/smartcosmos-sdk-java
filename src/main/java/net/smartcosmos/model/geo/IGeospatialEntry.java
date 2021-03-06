package net.smartcosmos.model.geo;

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

import net.smartcosmos.geo.GeometricShape;
import net.smartcosmos.model.base.IAccountDomainResource;
import net.smartcosmos.model.base.INamedObject;
import net.smartcosmos.model.base.ITypedObject;

/**
 * Referential object that creates a geographic binding to a reference object. The underlying format is represented by
 * the GeoJSON 1.0 specification. GeoJSON is a format for encoding a variety of geographic data structures. A GeoJSON
 * object may represent a geometry, a feature, or a collection of features. GeoJSON supports the following geometry
 * types:
 * <ul>
 * <li>Point</li>
 * <li>LineString</li>
 * <li>Polygon</li>
 * <li>MultiPoint</li>
 * <li>MultiLineString</li>
 * <li>MultiPolygon</li>
 * <li>GeometryCollection</li>
 * <li>Feature</li>
 * <li>FeatureCollection</li>
 * </ul>
 * Features in GeoJSON contain a geometry object and additional properties, and a feature collection represents a list
 * of features.
 * <p/>
 * To capture the a temporal geo-rectification, create an {@link IGeospatialEntry} that refers
 * to the object, then use the {@link IGeospatialEntry#getUrn()} and
 * {@link net.smartcosmos.model.base.EntityReferenceType#Georectification} to place the location on an
 * {@link net.smartcosmos.objects.model.context.ITimelineEntry}.
 * <p/>
 * Possible uses of the georectification object include the definition of a complex geo-fence that marks
 * a job site, a multi-point set of coordinates that represents a courier route, or
 * perhaps an analytical view of aggregated data. Another use case is to link an
 * {@link net.smartcosmos.objects.model.context.IObjectAddress} with a georectification to provide
 * a three-dimensional representation of the building located at a specific address
 * identified in only general terms by the postal address defined in the
 * {@link net.smartcosmos.objects.model.context.IObjectAddress} record.
 */
public interface IGeospatialEntry
        extends IAccountDomainResource<IGeospatialEntry>, INamedObject<IGeospatialEntry>, ITypedObject
{
    GeometricShape getGeometricShape();

    void setGeometricShape(GeometricShape geometricShape);
}
