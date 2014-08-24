/****************************************************************/
/*                      Detector3	                            */
/*                                                              */
/****************************************************************/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.net.*;
import java.lang.*;

/**
 * Summary description for Detector3
 *
 */
public class Detector3 extends JFrame
{
	// Variables declaration
	private JLabel jLabel1;
	private JTextArea jTextArea1;
	private JScrollPane jScrollPane1;
	private JButton jButton1;
	private JPanel contentPane;
	ServerSocket server_1;
	DataOutputStream dis1;
	DataOutputStream dis2;
	DataInputStream dis;
	Socket socket_1;
	Socket client_1;
	Socket client_2;
	long temp;
	int i=1;
	int length;
	
	// End of variables declaration


	public Detector3()
	{
		super();
		initializeComponent();
		this.setVisible(true);
		try
		{
			server_1=new ServerSocket(333);
			
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
		jLabel1 = new JLabel();
		jTextArea1 = new JTextArea();
		jScrollPane1 = new JScrollPane();
		jButton1 = new JButton();
		contentPane = (JPanel)this.getContentPane();

		//
		// jLabel1
		//
		jLabel1.setText("INTRUSION DETECTOR3");
		//
		// jTextArea1
		//
		//
		// jScrollPane1
		//
		jScrollPane1.setViewportView(jTextArea1);
		//
		// jButton1
		//
		jButton1.setBackground(new Color(255, 255, 255));
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
		addComponent(contentPane, jLabel1, 172,9,133,38);
		addComponent(contentPane, jScrollPane1, 26,37,441,341);
		addComponent(contentPane, jButton1, 204,390,83,28);
		//
		// Detector3
		//
		this.setTitle("Detector3 - extends JFrame");
		this.setLocation(new Point(0, 0));
		this.setSize(new Dimension(505, 462));
	}

	/** Adding Component Without a Layout Manager (Absolute Positioning) */
	private void addComponent(Container container,Component c,int x,int y,int width,int height)
	{
		c.setBounds(x,y,width,height);
		container.add(c);
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
						dis=new DataInputStream(socket_1.getInputStream());
						int length=dis.readInt();
						String destination=dis.readUTF();
						if(destination.equalsIgnoreCase("R-106"))
							{
								jTextArea1.append("\t**********************************\n");
								jTextArea1.append("\tTHIS IS FROM PORT R_106\n");
								jTextArea1.append("\t**********************************\n");
								client_1=new Socket("localhost",103);
								dis1=new DataOutputStream(client_1.getOutputStream());
								dis1.writeInt(length);
								dis1.writeUTF(destination);
						while(length>0)
							{
								
								rr=dis.readUTF();
								jTextArea1.append("Packet "+i+"\t"+rr+" Recieved...\n");
								dis1=new DataOutputStream(client_1.getOutputStream());
								dis1.writeUTF(rr);
								length--;
								i++;
							}
							i=1;
								
							}
						else if (destination.equalsIgnoreCase("R-108"))
						{
								jTextArea1.append("\t**********************************\n");
								jTextArea1.append("\tTHIS IS FROM PORT R_108\n");
								jTextArea1.append("\t**********************************\n");
								client_1=new Socket("localhost",103);
								dis1=new DataOutputStream(client_1.getOutputStream());
								dis1.writeInt(length);
								dis1.writeUTF(destination);
								
						while(length>0)
							{
									
								rr=dis.readUTF();
								jTextArea1.append("Packet "+i+"\t"+rr+" Recieved...\n");
								dis1=new DataOutputStream(client_1.getOutputStream());
								dis1.writeUTF(rr);
								length--;
								i++;
							}
							i=1;


								
						}
						
						else if (destination.equalsIgnoreCase("I-109"))
						{
								jTextArea1.append("\t**********************************\n");
								jTextArea1.append("\tTHIS IS FROM PORT I_109\n");
								jTextArea1.append("\t**********************************\n");
							
							while(length>0)
							{
									
								rr=dis.readUTF();
								StringBuffer sb=new StringBuffer(rr);
								sb.delete(7,10);
								jTextArea1.append("\t\tPacket "+i+"\t"+rr.substring(4,15)+" Recieved...\n");
								length--;
								i++;
								
							}
							i=1;
							int delay = 100; //milliseconds
								Timer t=new Timer(delay, new ActionListener() {
									int count=1;
									public void actionPerformed(ActionEvent evt) {
									if(count<=10)
									{
									java.awt.Toolkit.getDefaultToolkit().beep();
									count++;
									}	
									else
								  return;
								}
								});
								 
								t.start();
							JOptionPane.showMessageDialog(null,"This Is From Intruder Port");
							JOptionPane.showMessageDialog(null,"The Intruder Has Been Detected");
							JOptionPane.showMessageDialog(null,"This Is Detected By Detector3!!!!!!");
						}

						
						
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
		Detector3 r1=new Detector3();
		while (true)
		{
			r1.server();
		}
	}
//= End of Testing =


}
