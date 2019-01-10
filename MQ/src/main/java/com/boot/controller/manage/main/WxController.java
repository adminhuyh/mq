package com.boot.controller.manage.main;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.hibernate.engine.transaction.jta.platform.internal.SynchronizationRegistryBasedSynchronizationStrategy;

import com.dns.common.terminal.base.MD5Utils;
import com.dns.common.terminal.base.SendUtil;
import com.google.gson.Gson;


public class WxController {
    public static void testYDPay(){
    	Map<String, Object> data = new HashMap<String, Object>();
            data.put("appid", "wx43913794990870f7");
            data.put("mch_id","1516446371");
            data.put("nonce_str", String.valueOf(System.currentTimeMillis() * 3));
            data.put("body","测试小程序支付");
            data.put("out_trade_no","2787");
            data.put("total_fee", String.valueOf(new BigDecimal("0.01").multiply(new BigDecimal(100)).intValue()));
            data.put("spbill_create_ip",   "123.125.17.6");
            data.put("notify_url", ("http://test1.kexinapp.com/fuliShare"+"/terminal/wxNotifyBack"));
            data.put("trade_type", "JSAPI");
            data.put("attach", "2787");
            data.put("openid", "oEWKl5NtVFZ3sM29qkaN9S3j3v3o");
            System.out.println("payment.toPay***********data=" +data.toString());         
            List<String> list = getSorts(data);
            Document document = DocumentHelper.createDocument();
            Element xml = document.addElement("xml");
            StringBuffer str = new StringBuffer();
            for (String key : list) {
                xml.addElement(key).addCDATA(data.get(key).toString());
                str.append(key + "=" + data.get(key) + "&");
            }
             str.append("key=" + "zGkxsc66688..");// 密钥(PartnerKey)  
            try {
				xml.addElement("sign").addCDATA(MD5Utils.StringToMD5(str.toString()).toUpperCase());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
            System.out.println("payment.toPay***********发送" + document.asXML());
            String back;
			try {
				back = SendUtil.sendToUrl(document.asXML(), "https://api.mch.weixin.qq.com/pay/unifiedorder", "utf-8");
				System.out.println("payment.toPay***********返回" + back);
				Document backDom = DocumentHelper.parseText(back);
				Element root = backDom.getRootElement();
				if ("SUCCESS".equals(root.element("return_code").getTextTrim()) && "SUCCESS".equals(root.element("result_code").getTextTrim())) {
					System.out.println("successssssssssssssssful");
				}       
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    }
    public void getUserInfo(){    	
      String appid="";
      String secret="";
      String encryptedData="";
	  String code="";
	  System.out.println("appid========================="+appid);
	  System.out.println("secret========================"+secret);
	
	  String openid = "";
	  if(!StringUtils.isBlank(encryptedData)){
		  // 获取session_key
		  String back;
		try {
			back = SendUtil.sendToUrl("", "https://api.weixin.qq.com/sns/jscode2session?appid=" + appid + "&secret="	+ secret + "&js_code=" + code + "&grant_type=authorization_code", "utf-8");
			System.out.println("获取session_key返回：" + back);
			Map map = new Gson().fromJson(back, Map.class);
			String session_key = map.get("session_key").toString();
			openid = map.get("openid").toString();
		} catch (Exception e) {
			System.out.println("==========================================");
			e.printStackTrace();
		}
	  }else{
	      String getAccessToken ="https://api.weixin.qq.com/sns/oauth2/access_token?appid="+appid+"&secret="+secret+"&code="+code+"&grant_type=authorization_code";
		  String backJson ="";
				try {
					backJson = SendUtil.sendToUrl("", getAccessToken, "utf-8");
					System.out.println("backJson====77777777777777==="+backJson);
				} catch (Exception e) {
					e.printStackTrace();
				}
			System.out.println("getAccessToken====888888888888888==="+getAccessToken);
		  Map<String, Object> map = new Gson().fromJson(backJson, Map.class);
		  openid = map.get("openid").toString();
	  }    	
    }
    public static  List<String> getSorts(Map<String, Object> map) {
        List<String> list = new ArrayList<String>();
        Set<String> keys = map.keySet();
        for (String key : keys) {
            list.add(key);
        }
        Collections.sort(list);
        return list;
    } 
	public static void main(String[] args) {
		try {
			List list=new ArrayList();
			list.add("1");
			list.add("2");
			list.add("3");
			list.add("4");
			list.add("5");
			System.out.println(list.toString());
		    String str="[1, 2, 3, 4, 5]";
            List list2=Arrays.asList(str.split(","));
            System.out.println(list2.get(2));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//testYDPay();
	}
	public static void getToken() throws Exception{
		
		Map<String, Object> param = new HashMap<String, Object>();
		Gson gson = new Gson();
		/*component_appid=wxd5028639ede3015e
component_appsecret=0c75a8f5ca979e31394fb139340ecba7
		 * 
		 * 
		 */
		param.put("component_appid", "wxd5028639ede3015e");
		param.put("component_appsecret", "0c75a8f5ca979e31394fb139340ecba7");
		param.put("component_verify_ticket", getComponentTicket());
		String sendJson=gson.toJson(param);
		System.out.println("获取第三方平台access_token发送：" + sendJson);
		
//		String json = SendUtil.sendToUrl(sendJson, SystemPropertiesUtils.get("access_token_url", ""), "utf-8", TIME_OUT);
		String json = SendUtil.sendToUrl(sendJson,"https://api.weixin.qq.com/cgi-bin/component/api_component_token");
		System.out.println("获取第三方平台access_token返回：" + json);

//		16_-YortLSguV58XXuhTR8CPe_ewcKeiI1OagtLHe7R8LGInpXl54dhPncQZzbocjXIeiHjuHpMUjCoZnes89lC-6WNOm6JbGGu7aTMouUPcOdnQ_tRbRKMV-97pLYECAaAJAMKI
		
	}
    public static String  getComponentTicket() throws Exception{
        String ticket_path ="C:/Users/Administrator/Desktop/component_verify_ticket.txt";//"component_verify_ticket.txt";
        System.out.println("ticket_path"+ticket_path);
		File file = new File(ticket_path);
		if (!file.exists()) {
			throw new Exception("ticket文件不存在");
		}
		StringBuffer ticket = new StringBuffer();
		InputStreamReader read = new InputStreamReader(new FileInputStream(file), "utf-8");
		BufferedReader bufferedReader = new BufferedReader(read);
		String lineTXT = null;
		while ((lineTXT = bufferedReader.readLine()) != null) {
			String line = lineTXT.toString().trim();
			ticket.append(line);
		}
		bufferedReader.close();
		read.close();
		return ticket.toString();
    }
    public static String haha() throws Exception{
    	
    	Map<String, Object> param = new HashMap<String, Object>();
    	String component_access_token="16_-YortLSguV58XXuhTR8CPe_ewcKeiI1OagtLHe7R8LGInpXl54dhPncQZzbocjXIeiHjuHpMUjCoZnes89lC-6WNOm6JbGGu7aTMouUPcOdnQ_tRbRKMV-97pLYECAaAJAMKI";
		param.put("component_appid", "wxd5028639ede3015e");
		param.put("authorizer_appid", "wx674c6b8303c4603a");
		param.put("authorizer_refresh_token", "refreshtoken@@@SGYvBHoAVAU3t40z8Pp9QsPAszQVrvass2mhCOHPOxs");
		Gson gson = new Gson();
		String sendJson = gson.toJson(param);
		System.out.println("获取（刷新）授权公众号的令牌发送：" + sendJson);
		String json = SendUtil.sendToUrl(sendJson, "https://api.weixin.qq.com/cgi-bin/component/api_authorizer_token?component_access_token=" + component_access_token);
		System.out.println("获取（刷新）授权公众号的令牌返回：" + json);
		Map<String, Object> map = gson.fromJson(json, Map.class);
		String token = map.get("authorizer_access_token").toString();
    	System.out.println("token"+token);
    	return token;    	
    }
	
    public static String getUser(){
    	String appid="wx43913794990870f7";
        String secret="ec97685365518952c6e655e630d7d4cf";
    	String code="081g4nJV17NBGY09rHIV1YO2JV1g4nJw"; 
    	String json="";
    	Gson gson = new Gson();
		try {
			 String back = SendUtil.sendToUrl("", "https://api.weixin.qq.com/sns/jscode2session?appid=" + appid + "&secret="	+ secret + "&js_code=" + code + "&grant_type=authorization_code", "utf-8");
			System.out.println("获取（刷新）授权公众号的令牌返回：" + json);
			Map<String, Object> map = gson.fromJson(json, Map.class);
			String token = map.get("authorizer_access_token").toString();
			System.out.println("token"+token);
			return token;    	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "tokenerror";
    }
    
	
	
}
