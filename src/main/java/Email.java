import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String department;
    private String password;
    private int defaultPasswordLength = 10;
    private String email;
    private int mailboxCapacity = 500;
    private String alternateEmail;
    private String companySuffix = "ssh.com";

    //constructor for first and lastname


    public Email(String firstName, String lastName, String department){
        this.firstName = firstName;
        this.lastName = lastName;
        //System.out.println("Email created successfully: "+ this.firstName+" "+this.lastName);
        //call a method asking for the department - returns dept
        this.department = department;
        //System.out.println("Department is: "+ this.department);
        // calling a method that returns random password
        this.password = randomPassword(defaultPasswordLength);
        //System.out.println("This is your temp password: "+ this.password);
        //combine elements to generate email
        this.email = firstName.toLowerCase()+"."+lastName.toLowerCase()+"@"+department+"."+companySuffix;
        //System.out.println("Your email is: "+email);
    }

    //ask for the department
//    private String setDepartment(){
//        System.out.println("New Employee: "+ firstName+ ". \nEnter Department CODES\n1 for sales\n2 for Development\n3 For Accounting\n0 For None\nEnter Department Code:");
//        Scanner in = new Scanner(System.in);
//        int deptChoice = in.nextInt();
//        if(deptChoice == 1) {return "sales";}
//        else if(deptChoice == 2) {return "dev";}
//        else if (deptChoice == 3) {return "acct";}
//        else {return "";}
//        }

    //generate a random password
    private String randomPassword(int length){
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTWXYZ123456789@!#$%&*";
        char[] password = new char[length];
        for (int i=0; i<length;i++){
            int Random =(int) (Math.random() *  passwordSet.length());
            password[i] = passwordSet.charAt(Random);
        }
        return new String(password);
    }
    //get email
    public String getEmail() {
        return email;
    }
    //set the mailbox capacity
    public void setMailboxCapacity(int capacity) {
        this.mailboxCapacity = capacity;
    }


    //set the alternate mail
    public void setAlternateEmail(String altmail) {
        this.alternateEmail = altmail;
    }

    //change the password
    public void changePassword(String chngPass){
        this.password = chngPass;
    }
    public int getMailboxCapacity() {return mailboxCapacity;}
    public String getAlternateEmail() {return alternateEmail;}
    public String getPassword() {return password;}

    public String showInfo(){
        return "DISPLAY NAME: "+ " " + firstName + " " + lastName +" " +
                "\nCOMPANY EMAIL: "+ email +" " +
                "\nMAILBOX CAPACITY: " + mailboxCapacity +"mb";
    }
}
