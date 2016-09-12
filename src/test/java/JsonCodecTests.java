import com.clouway.taskone.JsonCodec;
import com.clouway.taskone.MessageCodec;
import com.clouway.taskone.Person;
import com.google.gson.reflect.TypeToken;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Type;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Petar Nedelchev <peter.krasimirov@gmail.com>
 */
public class JsonCodecTests {
    private MessageCodec codec;

    @Before
    public void setUp() throws Exception {
        codec = new JsonCodec();
    }

    @Test
    public void toJson() throws Exception {
        String name = "John";
        String lastName = "Smith";
        int age = 10;

        String expected = "{\"firstName\":\"" + name + "\",\"lastName\":\"" + lastName + "\",\"age\":" + age + "}";
        String actual = codec.marchall(new Person(name, lastName, age));

        assertThat(actual, is(expected));
    }

    @Test
    public void fromJson() throws Exception {
        String name = "Paul";
        String lastName = "Adams";
        int age = 14;
        Person expected = new Person(name, lastName, age);

        String json = "{\"firstName\":\"" + name + "\",\"lastName\":\"" + lastName + "\",\"age\":" + age + "}";
        Person actual = codec.unmarchall(json, Person.class );

        assertThat(actual , is(expected));
    }

    @Test
    public void bigData() throws Exception {
        StringBuilder jsonPeople = new StringBuilder();
        int peopleCount = 100000;

        jsonPeople.append("[");
        for (int i = 0; i < peopleCount; i++) {
            jsonPeople.append("{\"firstName\":\"Paul\",\"lastName\":\"Davey\",\"age\":16}");
            if (i < peopleCount -1){
                jsonPeople.append(",");
            }
        }
        jsonPeople.append("]");
        Type collectionType = new TypeToken<List<Person>>(){}.getType();
        List<Person> people = codec.unmarchall(jsonPeople.toString(), collectionType);

        assertThat(people.size(), is(peopleCount));
    }
}
