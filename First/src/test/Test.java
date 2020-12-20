package test;



import java.util.ArrayList;
import java.util.Arrays;
 
 
public class Test {
    public static void main(String[] args) {
        /** 원본 데이터 */
        int[] data = {10,3,4,50,4,4,1,2,10,10,25,2,10};
        String[] coffee = {"아메리카노","카페라떼","아메리카노","라떼","라떼","라떼", "바닐라라떼"};
               
        /** 원본 데이터 유형 */
//        ArrayList<Integer> itemList = new ArrayList<Integer>();
        ArrayList<String> itemList = new ArrayList<String>();
        
        /** 원본 데이터 유형별 중복개수 */
        ArrayList<Integer> cntList = new ArrayList<Integer>();
//        ArrayList<String> cntList = new ArrayList<String>();
        
        //1. 데이터 유형 및 개수를 설정한다.
        for(int i = 0 ; i < coffee.length ; i++){
            //item이 등록되었는지 확인한다.
            //1.1 등록되지 않았을 때 처리
            if(!itemList.contains(coffee[i])){
                
                //1.1.1 item을 itemList에 추가한다.
                itemList.add(coffee[i]);
                
                //1.1.2 item이 몇개 들어있는지 세어서 cntList에 추가한다.
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