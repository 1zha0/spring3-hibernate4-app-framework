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
package com.lzhao.framework.spring_hibernate.demo.service;

import com.lzhao.framework.spring_hibernate.base.service.ServiceImpl;
import com.lzhao.framework.spring_hibernate.demo.dao.PostcodeDao;
import com.lzhao.framework.spring_hibernate.demo.domain.Postcode;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Liang Zhao <alpha.roc@gmail.com>
 */
@Service
public class PostcodeServiceImpl extends ServiceImpl<Postcode> implements PostcodeService {

    private static final Log log = LogFactory.getLog(PostcodeServiceImpl.class);
    @Autowired
    private PostcodeDao dao;

    public Postcode find(Long id) {
        return dao.find(id);
    }

    public List<Postcode> findAll() {
        return dao.findAll();
    }

    public List<Postcode> findByPostcode(String pcode) {
        return dao.findByPostcode(pcode);
    }

    public List<Postcode> findByState(String stateAbbr) {
        return dao.findByState(Postcode.STATE_NAME.valueOf(stateAbbr).toString());
    }
}
