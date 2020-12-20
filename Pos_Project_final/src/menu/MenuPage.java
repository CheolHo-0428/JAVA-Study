package menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Pos.PosPanel_test.operation;
import admin.admin_login;
import main.main;


public class MenuPage extends JPanel {
	// 결제된 정보가 담겨 있는 어레이리스트들(중복값이 있음)
	public static ArrayList<String> ProductName = new ArrayList<String>(); //중복값이 있는 상품이름 리스트
	public static ArrayList<Integer> Price = new ArrayList<Integer>(); //중값이 있는 상품가격 리스트
   
	// 실제 AdminPage_Panel로 넘겨주는 어레이리스트들(중복값이 없음)
	public static ArrayList<String> ProductList = new ArrayList<String>(); //중복값이 없는 상품이름 리스트
	public static ArrayList<Integer> PriceList = new ArrayList<Integer>(); //중복값이 없는 상품가격 리스트
	public static ArrayList<Integer> CntList = new ArrayList<Integer>(); //선택된 상품갯수 리스트
   
	// 위의 중복값이 있는 어레이리스트들을 중복값 없는 데이터로 만들어주는 기능
	public class operation {
		operation(){		
			for(int i = 0; i <ProductName.size(); i=i+1) {
				System.out.println(ProductName.get(i));
				if(!ProductList.contains(ProductName.get(i))) {
					ProductList.add(ProductName.get(i));
					PriceList.add(Price.get(i));
					int cnt = 0;
					for(int I = i; I < ProductName.size(); I = I+1) {
						if(ProductName.get(i) == ProductName.get(I)) {
							cnt = cnt + 1;
						}
					}
					CntList.add(cnt);
				}
				else {
					continue;
				}
			}
			System.out.println(ProductList);
			System.out.println(PriceList);
			System.out.println(CntList);
		}		
	}
	
 //********************************************************************************// 
   JTextField textfield = new JTextField(30);
   JButton[] MenuPagebtn = new JButton[10];
   String[] menu = {
          "아메리카노","ICE아메리카노","카페라떼","ICE카페라떼",
          "카페모카","카푸치노","바닐라라떼","ICE바닐라라떼",
          "녹차라떼","아이스티"};
   
   int[] price = {
              1500,1800,2500,2500,
              3000,3000,3500,3500,
              1500,1800};
   
   String[] Str = {"쿠폰", "선택취소", "전체취소", "결제"};
   String[] ColName = {"메뉴", "수량", "가격"};
   String[][] Data;
   int count = 1;
   
   
   
   
   //메뉴 페이지 설정하기
   public MenuPage() {
      
      MenuButton menubtn = new MenuButton();
      ScrollPane scrollpane = new ScrollPane();
      
      setLayout(null); 
      setBackground(Color.LIGHT_GRAY);
 
      textfield.setBounds(510, 740, 500, 200);
      add(textfield);
 
      scrollpane.setBounds(10, 740, 500, 200);
      add(scrollpane);
 
      menubtn.setSize(1520, 700);
      menubtn.setLocation(30, 20);
      add(menubtn);
          
      JButton PayButton = new JButton("결제하기");
      PayButton.setBounds(1370, 740, 180, 150);
      add(PayButton);
      PayButton.addActionListener(new ActionListener() {
      
        @Override
        public void actionPerformed(ActionEvent e) {
           JButton MenuPagebtn = (JButton)e.getSource();
           int rowCont = table.getRowCount();
           int sum = 0;
           for(int i=0; i<rowCont; i=i+1) {
              sum = sum + (int)table.getValueAt(i, 2);
           }
           textfield.setText(String.valueOf(" 총금액 : " + sum +"원"));
           textfield.setFont(new Font("맑은 고딕", Font.BOLD, 40));
           
           new operation();
         }
      });

     
      
      JButton RemoveButton = new JButton("선택 취소");
      RemoveButton.setBounds(1200, 740, 150, 150);
      add(RemoveButton);
      
      RemoveButton.addActionListener(new ActionListener() {
    
          @Override
          public void actionPerformed(ActionEvent e) {
             JButton MenuPagebtn = (JButton)e.getSource();
             DefaultTableModel m = (DefaultTableModel)table.getModel();            
             m.removeRow(table.getSelectedRow());         
          }
       });
         
      
      
      JButton AllRemoveButton = new JButton("전체 취소");
      AllRemoveButton.setBounds(1030, 740, 150, 150);
      add(AllRemoveButton);
      

      AllRemoveButton.addActionListener(new ActionListener() {
       
          @Override
          public void actionPerformed(ActionEvent e) {
             JButton MenuPagebtn = (JButton)e.getSource();
             DefaultTableModel m = (DefaultTableModel)table.getModel();
             m.setRowCount(0);
             textfield.setText(String.valueOf(""));
          }         
       });
      
   }
   


   protected void dispose() {
	// TODO Auto-generated method stub
	
}



DefaultTableModel model = new DefaultTableModel(Data, ColName);
   JTable table = new JTable(model);


   //사용자가 선택한 메뉴를 담는 리스트
   class ScrollPane extends JPanel{
      
      ScrollPane() {
         
            DefaultTableModel m = (DefaultTableModel)table.getModel();
            
            setBackground(Color.LIGHT_GRAY);
            table.setLayout(new GridLayout(350,30,200,10));
            table.setRowHeight(50);
            table.getTableHeader().setFont(new Font("맑은 고딕", Font.BOLD, 15));
            add(new JScrollPane(table));
         }
      }
   
   
      
   
      //메뉴 버튼 10개
   class MenuButton extends JPanel {
      
      MenuButton() {
         
          setLayout(new GridLayout(2,10,10,5));
              setBackground(Color.LIGHT_GRAY);
              
              for(int i=0; i<MenuPagebtn.length;i=i+1) {
                 MenuPagebtn[i] = new JButton(menu[i]);
                 add(MenuPagebtn[i]);
              }

   
    
   //메뉴 입력 하고 하단 텍스트 필드에 담는 반복문
    for(int i=0; i<MenuPagebtn.length;i=i+1) {
       
        final int index = i;
        
        MenuPagebtn[i].addActionListener(new ActionListener() {
           
           @Override
           public void actionPerformed(ActionEvent e) {
            
              JButton MenuPagebtn = (JButton)e.getSource();
              DefaultTableModel m = (DefaultTableModel)table.getModel();
              m.addRow(new Object[]{menu[index],count,price[index]});
              ProductName.add(menu[index]);
              Price.add(price[index]);
                    }
              });
          }
    
    
    
//    //쿠폰
//    PaymentBtn[0].addActionListener(new ActionListener() {
//       
//          @Override
//          public void actionPerformed(ActionEvent e) {
//             JButton MenuPagebtn = (JButton)e.getSource();
//             table.setValueAt(0, table.getSelectedRow(), 2);            
//          }

      }
   }
}