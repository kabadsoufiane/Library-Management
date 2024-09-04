package com.library.libraryManagement;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.util.Base64;

public class SecretGenerator {
    public static void main(String[] args) {
        // Générer une clé de 512 bits (64 octets) pour l'algorithme HS512
        byte[] keyBytes = Keys.secretKeyFor(SignatureAlgorithm.HS512).getEncoded();
        String base64Key = Base64.getEncoder().encodeToString(keyBytes);
        System.out.println("Generated Base64 Key: " + base64Key);
    }
}