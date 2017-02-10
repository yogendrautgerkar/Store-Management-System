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
class StorePage extends Frame implements ActionListener{
    Label wel,spid,description;
    TextField spidt,descriptiont;
    Button warn,sale,sdiscount,req,desc,get_pid;
    TextArea disp;
    StorePage() {
        MyWindowAdapter win=new MyWindowAdapter(this);
        addWindowListener(win);
        
        setLayout(new BorderLayout(5, 5));
        setSize(1000, 1000);
        setLocation(400, 100);
        setVisible(true);
        Font fontr = new Font("Times New Roman", Font.BOLD, 15);
        Font fontr1 = new Font("Times New Roman", Font.BOLD, 30);
        
        //heading//
        Panel pnrth=new Panel(new FlowLayout());
        wel=new Label("STORE MANAGEMENT");
        wel.setFont(fontr1);
        
    //center border//
        Panel pcentr=new Panel(new GridLayout(1,2,5,5));
        
        //display//
        disp=new TextArea(" ",5,10,TextArea.SCROLLBARS_NONE);
        disp.setFont(fontr);
        disp.setBackground(Color.LIGHT_GRAY);
        
        //left side components//
        Panel form=new Panel(new GridLayout(5,1,5,5));
        
        //warn and sale button//
        Panel form1=new Panel(new GridLayout(1,2,5,5));
        
        //warn button//
        Panel wrn=new Panel(new FlowLayout());
        warn=new Button("WARNING");
        warn.addActionListener(this);
        warn.setFont(fontr);
        
        //sale button//
        Panel sle=new Panel(new FlowLayout());
        sale=new Button("TODAY'S SALE");
        sale.addActionListener(this);
        sale.setFont(fontr);
        
        //pid field//
        Panel form2=new Panel(new GridLayout(1,2,5,5));
        Panel spid1=new Panel(new FlowLayout());
        Panel spid2=new Panel(new FlowLayout());
        spid=new Label("PRODUCT ID");
        spid.setFont(fontr);
        spidt=new TextField(20);
        
        //discount, requirement and desccription button//
        Panel form3=new Panel(new GridLayout(1,3,5,5));
        
        //discount Button//
        Panel sdis=new Panel(new FlowLayout());
        sdiscount=new Button("DISCOUNT");
        sdiscount.addActionListener(this);
        sdiscount.setFont(fontr);
        
        //requirement button//
        Panel sreq=new Panel(new FlowLayout());
        req=new Button("REQUIREMENT");
        req.addActionListener(this);
        req.setFont(fontr);
        
        //description button//
        Panel sdes=new Panel(new FlowLayout());
        desc=new Button("DESCRIPTION");
        desc.addActionListener(this);
        desc.setFont(fontr);
        
        //description field//
        Panel form4=new Panel(new GridLayout(1,2,5,5));
        Panel desc1=new Panel(new FlowLayout());
        Panel desc2=new Panel(new FlowLayout());
        description=new Label("Description");
        description.setFont(fontr);
        descriptiont=new TextField(20);
        
        //get pid button//
        Panel form5=new Panel(new FlowLayout());
        get_pid=new Button("GET PRODUCT ID");
        get_pid.addActionListener(this);
        get_pid.setFont(fontr);
        
        //**********************************************************//
        
        pnrth.add(wel);
        add(pnrth,BorderLayout.NORTH);
        
        wrn.add(warn);
        sle.add(sale);
        form1.add(wrn);
        form1.add(sle);
        form.add(form1);
        
        spid1.add(spid);
        spid2.add(spidt);
        form2.add(spid1);
        form2.add(spid2);
        form.add(form2);
        
        sdis.add(sdiscount);
        sreq.add(req);
        sdes.add(desc);
        form3.add(sdis);
        form3.add(sreq);
        form3.add(sdes);
        form.add(form3);
        
        desc1.add(description);
        desc2.add(descriptiont);
        form4.add(desc1);
        form4.add(desc2);
        form.add(form4);
        
        form5.add(get_pid);
        form.add(form5);
        
        pcentr.add(form);
        
        pcentr.add(disp);
        add(pcentr,BorderLayout.CENTER);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
    if(e.getSource().equals(warn)){
        try {
                disp.setText("");
                Databases d=new Databases();
                d.startDb();
                ResultSet rs=d.displayRecords("select ps.P_ID,ps.EXP,p.p_name,p.company from store_management_system.Prod_in_store ps,store_management_system.product p where (CURDATE() between DATE_SUB(ps.EXP,INTERVAL ps.WarnDays DAY) and ps.EXP) and (ps.P_ID=p.ID)");
                try {
                    while(rs.next()){
                        disp.append("PID: "+rs.getString("P_ID")+"  Name: "+rs.getString("p.p_name")+"  Company: "+rs.getString("p.company")+"  Expiry date: "+rs.getString("EXP")+"\n");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(StockPage.class.getName()).log(Level.SEVERE, null, ex);
                }
                d.endDb();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(StockPage.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    else if(e.getSource().equals(sale)){
        try {
            Databases d=new Databases();
            d.startDb();
            ResultSet rs=d.displayRecords("Select SUM(total) as SL from store_management_system.cust_tran where DATE(c_date)=CURDATE()");
            try {
                if(rs.next())
                    disp.setText("Today's sale is: "+rs.getInt("SL"));
            } catch (SQLException ex) {
                Logger.getLogger(StorePage.class.getName()).log(Level.SEVERE, null, ex);
            }
            d.endDb();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StorePage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    else if(e.getSource().equals(sdiscount)){
        try {
            Databases d=new Databases();
            d.startDb();
            ResultSet rs=null;
            disp.setText("");
                
            if(spidt.getText().equals(""))
            {
                rs=d.displayRecords("select P_ID,Discount from store_management_system.Prod_in_store where Discount>0");
                try {
                    while(rs.next())
                    {
                        disp.append("PID: "+rs.getString("P_ID")+"  Discount: "+rs.getString("Discount")+"\n");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(StorePage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else
            {
                rs=d.displayRecords("select Discount from store_management_system.Prod_in_store where P_ID='"+spidt.getText()+"'");
                try {
                    if(rs.next())
                        disp.setText("PID: "+spidt.getText()+"  Discount: "+rs.getString("Discount"));
                    spidt.setText("");
                    spidt.requestFocus();
                } catch (SQLException ex) {
                    Logger.getLogger(StorePage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StorePage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    else if(e.getSource().equals(req)){
        try {
            Databases d=new Databases();
            d.startDb();
            disp.setText("");
            ResultSet rs=d.displayRecords("select ID,p_Name  from store_management_system.product where ID not in (select P_ID from store_management_system.Prod_in_store)");
            try {
                while(rs.next())
                {
                    disp.append("PID: "+rs.getString("ID")+"  Name: "+rs.getString("p_Name")+"\n");
                }
            } catch (SQLException ex) {
                Logger.getLogger(StorePage.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StorePage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    else if(e.getSource().equals(desc)){
        try {
            Databases d=new Databases();
            d.startDb();
            
            ResultSet rs=d.displayRecords("select p_Name,Company from store_management_system.product where ID='"+spidt.getText()+"'");
            try {
                if(rs.next())
                    disp.setText("Product Name: "+rs.getString("p_Name")+"\nCompany: "+rs.getString("Company"));
            } catch (SQLException ex) {
                Logger.getLogger(StorePage.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StorePage.class.getName()).log(Level.SEVERE, null, ex);
        }
        spidt.setText("");
        spidt.requestFocus();
    }
    else if(e.getSource().equals(get_pid)){
        try {
            String s1=descriptiont.getText();
            char cs1[]=s1.toCharArray();
            char cs2[]=new char[cs1.length*2+1];
            int i;
            cs2[0]='%';
            for(i=0;i<cs1.length;i++)
            {
                cs2[i*2+1]=cs1[i];
                cs2[i*2+2]='%';
            }
            s1=new String(cs2);
            Databases d=new Databases();
            d.startDb();
            ResultSet rs=d.displayRecords("select * from store_management_system.product where p_Name like '"+s1+"' or Company like '"+s1+"'");
            disp.setText("");
            try {
                while(rs.next())
                {
                    disp.append("PID: "+rs.getString("ID")+"   Name: "+rs.getString("p_Name")+"   Company: "+rs.getString("Company")+"\n");
                }
            } catch (SQLException ex) {
                Logger.getLogger(StorePage.class.getName()).log(Level.SEVERE, null, ex);
            }
            d.endDb();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StorePage.class.getName()).log(Level.SEVERE, null, ex);
        }
        descriptiont.setText("");
        descriptiont.requestFocus();
    }
    }
}
