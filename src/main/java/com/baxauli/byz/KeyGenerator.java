package com.baxauli.byz;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SignatureException;

/**
 * Gerador de par de chaves (pública e privada) para a criação e 
 * verificação de assinaturas digitais.
 *
 * @author Marcelo Baxauli <mlb122@hotmail.com>
 */
public class KeyGenerator 
{
    public static void main( String[] args ) throws NoSuchAlgorithmException, NoSuchProviderException, FileNotFoundException, IOException, InvalidKeyException, SignatureException
    {
        
        System.out.println("Creating new keypair:");
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("DSA");
        
        keyGen.initialize(1024);
        
        KeyPair pair = keyGen.generateKeyPair();
        PrivateKey priv = pair.getPrivate();
        PublicKey pub = pair.getPublic();
        
        String currentWorkingPath = new File("").getAbsolutePath();

        System.out.printf("%s%spublic-key\n", currentWorkingPath, File.separator);        
        outputToFile(pub.getEncoded(), "public-key");
        System.out.printf("%s%sprivate-key\n", currentWorkingPath, File.separator);
        outputToFile(priv.getEncoded(), "private-key");
        System.out.println("Done.");
        
    }
    
    private static void outputToFile(byte[] array, String fileName) throws FileNotFoundException, IOException {
        FileOutputStream output = new FileOutputStream(fileName);
        output.write(array);
        output.close();
    }
}
