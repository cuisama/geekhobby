package com.iss.test;

import org.junit.Test;

import java.util.Map;

/**
 * Created by yxcui on 2017/4/20.
 */
public class TTest {


    @Test
    public void aa(){
        String responseMsg = "<xml>"
                + "<ToUserName><![CDATA[%1$s]]></ToUserName>"
                + "<FromUserName><![CDATA[%2$s]]></FromUserName>"
                + "<CreateTime>%3$s</CreateTime>"
                + "<MsgType><![CDATA[%4$s]]></MsgType>"
                + "<Content><![CDATA[%5$s]]></Content>"
                + "<MsgId>%6$s</MsgId>"
                + "</xml>";
        XMLToMap xmlToMap = new XMLToMap();
        Map<String,String> map = xmlToMap.getXML(responseMsg);
        System.out.println(map);
    }
}
