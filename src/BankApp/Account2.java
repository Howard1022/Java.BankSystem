/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BankApp;

/**
 *
 * @author Howard Wu
 */

/**
 *
 * @author Lenovo
 */
public class Account2 {
    private String ID;
    private String Name;
    private String IC;
    private String Gender;
    private String Religion;
    private String Mobile;
    private String Email;
    private String AccountType;
    private String Address;
    private String DepositAmount;
    private String Password;
 
    
    public Account2(){
    }
    
    public Account2(String ID, String Name, String IC,String Gender, String Religion, String Mobile, String Email, String AccountType, String Address, String DepositAmount, String Password){
        this.ID = ID;
        this.Name = Name;
        this.IC = IC;
        this.Gender = Gender;
        this.Religion = Religion;
        this.Mobile = Mobile;
        this.Email = Email;
        this.AccountType = AccountType;
        this.Address = Address;
        this.DepositAmount = DepositAmount;
        this.Password = Password;
    }
    
    Account2(String accdata){
        String[] dataArr = accdata.split("/");
        this.ID = dataArr[0];
        this.Name = dataArr[1];
        this.IC = dataArr[2];
        this.Gender = dataArr[3];
        this.Religion = dataArr[4];
        this.Mobile = dataArr[5];
        this.Email = dataArr[6];
        this.AccountType = dataArr[7];
        this.Address = dataArr[8];
        this.DepositAmount = dataArr[9];
        this.Password = dataArr[10];
    }
    public String getEmail() {
        return Email;
    }
    public void setEmail(String Email) {
        this.Email = Email;
    }
    public String getName() {
        return Name;
    }
    public void setName(String Name) {
        this.Name = Name;
    }
    public String getID() {
        return ID;
    }
    public void setID(String ID) {
        this.ID = ID;
    }
    public String getGender() {
        return Gender;
    }
    public void setGender(String Gender) {
        this.Gender = Gender;
    }
    public String getDepositAmount() {
        return DepositAmount;
    }
    public void setDepositAmount(String DepositAmount) {
        this.DepositAmount = DepositAmount;
    }
    public String getIC() {
        return IC;
    }
    public void setIC(String IC) {
        this.IC = IC;
    }
    public String getMobile() {
        return Mobile;
    }
    public void setMobile(String Mobile) {
        this.Mobile = Mobile;
    }
    public String getPassword() {
        return Password;
    }
    public void setPassword(String Password) {
        this.Password = Password;
    }
    public String getAddress() {
        return Address;
    }
    public void setAddress(String Address) {
        this.Address = Address;
    }
    public String getReligion() {
        return Religion;
    }
    public void setReligion(String Religion) {
        this.Religion = Religion;
    }
    public String getAccountType() {
        return AccountType;
    }
    public void setAccountType(String AccountType) {
        this.AccountType = AccountType;
    }
  

    @Override
    public String toString(){
        return (this.ID + "/" + this.Name +"/"+ this.IC+"/"+this.Gender+"/"+this.Religion+"/"+this.Mobile+"/"+this.Email+"/"+this.AccountType+"/"+this.Address+"/"+this.DepositAmount+"/"+this.Password);
    }
}
