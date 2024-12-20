/*
 * Copyright 2021 Wovenware, Inc
 *
 * Wovenware licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License. You may obtain a copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package org.killbill.billing.plugin.moyasar.api;

import org.killbill.billing.payment.api.PluginProperty;
import org.killbill.billing.plugin.api.PluginProperties;
import org.killbill.billing.plugin.api.payment.PluginPaymentMethodPlugin;
import org.killbill.billing.plugin.moyasar.dao.MoyasarDao;
import org.killbill.billing.plugin.moyasar.dao.gen.tables.records.MoyasarPaymentMethodsRecord;

import java.util.List;
import java.util.UUID;


public class MoyasarPaymentMethodPlugin extends PluginPaymentMethodPlugin {

    public static MoyasarPaymentMethodPlugin build(MoyasarPaymentMethodsRecord moyasarPaymentMethodsRecord){
        final String externalPaymentMethodId = moyasarPaymentMethodsRecord.getMoyasarId();
        return new MoyasarPaymentMethodPlugin(UUID.fromString(moyasarPaymentMethodsRecord.getKbPaymentMethodId()),
                externalPaymentMethodId,
                moyasarPaymentMethodsRecord.getIsDefault() == MoyasarDao.TRUE,
                PluginProperties.buildPluginProperties(MoyasarDao.mapFromAdditionalDataString(String.valueOf(moyasarPaymentMethodsRecord.getAdditionalData()))));
    }

    public MoyasarPaymentMethodPlugin(final UUID kbPaymentMethodId,
                                      final String externalPaymentMethodId,
                                      final boolean isDefaultPaymentMethod,
                                      final List<PluginProperty> properties) {
        super(kbPaymentMethodId, externalPaymentMethodId, isDefaultPaymentMethod, properties);
    }
}
