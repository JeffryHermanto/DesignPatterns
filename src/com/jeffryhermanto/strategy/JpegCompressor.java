package com.jeffryhermanto.strategy;

public class JpegCompressor implements Compressor {
    @Override
    public void compress(String fileName) {
        System.out.println("Compressing " + fileName + " using JPEG");
    }
}
