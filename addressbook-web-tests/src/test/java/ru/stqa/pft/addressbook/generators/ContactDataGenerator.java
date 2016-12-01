package ru.stqa.pft.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.*;
import com.thoughtworks.xstream.XStream;
import ru.stqa.pft.addressbook.model.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class ContactDataGenerator {

    @Parameter(names = "-c", description = "Contact count")
    public int count;

    @Parameter(names = "-f", description = "Target file")
    public String file;

    @Parameter(names = "-d", description = "Data format")
    public String format;

    public static void main(String[] args) throws IOException {
        ContactDataGenerator generator = new ContactDataGenerator();
        JCommander jCommander = new JCommander(generator, args);
        try {
            jCommander.parse();
        } catch (ParameterException ex) {
            jCommander.usage();
            return;
        }
        generator.run();
    }

    private void run() throws IOException {
        List<ContactData> contacts = generateContacts(count);
        if (format.equals("xml")) {
            saveAsXML(contacts, new File(file));
        } else if (format.equals("json")) {
            saveAsJSON(contacts, new File(file));
        } else {
            System.out.println("Unrecognized format " + format);
        }
    }

    public void saveAsJSON(List<ContactData> contacts, File file) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
        String json = gson.toJson(contacts);
        // FIX: информация о файле не парсится автоматически
        String regex = "\"photo\": \\{\\}";
        String pattern = "\"photo\": \\{\"src/test/resources/photo.gif\"\\}";
        json = json.replaceAll(regex, pattern);
        //
        Writer writer = new FileWriter(file);
        writer.write(json);
        writer.close();
    }

    private void saveAsXML(List<ContactData> contacts, File file) throws IOException {
        XStream xstream = new XStream();
        xstream.processAnnotations(ContactData.class);
        String xml = xstream.toXML(contacts);
        Writer writer = new FileWriter(file);
        writer.write(xml);
        writer.close();
    }

    private List<ContactData> generateContacts(int count) {
        List<ContactData> contacts = new ArrayList<ContactData>();
        File photo = new File("src/test/resources/photo.gif");
        for (int i = 0; i < count; i++) {
            contacts.add(new ContactData()
                .withContactNameData(new ContactNameData()
                    .withFirstName("first_name "+i).withMiddleName("middle_name "+i)
                    .withLastName("last_name "+i).withNickName("nick_name "+i))
                .withContactPhoneData(new ContactPhoneData()
                    .withHome("home "+i).withMobile("mobile "+i).withWork("work "+i).withFax("fax "+i).withHome2("home2 "+i))
                .withContactEmailData(new ContactEmailData()
                    .withEmail1("email "+i).withEmail2("email2 "+i).withEmail3("email3 "+i))
                .withContactOtherData(new ContactOtherData()
                    .withTitle("title "+i).withCompany("company "+i).withAddress("address "+i)
                    .withAddress2("address2 "+i).withHomepage("homepage "+i).withNotes("notes "+i))
                .withPhoto(photo));
        }
        return contacts;
    }
}

