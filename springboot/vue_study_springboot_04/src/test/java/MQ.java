import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.stream.Collectors;

public class MQ {
    public static void main(String[] args) throws IOException {
        File file = new File("E:\\py running\\GA(遗传算法)求解JSP(车间调度问题)python项目源码+项目说明\\data.txt");
        String content = new String(java.nio.file.Files.readAllBytes(file.toPath()));

        // 将字符串解析为JSON对象
        ObjectMapper objectMapper = new ObjectMapper();
        Object json = objectMapper.readValue(content, Object.class);

        // 打印JSON对象
        System.out.println(json);

        String jsonString = objectMapper.writeValueAsString(json);
        System.out.println(jsonString);

        String json1 = jsonString;
        try {
            URL url = new URL("http://localhost:7777/ga");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json; utf-8");
            conn.setRequestProperty("Accept", "application/json");
            conn.setDoOutput(true);

            OutputStream os = conn.getOutputStream();
            byte[] input = json1.getBytes("utf-8");
            os.write(input, 0, input.length);

            InputStream inputStream = conn.getInputStream();
            String result = new BufferedReader(new InputStreamReader(inputStream))
                    .lines().collect(Collectors.joining("\n"));
            System.out.println("Response: " + result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
