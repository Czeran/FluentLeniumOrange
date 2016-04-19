package com.betacom.page;


import org.fluentlenium.core.FluentPage;
import org.openqa.selenium.By;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.fluentlenium.core.filter.FilterConstructor.withText;


public class AbstractPage extends FluentPage {

    public void clickOn(String element) {
        click("a", withText(element));
    }

    public void serchAndClick(By element, String text) {
        fill(find(element)).with(text);
        await().atMost(10, TimeUnit.SECONDS).until(".sbPickerCell0").isPresent();
        find(By.className("sbPickerCell0")).click();
    }

    public void writeToFile(String fileName, String value) throws IOException {
        File file = new File("src/main/resources/files/" + fileName);
        try {
            if (!file.exists()) {
                System.out.println("Plik " + fileName + " nie istnieje, tworze nowy");
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.newLine();
            bw.append(value);
            bw.close();
        } catch (IOException e) {
            System.out.println("Problem z utworzeniem pliku " + fileName);
            e.printStackTrace();
        }
    }

    public String getTrainingRequestId(String fileName) throws IOException {
        String id = "";
        File file = new File("src/main/resources/files/" + fileName);
        try {
            FileInputStream fis = new FileInputStream(file);
            int b = fis.read();
            if (b == -1){
                System.out.println("Nie ma żadnych wniosków do akceptacji. Program ");
                getDriver().quit();
            }
            else {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String sCurrentLine = "";
                while((sCurrentLine = br.readLine()) != null)
                {
                    id = sCurrentLine;
                }
            }
        } catch (IOException e) {
            System.out.println("Problem");
            e.printStackTrace();
        }
        return id;
        }

    public void removeLastLine(String fileName) throws IOException {
        File file = new File("src/main/resources/files/" + fileName);
        List<String> result = new ArrayList<String>();
        try{
            FileInputStream fis = new FileInputStream(file);
            int b = fis.read();
            BufferedReader br = new BufferedReader(new FileReader(file));
            String sCurrentLine = br.readLine();
            do{
                result.add(sCurrentLine);
            } while((sCurrentLine = br.readLine()) != null);
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            for(int i=0; i<result.size() - 1; i++)
            {
                bw.write(result.get(i)+"\n");
            }
            bw.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}