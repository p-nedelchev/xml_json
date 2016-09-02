import com.clouway.taskone.MessageCodec;
import com.clouway.taskone.Person;
import com.clouway.taskone.XmlCodec;
import com.google.gson.reflect.TypeToken;
import org.junit.Before;
import org.junit.Test;


import java.lang.reflect.Type;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author Petar Nedelchev <peter.krasimirov@gmail.com>
 */
public class XmlCodecTest {
    private MessageCodec codec;

    @Before
    public void setUp() throws Exception {
        codec = new XmlCodec();
    }

    @Test
    public void toXml() throws Exception {
        String name = "Sam";
        String lastName = "Smith";
        int age = 20;

        String expected = "<?xml version=\"1.0\" ?><person><firstName>" + name + "</firstName><lastName>" + lastName + "</lastName><age>" + age + "</age></person>";
        String actual = codec.marchall(new Person(name, lastName, age));

        assertThat(actual, is(expected));
    }

    @Test
    public void fromXml() throws Exception {
        String name = "Anne";
        String lastName = "Well";
        int age = 20;

        Person expected = new Person(name, lastName, age);
        String xml = "<?xml version=\"1.0\" ?><person><firstName>" + name + "</firstName><lastName>" + lastName + "</lastName><age>" + age + "</age></person>";
        Person actual = codec.unmarchall(xml, Person.class);

        assertThat(actual, is(expected));
    }

    @Test
    public void bigData() throws Exception {
        StringBuilder xmlPeople = new StringBuilder();
        int peopleCount = 100000;

        xmlPeople.append("<?xml version=\"1.0\" ?><list>");
        for (int i = 0; i < peopleCount; i++) {
             xmlPeople.append("<com.clouway.taskone.Person><firstName>John</firstName><lastName>Jones</lastName><age>25</age></com.clouway.taskone.Person>");
        }
        xmlPeople.append("</list>");
        Type listType = new TypeToken<List<Person>>() {}.getType();
        List<Person> persons = codec.unmarchall(xmlPeople.toString(), listType);

        assertThat(persons.size(), is(peopleCount));
    }
}
