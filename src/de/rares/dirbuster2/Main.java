package de.rares.dirbuster2;

import de.rares.dirbuster2.bruter.Bruter;
import de.rares.dirbuster2.dir.Dir;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static String url;
    public Scanner list;
    public static Main main;
    public static ArrayList<Dir> dirs = new ArrayList<>();
    public static ArrayList<Bruter> bruters = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Please enter the URL:");
        Scanner sc = new Scanner(System.in);
        url = sc.nextLine();
        System.out.println("Where is the List saved?");
        String glist = sc.nextLine();
        System.out.println("How many Threads would you need?");
        int threads = sc.nextInt();

        File f = new File(glist);
        if (f.exists() && f.getName().endsWith(".txt")) {
            main = new Main();
            main.list = new Scanner(f);
            for (int i = 0; i < threads; i++) {
                Bruter bruter = new Bruter();
                bruter.run();
               bruters.add(bruter);
                System.out.println("Thread #" + i + 1 + " started");
            }
            for (Bruter b  : bruters){
                try {
                    b.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //first layer forced

            for (Dir dir : dirs){
                
            }


        } else {
            System.out.println("Your given File is not valid. Please Check, that the suffix of the File is \'.txt\'");
        }
    }

}
