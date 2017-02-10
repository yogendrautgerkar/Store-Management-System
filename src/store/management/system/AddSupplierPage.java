/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store.management.system;

import java.awt.*;
import java.awt.event.*;


class AddSupplierPage extends Frame implements ActionListener{
    Label wel,sid,cont,sname,msg;
    TextField sidt,contt,snamet,pt;
    Button sok;
    String pu;
    
    AddSupplierPage(TextField t,String ad){
        MyWindowAdapter win=new MyWindowAdapter(this);
        addWindowListener(win);
        
        pu=ad;
        pt=t;
        
        setLayout(new GridLayout(5,1,5,5));
        setSize(400, 300);
        setLocation(500, 300);
        setVisible(true);
        Font fontc = new Font("Times New Roman", Font.BOLD, 15);
        Font fontc1 = new Font("Times New Roman", Font.BOLD, 30);
        
        //heading//
        Panel head=new Panel(new FlowLayout());
        wel=new Label("ADD SUPPLIER");
        wel.setFont(fontc1);
        
        //message//
        Panel head1=new Panel(new FlowLayout());
        msg=new Label("                       ");
        msg.setFont(fontc);
        
        //supplier id field//
        Panel psid= new Panel(new GridLayout(1,2,5,5));
        Panel psid1 = new Panel(new FlowLayout(FlowLayout.LEFT));
        Panel psid2 = new Panel(new FlowLayout(FlowLayout.LEFT));
        sid=new Label("Mobile No:");
        sid.setFont(fontc);
        sidt=new TextField(20);
        
        //name field//
        Panel psname= new Panel(new GridLayout(1,2,5,5));
        Panel psname1 = new Panel(new FlowLayout(FlowLayout.LEFT));
        Panel psname2 = new Panel(new FlowLayout(FlowLayout.LEFT));
        sname=new Label("Name:");
        sname.setFont(fontc);
        snamet=new TextField(20);
        
        //add supplier button//
        Panel psok= new Panel(new FlowLayout());
        sok=new Button("OK");
        sok.setFont(fontc);
        sok.addActionListener(this);
        
        //**************************************//
        
        head.add(wel);
        add(head);
        
        head1.add(msg);
        add(head1);
        
        psid1.add(sid);
        sidt.setText(pu);
        psid2.add(sidt);
        psid.add(psid1);
        psid.add(psid2);
        add(psid);
        
        psname1.add(sname);
        psname2.add(snamet);
        psname.add(psname1);
        psname.add(psname2);
        add(psname);
        
        psok.add(sok);
        add(psok);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(sok)){
            String id=sidt.getText();
            String n=snamet.getText();
            if(id.equals("")||n.equals("")){
                msg.setText("Fill all fields.");
            }
            else{
                try {
                    Databases d=new Databases();
                    d.startDb();
                    d.changeRecords("insert into supplier values('"+id+"','"+n+"');");
                    d.endDb();
                    pt.setText(id);
                } catch (ClassNotFoundException ex) {
                    System.out.println("Class not found.");
                }
                setVisible(false);
            }
        }
    }
}
