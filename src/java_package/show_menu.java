package java_package;

/**
 * Created by Dima on 15.04.2016.
 */
public class show_menu {

    void Show_start_menu() {
        System.out.println("Enter '1' to sign in\nEnter '2' to sign up\n" +
                "Enter '3' to see additional information\nEnter '4' to exit");
    }

    void Show_additional_info () {
        System.out.println("author: Dmitriy Snegovoy\n" +
                "Variant 15: Відсутність символів, що повторюються.");
    }

    void Show_admin_menu () {
        System.out.println("Enter '1' to show all users\n" +
                "Enter '2' to change your password\n" +
                "Enter '3' to block the user\n" +
                "Enter '4' to edit password limit\n" +
                "Enter '5' to add the user\n" +
                "Enter '6' to undo password limit\n" +
                "Enter '7' to exit");
    }

    void Show_user_menu () {
        System.out.println("Enter '1' to change your password\n" +
                "Enter '2' to exit");
    }

}
