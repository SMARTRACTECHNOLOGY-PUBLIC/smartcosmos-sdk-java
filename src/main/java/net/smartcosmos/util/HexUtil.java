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

package net.smartcosmos.util;

/**
 * Collection of byte hexadecimal conversion routines.
 */
public final class HexUtil
{
    private HexUtil()
    {
    }

    public static char toHexChar(int i)
    {
        if ((0 <= i) && (i <= 9))
        {
            return (char) ('0' + i);
        } else
        {
            return (char) ('a' + (i - 10));
        }
    }

    public static String bytesToHex(byte[] data)
    {
        StringBuilder buf = new StringBuilder();
        for (int i = 0; i < data.length; i++)
        {
            buf.append(byteToHex(data[i]).toUpperCase());
        }
        return (buf.toString());
    }

    public static String byteToHex(byte data)
    {
        StringBuilder buf = new StringBuilder();
        buf.append(toHexChar((data >>> 4) & 0x0F));
        buf.append(toHexChar(data & 0x0F));
        return buf.toString();
    }
}
