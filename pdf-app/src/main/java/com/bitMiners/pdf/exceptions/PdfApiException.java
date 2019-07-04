package com.bitMiners.pdf.exceptions;

public class PdfApiException extends RuntimeException {
    private final String message;
    private final int code;

    public PdfApiException(final String message, final int code) {
        super(message);
        this.message = message;
        this.code = code;
    }

    public PdfApiException(final String message, final int code, Throwable throwable) {
        super(message, throwable);
        this.message = message;
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }
}
