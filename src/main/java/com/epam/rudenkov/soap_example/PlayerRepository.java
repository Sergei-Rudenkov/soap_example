package com.epam.rudenkov.soap_example;

/**
 * Created by sergei_rudenkov on 12.1.16.
 */

import javax.annotation.PostConstruct;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import io.spring.guides.gs_producing_web_service.Player;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class PlayerRepository {
    private static final List<Player> players = new ArrayList<Player>();
    private static GregorianCalendar c = new GregorianCalendar();
    private static XMLGregorianCalendar gregDate;

    public PlayerRepository() {
        c.setTime(new Date());
        try {
            gregDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        }
    }

    @PostConstruct
    public void initData() {

        players.add(new Player(){
            {
                setId(1);
                setName("Vasia");
                setPatronimic("Vasilevich");
                setSuname("Tutkovich");
                setBirthdate(gregDate);
                setJoiningdate(gregDate);
            }
        });

        players.add(new Player(){
            {
                setId(2);
                setName("Fedia");
                setPatronimic("Adamovich");
                setSuname("Pupkovich");
                setBirthdate(gregDate);
                setJoiningdate(gregDate);
            }
        });

        players.add(new Player(){
            {
                setId(3);
                setName("Semen");
                setPatronimic("Abramovich");
                setSuname("Kuchkovich");
                setBirthdate(gregDate);
                setJoiningdate(gregDate);
            }
        });


    }

    public Player findCountry(String name) {
        Assert.notNull(name);

        Player result = null;

        for (Player player : players) {
            if (name.equals(player.getSuname())) {
                result = player;
            }
        }

        return result;
    }
}
