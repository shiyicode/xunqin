package com.web.Pic;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.ByteArrayBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by shiyi on 2016/12/14.
 */
public class PicCloud {

    protected static String PROCESS_DOMAIN = "service.image.myqcloud.com";
    protected int mAppId;
    protected String mSecretId;
    protected String mSecretKey;
    protected String mBucket;
    protected HttpClient mClient;

    public static PicCloud minstall = null;

    public static PicCloud getInstall(int appId, String secretId, String secretKey, String bucket)
    {
        if(minstall == null)
            minstall = new PicCloud(appId, secretId, secretKey, bucket);
        return minstall;
    }

    private PicCloud(int appId, String secretId, String secretKey, String bucket) {
        this.mAppId = appId;
        this.mSecretId = secretId;
        this.mSecretKey = secretKey;
        this.mBucket = bucket;

        this.mClient = new DefaultHttpClient();
    }

    public String getSign(long expired) {
        return FileCloudSign.appSignV2(mAppId, mSecretId, mSecretKey, mBucket, expired);
    }

    public int comparePicFile(String filenameA, String filenameB) throws IOException {

        long expired = System.currentTimeMillis()/1000L + 86400L;
        String sign = this.getSign(expired);

        HashMap header = new HashMap();
        header.put("Authorization", sign);
        header.put("Host", "service.image.myqcloud.com");

        HashMap body = new HashMap();

        body.put("appid", String.valueOf(mAppId));
        body.put("bucket", mBucket);

        System.out.println("B:"+body.toString());

        String reqUrl = "http://" + PROCESS_DOMAIN + "/face/compare";

//        CloudClient cloudClient = new CloudClient();
//        String info = cloudClient.post(reqUrl, header, (HashMap)null, reqData.toString().getBytes());

//        FileInputStream f = new FileInputStream(filenameA);
//        byte data[] = new byte[f.available()];
//        f.read(data);
//        f.close();
//        byte[][] d = {data};
//        String[] s = {"asas"};
//        String info = cloudClient.postfiles(reqUrl, header, body, d, s);
        String filenames[] = {filenameA, filenameB};
        String filkeys[] = {"imageA", "imageB"};

        String info = null;
        try {
            info = this.postfile(reqUrl, header, body, filenames, filkeys);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(info+"D:");


        return 0;
    }

    public int comparePicUrl(String urlA, String urlB) {

        long expired = System.currentTimeMillis()/1000L + 86400L;
        String sign = this.getSign(expired);

        HashMap header = new HashMap();
        header.put("Authorization", sign);
        header.put("Host", "service.image.myqcloud.com");

        JSONObject reqData = new JSONObject();

        reqData.put("appid", String.valueOf(mAppId));
        reqData.put("bucket", mBucket);
//        urlA = URLEncoder.encode(urlA, "UTF-8");
//        urlB = URLEncoder.encode(urlB, "UTF-8");
        reqData.put("urlA", urlA);
        reqData.put("urlB", urlB);

        String reqUrl = "http://" + PROCESS_DOMAIN + "/face/compare";

//        CloudClient cloudClient = new CloudClient();
//        String info = cloudClient.post(reqUrl, header, (HashMap)null, reqData.toString().getBytes());
        String info = this.post(reqUrl, header, reqData.toString().getBytes());
        System.out.println(info);

        JSONObject jb = this.getResponse(info);
        if(jb != null) {
            JSONObject jd = jb.getJSONObject("data");
            if(jd.has("fail_flag")) {
                int fail_flag = jd.getInt("fail_flag");
                return -1*fail_flag;
            }

            int similarity = jd.getInt("similarity");
            return  similarity;
        }

        return  -3;
    }

    public Boolean checkPicFile(String filename) {

        return  true;
    }

    public Boolean checkPicUrl(String url) {

        return  true;
    }

    public String post(String url, Map<String, String> header, byte[] data) {

        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader("accept", "*/*");
        httpPost.setHeader("connection", "Keep-Alive");
        httpPost.setHeader("user-agent", "qcloud-java-sdk");
        httpPost.setHeader("Content-Type", "application/json");

        if(header != null) {
            Iterator httpResponse = header.keySet().iterator();

            while(httpResponse.hasNext()) {
                String code = (String)httpResponse.next();
                httpPost.setHeader(code, (String)header.get(code));
            }
        }

        if(data != null) {
            try {
                String dataString = new String(data);
                StringEntity code3 = new StringEntity(dataString);
                httpPost.setEntity(code3);

            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }

        String responseStr = null;
        try {
            HttpResponse httpResponse3 = this.mClient.execute(httpPost);
            responseStr = EntityUtils.toString(httpResponse3.getEntity(), "UTF-8");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return responseStr;
    }

    public String postfile(String url, Map<String, String> header, Map<String, String> body, String[] filename, String[] fileKey) throws UnsupportedEncodingException {
        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader("accept", "*/*");
        httpPost.setHeader("user-agent", "qcloud-java-sdk");
        httpPost.setHeader("connection", "Keep-Alive");
        httpPost.setHeader("user-agent", "qcloud-java-sdk");
        httpPost.setHeader("Content-Type", "multipart/form-data;boundary=-------------");

        if(header != null) {
            Iterator httpResponse = header.keySet().iterator();

            while(httpResponse.hasNext()) {
                String code = (String)httpResponse.next();
                httpPost.setHeader(code, (String)header.get(code));
            }
        }

        int var13;
        MultipartEntity var10 = new MultipartEntity();
        if(body != null) {
            Iterator var12 = body.keySet().iterator();

            while(var12.hasNext()) {
                String contentBody = (String)var12.next();
                System.out.println(contentBody);
                System.out.println(body.get(contentBody).toString());
//                var10.addPart(contentBody, new StringBody(body.get(contentBody).toString()));
            }

            var10.addPart("bucket", new StringBody(body.get("bucket").toString(), Charset.forName("UTF-8")));
            var10.addPart("appid", new StringBody(body.get("appid").toString(), Charset.forName("UTF-8")));

        }

        for(int i=0; i<filename.length; i++)
        {
            if(i == fileKey.length)
                break;

            try {
                FileInputStream fileInputStream = new FileInputStream(filename[i]);
                byte[] data = new byte[fileInputStream.available()];
                fileInputStream.read(data);
                data = new byte[fileInputStream.available()];

                ByteArrayBody bab = new ByteArrayBody(data, filename[i]);
                var10.addPart(fileKey[i], bab);

                fileInputStream.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        httpPost.setEntity(var10);

        System.out.println("length:" + var10.getContentLength());

        String responseStr = null;
        try {
            HttpResponse httpResponse3 = this.mClient.execute(httpPost);
            responseStr = EntityUtils.toString(httpResponse3.getEntity(), "UTF-8");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return responseStr;
    }

    public String get(String url, Map<String, String> header, Map<String, String> query) throws IOException {
        HttpGet httpGet = new HttpGet(url);
        httpGet.setHeader("accept", "*/*");
        httpGet.setHeader("connection", "Keep-Alive");
        httpGet.setHeader("user-agent", "qcloud-java-sdk");
        httpGet.setHeader("Host", "web.image.myqcloud.com");
        if(header != null) {
            Iterator httpResponse = header.keySet().iterator();

            while(httpResponse.hasNext()) {
                String key = (String)httpResponse.next();
                httpGet.setHeader(key, (String)header.get(key));
            }
        }

        if(query != null) {
            String httpResponse1 = "";

            String key1;
            for(Iterator key2 = query.keySet().iterator(); key2.hasNext(); httpResponse1 = httpResponse1 + key1 + '=' + URLEncoder.encode((String)query.get(key1))) {
                key1 = (String)key2.next();
                if(httpResponse1 != "") {
                    httpResponse1 = httpResponse1 + '&';
                }
            }

            if(url.indexOf(63) > 0) {
                (new StringBuilder()).append(url).append('&').append(httpResponse1).toString();
            } else {
                (new StringBuilder()).append(url).append('?').append(httpResponse1).toString();
            }
        }

        HttpResponse httpResponse2 = this.mClient.execute(httpGet);
        return EntityUtils.toString(httpResponse2.getEntity(), "UTF-8");
    }



    public JSONObject getResponse(String rsp) {
        if("".equals(rsp)) {
            this.outError(-1, "empty rsp");
            return null;
        } else {
            JSONObject pack = new JSONObject(rsp);
            int code = pack.getInt("code");
            String msg = pack.getString("message");
            if(code != 0) {
                this.outError(code, msg);
                return null;
            } else {
                return pack;
            }
        }
    }

    public void outError(int errno, String message) {
        System.out.println("[" + errno + "]:" + message);
    }
}
