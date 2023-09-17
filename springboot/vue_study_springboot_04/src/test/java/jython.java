
import org.python.util.PythonInterpreter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class jython {
        public static void main(String[] args) {
            try {
                // 创建Python解释器对象
                PythonInterpreter python = new PythonInterpreter();

                // 读取Python脚本文件
                FileInputStream fileInputStream = new FileInputStream("E:\\py running\\job问题\\遗传算法2.py");
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
// 将读取的Python代码传递给解释器
                String script = "";
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    script += line + "\n";
                }
                python.exec(script);
                // 将读取的Python代码传递给解释器
//                python.exec(String.valueOf(bufferedReader));

                // 调用Python函数并传递参数
                python.exec("result = genetic_algorithm({{{0,1},{1,5},{2,3}},\n" +
                        "                {{1,4},{0,2},{2,8}},\n" +
                        "                {{2,1},{1,5},{0,5}},\n" +
                        "                {{0,8},{2,5},{1,1}},\n" +
                        "                {{2,6},{0,7},{1,1}},\n" +
                        "                {{0,9},{1,5},{2,3}},\n" +
                        "                {{1,4},{0,2},{2,8}},\n" +
                        "                {{2,5},{1,5},{0,5}},\n" +
                        "                {{0,8},{2,6},{1,1}},\n" +
                        "                {{2,8},{0,7},{1,9}}})");

                // 获取Python函数的返回值
                int result = python.get("result", Integer.class);
                System.out.println("Process result: " + result);

                // 关闭输入流和解释器
                bufferedReader.close();
                python.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
}
