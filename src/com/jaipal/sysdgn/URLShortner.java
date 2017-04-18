package com.jaipal.sysdgn;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dreddy on 4/6/2017.
 */
public class URLShortner {


    public static Map<String, String> urlStore = new HashMap<>();
    public  static String baseUrl="http://tinyurl.com/";
//    public static String encode(String url) {
//
//    }

    public static String decode(String tinyUrl) {
        String hash=tinyUrl.substring(baseUrl.length());
        return urlStore.getOrDefault(hash,"");
    }
}
