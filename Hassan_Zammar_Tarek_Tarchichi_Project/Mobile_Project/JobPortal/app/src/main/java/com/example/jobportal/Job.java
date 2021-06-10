package com.example.jobportal;

public class Job {
    private int CID;
    private String Cname;
    private String Email;
    private int Cphone;
    private String Jtitle;
    private String Jdescription;
    private String Jaddress;

    public Job(int CID, String Cname, String Email, int Cphone, String Jtitle, String Jdescription, String Jaddress) {
        this.CID = CID;
        this.Cname = Cname;
        this.Email = Email;
        this.Cphone = Cphone;
        this.Jtitle = Jtitle;
        this.Jdescription = Jdescription;
        this.Jaddress = Jaddress;
    }

    @Override
    public String toString() {
        return  "CID: " + CID +
                "\nCompany Name: " + Cname +
                "\nEmail: " + Email +
                "\nCompany Phone: " + Cphone +
                "\nJob Title: " + Jtitle +
                "\nJob Description: " + Jdescription +
                "\nJob Address: " + Jaddress;
    }
}

