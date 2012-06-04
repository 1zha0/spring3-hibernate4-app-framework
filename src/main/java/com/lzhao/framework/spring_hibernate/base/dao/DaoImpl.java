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
package com.lzhao.framework.spring_hibernate.base.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author Liang Zhao <alpha.roc@gmail.com>
 */
public class DaoImpl<T> implements Dao<T> {

    private static final Log log = LogFactory.getLog(DaoImpl.class);
    @PersistenceContext
    private EntityManager em;

    public T find(Class<T> clazz, Long id) {
        return (T) em.find(clazz, id);
    }

    public List<T> findAll(Class<T> clazz) {
        return (List<T>) em.createQuery("FROM " + clazz.getSimpleName()).getResultList();
    }

    public T save(T t) {
        return em.merge(t);
    }

    public void delete(T t) {
        em.remove(t);
    }

    public void refresh(T t) {
        em.refresh(t);
    }
}