package com.bjsxt.controller;


import com.bjsxt.common.pojo.Result;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.stream.Collectors;
@CrossOrigin
@RestController
public class ProcessingController {

    @PostMapping("/processing")
    public Result process(@RequestBody String json) {
        String result = null;
        try {
            URL url = new URL("http://localhost:6616/ga");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json; utf-8");
            conn.setRequestProperty("Accept", "application/json");
            conn.setDoOutput(true);

            OutputStream os = conn.getOutputStream();
            byte[] input = json.getBytes("utf-8");
            os.write(input, 0, input.length);

            InputStream inputStream = conn.getInputStream();
            result = new BufferedReader(new InputStreamReader(inputStream))
                    .lines().collect(Collectors.joining("\n"));
            System.out.println("Response: " + result);

        } catch (Exception e) {
            e.printStackTrace();
        }
        // 处理JSON数据并返回结果

        return Result.ok(result);
    }
}
