package com.copyright.rup.works.broker;

import com.copyright.rup.works.broker.api.IMarshaler;
import com.copyright.rup.works.broker.marshaler.GsonMarshaler;
import com.copyright.rup.works.broker.marshaler.JacksonMarshaler;
import com.copyright.rup.works.broker.marshaler.JaxbMarshaler;
import com.copyright.rup.works.broker.marshaler.WorkWrapper;
import com.copyright.rup.works.broker.marshaler.XStreamMarshaler;
import com.copyright.rup.works.domain.api.IAffiliation;
import com.copyright.rup.works.domain.api.IAuthor;
import com.copyright.rup.works.domain.api.IContributor;
import com.copyright.rup.works.domain.api.IEditor;
import com.copyright.rup.works.domain.api.IPublisher;
import com.copyright.rup.works.domain.api.ITitle;
import com.copyright.rup.works.domain.api.IWork;
import com.copyright.rup.works.domain.api.IWorkCollection;
import com.copyright.rup.works.domain.api.IWorkLanguage;
import com.copyright.rup.works.domain.impl.Affiliation;
import com.copyright.rup.works.domain.impl.Author;
import com.copyright.rup.works.domain.impl.Contributor;
import com.copyright.rup.works.domain.impl.Editor;
import com.copyright.rup.works.domain.impl.Publisher;
import com.copyright.rup.works.domain.impl.Subject;
import com.copyright.rup.works.domain.impl.Title;
import com.copyright.rup.works.domain.impl.Work;
import com.copyright.rup.works.domain.impl.WorkCollection;
import com.copyright.rup.works.domain.impl.WorkLanguage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


public class Runner {

<<<<<<< HEAD:src/main/java/com/copyright/rup/works/brocker/Runner.java
    /**
     * Logger.
     */
=======
>>>>>>> 2f054807a815ed8a61117676e1ffbd0930864d91:broker-prototype/src/main/java/com/copyright/rup/works/broker/Runner.java
    private static final Logger LOGGER = LoggerFactory.getLogger(Runner.class);

    public static IWork generateWork() {
        IWork work = new Work();

        work.setAudience(Arrays.asList("TestFirstAudience", "TestSecondAudience",
                "TestThirdAudience"));
        work.setAuthors(generateAuthorList());
        work.setCollection(generateWorkCollection());

        work.setContributors(generateContributers());

        work.setEditors(generateEditorList());
        work.setId("TestID");

        IWorkLanguage workLanguage = new WorkLanguage();
        workLanguage.setLanguage("TestLanguage");
        workLanguage.setLanguageRole("TestLanguageType");
        work.setLanguage(workLanguage);

        work.setPublicationCountry("TestPublicationCountry");
        work.setPublicationType("TestPublicationType");

        IPublisher publisher = new Publisher();
        publisher.setName("TestPublishetName");
        publisher.setPublicationPlace("TestPublishetPlace");
        publisher.setRole("TestPublishetRole");
        publisher.setSortOrder(1);
        publisher.setStatus("TestPublishetStatus");
        work.setPublisher(publisher);

        Subject subject = new Subject();
        subject.setSubject("TestSubject");
        subject.setSubjectType("TestSubjectType");
        work.setSubject(subject);

        work.setTitles(generateTitleList());

        return work;
    }

    public static void main(String[] args) throws Exception {

        IWork work = generateWork();
        List<IWork> works = new ArrayList<>();
        works.add(work);

        printResult(new GsonMarshaler(), work, works);
        printResult(new JacksonMarshaler(), work, works);
        printResult(new JaxbMarshaler(), work, works);
        printResult(new XStreamMarshaler(), work, works);
    }

    static List<IAuthor> generateAuthorList() {
        List<IAuthor> authors = new ArrayList<IAuthor>();

        IAffiliation affiliation = new Affiliation();
        affiliation.setAddress("TestAffiliationAddress");
        affiliation.setCountry("TestAffilisationCountry");

        IAuthor author = new Author();
        author.setAffiliation(affiliation);
        author.setBirthYear("TestFirstAutherBirthDay");
        author.setDeathYear("TestFirstAuthorDeathYear");
        author.setName("TestFirstAutherName");
        author.setRole("TestFirstAutherRole");
        authors.add(author);

        author = new Author();
        author.setAffiliation(affiliation);
        author.setBirthYear("TestSecondAutherBirthDay");
        author.setDeathYear("TestSecondAuthorDeathYear");
        author.setName("TestSecondAutherName");
        author.setRole("TestSecondFirstAutherRole");
        authors.add(author);

        return authors;
    }

