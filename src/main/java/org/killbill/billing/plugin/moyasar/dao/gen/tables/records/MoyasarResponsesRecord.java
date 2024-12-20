/*
 * This file is generated by jOOQ.
 */
package org.killbill.billing.plugin.moyasar.dao.gen.tables.records;


import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record11;
import org.jooq.Row11;
import org.jooq.impl.UpdatableRecordImpl;
import org.jooq.types.ULong;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class MoyasarResponsesRecord extends UpdatableRecordImpl<org.killbill.billing.plugin.moyasar.dao.gen.tables.records.MoyasarResponsesRecord> implements Record11<ULong, String, String, String, String, BigDecimal, String, String, String, LocalDateTime, String> {

    private static final long serialVersionUID = 1915510161;

    /**
     * Setter for <code>killbill.moyasar_responses.record_id</code>.
     */
    public void setRecordId(ULong value) {
        set(0, value);
    }

    /**
     * Getter for <code>killbill.moyasar_responses.record_id</code>.
     */
    public ULong getRecordId() {
        return (ULong) get(0);
    }

    /**
     * Setter for <code>killbill.moyasar_responses.kb_account_id</code>.
     */
    public void setKbAccountId(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>killbill.moyasar_responses.kb_account_id</code>.
     */
    public String getKbAccountId() {
        return (String) get(1);
    }

    /**
     * Setter for <code>killbill.moyasar_responses.kb_payment_id</code>.
     */
    public void setKbPaymentId(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>killbill.moyasar_responses.kb_payment_id</code>.
     */
    public String getKbPaymentId() {
        return (String) get(2);
    }

    /**
     * Setter for <code>killbill.moyasar_responses.kb_payment_transaction_id</code>.
     */
    public void setKbPaymentTransactionId(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>killbill.moyasar_responses.kb_payment_transaction_id</code>.
     */
    public String getKbPaymentTransactionId() {
        return (String) get(3);
    }

    /**
     * Setter for <code>killbill.moyasar_responses.transaction_type</code>.
     */
    public void setTransactionType(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>killbill.moyasar_responses.transaction_type</code>.
     */
    public String getTransactionType() {
        return (String) get(4);
    }

    /**
     * Setter for <code>killbill.moyasar_responses.amount</code>.
     */
    public void setAmount(BigDecimal value) {
        set(5, value);
    }

    /**
     * Getter for <code>killbill.moyasar_responses.amount</code>.
     */
    public BigDecimal getAmount() {
        return (BigDecimal) get(5);
    }

    /**
     * Setter for <code>killbill.moyasar_responses.currency</code>.
     */
    public void setCurrency(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>killbill.moyasar_responses.currency</code>.
     */
    public String getCurrency() {
        return (String) get(6);
    }

    /**
     * Setter for <code>killbill.moyasar_responses.moyasar_id</code>.
     */
    public void setMoyasarId(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>killbill.moyasar_responses.moyasar_id</code>.
     */
    public String getMoyasarId() {
        return (String) get(7);
    }

    /**
     * Setter for <code>killbill.moyasar_responses.additional_data</code>.
     */
    public void setAdditionalData(String value) {
        set(8, value);
    }

    /**
     * Getter for <code>killbill.moyasar_responses.additional_data</code>.
     */
    public String getAdditionalData() {
        return (String) get(8);
    }

    /**
     * Setter for <code>killbill.moyasar_responses.created_date</code>.
     */
    public void setCreatedDate(LocalDateTime value) {
        set(9, value);
    }

    /**
     * Getter for <code>killbill.moyasar_responses.created_date</code>.
     */
    public LocalDateTime getCreatedDate() {
        return (LocalDateTime) get(9);
    }

    /**
     * Setter for <code>killbill.moyasar_responses.kb_tenant_id</code>.
     */
    public void setKbTenantId(String value) {
        set(10, value);
    }

    /**
     * Getter for <code>killbill.moyasar_responses.kb_tenant_id</code>.
     */
    public String getKbTenantId() {
        return (String) get(10);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<ULong> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record11 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row11<ULong, String, String, String, String, BigDecimal, String, String, String, LocalDateTime, String> fieldsRow() {
        return (Row11) super.fieldsRow();
    }

    @Override
    public Row11<ULong, String, String, String, String, BigDecimal, String, String, String, LocalDateTime, String> valuesRow() {
        return (Row11) super.valuesRow();
    }

    @Override
    public Field<ULong> field1() {
        return org.killbill.billing.plugin.moyasar.dao.gen.tables.MoyasarResponses.MOYASAR_RESPONSES.RECORD_ID;
    }

    @Override
    public Field<String> field2() {
        return org.killbill.billing.plugin.moyasar.dao.gen.tables.MoyasarResponses.MOYASAR_RESPONSES.KB_ACCOUNT_ID;
    }

    @Override
    public Field<String> field3() {
        return org.killbill.billing.plugin.moyasar.dao.gen.tables.MoyasarResponses.MOYASAR_RESPONSES.KB_PAYMENT_ID;
    }

    @Override
    public Field<String> field4() {
        return org.killbill.billing.plugin.moyasar.dao.gen.tables.MoyasarResponses.MOYASAR_RESPONSES.KB_PAYMENT_TRANSACTION_ID;
    }

    @Override
    public Field<String> field5() {
        return org.killbill.billing.plugin.moyasar.dao.gen.tables.MoyasarResponses.MOYASAR_RESPONSES.TRANSACTION_TYPE;
    }

    @Override
    public Field<BigDecimal> field6() {
        return org.killbill.billing.plugin.moyasar.dao.gen.tables.MoyasarResponses.MOYASAR_RESPONSES.AMOUNT;
    }

    @Override
    public Field<String> field7() {
        return org.killbill.billing.plugin.moyasar.dao.gen.tables.MoyasarResponses.MOYASAR_RESPONSES.CURRENCY;
    }

    @Override
    public Field<String> field8() {
        return org.killbill.billing.plugin.moyasar.dao.gen.tables.MoyasarResponses.MOYASAR_RESPONSES.MOYASAR_ID;
    }

    @Override
    public Field<String> field9() {
        return org.killbill.billing.plugin.moyasar.dao.gen.tables.MoyasarResponses.MOYASAR_RESPONSES.ADDITIONAL_DATA;
    }

    @Override
    public Field<LocalDateTime> field10() {
        return org.killbill.billing.plugin.moyasar.dao.gen.tables.MoyasarResponses.MOYASAR_RESPONSES.CREATED_DATE;
    }

    @Override
    public Field<String> field11() {
        return org.killbill.billing.plugin.moyasar.dao.gen.tables.MoyasarResponses.MOYASAR_RESPONSES.KB_TENANT_ID;
    }

    @Override
    public ULong component1() {
        return getRecordId();
    }

    @Override
    public String component2() {
        return getKbAccountId();
    }

    @Override
    public String component3() {
        return getKbPaymentId();
    }

    @Override
    public String component4() {
        return getKbPaymentTransactionId();
    }

    @Override
    public String component5() {
        return getTransactionType();
    }

    @Override
    public BigDecimal component6() {
        return getAmount();
    }

    @Override
    public String component7() {
        return getCurrency();
    }

    @Override
    public String component8() {
        return getMoyasarId();
    }

    @Override
    public String component9() {
        return getAdditionalData();
    }

    @Override
    public LocalDateTime component10() {
        return getCreatedDate();
    }

    @Override
    public String component11() {
        return getKbTenantId();
    }

    @Override
    public ULong value1() {
        return getRecordId();
    }

    @Override
    public String value2() {
        return getKbAccountId();
    }

    @Override
    public String value3() {
        return getKbPaymentId();
    }

    @Override
    public String value4() {
        return getKbPaymentTransactionId();
    }

    @Override
    public String value5() {
        return getTransactionType();
    }

    @Override
    public BigDecimal value6() {
        return getAmount();
    }

    @Override
    public String value7() {
        return getCurrency();
    }

    @Override
    public String value8() {
        return getMoyasarId();
    }

    @Override
    public String value9() {
        return getAdditionalData();
    }

    @Override
    public LocalDateTime value10() {
        return getCreatedDate();
    }

    @Override
    public String value11() {
        return getKbTenantId();
    }

    @Override
    public org.killbill.billing.plugin.moyasar.dao.gen.tables.records.MoyasarResponsesRecord value1(ULong value) {
        setRecordId(value);
        return this;
    }

    @Override
    public org.killbill.billing.plugin.moyasar.dao.gen.tables.records.MoyasarResponsesRecord value2(String value) {
        setKbAccountId(value);
        return this;
    }

    @Override
    public org.killbill.billing.plugin.moyasar.dao.gen.tables.records.MoyasarResponsesRecord value3(String value) {
        setKbPaymentId(value);
        return this;
    }

    @Override
    public org.killbill.billing.plugin.moyasar.dao.gen.tables.records.MoyasarResponsesRecord value4(String value) {
        setKbPaymentTransactionId(value);
        return this;
    }

    @Override
    public org.killbill.billing.plugin.moyasar.dao.gen.tables.records.MoyasarResponsesRecord value5(String value) {
        setTransactionType(value);
        return this;
    }

    @Override
    public org.killbill.billing.plugin.moyasar.dao.gen.tables.records.MoyasarResponsesRecord value6(BigDecimal value) {
        setAmount(value);
        return this;
    }

    @Override
    public org.killbill.billing.plugin.moyasar.dao.gen.tables.records.MoyasarResponsesRecord value7(String value) {
        setCurrency(value);
        return this;
    }

    @Override
    public org.killbill.billing.plugin.moyasar.dao.gen.tables.records.MoyasarResponsesRecord value8(String value) {
        setMoyasarId(value);
        return this;
    }

    @Override
    public org.killbill.billing.plugin.moyasar.dao.gen.tables.records.MoyasarResponsesRecord value9(String value) {
        setAdditionalData(value);
        return this;
    }

    @Override
    public org.killbill.billing.plugin.moyasar.dao.gen.tables.records.MoyasarResponsesRecord value10(LocalDateTime value) {
        setCreatedDate(value);
        return this;
    }

    @Override
    public org.killbill.billing.plugin.moyasar.dao.gen.tables.records.MoyasarResponsesRecord value11(String value) {
        setKbTenantId(value);
        return this;
    }

    @Override
    public org.killbill.billing.plugin.moyasar.dao.gen.tables.records.MoyasarResponsesRecord values(ULong value1, String value2, String value3, String value4, String value5, BigDecimal value6, String value7, String value8, String value9, LocalDateTime value10, String value11) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached MoyasarResponsesRecord
     */
    public MoyasarResponsesRecord() {
        super(org.killbill.billing.plugin.moyasar.dao.gen.tables.MoyasarResponses.MOYASAR_RESPONSES);
    }

    /**
     * Create a detached, initialised MoyasarResponsesRecord
     */
    public MoyasarResponsesRecord(ULong recordId, String kbAccountId, String kbPaymentId, String kbPaymentTransactionId, String transactionType, BigDecimal amount, String currency, String moyasarId, String additionalData, LocalDateTime createdDate, String kbTenantId) {
        super(org.killbill.billing.plugin.moyasar.dao.gen.tables.MoyasarResponses.MOYASAR_RESPONSES);

        set(0, recordId);
        set(1, kbAccountId);
        set(2, kbPaymentId);
        set(3, kbPaymentTransactionId);
        set(4, transactionType);
        set(5, amount);
        set(6, currency);
        set(7, moyasarId);
        set(8, additionalData);
        set(9, createdDate);
        set(10, kbTenantId);
    }
}
