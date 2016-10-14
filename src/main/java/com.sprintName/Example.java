package com.sprintName;


import com.sprintName.model.Adjective;
import com.sprintName.model.CodeName;
import com.sprintName.model.Noun;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@EnableSwagger2
@RestController
@EnableAutoConfiguration
public class Example {

    private static final List<String> CODE_NAMES = new ArrayList<String>();
    public static final List<Adjective> ADJECTIVES_LIST = new ArrayList<Adjective>();
    public static final List<Noun> NOUNS_LIST = new ArrayList<Noun>();
    private static AtomicLong nextId = new AtomicLong();

    private static long idCounter() {
        return nextId.getAndIncrement();
    }

    static {
        ADJECTIVES_LIST.add(new Adjective(Example.idCounter(), "stupid"));
        ADJECTIVES_LIST.add(new Adjective(Example.idCounter(), "smart"));
        ADJECTIVES_LIST.add(new Adjective(Example.idCounter(), "ugly"));
        ADJECTIVES_LIST.add(new Adjective(Example.idCounter(), "nice"));
    }

    static {
        NOUNS_LIST.add(new Noun(Example.idCounter(), "girl"));
        NOUNS_LIST.add(new Noun(Example.idCounter(), "car"));
        NOUNS_LIST.add(new Noun(Example.idCounter(), "horse"));
        NOUNS_LIST.add(new Noun(Example.idCounter(), "bottle"));
    }


    static private int mathRandom(int max) {
        return (int) (Math.random() * (max));
    }

    private void addToAdjectives(String adjective) {
        if (!ADJECTIVES_LIST.contains(new Adjective(0, adjective))) {
            ADJECTIVES_LIST.add(new Adjective(idCounter(), adjective));
        }
    }

    private void addToNouns(String noun) {
        if (!NOUNS_LIST.contains(new Noun(0, noun))) {
            NOUNS_LIST.add(new Noun(idCounter(), noun));
        }
    }

    private String finalInfo(){
        return "Sorry, no more names available";
    }

    private void addToNames(String codeName) throws Exception {
        if (!CODE_NAMES.contains(codeName)) {
            CODE_NAMES.add(codeName);
        }else {
            if(CODE_NAMES.size()== NOUNS_LIST.size()*ADJECTIVES_LIST.size()) {
                throw new Exception(finalInfo());
            }
            else {
                codeName();
            }
        }
    }

    @RequestMapping(value="/showAdjectives", method={RequestMethod.GET})
    public List<Adjective> showAdjectives(){
        return ADJECTIVES_LIST;
    }

    @RequestMapping(value="/showNouns", method={RequestMethod.GET})
    public List<Noun> showNouns(){
        return NOUNS_LIST;
    }

    @RequestMapping(value="/showNames", method={RequestMethod.GET})
    public List showNames(){
        return CODE_NAMES;
    }

    /**
     *
     * @param newAdjective
     */
    @RequestMapping(value = "/addAdjective", method = {RequestMethod.POST})
    public void restPostAdj(@RequestParam("newAdjective") String newAdjective) {
        addToAdjectives(newAdjective);
    }

    @RequestMapping(value = "/addNoun", method = {RequestMethod.POST})
    public void restPostNoun(@RequestParam("newNoun") String newNoun) {
        addToNouns(newNoun);
    }

    @RequestMapping(value = "/", method={RequestMethod.GET})
    public String home() {
        return "Hello Word";
    }

    @RequestMapping(value="/codeName", method={RequestMethod.GET})
    public String codeName() {
        int adj = mathRandom(ADJECTIVES_LIST.size());
        int noun = mathRandom(NOUNS_LIST.size());
        int name = CODE_NAMES.size();

        CodeName readyName = new CodeName(ADJECTIVES_LIST.get(adj), NOUNS_LIST.get(noun));

        try {
            addToNames(readyName.toString());
        } catch(Exception e){
            return e.getMessage();
        }

        return CODE_NAMES.get(name);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Example.class, args);
    }

}