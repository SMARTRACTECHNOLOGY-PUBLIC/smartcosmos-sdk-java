package net.smartcosmos.profiles.pojo.context;

/*
 * *#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*
 * SMART COSMOS Platform Core SDK
 * ===============================================================================
 * Copyright (C) 2013 - 2014 SMARTRAC Technology Fletcher, Inc.
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
import com.google.common.base.Preconditions;
import net.smartcosmos.profiles.model.context.IVerifyMessage;
import net.smartcosmos.util.json.JsonGenerationView;

public class VerifyMessage implements IVerifyMessage
{
    @JsonView(JsonGenerationView.Minimum.class)
    private String verificationType;

    @JsonView(JsonGenerationView.Minimum.class)
    private int verificationState = 0;

    @Override
    public String getVerificationType()
    {
        return verificationType;
    }

    @Override
    public void setVerificationType(String verificationType)
    {
        Preconditions.checkNotNull(verificationType);
        this.verificationType = verificationType;
    }

    @Override
    public int getVerificationState()
    {
        return verificationState;
    }

    @Override
    public void setVerificationState(int verificationState)
    {
        Preconditions.checkArgument(verificationState >= 0);
        this.verificationState = verificationState;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VerifyMessage that = (VerifyMessage) o;

        if (verificationState != that.verificationState) return false;
        if (!verificationType.equals(that.verificationType)) return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = verificationType.hashCode();
        result = 31 * result + verificationState;
        return result;
    }
}
