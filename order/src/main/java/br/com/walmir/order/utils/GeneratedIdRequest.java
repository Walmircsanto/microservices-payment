package br.com.walmir.order.utils;

import br.com.walmir.order.dto.RequestOrderDTO;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class GeneratedIdRequest {

    public String generatedHashId(RequestOrderDTO request) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        String hashId = request.getIdProduct() + request.getNumberCard() + request.getOrderStatus();
        MessageDigest typeAlgorithm = MessageDigest.getInstance("SHA-256"); // o algoritmo precisa de uma sequencia de bytes para aplicar suas operações
        byte[] digest = typeAlgorithm.digest(hashId.getBytes());

        return new String(digest, "UTF-8");
    }
}
