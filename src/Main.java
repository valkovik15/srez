import org.xml.sax.SAXException;

import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Cinema> data=new ArrayList<>();
        try {
            data=MyUtils.readFromFile();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
            System.out.println("Parse went wrong");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("File system error");
        } catch (SAXException e) {
            e.printStackTrace();
            System.out.println("SAX is evil");
        }
        System.out.println(data);
        MyUtils.sortedByNamePrint(data);
        MyUtils.maxCinema(data);
        MyUtils.filmsMerge(data);
        MyUtils.seatSearch(data, 365);
        MyUtils.seatSearch(data, 366);
    }

}