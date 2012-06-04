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
package com.lzhao.framework.spring_hibernate.demo.dao;

import com.lzhao.framework.spring_hibernate.base.dao.DaoImpl;
import com.lzhao.framework.spring_hibernate.demo.domain.Postcode;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Liang Zhao <alpha.roc@gmail.com>
 */
@Repository
public class PostcodeDaoImpl extends DaoImpl<Postcode> implements PostcodeDao {

    private static final Log log = LogFactory.getLog(PostcodeDaoImpl.class);
    @PersistenceContext
    private EntityManager em;

    public Postcode find(Long id) {
        return super.find(Postcode.class, id);
    }

    public List<Postcode> findAll() {
        return super.findAll(Postcode.class);
    }

    public List<Postcode> findByPostcode(String pcode) {
        return em.createQuery("FROM Postcode p WHERE p.pcode = :value").
                setParameter("value", pcode).
                getResultList();
    }

    public List<Postcode> findByState(String stateAbbr) {
        return em.createQuery("FROM Postcode p WHERE p.stateAbbr = :value").
                setParameter("value", stateAbbr).
                getResultList();
    }
}
