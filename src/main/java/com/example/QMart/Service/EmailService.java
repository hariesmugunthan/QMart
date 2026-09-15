package com.example.QMart.Service;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.util.Base64;
import com.example.QMart.DTO.InvoiceRequest;
import java.util.List;
import com.example.QMart.Models.PurchasedItems;

import java.util.List;
import java.util.Map;
@Service
public class EmailService {
    @Autowired
    private JavaMailSender mailSender;

    public void sendCustomerQR(
            String email,
            int customerId,
            String qrCode) throws Exception {

        MimeMessage message = mailSender.createMimeMessage();

        MimeMessageHelper helper =
                new MimeMessageHelper(message, true);

        helper.setTo(email);

        helper.setSubject("QMart Customer QR");

        helper.setText(
                "Hello,\n\n" +
                        "Your QMart Customer ID is: " + customerId + "\n\n" +
                        "Your QR code is attached to this email.\n\n" +
                        "Thank you,\n" +
                        "QMart"
        );

        byte[] qrBytes = Base64.getDecoder().decode(qrCode);

        helper.addAttachment(
                "QMart-Customer-" + customerId + ".png",
                new ByteArrayResource(qrBytes)
        );

        mailSender.send(message);
    }
    public void sendInvoice(
            String email,
            int customerId,
            List<InvoiceRequest.InvoiceItem> items) throws Exception {

        MimeMessage message = mailSender.createMimeMessage();

        MimeMessageHelper helper =
                new MimeMessageHelper(message, true);

        helper.setTo(email);

        helper.setSubject("QMart Invoice - Customer " + customerId);

        StringBuilder invoice = new StringBuilder();

        invoice.append("Hello,\n\n");
        invoice.append("Your QMart Invoice\n");
        invoice.append("====================\n\n");

        double total = 0;

        for (InvoiceRequest.InvoiceItem item : items) {

            invoice.append(item.getName())
                    .append(" x ")
                    .append(item.getQuantity())
                    .append(" = ₹")
                    .append(item.getSubtotal())
                    .append("\n");

            total += item.getSubtotal();
        }

        invoice.append("\n--------------------\n");
        invoice.append("Total: ₹").append(total);
        invoice.append("\n--------------------\n\n");

        invoice.append("Thank you for shopping at QMart!");

        helper.setText(invoice.toString());

        mailSender.send(message);
    }
    public void sendAllInvoice(
            String email,
            int customerId,
            Map<Integer, List<PurchasedItems>> grouped)
            throws Exception {

        MimeMessage message =
                mailSender.createMimeMessage();

        MimeMessageHelper helper =
                new MimeMessageHelper(message, true);

        helper.setTo(email);

        helper.setSubject(
                "QMart Complete Invoice - Customer "
                        + customerId
        );

        StringBuilder invoice =
                new StringBuilder();

        invoice.append("Hello,\n\n");

        invoice.append("QMart Complete Invoice\n");
        invoice.append("========================\n\n");

        invoice.append("Customer ID: ")
                .append(customerId)
                .append("\n\n");

        double grandTotal = 0;

        for (Map.Entry<Integer, List<PurchasedItems>> entry
                : grouped.entrySet()) {

            int shopId = entry.getKey();

            List<PurchasedItems> items =
                    entry.getValue();

            invoice.append("------------------------\n");

            invoice.append("Shop ID: ")
                    .append(shopId)
                    .append("\n");

            invoice.append("------------------------\n\n");

            double shopTotal = 0;

            for (PurchasedItems item : items) {

                invoice.append(
                        item.getProduct().getName()
                );

                invoice.append(" x ");

                invoice.append(
                        item.getQuantity()
                );

                invoice.append(" = ₹");

                invoice.append(
                        item.getSubtotal()
                );

                invoice.append("\n");

                shopTotal += item.getSubtotal();
            }

            invoice.append("\nShop Total: ₹")
                    .append(shopTotal)
                    .append("\n\n");

            grandTotal += shopTotal;
        }

        invoice.append("========================\n");

        invoice.append("Grand Total: ₹")
                .append(grandTotal)
                .append("\n");

        invoice.append("========================\n\n");

        invoice.append(
                "Thank you for shopping at QMart!"
        );

        helper.setText(invoice.toString());

        mailSender.send(message);
    }
}
