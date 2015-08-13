import java.awt.Canvas;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Scrollbar;
import java.awt.event.AdjustmentListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.AdjustmentEvent;


public class MainFrame extends Frame implements AdjustmentListener
{
	Canvas objCanvas;
	public MainFrame()
	{
		setBounds(0, 0, 500, 500);
		
		setLayout(null);
		
		
		
		addWindowListener(new WindowAdapter()
		{

			@Override
			public void windowClosing(WindowEvent e)
			{
				// TODO Auto-generated method stub
				dispose();
			}
			
		});
		
		
		 objCanvas =new Canvas();
		objCanvas.setBounds(100,100, 300,100);
		objCanvas.setBackground(Color.blue );
		add(objCanvas);
		
		
		Label lblCanvas=new Label("xPOs");
		lblCanvas.setBounds(50,300,50,30);
		add(lblCanvas);
		
		
		Label lblCanvas1=new Label("yPOs");
		lblCanvas1.setBounds(50,350,50,30);
		add(lblCanvas1);
		
		
		Label lblCanvas2=new Label("Width");
		lblCanvas2.setBounds(50,400,50,30);
		add(lblCanvas2);
		
		
		Label lblCanvas3=new Label("Height");
		lblCanvas3.setBounds(50,450,50,30);
		add(lblCanvas3);
		
		
		Scrollbar objScroll=new Scrollbar();
		objScroll.setBounds(60, 300, 350, 20);
		add(objScroll);
		objScroll.setOrientation(objScroll.HORIZONTAL);
		
		Scrollbar objScroll1=new Scrollbar();
		objScroll1.setBounds(60, 350, 350, 20);
		objScroll1.setOrientation(objScroll1.HORIZONTAL);
		add(objScroll1);
		
		Scrollbar objScroll2=new Scrollbar();
		objScroll2.setBounds(60, 400, 350, 20);
		objScroll2.setOrientation(objScroll2.HORIZONTAL);
		add(objScroll2);
		
		Scrollbar objScroll3=new Scrollbar();
		objScroll3.setBounds(60, 450, 350, 20);
		objScroll3.setOrientation(objScroll3.HORIZONTAL);
		
		add(objScroll3);
		
		
		setVisible(true);
	}

	@Override
	public void adjustmentValueChanged(AdjustmentEvent e)
	{
		Scrollbar objScroll1=(Scrollbar)e.getSource();
	
		if(e.equals(objScroll1))
		{
		   this.objCanvas.setBounds(50, 50, 100, 100);
			
		}
	}


}
