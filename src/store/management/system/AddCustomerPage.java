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

class AddCustomerPage extends Frame implements ActionListener{
    Label cid,name,con_nmbr,heading,msg;
    TextField cidt,namet,con_nmbrt;
    Button add;
    
    AddCustomerPage(String s){
        MyWindowAdapter win=new MyWindowAdapter(this);
        addWindowListener(win);
        
        
        setLayout(new GridLayout(6,1,5,5));
        setSize(400, 300);
        setLocation(500, 300);
        setVisible(true);
        Font fontc = new Font("Times New Roman", Font.BOLD, 15);
        Font fontc1 = new Font("Times New Roman", Font.BOLD, 30);
        
        //heading//
        Panel head=new Panel(new FlowLayout());
        heading=new Label("Add Customer");
        heading.setFont(fontc1);
        
        //message field below heading//
        Panel head1=new Panel(new FlowLayout());
        msg=new Label("                 ");
        msg.setFont(fontc);
        
        //Customer ID field//
        Panel customer=new Panel(new GridLayout(1,2,5,5));
        Panel customer1=new Panel(new FlowLayout(FlowLayout.LEFT));
        Panel customer2=new Panel(new FlowLayout(FlowLayout.LEFT));
        cid=new Label("Mobile No");
        cid.setFont(fontc);
        cidt=new TextField(20);
        cidt.setText(s);
        
        //name field//
        Panel pname=new Panel(new GridLayout(1,2,5,5));
        Panel pname1=new Panel(new FlowLayout(FlowLayout.LEFT));
        Panel pname2=new Panel(new FlowLayout(FlowLayout.LEFT));
        name=new Label("Name");
        name.setFont(fontc);
        namet=new TextField(20);
        
        /* //contact field//
        Panel pcon=new Panel(new GridLayout(1,2,5,5));
        Panel pcon1=new Panel(new FlowLayout(FlowLayout.LEFT));
        Panel pcon2=new Panel(new FlowLayout(FlowLayout.LEFT));
        con_nmbr=new Label("Contact Number");
        con_nmbr.setFont(fontc);
        con_nmbrt=new TextField(20);*/
        
        //add  button//
        Panel add_but=new Panel(new FlowLayout());
        add=new Button("ADD");
        add.setFont(fontc1);
        add.addActionListener(this);
        
        //***********************************************//
        
        head.add(heading);
        add(head);
        
        head1.add(msg);
        add(head1);
        
        customer1.add(cid);
        customer2.add(cidt);
        customer.add(customer1);
        customer.add(customer2);
        add(customer);
        
        pname1.add(name);
        pname2.add(namet);
        pname.add(pname1);
        pname.add(pname2);
        add(pname);
        
        add_but.add(add);
        add(add_but);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(add)){
            String id=cidt.getText();
            String n=namet.getText();
            if(id.equals("")||n.equals("")){
                msg.setText("Fill all fields.");
            }
            else{
                try {
                    Databases d=new Databases();
                    d.startDb();
                    d.changeRecords("insert into Customer values('"+id+"','"+n+"');");
                    d.endDb();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(AddCustomerPage.class.getName()).log(Level.SEVERE, null, ex);
                }
                setVisible(false);
            }
        }
    }
}
