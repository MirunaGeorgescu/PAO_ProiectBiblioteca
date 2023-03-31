package ro.pao.application;

import ro.pao.service.LibrarianService;
import ro.pao.service.MemberService;
import ro.pao.service.impl.LibrarianServiceImpl;
import ro.pao.service.impl.MemberServiceImpl;

import java.util.Scanner;

public class Menu {
    private static Menu INSTANCE;
    private final MemberService memberService = new MemberServiceImpl();
    private final LibrarianService librarianService = new LibrarianServiceImpl();

    public static Menu getInstance(){
        return (INSTANCE == null ? new Menu() : INSTANCE);
    }

    // the intro method: displays the menu
    public void intro(){
        String intro = "--------------------------- Welcome to the library! ---------------------------\n" +
                "Please choose an option:\n" +
                "1. Log in as a member\n" +
                "2. Log in as a librarian\n" +
                "3. Make a new member account\n" +
                "4. Make a new librarian account\n" +
                "5. Exit";
        System.out.println(intro);
    }

    // the memberLogin method: checks if the username and password are correct
    public Boolean memberLogin(){
        String loginText = "----------------------------- Welcome back! -----------------------------\n" +
                "Please enter your username and password:\n" +
                "Username: ";
        System.out.println(loginText);

        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();

        loginText = "Password: ";
        System.out.println(loginText);
        String password = scanner.nextLine();

        if (memberService.isMember(username, password)){
            System.out.println("Login successful!");
            return true;
        } else {
            System.out.println("Login failed!");
            return false;
        }
    }

    // the librarianLogin method: checks if the username and password are correct
    public Boolean librarianLogin(){
        String loginText = "----------------------------- Welcome back! -----------------------------\n" +
                "Please enter your username and password:\n" +
                "Username: ";
        System.out.println(loginText);

        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();

        loginText = "Password: ";
        System.out.println(loginText);
        String password = scanner.nextLine();

        if (librarianService.isLibrarian(username, password)){
            System.out.println("Login successful!");
            return true;
        } else {
            System.out.println("Login failed!");
            return false;
        }
    }

    // the newMember method: creates a new member account
    public void newMember(){
        String newMemberText = "----------------------------- Welcome! Create your account -----------------------------\n" +
                "Please enter your username and password:\n" +
                "Username: ";
        System.out.println(newMemberText);

        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();

        newMemberText = "Password: ";
        System.out.println(newMemberText);
        String password = scanner.nextLine();

        newMemberText = "Please enter your name: ";
        System.out.println(newMemberText);
        String name = scanner.nextLine();

        newMemberText = "Please enter your address: ";
        System.out.println(newMemberText);
        String address = scanner.nextLine();

        newMemberText = "Please enter your email: ";
        System.out.println(newMemberText);
        String email = scanner.nextLine();

        newMemberText = "Please enter your phone number: ";
        System.out.println(newMemberText);
        String phoneNumber = scanner.nextLine();

        memberService.createMember(username, password, name, address, email, phoneNumber);
    }
}
