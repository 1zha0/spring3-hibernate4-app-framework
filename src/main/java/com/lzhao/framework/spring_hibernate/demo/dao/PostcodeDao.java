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

import com.lzhao.framework.spring_hibernate.demo.domain.Postcode;
import java.util.List;

/**
 *
 * @author Liang Zhao <alpha.roc@gmail.com>
 */
public interface PostcodeDao {

    public Postcode find(Long id);

    public List<Postcode> findAll();

    public List<Postcode> findByPostcode(String pcode);

    public List<Postcode> findByState(String stateAbbr);
}
