package com.example.QMart.Service;

import org.springframework.stereotype.Service;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
@Service
public class QRService {
    public String generateQR(int customerId) throws WriterException, IOException {

        QRCodeWriter writer = new QRCodeWriter();

        BitMatrix matrix = writer.encode(
                String.valueOf(customerId),
                BarcodeFormat.QR_CODE,
                300,
                300
        );

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        MatrixToImageWriter.writeToStream(
                matrix,
                "PNG",
                outputStream
        );

        byte[] qrBytes = outputStream.toByteArray();

        return Base64.getEncoder().encodeToString(qrBytes);
    }
}
