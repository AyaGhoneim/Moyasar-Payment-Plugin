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

package org.killbill.billing.plugin.moyasar.core;

import com.google.common.base.Ascii;
import com.google.common.base.MoreObjects;
import com.google.common.base.Strings;
import org.joda.time.Period;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

public class MoyasarConfigProperties {

	private static final String PROPERTY_PREFIX = "org.killbill.billing.plugin.moyasar.";

	public static final String MOYASAR_ENVIRONMENT_KEY = "MOYASAR_ENVIRONMENT";
	public static final String MOYASAR_MERCHANT_ID_KEY = "MOYASAR_MERCHANT_ID";
	public static final String MOYASAR_PUBLIC_KEY = "MOYASAR_PUBLIC_KEY";
	public static final String MOYASAR_PRIVATE_KEY = "MOYASAR_PRIVATE_KEY";

	public static final String DEFAULT_PENDING_PAYMENT_EXPIRATION_PERIOD = "P3d";

	private static final String ENTRY_DELIMITER = "|";
	private static final String KEY_VALUE_DELIMITER = "#";
	private static final String DEFAULT_CONNECTION_TIMEOUT = "30000";
	private static final String DEFAULT_READ_TIMEOUT = "60000";

	private final String region;
    private final String btEnvironment;
    private final String btMerchantId;
    private final String btPublicKey;
    private final String btPrivateKey;
	private final String connectionTimeout;
	private final String readTimeout;
	private final Period pendingPaymentExpirationPeriod;
	private final Map<String, Period> paymentMethodToExpirationPeriod = new LinkedHashMap<String, Period>();
	private final String chargeDescription;
	private final String chargeStatementDescriptor;

	public MoyasarConfigProperties(final Properties properties, final String region) {
		this.region = region;
		this.btEnvironment = properties.getProperty(PROPERTY_PREFIX + "btEnvironment", "sandbox");
		this.btMerchantId = properties.getProperty(PROPERTY_PREFIX + "btMerchantId");
		this.btPublicKey = properties.getProperty(PROPERTY_PREFIX + "btPublicKey");
		this.btPrivateKey = properties.getProperty(PROPERTY_PREFIX + "btPrivateKey");
		this.connectionTimeout = properties.getProperty(PROPERTY_PREFIX + "connectionTimeout", DEFAULT_CONNECTION_TIMEOUT);
		this.readTimeout = properties.getProperty(PROPERTY_PREFIX + "readTimeout", DEFAULT_READ_TIMEOUT);
		this.pendingPaymentExpirationPeriod = readPendingExpirationProperty(properties);
		this.chargeDescription = Ascii.truncate(MoreObjects.firstNonNull(properties.getProperty(PROPERTY_PREFIX + "chargeDescription"), "Kill Bill charge"), 22, "...");
		this.chargeStatementDescriptor = Ascii.truncate(MoreObjects.firstNonNull(properties.getProperty(PROPERTY_PREFIX + "chargeStatementDescriptor"), "Kill Bill charge"), 22, "...");
	}

	public String getRegion() {
		return region;
	}

	public String getBtEnvironment() {
		if (btEnvironment == null || btEnvironment.isEmpty()) {
			return getClient(MOYASAR_ENVIRONMENT_KEY, null);
		}
		return btEnvironment;
	}

	public String getBtMerchantId() {
		if (btMerchantId == null || btMerchantId.isEmpty()) {
			return getClient(MOYASAR_MERCHANT_ID_KEY, null);
		}
		return btMerchantId;
	}

	public String getBtPublicKey() {
		if (btPublicKey == null || btPublicKey.isEmpty()) {
			return getClient(MOYASAR_PUBLIC_KEY, null);
		}
		return btPublicKey;
	}

	public String getBtPrivateKey() {
		if (btPrivateKey == null || btPrivateKey.isEmpty()) {
			return getClient(MOYASAR_PRIVATE_KEY, null);
		}
		return btPrivateKey;
	}

	public String getConnectionTimeout() {
		return connectionTimeout;
	}

	public String getReadTimeout() {
		return readTimeout;
	}

	public String getChargeDescription() {
		return chargeDescription;
	}

	public String getChargeStatementDescriptor() {
		return chargeStatementDescriptor;
	}

	public Period getPendingPaymentExpirationPeriod(@Nullable final String paymentMethod) {
		if (paymentMethod != null && paymentMethodToExpirationPeriod.get(paymentMethod.toLowerCase()) != null) {
			return paymentMethodToExpirationPeriod.get(paymentMethod.toLowerCase());
		} else {
			return pendingPaymentExpirationPeriod;
		}
	}

	private Period readPendingExpirationProperty(final Properties properties) {
		final String pendingExpirationPeriods = properties.getProperty(PROPERTY_PREFIX + "pendingPaymentExpirationPeriod");
		final Map<String, String> paymentMethodToExpirationPeriodString = new HashMap<String, String>();
		refillMap(paymentMethodToExpirationPeriodString, pendingExpirationPeriods);
		// No per-payment method override, just a global setting
		if (pendingExpirationPeriods != null && paymentMethodToExpirationPeriodString.isEmpty()) {
			try {
				return Period.parse(pendingExpirationPeriods);
			} catch (final IllegalArgumentException e) { /* Ignore */ }
		}

		// User has defined per-payment method overrides
		for (final Map.Entry<String, String> entry : paymentMethodToExpirationPeriodString.entrySet()) {
			try {
				paymentMethodToExpirationPeriod.put(entry.getKey().toLowerCase(), Period.parse(entry.getValue()));
			} catch (final IllegalArgumentException e) { /* Ignore */ }
		}

		return Period.parse(DEFAULT_PENDING_PAYMENT_EXPIRATION_PERIOD);
	}

	private synchronized void refillMap(final Map<String, String> map, final String stringToSplit) {
		map.clear();
		if (!Strings.isNullOrEmpty(stringToSplit)) {
			for (final String entry : stringToSplit.split("\\" + ENTRY_DELIMITER)) {
				final String[] split = entry.split(KEY_VALUE_DELIMITER);
				if (split.length > 1) {
					map.put(split[0], split[1]);
				}
			}
		}
	}

	private String getClient(String envKey, String defaultValue) {
		Map<String, String> env = System.getenv();

		String value = env.get(envKey);

		if (value == null || value.isEmpty()) {
			return defaultValue;
		}

		return value;
	}
}
