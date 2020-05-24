package model;

import java.sql.Date;

public class Billing {
    private static String billingId;
    private static Date createdAt;
    private static Float price;

    public String getBillingId() {
        return billingId;
    }

    public void setBillingId(String billingId) {
        Billing.billingId = billingId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        Billing.createdAt = createdAt;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        Billing.price = price;
    }
}
