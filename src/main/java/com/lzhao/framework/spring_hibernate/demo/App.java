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
package com.lzhao.framework.spring_hibernate.demo;

import com.lzhao.framework.spring_hibernate.demo.domain.Postcode;
import com.lzhao.framework.spring_hibernate.demo.service.PostcodeService;
import com.lzhao.framework.spring_hibernate.demo.util.RandomUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 *
 * @author Liang Zhao <alpha.roc@gmail.com>
 */
@Component
public class App {

    private static final Log log = LogFactory.getLog(App.class);
    private static PostcodeService pService;

    // Setter based injection for @Autowired static field
    @Autowired
    private void setPostcodeService(PostcodeService pService) {
        App.pService = pService;
    }

    public static void main(String[] args) {
        new ClassPathXmlApplicationContext("application-context.xml");
        for (int i = 0; i < 100; i++) {
            Postcode p = new Postcode(RandomUtil.randomPostcode(),
                    RandomUtil.randomLocality(),
                    RandomUtil.randomStateAbbr());
            pService.save(p);
        }
    }
}
