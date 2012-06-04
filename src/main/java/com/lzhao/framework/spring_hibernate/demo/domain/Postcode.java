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
package com.lzhao.framework.spring_hibernate.demo.domain;

import com.lzhao.framework.spring_hibernate.base.domain.DomainObjectImpl;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author Liang Zhao <alpha.roc@gmail.com>
 */
@Entity
@Table(name = "POSTCODE_TABLE")
public class Postcode extends DomainObjectImpl {

    private static final Log log = LogFactory.getLog(Postcode.class);
    @Column(name = "PCODE", nullable = false)
    private String pcode;
    @Column(name = "LOCALITY", nullable = false)
    private String locality;
    @Column(name = "STATE_ABBR", nullable = false)
    private String stateAbbr;

    public enum STATE_NAME {

        ACT("Australian Capital Territory"),
        NSW("New South Wales"),
        NT("Northern Territory"),
        QLD("Queensland"),
        SA("South Australia"),
        TAS("Tasmania"),
        VIC("Victoria"),
        WA("Western Australia");
        private String name;

        STATE_NAME(String value) {
            this.name = value;
        }

        public String getName() {
            return name;
        }
    }

    public Postcode() {
    }

    public Postcode(String pcode, String locality, String stateAbbr) {
        this.pcode = pcode;
        this.locality = locality;
        this.stateAbbr = stateAbbr;
    }

    /**
     * @return the pcode
     */
    public String getPcode() {
        return pcode;
    }

    /**
     * @param pcode the pcode to set
     */
    public void setPcode(String pcode) {
        this.pcode = pcode;
    }

    /**
     * @return the locality
     */
    public String getLocality() {
        return locality;
    }

    /**
     * @param locality the locality to set
     */
    public void setLocality(String locality) {
        this.locality = locality;
    }

    /**
     * @return the state
     */
    public String getStateShortName() {
        return stateAbbr;
    }

    /**
     * @return the state
     */
    public String getStateLongName() {
        return STATE_NAME.valueOf(stateAbbr).getName();
    }

    /**
     * @return the state
     */
    public String getStateAbbr() {
        return stateAbbr;
    }

    /**
     * @param state the state to set
     */
    public void setStateAbbr(String stateAbbr) {
        this.stateAbbr = stateAbbr;
    }
}
