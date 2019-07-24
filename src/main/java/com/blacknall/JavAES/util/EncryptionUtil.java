package com.blacknall.JavAES.util;

import lombok.extern.slf4j.Slf4j;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

@Slf4j
public class EncryptionUtil {

    public static byte[] encrypt(Object object, Key key) {

        try {
            Cipher cipher;
            ObjectOutputStream os;
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            os = new ObjectOutputStream(out);
            cipher = Cipher.getInstance("AES");
            os.writeObject(object);
            cipher.init(Cipher.ENCRYPT_MODE, key);
            return cipher.doFinal(out.toByteArray());

        } catch (NoSuchAlgorithmException e) {
            log.info("no algoritm");
        } catch (NoSuchPaddingException e) {
            log.info("no padding");
        } catch (IOException e) {
            log.info("io error");
        } catch (BadPaddingException e) {
            log.info("Bad padding");
        } catch (IllegalBlockSizeException e) {
            log.info("bad block size");
        } catch (InvalidKeyException e) {
            log.info("Bad key");
        }
        return new byte[0];
    }

    public static Object decrypt(byte[] bytes, Key key) {

        try {       //get key, pass to cipher, wrap param in byteinput, decrypt byte param
            ObjectInputStream os;
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] decryptedBytes = cipher.doFinal(bytes);
            ByteArrayInputStream out = new ByteArrayInputStream(decryptedBytes);
            out.close();
            os = new ObjectInputStream(out);
            os.close();
            return os.readObject();
        } catch (IOException e) {
            log.info("io ex");
        } catch (NoSuchAlgorithmException e) {
            log.info("algo");
        } catch (InvalidKeyException e) {
            log.info("bad key");
        } catch (NoSuchPaddingException e) {
            log.info("no padding");
        } catch (BadPaddingException e) {
            log.info(e.getMessage());
            log.info("bad padding");
        } catch (IllegalBlockSizeException e) {
            log.info("bad block size");
        } catch (ClassNotFoundException e) {
            log.info("class not found");
        }
        return new Object();
    }
}
