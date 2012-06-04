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
package com.lzhao.framework.spring_hibernate.base.service;

import com.lzhao.framework.spring_hibernate.base.dao.Dao;
import com.lzhao.framework.spring_hibernate.base.service.Service;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Liang Zhao <alpha.roc@gmail.com>
 */
public class ServiceImpl<T> implements Service<T> {

    private static final Log log = LogFactory.getLog(ServiceImpl.class);
    @Autowired
    private Dao<T> dao;

    public Dao<T> getDao() {
        return dao;
    }

    public void setDao(Dao<T> dao) {
        this.dao = dao;
    }

    public T find(Class<T> clazz, Long id) {
        return dao.find(clazz, id);
    }

    public List<T> findAll(Class<T> clazz) {
        return dao.findAll(clazz);
    }

    @Transactional
    public T save(T t) {
        return dao.save(t);
    }

    @Transactional
    public void saveAll(List<T> l) {
        for (T t : l) {
            dao.save(t);
        }
    }

    @Transactional
    public void delete(T t) {
        dao.delete(t);
    }

    public void refresh(T t) {
        dao.refresh(t);
    }
}
