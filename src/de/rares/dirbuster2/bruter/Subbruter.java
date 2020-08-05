package de.rares.dirbuster2.bruter;

import de.rares.dirbuster2.Main;
import de.rares.dirbuster2.dir.Dir;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class Subbruter extends Thread {

    ArrayList<Dir> dirs  = new ArrayList<>();
    @Override
    public void run() {

        String bust;
        while (Main.main.list.hasNextLine()) {
            synchronized (Main.main.list) {
                bust = Main.main.list.nextLine();
            }
            URL url = null;
            try {
                url = new URL(Main.url + "/" + bust);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                if(conn.getResponseCode() == 200 ||conn.getResponseCode() == 201 || conn.getResponseCode() == 202){
                    dirs.add(new Dir(bust));
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

}