    static final List<IEditor> generateEditorList() {
        List<IEditor> editors = new ArrayList<>();

        IAffiliation affiliation = new Affiliation();
        affiliation.setAddress("TestEditorAffiliationAddress");
        affiliation.setCountry("TestEditorAffiliationCountry");
        IEditor editor = new Editor();
        editor.setAffiliation(affiliation);
        editor.setName("TestEditorName");
        editor.setRole("TestEditorRole");
        editors.add(editor);

        return editors;// Arrays.asList((IEditor)null)
    }

    static List<ITitle> generateTitleList() {
        List<ITitle> titles = new ArrayList<>();

        ITitle title = new Title();
        title.setEdition("TestFirstTitleEdition");
        title.setTitle("TestFirstTitle");
        title.setType("TestFirstTitleType");
        title.setVolume("TestFirstTitleVolume");
        titles.add(title);

        title = new Title();
        title.setEdition("TestSecondTitleEdition");
        title.setTitle("TestSecondtTitle");
        title.setType("TestSecondTitleType");
        title.setVolume("TestSecondTitleVolume");
        titles.add(title);

        return titles;
    }

    static IWorkCollection generateWorkCollection() {
        IWorkCollection workCollection = new WorkCollection();

        workCollection.setCollectionName("TestWorkCollection");
        workCollection.setCollectionType("TestWorkCollectionType");
        workCollection.setCreateByFileOSFilePath("TestWorkCollection???1");
        workCollection.setCreateByFileSubmittedPath("TestWorkCollection???2");
        workCollection.setDataProvider("TestWorkCollectionDataProvider");
        workCollection.setImportFileContentType("TestWorkCollectionImportanteFileContent");
        workCollection.setImportFileType("TestWorkCollectionImportantFileType");
        workCollection.setSubmitProcessedDatetime(new Date());
        workCollection.setSubmittedByUser("TestWorkCollectionSubmittedByUser");
        workCollection.setSubmittedDatetime(new Date());

        return workCollection;
    }

    private static final List<IContributor> generateContributers() {
        IAffiliation affiliation = new Affiliation();
        affiliation.setAddress("TestAffiliationAddress");
        affiliation.setCountry("TestAffilisationCountry");

        Contributor contributor = new Contributor();
        contributor.setAffiliation(affiliation);
        contributor.setName("TestNameContributer");
        contributor.setRole("TestContributeRole");

        List<IContributor> contributors = new ArrayList<>();
        contributors.add(contributor);
        return contributors;
    }

    private static void printResult(IMarshaler converter, IWork work, List<IWork> works)
            throws Exception {
        LOGGER.info(converter.getClass().getName() + ":");

        String jsonRepresentationOfInstance = converter.toJson(work);
        LOGGER.info(jsonRepresentationOfInstance);
        IWork deserializedInstance = converter.toEntity(jsonRepresentationOfInstance,
                work.getClass());
        LOGGER.info("Compare serialized and deserialized objects: "
                + work.equals(deserializedInstance));

        WorkWrapper wrapper = new WorkWrapper();
        wrapper.setWorks(works);
        String jsonRepresentationOfList = converter.toJson(wrapper);
        LOGGER.info(jsonRepresentationOfList);
        List<IWork> deserializedWorks = converter.toEntities(jsonRepresentationOfList);
<<<<<<< HEAD:src/main/java/com/copyright/rup/works/brocker/Runner.java
        LOGGER.info("Compare serialized and deserialized lists: " + works.equals(deserializedWorks)
                + "\n");
=======
        LOGGER.info("Compare serialized and deserialized lists: "
                + works.equals(deserializedWorks));
>>>>>>> 2f054807a815ed8a61117676e1ffbd0930864d91:broker-prototype/src/main/java/com/copyright/rup/works/broker/Runner.java
    }
}
