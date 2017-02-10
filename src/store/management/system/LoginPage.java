/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store.management.system;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

class LoginPage extends Frame implements ActionListener {
    TextField logint, pswrdt;
    Label login, pswrd, head,msg;
    Button ok, reset;
    char type;
    HomePage hg;
    
    LoginPage(char c, HomePage h) {
        MyWindowAdapter win=new MyWindowAdapter(this);
        addWindowListener(win);
        
        hg=h;
        type=c;
        setLayout(new GridLayout(5, 1, 5, 5));
        setSize(400, 300);
        setLocation(500, 300);
        setVisible(true);
        Font fontl = new Font("Times New Roman", Font.BOLD, 15);
        Font fontl1 = new Font("Times New Roman", Font.BOLD, 30);
        
        //heading//
        Panel phead = new Panel(new FlowLayout());
        head = new Label("LOGIN");
        head.setFont(fontl1);
        
        //message for invalid id//
        Panel phead1 = new Panel(new FlowLayout());
        msg=new Label("                      ");
        msg.setFont(fontl);
        
        //login field//
        Panel plog = new Panel(new FlowLayout());
        login = new Label("Login ID:  ");
        login.setFont(fontl);
        logint = new TextField(20);
        
        //psword field//
        Panel ppas = new Panel(new FlowLayout());
        pswrd = new Label("Password:");
        pswrd.setFont(fontl);
        pswrdt = new TextField(20);
        pswrdt.setEchoChar('*');
        
        //button field//
        //ok button//
        Panel pbut = new Panel(new FlowLayout());
        ok = new Button("OK");
        ok.setFont(fontl);
        ok.addActionListener(this);
        //reset button//
        reset = new Button("Reset");
        reset.setFont(fontl);
        reset.addActionListener(this);

        
        
        phead.add(head);
        add(phead);
        
        phead1.add(msg);
        add(phead1);
       
        plog.add(login);
        plog.add(logint);
        add(plog);
        
        ppas.add(pswrd);
        ppas.add(pswrdt);
        add(ppas);
        
        pbut.add(ok);
        pbut.add(reset);
        add(pbut);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(ok)) {
            try {
                Databases d=new Databases();
                    d.startDb();
                ResultSet rs=d.displayRecords("select * from user_login where login_id='"+logint.getText()+"' and password='"+pswrdt.getText()+"' and type='"+type+"';");
                    
                if(rs.next()){
                    switch (type){
                        case 'O':
                            OwnerPage o=new OwnerPage();
                            break;
                        case 'B':
                            BillPage b=new BillPage();
                            break;
                        case 'M':
                            StorePage s=new StorePage();
                            break;
                        case 'S':
                            StockPage st=new StockPage();
                            break;
                    }
                    hg.setVisible(false);
                    setVisible(false);
                }
                else
                {
                    msg.setText("Invalid Login");
                }
                d.endDb();
            } catch (SQLException ex) {
                Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (e.getSource().equals(reset)) {
            logint.setText(" ");
            pswrdt.setText(" ");
        }
    }
}
