package ee402;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

@SuppressWarnings("serial")
public class BasicWebBrowser extends Frame implements ActionListener, WindowListener {

    private TextField hostname, page;
    private TextArea returnPage;
    
    public BasicWebBrowser() {
        super("Basic Web Browser Application");
        this.addWindowListener(this);
        
        Panel north = new Panel();
        north.setLayout(new FlowLayout());
        hostname = new TextField("www.eeng.dcu.ie",30);
        north.add(new Label("Site:"));
        north.add(hostname);
        page = new TextField("index.html", 30);
        north.add(new Label("Page:"));
        north.add(page);
        this.add(north, BorderLayout.NORTH);
        
        returnPage = new TextArea(10,40);
        this.add(returnPage, BorderLayout.CENTER);
   
        Button go = new Button("Load");
        go.addActionListener(this);
        this.add(go, BorderLayout.SOUTH);
        this.setSize(600,350);
        this.setVisible(true);    
    }

    public void actionPerformed(ActionEvent e) {
        Socket httpSocket = null;  
        DataOutputStream os = null;   //output stream
        DataInputStream is = null;    //input stream
        BufferedReader br = null; 	  //buffered reader for correct reading
        
        try {
            httpSocket = new Socket(this.hostname.getText(), 80);   //HTTP port 80
            os = new DataOutputStream(httpSocket.getOutputStream());
            is = new DataInputStream(httpSocket.getInputStream());
            br = new BufferedReader(new InputStreamReader(is));
        } catch (UnknownHostException ex) {
            System.err.println("Don't know host: " + this.hostname.getText());
        } catch (IOException ex) {
            System.err.println("No I/O for the connection to: " + this.hostname.getText());
        }

        if (httpSocket != null && os != null && is != null) {
           try
           {
               this.returnPage.append("Sending Request\n");
               String theRequest = new String("GET /" + this.page.getText() + "\n\n");
               returnPage.append(theRequest);
                  os.writeBytes(theRequest);
                
                this.returnPage.append("Request Sent\n");
                // keep reading from/to the socket till we receive "Ok"
                // from HTTP server. Once received then break.

                String responseLine;
                while ((responseLine = br.readLine()) != null) {
                    this.returnPage.append(responseLine);
                    if (responseLine.indexOf("Ok") != -1) {
                      break;
                    }
                }
                this.returnPage.append("End of Response\n");
                os.close();
                is.close();
                httpSocket.close();   
           }
           catch (UnknownHostException ex) {
                   System.err.println("Trying to connect to unknown host: " + ex);
           }
           catch (IOException ex) {
                   System.err.println("IOException:  " + ex);
           }
        }
    }

    public static void main(String[] args) {
        new BasicWebBrowser();
    }

    public void windowActivated(WindowEvent arg0) {}
	public void windowClosed(WindowEvent arg0) {}
	public void windowClosing(WindowEvent arg0) {
		System.exit(0);
	}
	public void windowDeactivated(WindowEvent arg0) {}
	public void windowDeiconified(WindowEvent arg0) {}
	public void windowIconified(WindowEvent arg0) {}
	public void windowOpened(WindowEvent arg0) {}
}
