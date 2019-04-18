package com.qbtrance.djrank.utilities;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageWaterMarkInjection {

    public static void main(String... args) throws IOException {

        // overlay settings
        File input = new File("/tmp/duke.png");
        File overlay = new File("/tmp/watermark.png");
        File output = new File("/tmp/duke-image-watermarked.png");

        // adding text as overlay to an image
        addImageWatermark(overlay, "png", input, output);
    }

    private static void addImageWatermark(File watermark, String type, File source, File destination) throws IOException {
        BufferedImage image = ImageIO.read(source);
        BufferedImage overlay = resize(ImageIO.read(watermark), 150, 150);

        // determine image type and handle correct transparency
        int imageType = "png".equalsIgnoreCase(type) ? BufferedImage.TYPE_INT_ARGB : BufferedImage.TYPE_INT_RGB;
        BufferedImage watermarked = new BufferedImage(image.getWidth(), image.getHeight(), imageType);

        // initializes necessary graphic properties
        Graphics2D w = (Graphics2D) watermarked.getGraphics();
        w.drawImage(image, 0, 0, null);
        AlphaComposite alphaChannel = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.4f);
        w.setComposite(alphaChannel);

        // calculates the coordinate where the String is painted
        int centerX = image.getWidth() / 2;
        int centerY = image.getHeight() / 2;

        // add text watermark to the image
        w.drawImage(overlay, centerX, centerY, null);
        ImageIO.write(watermarked, type, destination);
        w.dispose();
    }

    private static BufferedImage resize(BufferedImage img, int height, int width) {
        Image tmp = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        BufferedImage resized = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = resized.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();
        return resized;
    }
}