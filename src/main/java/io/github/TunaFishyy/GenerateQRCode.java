package io.github.TunaFishyy;

import com.google.zxing.*;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class GenerateQRCode {

    public static void generateQRcode(String data, String path, String charset, Map map, int h, int w) throws WriterException, IOException {
        BitMatrix matrix = new MultiFormatWriter().encode(new String(data.getBytes(charset), charset), BarcodeFormat.QR_CODE, w, h);
        MatrixToImageWriter.writeToFile(matrix, path.substring(path.lastIndexOf('.') + 1), new File(path));
    }

    public static void main(String[] args) throws WriterException, IOException, NotFoundException {
        String str = "DUMMY";
        String path = "C:\\dev\\intellij\\QRCodeGenerator\\src\\main\\java\\io\\github\\TunaFishyy\\Dummy.png";
        String charset = "UTF-8";

        Map<EncodeHintType, ErrorCorrectionLevel> map = new HashMap<>();
        map.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);

        generateQRcode(str, path, charset, map, 200, 200);

        System.out.println("<QR Code created>");
    }



}