/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store.management.system;

import java.awt.event.*;


class MyWindowAdapter extends WindowAdapter {
    AddCustomerPage acp;
    AddItemPage aip;
    AddSupplierPage asp;
    BillPage bp;
    HomePage hp;
    LoginPage lp;
    NewLoginPage nlp;
    OwnerPage op;
    StockPage kp;
    StorePage rp;
    public MyWindowAdapter(AddCustomerPage acp) {
        this.acp=acp;    
    }
    public MyWindowAdapter(AddItemPage aip){
        this.aip=aip;   
    }
    public MyWindowAdapter(AddSupplierPage asp) {
        this.asp=asp;
    }
    public MyWindowAdapter(BillPage bp) {
        this.bp=bp;
    }
    public MyWindowAdapter(HomePage hp) {
        this.hp=hp;
    }
    public MyWindowAdapter(LoginPage lp) {
        this.lp=lp;
    }
    public MyWindowAdapter(NewLoginPage nlp) {
        this.nlp=nlp;
    }
    public MyWindowAdapter(OwnerPage op) {
        this.op=op;
    }
    public MyWindowAdapter(StockPage kp) {
        this.kp=kp;
    }
    public MyWindowAdapter(StorePage rp) {
        this.rp=rp;
    }

    @Override
    public void windowClosing(WindowEvent we) {
        if(we.getComponent().equals(hp)){
            System.exit(0);
        }
        else  if(we.getComponent().equals(lp)){
            lp.setVisible(false);
        }
        else  if(we.getComponent().equals(op)){
            op.setVisible(false);
            HomePage h=new HomePage();
        }
        else  if(we.getComponent().equals(bp)){
            bp.setVisible(false);
           HomePage h=new HomePage();
        }
        else  if(we.getComponent().equals(rp)){
            rp.setVisible(false);
            HomePage h=new HomePage();
        }
        else  if(we.getComponent().equals(kp)){
            kp.setVisible(false);
            HomePage h=new HomePage();
        }
        else  if(we.getComponent().equals(nlp)){
            nlp.setVisible(false);
        }
        else  if(we.getComponent().equals(acp)){
            acp.setVisible(false);
        }
        else  if(we.getComponent().equals(aip)){
            aip.setVisible(false);
        }
        else  if(we.getComponent().equals(asp)){
            asp.setVisible(false);
        }
        
    }
}
