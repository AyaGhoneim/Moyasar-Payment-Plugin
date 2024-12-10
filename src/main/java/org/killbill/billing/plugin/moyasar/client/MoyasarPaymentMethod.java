package org.killbill.billing.plugin.moyasar.client;

import java.util.Map;

public class MoyasarPaymentMethod implements PaymentMethod {
    private final String token;
    private final boolean isDefault;
    private final String imageUrl;
    private final String customerId;
    private final Map<String, String> details;

    public MoyasarPaymentMethod(String token, boolean isDefault, String imageUrl, String customerId, Map<String, String> details) {
        this.token = token;
        this.isDefault = isDefault;
        this.imageUrl = imageUrl;
        this.customerId = customerId;
        this.details = details;
    }

    @Override
    public String getToken() {
        return token;
    }

    @Override
    public boolean isDefault() {
        return isDefault;
    }

    @Override
    public String getImageUrl() {
        return imageUrl;
    }

    @Override
    public String getCustomerId() {
        return customerId;
    }

    @Override
    public Map<String, String> getDetails() {
        return details;
    }
}