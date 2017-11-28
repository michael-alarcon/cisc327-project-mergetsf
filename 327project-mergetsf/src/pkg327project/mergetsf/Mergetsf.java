/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg327project.mergetsf;

import java.io.*;

/**
 *
 * @author Michael Alarcon
 */
public class Mergetsf {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {

        String line;
        try {
            FileWriter fw = new FileWriter(args[1]);
            BufferedWriter bufferedWriter = new BufferedWriter(fw);

            File dir = new File(args[0]);
            File[] directoryListing = dir.listFiles();

            for (File transactionFile : directoryListing) {
                FileReader fileReader = new FileReader(transactionFile);
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                while ((line = bufferedReader.readLine()) != null) {
                    if (line.equals("EOS")) {
                        break;
                    } else {
                        bufferedWriter.write(line);
                        bufferedWriter.newLine();
                    }
                }
                bufferedReader.close();
            }
            bufferedWriter.write("EOS");
            bufferedWriter.flush();
            bufferedWriter.close();
            
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
