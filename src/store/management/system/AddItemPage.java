/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store.management.system;
import java.awt.*;
import java.awt.event.*;
class AddItemPage extends Frame implements ActionListener{
    Label iwel,ipid,cmpny,iname,msg;
    TextField ipidt,cmpnyt,inamet;
    Button iok;
    
    AddItemPage(){
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
        iwel=new Label("ADD NEW ITEM");
        iwel.setFont(fontc1);
        
        //message//
        Panel head1=new Panel(new FlowLayout());
        msg=new Label("                           ");
        msg.setFont(fontc);
        
        //product id field//
        Panel pipid= new Panel(new GridLayout(1,2,5,5));
        Panel pipid1 = new Panel(new FlowLayout(FlowLayout.LEFT));
        Panel pipid2 = new Panel(new FlowLayout(FlowLayout.LEFT));
        ipid=new Label("Product ID");
        ipid.setFont(fontc);
        ipidt=new TextField(20);
        
        //name field//
        Panel piname= new Panel(new GridLayout(1,2,5,5));
        Panel piname1 = new Panel(new FlowLayout(FlowLayout.LEFT));
        Panel piname2 = new Panel(new FlowLayout(FlowLayout.LEFT));
        iname=new Label("Name");
        iname.setFont(fontc);
        inamet=new TextField(20);
        
        //company field//
        Panel pcmpny= new Panel(new GridLayout(1,2,5,5));
        Panel pcmpny1 = new Panel(new FlowLayout(FlowLayout.LEFT));
        Panel pcmpny2 = new Panel(new FlowLayout(FlowLayout.LEFT));
        cmpny=new Label("Company");
        cmpny.setFont(fontc);
        cmpnyt=new TextField(20);
        
        //add new item button//
        Panel piok= new Panel(new FlowLayout());
        iok=new Button("OK");
        iok.setFont(fontc);
        iok.addActionListener(this);
        
        //*****************************************************//
        
        head.add(iwel);
        add(head);
        
        head1.add(msg);
        add(head1);
        
        pipid1.add(ipid);
        pipid2.add(ipidt);
        pipid.add(pipid1);
        pipid.add(pipid2);
        add(pipid);
        
        piname1.add(iname);
        piname2.add(inamet);
        piname.add(piname1);
        piname.add(piname2);
        add(piname);
        
        pcmpny1.add(cmpny);
        pcmpny2.add(cmpnyt);
        pcmpny.add(pcmpny1);
        pcmpny.add(pcmpny2);
        add(pcmpny);
        
        piok.add(iok);
        add(piok);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(iok)){
            String id=ipidt.getText();
            String n=inamet.getText();
            String c=cmpnyt.getText();
            if(id.equals("")||n.equals("")||c.equals("")){
                msg.setText("Fill all fields.");
            }
            else{
                try {
                    Databases d=new Databases();
                    d.startDb();
                    d.changeRecords("insert into product values('"+id+"','"+n+"','"+c+"');");
                    d.endDb();
                } catch (ClassNotFoundException ex) {
                    System.out.println("Class not found.");
                }
                setVisible(false);
            }
        }
    }
}
