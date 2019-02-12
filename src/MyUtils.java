import org.xml.sax.SAXException;

import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;


public class MyUtils {
    public static List<Cinema> readFromFile() throws ParserConfigurationException, SAXException, IOException {
        //JFileChooser fileChooser = new JFileChooser();
        //if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {

            File file = new File("src/test.xml");
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            Parser saxp = new Parser();
            parser.parse(file, saxp);
            List<Cinema> l = saxp.getTemp();

            return l;
        //} else
          //  return null;
    }
    public static void sortedByNamePrint(List<Cinema> data)
    {
        List<Cinema> copy=new ArrayList<>(data);
        Collections.sort(copy);
        System.out.println("SORT");
        System.out.println(copy);
    }
    public static void filmsMerge(List<Cinema> data)
    {
        Set<String> temp=new HashSet<>();
        /*for(Cinema i:data)
        {
            temp.addAll(i.getFilms());
        }
        System.out.println(temp);
        temp.clear();*/
        data.stream().map(Cinema::getFilms).forEach(temp::addAll);
        System.out.println("MERGE");
        System.out.println(temp);
    }
    public static void maxCinema(List<Cinema> data)
    {

        Map<Integer, List<Cinema>> m= data.stream().collect(Collectors.groupingBy(Cinema::getSeats));
        System.out.println("MAX");
        System.out.println(m.get(Collections.max(m.keySet())));
    }
    public static void seatSearch(List<Cinema> data, Integer goal)
    {
        /*Map<Integer, List<Cinema>> m= data.stream().collect(Collectors.groupingBy(Cinema::getSeats));
        System.out.println(m.get(goal));*/
        List<Cinema> copy=new ArrayList<>(data);
        Collections.sort(copy, new MyComparator());
        System.out.println("BIN");
        int i=Collections.binarySearch(copy, new Cinema("a", goal, null), new MyComparator());
        if(i>=0)
        {
            System.out.println(copy.get(i));
        }
        else
        {
            System.out.println("None");
        }

    }
}
