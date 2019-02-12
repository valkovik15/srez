
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Parser extends DefaultHandler{
    private Integer seats;
    private String name;
    private String film;
    boolean bCinema = false;
    boolean bName = false;
    boolean bFilm =false;
    List<Cinema> temp;
    Set<String> films;
    public Parser() {
        this.temp = new ArrayList<>();
        this.films=new HashSet<>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        if (qName.equalsIgnoreCase("cinema"))
            seats=Integer.parseInt(attributes.getValue("seats"));
        else if (qName.equalsIgnoreCase("name"))
            bName =true;
        else if (qName.equalsIgnoreCase("films"))
        {
            films=new HashSet<>();
        }
        else if (qName.equalsIgnoreCase("film"))
            bFilm =true;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException{
        super.characters(ch, start, length);

        if(bName) {
            name =new String(ch, start, length);
            bName =false;
        }
        if(bFilm) {
            film = new String(ch, start, length);
            films.add(film);
            bFilm =false;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        if (qName.equalsIgnoreCase("cinema")) {
            Cinema c=new Cinema(name, seats, films);
            temp.add(c);
        }
    }

    public List getTemp() {
        return temp;
    }
}
