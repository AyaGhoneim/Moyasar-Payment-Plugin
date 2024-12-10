package org.killbill.billing.plugin.moyasar.client;

import java.util.Map;

public interface PaymentMethod {

    /**
     * Get the unique token for the payment method.
     *
     * @return The payment method token.
     */
    String getToken();

    /**
     * Check if this is the default payment method.
     *
     * @return True if it is the default payment method, false otherwise.
     */
    boolean isDefault();

    /**
     * Get the image URL representing the payment method (e.g., card type icon).
     *
     * @return The image URL.
     */
    String getImageUrl();

    /**
     * Get the customer ID associated with this payment method.
     *
     * @return The customer ID.
     */
    String getCustomerId();

    /**
     * Get additional details of the payment method (e.g., card type, last four digits).
     *
     * @return A map of payment method details.
     */
    Map<String, String> getDetails();
}
