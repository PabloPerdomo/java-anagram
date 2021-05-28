package x.pablop315;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@RunWith(JUnit4.class)
public class AnagramValidatorTest {

    @Test
    public void testExamplesWorksOk() {
        assertThat(AnagramValidator.areAnagrams("Listen", "Silent"), is(true));
        assertThat(AnagramValidator.areAnagrams("Elvis", "Lives"), is(true));
        assertThat(AnagramValidator.areAnagrams("Conservación", "Conservación"), is(true));
    }

    @Test
    public void testNullAndEmptyWorksOk() {
        assertThat(AnagramValidator.areAnagrams(null, null), is(true));
        assertThat(AnagramValidator.areAnagrams("", ""), is(true));
        assertThat(AnagramValidator.areAnagrams(null, "QWERTY"), is(false));
        assertThat(AnagramValidator.areAnagrams("QWERTY", null), is(false));
        assertThat(AnagramValidator.areAnagrams("QWERTY", "QWERTYY"), is(false));
    }

    @Test
    public void testNonAnagramsWorksOk() {
        assertThat(AnagramValidator.areAnagrams("Listen", "Listed"), is(false));
        assertThat(AnagramValidator.areAnagrams("Elvis", "Elbis"), is(false));
        assertThat(AnagramValidator.areAnagrams("Conservación", "Conserbación"), is(false));
    }

    @Test
    public void testOthersExamplesWorksOk() {
        assertThat(AnagramValidator.areAnagrams("Não", "OÃN"), is(true));
        assertThat(AnagramValidator.areAnagrams("Segurança", "aseguranç"), is(true));
        assertThat(AnagramValidator.areAnagrams("ConservaciÓn", "Conservación"), is(true));
    }

}
