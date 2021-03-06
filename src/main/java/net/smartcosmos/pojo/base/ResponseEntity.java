package net.smartcosmos.pojo.base;

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
import net.smartcosmos.util.json.JsonGenerationView;
import net.smartcosmos.util.json.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Communicates the outcome of the RESTful operation submitted to the server, where {@link #getCode()} has a numeric
 * value that always maps back to a {@link Result}, and {@link #getMessage()} contains
 * the system assigned URN stored in {@link net.smartcosmos.model.base.IDomainResource#getUrn()} or a detailed error
 * message describing the failure.
 */
public class ResponseEntity
{
    private static final Logger LOG = LoggerFactory.getLogger(ResponseEntity.class);

    @JsonView(JsonGenerationView.Minimum.class)
    private int code;

    @JsonView(JsonGenerationView.Minimum.class)
    private String message;

    /**
     * Convenience method for quickly building a ResponseEntity.
     */
    public static class Builder
    {
        private final ResponseEntity entity = new ResponseEntity();

        public Builder(int code)
        {
            entity.setCode(code);
        }

        public Builder(String message)
        {
            entity.setMessage(message);
        }

        public Builder(int code, String message)
        {
            entity.setCode(code);
            entity.setMessage(message);
        }

        public ResponseEntity build()
        {
            return entity;
        }
    }

    /**
     * Result code from the server operation as represented by {@link Result} enum codes.
     *
     * @return Result code
     */
    public int getCode()
    {
        return code;
    }

    public void setCode(int code)
    {
        this.code = code;
    }

    /**
     * Textual description of the outcome of the most recent server operation.
     *
     * @return Contains either the system assigned URN when {@link Result#OK} is in the {@link #getCode()}, or a
     * detailed error message describing the failure.
     */
    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public Result getResult()
    {
        return Result.translate(getCode());
    }

    public static String toJson(Result result, Object... args)
    {
        ResponseEntity re = new ResponseEntity();
        re.setMessage(String.format(result.getFormattedMessage(), args));
        re.setCode(result.getCode());

        return JsonUtil.toJson(re);
    }

    public void log()
    {
        LOG.info("Response Code: {}, Response Message: {}", getCode(), getMessage());
    }
}
