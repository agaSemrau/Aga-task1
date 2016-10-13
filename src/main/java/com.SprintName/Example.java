package com.SprintName;

import com.SprintName.model.Adjective;
import com.SprintName.model.CodeName;
import com.SprintName.model.Noun;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@EnableAutoConfiguration
public class Example {

    private static final List<Adjective> ADJECTIVES_LIST = new ArrayList<Adjective>();

    private static long idCounter() {
        return nextId.getAndIncrement();
    }

    private static AtomicLong nextId = new AtomicLong();

    static {
        ADJECTIVES_LIST.add(new Adjective(Example.idCounter(), "stupid"));
        ADJECTIVES_LIST.add(new Adjective(Example.idCounter(), "smart"));
        ADJECTIVES_LIST.add(new Adjective(Example.idCounter(), "ugly"));
        ADJECTIVES_LIST.add(new Adjective(Example.idCounter(), "nice"));
    }

    private static final List<Noun> NOUNS_LIST = new ArrayList<Noun>();

    static {
        NOUNS_LIST.add(new Noun(Example.idCounter(), "girl"));
        NOUNS_LIST.add(new Noun(Example.idCounter(), "car"));
        NOUNS_LIST.add(new Noun(Example.idCounter(), "horse"));
        NOUNS_LIST.add(new Noun(Example.idCounter(), "bottle"));
    }




    private String capitalize(final String line) {
        return Character.toUpperCase(line.charAt(0)) + line.substring(1);
    }

    private void addToAdjectives(String adjective) {
        ADJECTIVES_LIST.add(new Adjective(idCounter(), adjective));
   }

    private void addToNouns(String noun) {
        NOUNS_LIST.add(new Noun(idCounter(), noun));
    }

    @RequestMapping( value="/addAdective", method = {RequestMethod.POST})
    public void restPostAdj(@RequestParam("newAdjective") String newAdjective) {
        addToAdjectives(newAdjective);
    }

    @RequestMapping( value="/addNoun", method = {RequestMethod.POST})
    public void restPostNoun(@RequestParam("newNoun") String newNoun) {
        addToNouns(newNoun);
    }

    @RequestMapping("/")
    String home() {
        return "Hello Word";
    }

    @RequestMapping("/codeName")
    String codeName() {

        int adj = mathRandom(ADJECTIVES_LIST.size());
        int noun = mathRandom(NOUNS_LIST.size());
        CodeName thing = new CodeName(ADJECTIVES_LIST.get(adj), NOUNS_LIST.get(noun));
        return thing.toString();
    }

    static int mathRandom(int max) {
        return (int) (Math.random() * (max));
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Example.class, args);
//       System.out.println(codeName());
    }

//    void note() {
//        for (int i = 0; i < maxAdjectives; i++) {
//            System.out.println(ADJECTIVES[i]);
//        }
//        List<String> list = Arrays.asList(ADJECTIVES);
//        list.forEach(a -> System.out.println(a));
//        for (String s : list) {
//        }
//    }
}