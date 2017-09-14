/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dc23bfilezipper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import javafx.application.Platform;

/**
 *
 * @author devincargill
 */
public class zipModel extends Thread {
    private File sourceDirectory;
    private File destinationDirectory;
    private File[] files;   
    public Boolean stop = false;
    private Notification notification;
    static final int BUFFER = 2048;
    
    public zipModel(File sourceDirectory, File destinationDirectory) {
        this.sourceDirectory = sourceDirectory;
        this.destinationDirectory = destinationDirectory;
        files = sourceDirectory.listFiles(new FilenameFilter(){
           @Override
           public boolean accept(File directory, String filename){
               return true;
           }
        });
    }
    
    public int getNumFiles() {
        if (files == null) {
            return 0;
        }
        return files.length;
    }
    
    public File[] getFiles() {
        return this.files;
    }
    
    @Override
    public void run() {
        try {
            File sourceDir = new File(this.sourceDirectory.getPath());
            
            List<File> filesToZip = new ArrayList<File>();
            System.out.println("Preparing: " + sourceDir.getCanonicalPath());
            getAllFiles(sourceDir, filesToZip);
            System.out.println("Creating destination directory zip");
            writeZipFile(sourceDir, filesToZip);
            System.out.println("Finshed Compressing Files");
        } catch (IOException ex) {
            Logger.getLogger(zipModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //This method allows a notification handler to be registered to receive
    // notifications
    public void setOnNotification(Notification notification){
        this.notification = notification;
    }
    
    private void doNotify(double percentComplete, zipState state, String message) {
        //this function provides the notification through the registered handler
        if(notification != null){
            Platform.runLater(() -> {
               notification.handle(percentComplete, state, message);
            });
        }
    }
    
    private double calculatePercent(int count, int total) {
        if (total == 0) return 0;
        return (double)count / (double)total;
    }

    private void getAllFiles(File dest, List<File> fileList) {
        try {
            File[] files = dest.listFiles();
            for (File singleFile : files) {
                    fileList.add(singleFile);
                    if (singleFile.isDirectory()) {
                            System.out.println("directory:" + singleFile.getCanonicalPath());
                            getAllFiles(singleFile, fileList);
                    } else {
                            System.out.println("     file:" + singleFile.getCanonicalPath());
                    }
            }
        } catch (IOException e) {
                e.printStackTrace();
        }
    }

    private void writeZipFile(File directoryToZip, List<File> fileList) {
        try {
            FileOutputStream fos = new FileOutputStream(this.destinationDirectory.getPath() + "/" + directoryToZip.getName() + ".zip");
            ZipOutputStream zos = new ZipOutputStream(fos);
            int numComplete = 0;
            
            for (File file : fileList) {
                    if (!file.isDirectory()) { // we only zip files, not directories
                            addToZip(directoryToZip, file, zos);
                            numComplete++;
                            int total = (int)(fileList.size() * .85);
                            doNotify(calculatePercent(numComplete, total), zipState.RUNNING, "Extracting " + file.getPath() + " to " + this.destinationDirectory.getPath() + "/" + directoryToZip.getName() + ".zip");
                    }
            }
                
                doNotify(1, zipState.ENDED, "File Compression Complete");
                zos.close();
                fos.close();
        } catch (FileNotFoundException e) {
                e.printStackTrace();
        } catch (IOException e) {
                e.printStackTrace();
        }
    }

    private void addToZip(File directoryToZip, File file, ZipOutputStream zipOut) throws IOException {
        FileInputStream input = new FileInputStream(file);
        
        String zipFilePath = file.getCanonicalPath().substring(directoryToZip.getCanonicalPath().length() + 1,
                        file.getCanonicalPath().length());
        System.out.println("Writing '" + zipFilePath + "' to zip file");
        ZipEntry zipEntry = new ZipEntry(zipFilePath);
        zipOut.putNextEntry(zipEntry);

        byte[] bytes = new byte[1024];
        int length;
        while ((length = input.read(bytes)) >= 0) {
                zipOut.write(bytes, 0, length);
        }

        zipOut.closeEntry();
        input.close();
    }
}
