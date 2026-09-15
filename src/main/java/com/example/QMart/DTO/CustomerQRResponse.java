package com.example.QMart.DTO;

public class CustomerQRResponse {

    private int customerId;
    private String qrCode;

    public CustomerQRResponse(int customerId, String qrCode) {
        this.customerId = customerId;
        this.qrCode = qrCode;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getQrCode() {
        return qrCode;
    }
}
