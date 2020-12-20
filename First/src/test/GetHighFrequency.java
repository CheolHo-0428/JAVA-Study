package test;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
 
public class GetHighFrequency {
    static String[] coreComp;
    static ArrayList<String> rawList = new ArrayList<String>();
    static HashMap<String, Integer> coreCntMap = new HashMap<String, Integer>();
    static String NEWLINE = System.getProperty("line.separator");
 
    // 문장을 공백 단위로 끊어 rawList에 담는 메소드
    public static void getData() {
        File file = new File("C:/Users/Playdata/Desktop/new/501524.txt");
        String line = "";
        String tempCore = "";
        try {
            BufferedReader inFiles = new BufferedReader(
                    new InputStreamReader(new FileInputStream(file.getAbsolutePath()), "UTF8"));
            while ((line = inFiles.readLine()) != null) {
                // 전처리 ① : 필드명 제거
                tempCore = line.replace("core_competence:", "");
                // 전처리 ② : 핵심역량에서 특수문자를 제거('replace'활용)한 뒤,
                // 라인단위("|*|")로 split하여 키워드를 coreComp에 담음
                coreComp = tempCore.replace("|*|", " ").
                        replace(".", "").
                        replace("!", "").
                        replace(",", " ").
                        replace("(", " ").
                        replace(")", " ").
                        replace("[", " ").
                        replace("]", " ").
                        replace("/", " ").
                        replace("합니다", " ").split(" ");
                for (int k = 0; k < coreComp.length; k++) {
                    if (coreComp[k].length() != 0)
                        rawList.add(coreComp[k]);
                }
            }
            inFiles.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
    // 핵심역량 키워드의 카운트를 하는 메소드
    public static void getCoreComp() {
        int cnt = 1;
        
        for (int k = 0; k < rawList.size(); k++) {
            if (coreCntMap.containsKey(rawList.get(k))) {
                cnt = coreCntMap.get(rawList.get(k)) + 1;
            } else {
                cnt = 1;
            }
            coreCntMap.put(rawList.get(k), cnt);
        }
    }
 
    // 파일 작성하는 메소드
    public static void writeFile() {
        String filename = "C:/Users/Playdata/Desktop/new/coreComp_cnt_result.txt";
        try {
            File output = new File(filename);
            BufferedWriter writer = new BufferedWriter(new FileWriter(output));
 
            if (output.isFile() && output.canWrite()) {
                for (String key : coreCntMap.keySet()) {
                    if (coreCntMap.get(key) > 20) {
                        
                        StringBuilder sb = new StringBuilder();
                        sb.append(key);
                        sb.append(",");
                        sb.append(coreCntMap.get(key));
                        sb.append(NEWLINE);
                        
                        //System.out.println("sb : " + sb);
                        String resultString = sb.toString();
                        writer.write(resultString);
                    }
                }
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 
    public static void main(String[] args) {
        System.out.println("==============데이터 가져오기 시작==============");
        getData();
        System.out.println("===============키워드 카운트 시작===============");
        getCoreComp();
        System.out.println("================파일 작성 시작================");
        writeFile();
        System.out.println("====================끝====================");
    }
}