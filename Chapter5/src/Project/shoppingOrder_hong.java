package Project;

public class shoppingOrder_hong {

	public static void main(String[] args) {
		shoppingOrder so = new shoppingOrder();
		so.OrderNumber = "201803120001";
		so.ID = "abc123";
		so.Date = "2018�� 3�� 12��";
		so.Name = "ȫ���";
		so.productNumber = "PD0345-12";
		so.address = "����� �������� ���ǵ��� 20����";
		
		System.out.println("�ֹ� ��ȣ: " + so.OrderNumber);
		System.out.println("�ֹ��� ���̵�: " + so.ID);
		System.out.println("�ֹ� ��¥: " + so.Date);
		System.out.println("�ֹ��� �̸�: " + so.Name);
		System.out.println("�ֹ� ��ǰ ��ȣ: " + so.productNumber);
		System.out.println("��� �ּ�: " + so.address);
	}

}
