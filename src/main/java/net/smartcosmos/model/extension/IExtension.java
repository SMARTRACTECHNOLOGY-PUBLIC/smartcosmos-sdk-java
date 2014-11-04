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

package net.smartcosmos.model.extension;

import net.smartcosmos.model.base.IDomainResource;
import net.smartcosmos.model.base.INamedObject;
import net.smartcosmos.model.context.IAccount;

/**
 * Primary means of expanding the capabilities of the platform. This is where 3rd party developers hook into the system
 * to provide unique computational capabilities. When combined with the near real-time event delivery mechanisms
 * afforded by {@link net.smartcosmos.model.integration.INotificationEndpoint}, external systems
 * have access to the data flow to maintain state, perform calculations, etc. as data immediately changes in
 * the context store.
 */
public interface IExtension extends IDomainResource<IExtension>, INamedObject<IExtension>
{
    int getVersion();

    void setVersion(int version);

    IAccount getAccount();

    void setAccount(IAccount account);

    String getSupportEmail();

    void setSupportEmail(String supportEmail);

    String getWebSiteUrl();

    void setWebSiteUrl(String webSiteUrl);

    String getClientId();

    String getClientSecret();

    String getAppCatalogUrl();

    String getRedirectUrl();

    void setRedirectUrl(String redirectUrl);

    String getLongDescription();

    void setLongDescription(String longDescription);

    long getRegistrationTimestamp();

    ExtensionType getExtensionType();

    void setExtensionType(ExtensionType extensionType);
}