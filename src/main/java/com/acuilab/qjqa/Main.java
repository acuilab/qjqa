/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acuilab.qjqa;

import com.baidu.aip.ocr.AipOcr;
import java.awt.AWTException;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.RenderedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import javax.imageio.ImageIO;
import org.json.JSONObject;

/**
 *
 * @author admin
 */
public class Main {
    
    public static final int TIME_STEP = 1000;   // 1s
    
    //设置APPID/AK/SK
    public static final String APP_ID = "16890386";
    public static final String API_KEY = "KqPzhOQi0j6tjZTyIxnMOFsE";
    public static final String SECRET_KEY = "Csmic7KKRnkMhPRncsxaGHWd0sHZC7CZ";

    public static void main(String[] args) throws AWTException, IOException {
        Robot robot = new Robot();
        Image image = robot.createScreenCapture(new Rectangle(120, 92, 320, 120));
        
        ByteArrayOutputStream bos = new ByteArrayOutputStream(); 
        ImageIO.write((RenderedImage) image, "jpg", bos);
        byte[] file = bos.toByteArray();
        
        // 初始化一个AipOcr
        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);

//        // 可选：设置网络连接参数
//        client.setConnectionTimeoutInMillis(2000);
//        client.setSocketTimeoutInMillis(60000);

//        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
//        client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
//        client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理

//        // 可选：设置log4j日志输出格式，若不设置，则使用默认配置
//        // 也可以直接通过jvm启动参数设置此环境变量
//        System.setProperty("aip.log4j.conf", "path/to/your/log4j.properties");

        // 调用接口
        JSONObject res = client.basicGeneral(file, new HashMap<String, String>());
        System.out.println(res.toString(2));
    }
}
