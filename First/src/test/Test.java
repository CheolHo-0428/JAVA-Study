package test;



import java.util.ArrayList;
import java.util.Arrays;
 
 
public class Test {
    public static void main(String[] args) {
        /** ���� ������ */
        int[] data = {10,3,4,50,4,4,1,2,10,10,25,2,10};
        String[] coffee = {"�Ƹ޸�ī��","ī���","�Ƹ޸�ī��","��","��","��", "�ٴҶ��"};
               
        /** ���� ������ ���� */
//        ArrayList<Integer> itemList = new ArrayList<Integer>();
        ArrayList<String> itemList = new ArrayList<String>();
        
        /** ���� ������ ������ �ߺ����� */
        ArrayList<Integer> cntList = new ArrayList<Integer>();
//        ArrayList<String> cntList = new ArrayList<String>();
        
        //1. ������ ���� �� ������ �����Ѵ�.
        for(int i = 0 ; i < coffee.length ; i++){
            //item�� ��ϵǾ����� Ȯ���Ѵ�.
            //1.1 ��ϵ��� �ʾ��� �� ó��
            if(!itemList.contains(coffee[i])){
                
                //1.1.1 item�� itemList�� �߰��Ѵ�.
                itemList.add(coffee[i]);
                
                //1.1.2 item�� � ����ִ��� ��� cntList�� �߰��Ѵ�.
                int cnt = 0;
                for(int searchIndex = i; searchIndex < coffee.length; searchIndex++){
                    if(coffee[i] == coffee[searchIndex]){
                        cnt++;
                    }    
                }
                cntList.add(cnt);   
            }
            else{
                continue;
            }                        
        }
        System.out.println(itemList);
        System.out.println(cntList);     
    }
}