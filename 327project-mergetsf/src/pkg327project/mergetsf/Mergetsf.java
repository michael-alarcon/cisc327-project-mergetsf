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
     */
    public static void main(String[] args) throws IOException {

        String line;

        FileWriter fw = new FileWriter(mergedTransactionFile);
        BufferedWriter bufferedWriter = new BufferedWriter(fw);

        File dir = new File(args[0]);
        File[] directoryListing = dir.listFiles();

        if (directoryListing != null) {
            for (File transactionFile : directoryListing) {
                FileReader fileReader = new FileReader(transactionFile);
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                while ((line = bufferedReader.readLine()) != null) {
                    bufferedWriter.write(line);
                }
            }
        } else {
            // Error
        }

    }

}
