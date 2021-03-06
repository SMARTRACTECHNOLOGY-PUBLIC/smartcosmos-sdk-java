package net.smartcosmos.model.extension;

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

/**
 * Collection of fine-grained read and write permissions that an extension may choose to
 * ask a user for when performing an OAuth 2.0 authorization handshake.
 * <p/>
 * <b>NOTE:</b> The {@link #EventStream} implies *Read permissions across the board. It is
 * not presently possible to constrain the event stream to a subset of entities.
 */
public enum PermissionType
{
    AccountRead,
    AccountWrite,

    DeviceRead,
    DeviceWrite,

    // Implies *Read permissions since JSON is included in all events
    EventStream,

    FileRead,
    FileWrite,

    GeospatialEntryRead,
    GeospatialEntryWrite,

    MetadataRead,
    MetadataWrite,

    ObjectRead,
    ObjectWrite,

    ObjectAddressRead,
    ObjectAddressWrite,

    ObjectInteractionRead,
    ObjectInteractionWrite,

    ObjectInteractionSessionRead,
    ObjectInteractionSessionWrite,

    RelationshipRead,
    RelationshipWrite,

    TagAssignmentRead,
    TagAssignmentWrite,

    TagRead,
    TagWrite,

    TimelineRead,
    TimelineWrite,

    UserRead,
    UserWrite
}
