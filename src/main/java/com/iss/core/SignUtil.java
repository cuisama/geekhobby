package com.iss.core;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by yxcui on 2017/4/21.
 */
public class SignUtil {

    public static boolean checkSignature(String signature, String timestamp, String nonce){
        String token = "geekhobby";

        List<String> list = new ArrayList<String>();
        list.add(nonce);
        list.add(token);
        list.add(timestamp);
        Collections.sort(list);
        String source = list.get(0)+list.get(1)+list.get(2);

        StringBuilder sb = new StringBuilder();
        MessageDigest md5;
        try {
            md5 = MessageDigest.getInstance("SHA-1");
            md5.update(source.getBytes());
            for (byte b : md5.digest()) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString()==signature;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return false;
    }
}
