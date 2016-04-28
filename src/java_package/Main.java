package java_package;

import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        show_menu menu = new show_menu();
        SQL sql = new SQL();
        int chose;
        Scanner sc = new Scanner(System.in);
        do{
            menu.Show_start_menu();
            chose = sc.nextInt();
            int k = 0;
            switch (chose) {
                case 1:
                    do {
                        String loginn, passs;
                        System.out.println("Enter your login:");
                        loginn = sc.next();
                        System.out.println("Enter your pass:");
                        passs = sc.next();
                        if (sql.SignIn(loginn, passs)) {
                            System.out.println("WELCOME " + loginn);
                            if (loginn.equals("admin")) {
                                int chose1;
                                do {
                                    menu.Show_admin_menu();
                                    chose1 = sc.nextInt();
                                    switch (chose1) {
                                        case 1:
                                            sql.ShowListOfUsers();
                                            break;
                                        case 2:
                                            System.out.println("Enter your current password:");
                                            passs = sc.next();
                                            if(sql.SignIn(loginn, passs)) {
                                                String newpass;
                                                System.out.println("Enter new password");
                                                newpass = sc.next();
                                                sql.ChangePassword(loginn, newpass);
                                            }
                                            break;
                                        case 3:
                                            String username;
                                            System.out.println("Enter username to block:");
                                            username = sc.next();
                                            sql.BlockUser(username);
                                        case 4:
                                            String username1;
                                            System.out.println("Enter username to block:");
                                            username1 = sc.next();
                                            sql.NotAnyPassword(username1);
                                        case 5:
                                            String username3;
                                            System.out.println("Enter username to add:");
                                            username3 = sc.next();
                                            sql.AddUser(username3);
                                        case 6:
                                            String username4;
                                            System.out.println("Enter username to block:");
                                            username4 = sc.next();
                                            sql.AnyPassword(username4);
                                    }
                                } while(chose1 != 7);
                                break;
                            } else {
                                int chose2;
                                do {
                                    menu.Show_user_menu();
                                    chose2 = sc.nextInt();
                                    switch (chose2) {
                                        case 1:
                                            System.out.println("Enter your current password:");
                                            passs = sc.next();
                                            if(sql.SignIn(loginn, passs)) {
                                                String newpass;
                                                System.out.println("Enter new password");
                                                newpass = sc.next();
                                                sql.ChangePassword(loginn, newpass);
                                            }
                                            break;
                                    }
                                } while(chose2 != 2);
                                break;
                            }
                        } else
                            k++;
                    }while (k != 3);
                    chose = 4;
                    break;
                case 2:
                    String login, pass, pass1;
                    System.out.println("Enter your login:");
                    login = sc.next();
                    System.out.println("Enter your pass:");
                    pass = sc.next();
                    System.out.println("Enter your pass once more:");
                    pass1 = sc.next();
                    if(pass.equals(pass1)) {
                        sql.SignUp(login, pass);
                        System.out.println("You hava been registered");
                        break;
                    }
                    else
                        System.out.println("password did not confirmed");
                        break;
                case 3:
                    menu.Show_additional_info();
                    break;
            }
        } while(chose != 4);
    }
}
