/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store.management.system;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

class BillPage extends Frame implements ActionListener {
    Label contact, pid, quant, wel,total;
    TextField contactt, pidt, quantt, verifyt,totalt;
    Button acus,aitem, abill, verify;
    TextArea list;
    Image img;
    int pay,amt,pro,cost,tr,quan;

    BillPage() {
        pay=0;
        cost=0;
        MyWindowAdapter win=new MyWindowAdapter(this);
        addWindowListener(win);
        
        
        setLayout(new BorderLayout(5,5));
        setSize(1000, 1000);
        setLocation(400, 100);
        setVisible(true);
        Font fontb = new Font("Times New Roman", Font.BOLD, 15);
        Font fontb1 = new Font("Times New Roman", Font.BOLD, 30);

     ////heading and add customer field////north border////
        Panel pnorth=new Panel(new GridLayout(2,1,5,5));
        
        //heading//
        Panel head = new Panel(new FlowLayout());
        wel = new Label("BILL");
        wel.setFont(fontb1);

     //add customer ane verify field//
        Panel cus_ver = new Panel(new GridLayout(1, 4, 5, 5));
        Panel add_cus = new Panel(new FlowLayout((FlowLayout.LEFT)));
        Panel verify1 = new Panel(new FlowLayout((FlowLayout.LEFT)));
        Panel verify2 = new Panel(new FlowLayout((FlowLayout.LEFT)));
        //add customer button//
        acus = new Button("ADD CUSTOMER");
        acus.setFont(fontb);
        acus.addActionListener(this);
        //verify textfield//
        verifyt = new TextField(20);
        verifyt.setFont(fontb);
        //verify button//
        verify = new Button("VERIFY CUSTOMER");
        verify.setFont(fontb);
        verify.addActionListener(this);
        
     ////text area for item list and other components////center border//
        Panel pcenter=new Panel(new GridLayout(1,2, 5, 5));
        
        //dividiny center into two parts//
        Panel division= new Panel(new GridLayout(1,2, 5, 5));
        
        //item list TextArea//
        list=new TextArea("",8,5,TextArea.SCROLLBARS_VERTICAL_ONLY);
        Font l=new Font("Times new roman",Font.PLAIN,20);
        list.setFont(l);
        
        ////Billing////
        Panel billing=new Panel(new GridLayout(5,1,5,5));
        
        //product ID field//
        Panel pro_id = new Panel(new GridLayout(1, 2, 5, 5));
        Panel pro_id1 = new Panel(new FlowLayout(FlowLayout.LEFT));
        Panel pro_id2 = new Panel(new FlowLayout(FlowLayout.LEFT));
        pid = new Label("Product ID:  ");
        pidt = new TextField(20);
        pid.setFont(fontb);

        //quantity field//
        Panel quan = new Panel(new GridLayout(1, 2, 5, 5));
        Panel quan1 = new Panel(new FlowLayout(FlowLayout.LEFT));
        Panel quan2 = new Panel(new FlowLayout(FlowLayout.LEFT));
        quant = new Label("Quantity:     ");
        quantt = new TextField(20);
        quant.setFont(fontb);

        //add item button//
        Panel additem = new Panel(new GridLayout(1, 2, 5, 5));
        Panel additem1 = new Panel(new FlowLayout(FlowLayout.LEFT));
        Panel additem2 = new Panel(new FlowLayout(FlowLayout.LEFT));
        aitem = new Button("ADD ITEM");
        aitem.setFont(fontb);
        aitem.addActionListener(this);

        //contact no. field//
        Panel con = new Panel(new GridLayout(1, 2, 5, 5));
        Panel con1 = new Panel(new FlowLayout(FlowLayout.LEFT));
        Panel con2 = new Panel(new FlowLayout(FlowLayout.LEFT));
        contact=new Label("Mobile No:");
        contactt=new TextField(20);
        contact.setFont(fontb);
        
        //bill button//
        Panel bill_but = new Panel(new GridLayout(1, 2, 5, 5));
        Panel bill_but1 = new Panel(new FlowLayout(FlowLayout.LEFT));
        Panel bill_but2 = new Panel(new FlowLayout(FlowLayout.LEFT));
        abill=new Button("BILL");
        abill.setFont(fontb);
        abill.addActionListener(this);

        //total field//
        Panel psouth=new Panel(new GridLayout(1,4,5,5));
        Panel tot=new Panel(new FlowLayout(FlowLayout.LEFT));
        total=new Label("Total");
        total.setFont(fontb);
        totalt=new TextField(20);
        
        //**********************************************************//
       
        head.add(wel);
        pnorth.add(head);
        
        add_cus.add(acus);
        verify1.add(verifyt);
        verify2.add(verify);
        cus_ver.add(add_cus);
        cus_ver.add(new Label(""));
        cus_ver.add(verify1);
        cus_ver.add(verify2);
        pnorth.add(cus_ver);
        
        pro_id1.add(pid);
        pro_id2.add(pidt);
        pro_id.add(pro_id1);
        pro_id.add(pro_id2);
        billing.add(pro_id);
        
        quan1.add(quant);
        quan2.add(quantt);
        quan.add(quan1);
        quan.add(quan2);
        billing.add(quan);

        additem1.add(new Label(""));
        additem2.add(aitem);
        additem.add(additem1);
        additem.add(additem2);
        billing.add(additem);
        
        con1.add(contact);
        con2.add(contactt);
        con.add(con1);
        con.add(con2);
        billing.add(con);
        
        bill_but1.add(new Label(" "));
        bill_but2.add(abill); 
        bill_but.add(bill_but1);
        bill_but.add(bill_but2);
        billing.add(bill_but);
        
        division.add(billing);
        pcenter.add(division);
        pcenter.add(list);
        
        
        tot.add(total);
        tot.add(totalt);
        psouth.add(new Label(""));
        psouth.add(new Label(""));
        psouth.add(new Label(""));
        psouth.add(tot);
        
        add(psouth,BorderLayout.SOUTH);
        
        add(pcenter,BorderLayout.CENTER);
        
        add(pnorth,BorderLayout.NORTH);
    }
    @Override
         public void paint(Graphics g){
            g.drawImage(img, 200, 200, null);
        }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(acus)){
            AddCustomerPage acp=new AddCustomerPage("");
        }
        else if(e.getSource().equals(verify)){
            try {
                String a=verifyt.getText();
                Databases d=new Databases();
                d.startDb();
                ResultSet rs=d.displayRecords("select *from store_management_system.Customer where id="+a+";");
                try {
                    if(rs.next()){
                        contactt.setText(rs.getString("id"));
                    }
                    else{
                        AddCustomerPage acp=new AddCustomerPage(a);
                        contactt.setText(a);
                    }
                    d.endDb();
                d=new Databases();
                d.startDb();
                d.changeRecords("insert into cust_tran (cid,profit,total) values ('"+a+"',0,0);");
                d.endDb();
                d=new Databases();
                d.startDb();
                rs=d.displayRecords("select max(t_id) as ntid from store_management_system.cust_tran;");
                if(rs.next()){
                    tr=rs.getInt("ntid");
                }
                d.endDb();
                pidt.requestFocus();
                } catch (SQLException ex) {
                    Logger.getLogger(BillPage.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(BillPage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(e.getSource().equals(aitem)){
            try {
                int x = 0;
                String a=pidt.getText();
                String b=quantt.getText();
                Databases d=new Databases();
                d.startDb();
                ResultSet rs=d.displayRecords("select QTY,CP,MRP,Discount from store_management_system.Prod_in_store where P_ID='"+a+"';");
                if(rs.next()){
                    quan=rs.getInt("QTY");
                
                        int cp=rs.getInt("CP");
                        int c=rs.getInt("MRP");
                        int ds=rs.getInt("Discount");
                        x=Integer.parseInt(b);
                        amt=(int)x*(c-ds*c/100);/*calculating price after discount*/
                        pro=x*cp;
                        list.append(a+"  "+b+"   "+amt+"\n");
                        pay=pay+amt;
                        totalt.setText(Integer.toString(pay));
                        cost=cost+pro;
                    quantt.setText("");
                    pidt.setText("");
                    pidt.requestFocus();
                }
                d.endDb();
                d=new Databases();
                d.startDb();
                d.changeRecords("insert into store_management_system.cust_prod_tran values("+tr+",'"+a+"',"+b+");");
                d.endDb();
                d=new Databases();
                d.startDb();
                if(quan>x){
                    int z=quan-x;
                    d.changeRecords("update store_management_system.Prod_in_store set QTY="+z+" where P_ID='"+a+"';");
                }
                else if(quan==x){
                    d.changeRecords("delete from store_management_system.Prod_in_store where P_ID="+a+";");
                }
                d.endDb();
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(BillPage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(e.getSource().equals(abill)){
            
            try {
                String k=contactt.getText();
                int prft=pay-cost;
                Databases d=new Databases();
                d.startDb();
                d.changeRecords("update store_management_system.cust_tran set profit="+prft+",total="+pay+" where t_id='"+tr+"';");
                //d.changeRecords("");
                d.endDb();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(BillPage.class.getName()).log(Level.SEVERE, null, ex);
            }
            pay=0;
            cost=0;
            list.setText("");
            pidt.setText("");
            quantt.setText("");
            verifyt.setText("");
            contactt.setText("");
            verifyt.requestFocus();
        }
    }
}
