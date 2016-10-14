package com.sprintName;

import com.sprintName.model.Adjective;
import com.sprintName.model.Noun;
import org.junit.Test;

import static com.sprintName.Example.ADJECTIVES_LIST;
import static com.sprintName.Example.NOUNS_LIST;
import static org.junit.Assert.assertEquals;

/**
 * Created by klarki on 13.10.16.
 */
public class ExampleTest {
    @Test
    public void homeTest(){
        assertEquals("Hello Word", new Example().home());
    }
    @Test
    public void restPostAdjTest(){
        new Example().restPostAdj("silly");
        new Example().showAdjectives();
        int expectedResult = 5;
        assertEquals(expectedResult, ADJECTIVES_LIST.size() );
    }

    @Test
    public void restPostNounTest(){
        new Example().restPostNoun("cow");
        new Example().showNouns();
        int expectedResult = 5;
        assertEquals(expectedResult, NOUNS_LIST.size());
    }

    @Test
    public void showAdjectivesTest(){
        int expectedLength = 4;
        String expectedResultItem3 = "nice";

        assertEquals(expectedResultItem3, new Example().showAdjectives().get(3).getAdjective());
        assertEquals(expectedLength, new Example().showAdjectives().size());
    }

    @Test
    public void codeNameTest(){
        NOUNS_LIST.removeAll(new Example().showNouns());
        ADJECTIVES_LIST.removeAll(new Example().showAdjectives());
        ADJECTIVES_LIST.add(new Adjective(1, "kupa"));
        NOUNS_LIST.add(new Noun(1, "kupare"));
        assertEquals("kupa kupare", new Example().codeName());
    }
}
