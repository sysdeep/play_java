import javax.swing.JFrame;

// import jdk.internal.platform.Container;

import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.Container;

public class MyWindowApp extends JFrame { //Наследуя от JFrame мы получаем всю функциональность окна

	public MyWindowApp(){
		super("My First Window la"); //Заголовок окна
		setBounds(100, 100, 200, 200); //Если не выставить 
																	 //размер и положение 
																	 //то окно будет мелкое и незаметное
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //это нужно для того чтобы при 
																										//закрытии окна закрывалась и программа,


		Container pane = this.getContentPane();
		BoxLayout layout = new BoxLayout(pane, BoxLayout.Y_AXIS);
		this.setLayout(layout);

		JButton btn1 = new JButton("hello 1");	
		JButton btn2 = new JButton("hello 2");	
		this.add(btn1);																									//иначе она останется висеть в процессах
		this.add(btn2);																									//иначе она останется висеть в процессах

		// layout.addLayoutComponent(btn1 constraints);
	}

	public static void main(String[] args) { //эта функция может быть и в другом классе
		MyWindowApp app = new MyWindowApp(); //Создаем экземпляр нашего приложения
		app.setVisible(true); //С этого момента приложение запущено!
	}
}