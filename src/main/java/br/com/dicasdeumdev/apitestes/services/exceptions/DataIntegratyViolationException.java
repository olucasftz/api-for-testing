package br.com.dicasdeumdev.apitestes.services.exceptions;

public class DataIntegratyViolationException extends RuntimeException {

    public DataIntegratyViolationException(String message) {
        super(message);
    }
}
