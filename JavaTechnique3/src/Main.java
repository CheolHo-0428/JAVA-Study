import javax.swing.JFrame;

import com.teamdev.jxbrowser.browser.Browser;
import com.teamdev.jxbrowser.view.swt.BrowserView;

public class Main extends JFrame {
	
	private Browser browser = new Browser();
	private BrowserView browserView = new BrowserView(browser);
	
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Google Chart");
		setVisible(true);
		setResizable(false);
		setSize(800, 600);
		
		browser.addLoadListener(new LoadAdapter() {
			@override
			public void onFinishLoadingFrame(FinishLoadingEvent event) {
				if (event.isMainFrame()) {
					System.out.println("HTML ������ �ε�Ǿ����ϴ�.");
				}
			}		
		});
		
		// ������ ������ https://www.youtube.com/watch?v=xPGDhrslRfI 7�� 12�� ����

	}
}
