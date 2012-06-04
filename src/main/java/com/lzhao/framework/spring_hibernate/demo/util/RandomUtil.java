/*
 * Copyright 2012 Liang Zhao <alpha.roc@gmail.com>.
 *
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
 */
package com.lzhao.framework.spring_hibernate.demo.util;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class RandomUtil {

    private static final Log log = LogFactory.getLog(RandomUtil.class);
    
    public static final String[] STATES_ABBR = {"ACT",
        "NSW", "NT", "QLD", "SA", "TAS", "VIC", "WA"};

    public static String randomPostcode() {
        return RandomStringUtils.randomNumeric(4);
    }

    public static String randomStateAbbr() {
        return STATES_ABBR[(int) (Math.random() * (STATES_ABBR.length - 1))];
    }

    public static String randomLocality() {
        return RandomStringUtils.randomAlphanumeric(10);
    }
}
