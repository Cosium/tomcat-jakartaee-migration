/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.tomcat.jakartaee;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {

    private static EESpecProfile profile = EESpecProfile.TOMCAT;

    /**
     * Set the Jakarta EE specifications that should be used.
     * @param profile the Jakarta EE specification profile
     */
    public static void setEESpecProfile(String profile) {
        setEESpecProfile(EESpecProfile.valueOf(profile));
    }

    /**
     * Set the Jakarta EE specifications that should be used.
     * @param profile the Jakarta EE specification profile
     */
    public static void setEESpecProfile(EESpecProfile profile) {
        Util.profile = profile;
    }

    /**
     * Get the Jakarta EE profile being used.
     * @return the profile
     */
    public static EESpecProfile getEESpecProfile() {
        return profile;
    }

    /**
     * Get the extension of a filename
     * <p>
     * The extension is the string after the last '{@code .}' in the filename.
     * @param filename the name of the file
     * @return the extension or an empty string, if no dot is found in the filename
     */
    public static String getExtension(String filename) {
        // Extract the extension
        int lastPeriod = filename.lastIndexOf('.');
        if (lastPeriod == -1) {
            return "";
        }
        return filename.substring(lastPeriod + 1).toLowerCase(Locale.ENGLISH);
    }


    public static String convert(String name) {
        Matcher m = profile.getPattern().matcher(name);
        return m.replaceAll("jakarta$1");
    }


    private Util() {
        // Hide default constructor. Utility class.
    }
}
