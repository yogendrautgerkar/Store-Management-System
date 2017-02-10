/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store.management.system;
import java.awt.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
class NewLoginPage extends Frame implements ActionListener{
    Label log,pas,type,wel;
    TextField logt,past;
    Button create;
    CheckboxGroup cbg;
    Checkbox b,r,k;
    
    NewLoginPage(){
        MyWindowAdapter win=new MyWindowAdapter(this);
        addWindowListener(win);
        
        setLayout(new GridLayout(5,1,5,5));
        setSize(400, 300);
        setLocation(500, 300);
        setVisible(true);
        Font fontl = new Font("Times New Roman", Font.BOLD, 15);
        Font fontl1 = new Font("Times New Roman", Font.BOLD, 30);
        
        //heading//
        Panel frm1=new Panel(new FlowLayout());
        wel=new Label("CREATE NEW LOGIN");
        wel.setFont(fontl1);
        
        //type field//
        Panel frm2=new Panel(new GridLayout(1,2,5,5));
        Panel ra=new Panel(new FlowLayout(FlowLayout.LEFT));
        type=new Label("Type");
        type.setFont(fontl);
        cbg=new CheckboxGroup();
        b=new Checkbox("Bill",cbg,true);
        b.setFont(fontl);
        r=new Checkbox("Store",cbg,false);
        r.setFont(fontl);
        k=new Checkbox("Stock",cbg,true);
        k.setFont(fontl);
        
        //login field//
        Panel frm3=new Panel(new GridLayout(1,2,5,5));
        Panel lab=new Panel(new FlowLayout(FlowLayout.LEFT));
        Panel text=new Panel(new FlowLayout(FlowLayout.LEFT));
        log=new Label("Login ID");
        log.setFont(fontl);
        logt=new TextField(20);
        
        //password field//
        Panel frm4=new Panel(new GridLayout(1,2,5,5));
        Panel lab1=new Panel(new FlowLayout(FlowLayout.LEFT));
        Panel text1=new Panel(new FlowLayout(FlowLayout.LEFT));
        pas=new Label("Password");
        pas.setFont(fontl);
        past=new TextField(20);
        
        //create button//
       // Panel frm5=new Panel(new GridLayout(1,1,5,5));
        Panel frm5=new Panel(new FlowLayout());
        create=new Button("CREATE");
        create.setFont(fontl);
        create.addActionListener(this);
        
        //************************************************//
        
        frm1.add(wel);
        add(frm1);
        
        ra.add(type);
        frm2.add(ra);
        frm2.add(b);
        frm2.add(r);
        frm2.add(k);
        add(frm2);
        
        lab.add(log);
        text.add(logt);
        frm3.add(lab);
        frm3.add(text);
        add(frm3);
        
        lab1.add(pas);
        text1.add(past);
        frm4.add(lab1);
        frm4.add(text1);
        add(frm4);
        
        frm5.add(create);
        add(frm5);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(create)){
            String ul=logt.getText();
            String pw=past.getText();
            Checkbox c=cbg.getSelectedCheckbox();
            char type;
            if(c==null||ul.equals(null)||pw.equals(null)){
                wel.setText("Incorrect");
            }
            else{
                try {
                    if(c==b)
                        type='B';
                    else if(c==r)
                        type='M';
                    else
                        type='S';
                    Databases d=new Databases();
                    d.startDb();
                    d.changeRecords("insert into user_login values ('"+ul+"','"+pw+"','"+type+"');");
                    d.endDb();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(NewLoginPage.class.getName()).log(Level.SEVERE, null, ex);
                }
                setVisible(false);
                
            }    
        }
    }
    
}
