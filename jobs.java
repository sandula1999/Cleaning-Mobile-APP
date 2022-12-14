package com.example.icbt;

public class jobs {

    private String JobType;
    private String CustomerName;
    private String CustomerEmail;
    private String CustomerMobile;
    private String CustomerAddress;
    private String NumberOfRoom;

    public jobs(){}

    public jobs(String jobtype,String customername,String customeremail,String customermobile,String customeraddress,String numberofroom){
        JobType=jobtype;
        CustomerName=customername;
        CustomerEmail=customeremail;
        CustomerMobile=customermobile;
        CustomerAddress=customeraddress;
        NumberOfRoom=numberofroom;

    }

    public String getJobType () {
        return JobType;
    }

    public void setJobType ( String jobtype ) {
       this.JobType = jobtype;
    }

    public String getCustomerName () {
        return CustomerName;
    }

    public void setCustomerName ( String customername ) {
        this.CustomerName = customername;
    }

    public String getCustomerEmail () {
        return CustomerEmail;
    }

    public void setCustomerEmail ( String customeremail ) {
        this.CustomerEmail = customeremail;
    }

    public String getCustomerMobile () {
        return CustomerMobile;
    }

    public void setCustomerMobile ( String customermobile ) {
        this.CustomerMobile = customermobile;
    }

    public String getCustomerAddress () {
        return CustomerAddress;
    }

    public void setCustomerAddress ( String customeraddress ) {
        this.CustomerAddress = customeraddress;
    }

    public String getNumberOfRoom () {
        return NumberOfRoom;
    }

    public void setNumberOfRoom ( String numberofroom ) {
        this.NumberOfRoom = numberofroom;
    }
}
