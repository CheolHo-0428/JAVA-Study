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
 
    // ������ ���� ������ ���� rawList�� ��� �޼ҵ�
    public static void getData() {
        File file = new File("C:/Users/Playdata/Desktop/new/501524.txt");
        String line = "";
        String tempCore = "";
        try {
            BufferedReader inFiles = new BufferedReader(
                    new InputStreamReader(new FileInputStream(file.getAbsolutePath()), "UTF8"));
            while ((line = inFiles.readLine()) != null) {
                // ��ó�� �� : �ʵ�� ����
                tempCore = line.replace("core_competence:", "");
                // ��ó�� �� : �ٽɿ������� Ư�����ڸ� ����('replace'Ȱ��)�� ��,
                // ���δ���("|*|")�� split�Ͽ� Ű���带 coreComp�� ����
                coreComp = tempCore.replace("|*|", " ").
                        replace(".", "").
                        replace("!", "").
                        replace(",", " ").
                        replace("(", " ").
                        replace(")", " ").
                        replace("[", " ").
                        replace("]", " ").
                        replace("/", " ").
                        replace("�մϴ�", " ").split(" ");
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
 
    // �ٽɿ��� Ű������ ī��Ʈ�� �ϴ� �޼ҵ�
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
 
    // ���� �ۼ��ϴ� �޼ҵ�
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
        System.out.println("==============������ �������� ����==============");
        getData();
        System.out.println("===============Ű���� ī��Ʈ ����===============");
        getCoreComp();
        System.out.println("================���� �ۼ� ����================");
        writeFile();
        System.out.println("====================��====================");
    }
}