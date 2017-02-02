package com.web.Pic;

/**
 * Created by shiyi on 2016/12/14.
 */

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.HmacUtils;

import java.util.Random;

public class FileCloudSign {
    public FileCloudSign() {
    }

    public static String appSign(int appId, String secret_id, String secret_key, long expired) {
        return appSignBase(appId, secret_id, secret_key, "", expired, "");
    }

    public static String appSignV2(int appId, String secret_id, String secret_key, String bucket, long expired) {
        return appSignBase(appId, secret_id, secret_key, bucket, expired, "");
    }

    public static String appSignOnce(int appId, String secret_id, String secret_key, String fileid) {
        return appSignBase(appId, secret_id, secret_key, "", 0L, fileid);
    }

    public static String appSignOnceV2(int appId, String secret_id, String secret_key, String bucket, String fileid) {
        return appSignBase(appId, secret_id, secret_key, bucket, 0L, fileid);
    }

    private static String appSignBase(int appId, String secret_id, String secret_key, String bucket, long expired, String fileid) {
        if(!empty(secret_id) && !empty(secret_key)) {
            long now = System.currentTimeMillis() / 1000L;
            int rdm = Math.abs((new Random()).nextInt());
            String plain_text = "";
            if(empty(bucket)) {
                plain_text = String.format("a=%d&k=%s&e=%d&t=%d&r=%d&u=%s&f=%s", new Object[]{Integer.valueOf(appId), secret_id, Long.valueOf(expired), Long.valueOf(now), Integer.valueOf(rdm), Integer.valueOf(0), fileid});
            } else {
                plain_text = String.format("a=%d&b=%s&k=%s&e=%d&t=%d&r=%d&u=%s&f=%s", new Object[]{Integer.valueOf(appId), bucket, secret_id, Long.valueOf(expired), Long.valueOf(now), Integer.valueOf(rdm), Integer.valueOf(0), fileid});
            }

            byte[] bin = HmacUtils.hmacSha1(secret_key, plain_text);
            byte[] all = new byte[bin.length + plain_text.getBytes().length];
            System.arraycopy(bin, 0, all, 0, bin.length);
            System.arraycopy(plain_text.getBytes(), 0, all, bin.length, plain_text.getBytes().length);
            all = Base64.encodeBase64(all);
            return new String(all);
        } else {
            return null;
        }
    }

    public static boolean empty(String s) {
        return s == null || s.trim().equals("") || s.trim().equals("null");
    }
}
