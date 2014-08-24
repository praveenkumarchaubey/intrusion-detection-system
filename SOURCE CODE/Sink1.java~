/****************************************************************/
/*                      Sink1	                            */
/*                                                              */
/****************************************************************/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
import java.net.*;
/**
 * Summary description for Sink1
 *
 */
public class Sink1 extends JFrame
{
	// Variables declaration
	private JLabel jLabel1;
	private JTabbedPane jTabbedPane1;
	private JButton jButton1;
	private JPanel contentPane;
	//-----
	private JTextArea jTextArea1;
	private JScrollPane jScrollPane1;
	private JPanel jPanel1;
	//-----
	private JTextArea jTextArea2;
	private JScrollPane jScrollPane2;
	private JPanel jPanel2;
	//-----
	
	String Recieved1;
	ServerSocket server_1;
	Socket socket_1;
	int i=1;
	String destination;
	String rr="";
	//-----
	// End of variables declaration


	public Sink1()
	{
		super();
		initializeComponent();
		try
		{
			server_1=new ServerSocket(101);
		}
		catch (Exception exp)
		{
			exp.printStackTrace();
		}
		

		this.setVisible(true);
		
		
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 */
	private void initializeComponent()
	{
		jLabel1=new JLabel();
		jLabel1.setFont(new Font("Serief",Font.BOLD,16));
		jTabbedPane1 = new JTabbedPane();
		jButton1 = new JButton();
		contentPane = (JPanel)this.getContentPane();
		//-----
		jTextArea1 = new JTextArea();
		jScrollPane1 = new JScrollPane();
		jPanel1 = new JPanel();
		
		//-----
		jTextArea2 = new JTextArea();
		jScrollPane2 = new JScrollPane();
		jPanel2 = new JPanel();
		
		//-----
		jTextArea1.setText("\t**********THIS IS FROM PORT R_101*************\n\n");
		//-----

		//
		jTextArea2.setText("\t**********THIS IS FROM PORT R_107**************\n\n");
		// jTabbedPane1
		//
		jTabbedPane1.addTab("Dest1", jPanel1);
		jTabbedPane1.addTab("Dest2", jPanel2);
		jTabbedPane1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e)
			{
				jTabbedPane1_stateChanged(e);
			}

		});
		//
		//
		// jLabel1
		//
		jLabel1.setText("Sink1");
		//
		// jButton1
		//
		jButton1.setText("Exit");
		jButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				jButton1_actionPerformed(e);
			}

		});
		//
		// contentPane
		//
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(153, 204, 255));
		addComponent(contentPane, jLabel1, 232,9,193,38);
		addComponent(contentPane, jTabbedPane1, 21,44,473,374);
		addComponent(contentPane, jButton1, 228,425,88,32);
		//
		// jTextArea1
		//
		//
		// jScrollPane1
		//
		jScrollPane1.setViewportView(jTextArea1);
		//
		// jPanel1
		//
		jPanel1.setLayout(null);
		addComponent(jPanel1, jScrollPane1, 23,19,418,301);
		//
		// jTextArea2
		//
		//
		// jScrollPane2
		//
		jScrollPane2.setViewportView(jTextArea2);
		//
		// jPanel2
		//
		jPanel2.setLayout(null);
		addComponent(jPanel2, jScrollPane2, 22,19,416,302);
		//
		// jTextArea3
		//
		//
		// jScrollPane3
		//
		//jScrollPane3.setViewportView(jTextArea3);
		//
		// jPanel3
		//
		//jPanel3.setLayout(null);
		//addComponent(jPanel3, jScrollPane3, 30,18,414,305);
		//
		// Sink1
		//
		this.setTitle("Sink1 - extends JFrame");
		this.setLocation(new Point(0, 0));
		this.setSize(new Dimension(544, 494));
	}

	/** Adding Component Without a Layout Manager (Absolute Positioning) */
	private void addComponent(Container container,Component c,int x,int y,int width,int height)
	{
		c.setBounds(x,y,width,height);
		container.add(c);
	}

	private void jTabbedPane1_stateChanged(ChangeEvent e)
	{
		System.out.println("\njTabbedPane1_stateChanged(ChangeEvent e) called.");
		
	}

	private void jButton1_actionPerformed(ActionEvent e)
	{
		System.out.println("\njButton1_actionPerformed(ActionEvent e) called.");
		
	}

	


public void server()
	{
		
						try
						{
						String rr="";
						socket_1=server_1.accept();	                                   
						DataInputStream dis=new DataInputStream(socket_1.getInputStream()); 
						int length=dis.readInt();
						String destination=dis.readUTF();
						while(length>0)
							{
								rr=dis.readUTF();	
															
							if(destination.equalsIgnoreCase("R-101"))

							{
								
								jTextArea1.append("Packet "+i+"\t"+rr+" Recieved...\n");
							}
								
							
							else if (destination.equalsIgnoreCase("R-107"))
							{
							
								jTextArea2.append("Packet "+i+"\t"+rr+" Recieved...\n");
							}
							else 
								JOptionPane.showMessageDialog(null,"No Packets Received");
								length--;
								i++;
							}
							i=1;
							
						}
						catch (Exception exp)
						{
							exp.printStackTrace();
						}
						
					
					
	
	}
	


























 

//============================= Testing ================================//
//=                                                                    =//
//= The following main method is just for testing this class we built.=//
//======================================================================//
	public static void main(String[] args)
	{
		
		
		Sink1 s1=new Sink1();
		while(true)
		{
			s1.server();
		}
	}
//= End of Testing =


}
