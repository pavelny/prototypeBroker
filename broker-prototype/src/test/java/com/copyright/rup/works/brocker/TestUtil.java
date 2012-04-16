package com.copyright.rup.works.brocker;

import com.copyright.rup.works.broker.Generator;
import com.copyright.rup.works.domain.api.IWork;

import java.util.ArrayList;
import java.util.List;

/**
 * It is a utility class.
 * <p/>
 * Copyright (C) 2012 copyright.com
 * <p/>
 * Date: Apr 17, 2012
 *
 * @author Andrei_Khadziukou
 *
 */
public final class TestUtil {

    private TestUtil() {
    }

    public static final int COUNT_WORK_OBJECT = 10;

    //public static final String JSON_GSON = "\"authors\":[{\"birthYear\":\"TestFirstAutherBirthDay\",\"deathYear\":\"TestFirstAuthorDeathYear\",\"name\":\"TestFirstAutherName\",\"role\":\"TestFirstAutherRole\",\"affiliation\":{\"address\":\"TestAffiliationAddress\",\"country\":\"TestAffilisationCountry\"}},{\"birthYear\":\"TestSecondAutherBirthDay\",\"deathYear\":\"TestSecondAuthorDeathYear\",\"name\":\"TestSecondAutherName\",\"role\":\"TestSecondFirstAutherRole\",\"affiliation\":{\"address\":\"TestAffiliationAddress\",\"country\":\"TestAffilisationCountry\"}}],\"workCollection\":{\"collectionName\":\"TestWorkCollection\",\"collectionType\":\"TestWorkCollectionType\",\"dataProvider\":\"TestWorkCollectionDataProvider\",\"submittedByUser\":\"TestWorkCollectionSubmittedByUser\",\"submittedDatetime\":\"Apr 12, 2012 6:15:03 PM\",\"submitProcessedDatetime\":\"Apr 12, 2012 6:15:03 PM\",\"createByFileSubmittedPath\":\"TestWorkCollection???2\",\"createByFileOSFilePath\":\"TestWorkCollection???1\",\"importFileType\":\"TestWorkCollectionImportantFileType\",\"importFileContentType\":\"TestWorkCollectionImportanteFileContent\"},\"editors\":[{\"name\":\"TestEditorName\",\"role\":\"TestEditorRole\",\"affiliation\":{\"address\":\"TestEditorAffiliationAddress\",\"country\":\"TestEditorAffiliationCountry\"}}],\"language\":{\"language\":\"TestLanguage\",\"languageRole\":\"TestLanguageType\"},\"publicationType\":\"TestPublicationType\",\"publicationCountry\":\"TestPublicationCountry\",\"publisher\":{\"name\":\"TestPublishetName\",\"role\":\"TestPublishetRole\",\"publicationPlace\":\"TestPublishetPlace\",\"status\":\"TestPublishetStatus\",\"sortOrder\":1},\"titles\":[{\"title\":\"TestFirstTitle\",\"volume\":\"TestFirstTitleVolume\",\"type\":\"TestFirstTitleType\",\"edition\":\"TestFirstTitleEdition\"},{\"title\":\"TestSecondtTitle\",\"volume\":\"TestSecondTitleVolume\",\"type\":\"TestSecondTitleType\",\"edition\":\"TestSecondTitleEdition\"}],\"audience\":[\"TestFirstAudience\",\"TestSecondAudience\",\"TestThirdAudience\"]}";;
    //public static final String JSON_JACKSON = "{\"id\":\"TestID\",\"authors\":[{\"name\":\"TestFirstAutherName\",\"role\":\"TestFirstAutherRole\",\"affiliation\":{\"address\":\"TestAffiliationAddress\",\"country\":\"TestAffilisationCountry\"},\"birthYear\":\"TestFirstAutherBirthDay\",\"deathYear\":\"TestFirstAuthorDeathYear\"},{\"name\":\"TestSecondAutherName\",\"role\":\"TestSecondFirstAutherRole\",\"affiliation\":{\"address\":\"TestAffiliationAddress\",\"country\":\"TestAffilisationCountry\"},\"birthYear\":\"TestSecondAutherBirthDay\",\"deathYear\":\"TestSecondAuthorDeathYear\"}],\"contributors\":null,\"editors\":[{\"name\":\"TestEditorName\",\"role\":\"TestEditorRole\",\"affiliation\":{\"address\":\"TestEditorAffiliationAddress\",\"country\":\"TestEditorAffiliationCountry\"}}],\"language\":{\"language\":\"TestLanguage\",\"languageRole\":\"TestLanguageType\"},\"publicationType\":\"TestPublicationType\",\"publicationCountry\":\"TestPublicationCountry\",\"publisher\":{\"name\":\"TestPublishetName\",\"role\":\"TestPublishetRole\",\"publicationPlace\":\"TestPublishetPlace\",\"status\":\"TestPublishetStatus\",\"sortOrder\":1},\"subject\":null,\"titles\":[{\"title\":\"TestFirstTitle\",\"volume\":\"TestFirstTitleVolume\",\"type\":\"TestFirstTitleType\",\"edition\":\"TestFirstTitleEdition\"},{\"title\":\"TestSecondtTitle\",\"volume\":\"TestSecondTitleVolume\",\"type\":\"TestSecondTitleType\",\"edition\":\"TestSecondTitleEdition\"}],\"audience\":[\"TestFirstAudience\",\"TestSecondAudience\",\"TestThirdAudience\"],\"collection\":{\"collectionName\":\"TestWorkCollection\",\"collectionType\":\"TestWorkCollectionType\",\"dataProvider\":\"TestWorkCollectionDataProvider\",\"submittedByUser\":\"TestWorkCollectionSubmittedByUser\",\"submittedDatetime\":1334211303369,\"submitProcessedDatetime\":1334211303369,\"createByFileSubmittedPath\":\"TestWorkCollection???2\",\"createByFileOSFilePath\":\"TestWorkCollection???1\",\"importFileType\":\"TestWorkCollectionImportantFileType\",\"importFileContentType\":\"TestWorkCollectionImportanteFileContent\"}}";
    //public static final String JSON_JAXB = "{\"work\":{\"id\":\"TestID\",\"authors\":[{\"name\":\"TestFirstAutherName\",\"role\":\"TestFirstAutherRole\",\"affiliation\":{\"address\":\"TestAffiliationAddress\",\"country\":\"TestAffilisationCountry\"},\"birthYear\":\"TestFirstAutherBirthDay\",\"deathYear\":\"TestFirstAuthorDeathYear\"},{\"name\":\"TestSecondAutherName\",\"role\":\"TestSecondFirstAutherRole\",\"affiliation\":{\"address\":\"TestAffiliationAddress\",\"country\":\"TestAffilisationCountry\"},\"birthYear\":\"TestSecondAutherBirthDay\",\"deathYear\":\"TestSecondAuthorDeathYear\"}],\"workCollection\":{\"collectionName\":\"TestWorkCollection\",\"collectionType\":\"TestWorkCollectionType\",\"createByFileOSFilePath\":\"TestWorkCollection???1\",\"createByFileSubmittedPath\":\"TestWorkCollection???2\",\"dataProvider\":\"TestWorkCollectionDataProvider\",\"importFileContentType\":\"TestWorkCollectionImportanteFileContent\",\"importFileType\":\"TestWorkCollectionImportantFileType\",\"submitProcessedDatetime\":\"2012-04-12T18:15:03.369+12:00\",\"submittedByUser\":\"TestWorkCollectionSubmittedByUser\",\"submittedDatetime\":\"2012-04-12T18:15:03.369+12:00\"},\"editors\":{\"name\":\"TestEditorName\",\"role\":\"TestEditorRole\",\"affiliation\":{\"address\":\"TestEditorAffiliationAddress\",\"country\":\"TestEditorAffiliationCountry\"}},\"language\":{\"language\":\"TestLanguage\",\"languageRole\":\"TestLanguageType\"},\"publicationType\":\"TestPublicationType\",\"publicationCountry\":\"TestPublicationCountry\",\"publisher\":{\"name\":\"TestPublishetName\",\"publicationPlace\":\"TestPublishetPlace\",\"role\":\"TestPublishetRole\",\"sortOrder\":1,\"status\":\"TestPublishetStatus\"},\"titles\":[{\"edition\":\"TestFirstTitleEdition\",\"title\":\"TestFirstTitle\",\"type\":\"TestFirstTitleType\",\"volume\":\"TestFirstTitleVolume\"},{\"edition\":\"TestSecondTitleEdition\",\"title\":\"TestSecondtTitle\",\"type\":\"TestSecondTitleType\",\"volume\":\"TestSecondTitleVolume\"}],\"audience\":[\"TestFirstAudience\",\"TestSecondAudience\",\"TestThirdAudience\"]}}";
    public static final String JSON_XSTEAME = generateJsonStringForXstreame();

    private static List<IWork> works;

    public static List<IWork> getWorks() {
        return works;
    }

    static {
        works = new ArrayList<>();
        for (int i = 0; i < COUNT_WORK_OBJECT; i++) {
            works.add(Generator.generateWork());
        }
    }

    private static String generateJsonStringForXstreame() {
        StringBuilder sb = new StringBuilder();
        sb.append("{").append("\"id\": \"TestID\",").append("\"authors\": [").append("{")
                .append("\"name\": \"TestFirstAutherName\",")
                .append("\"role\": \"TestFirstAutherRole\",").append("\"affiliation\": {")
                .append("\"@class\": \"com.copyright.rup.works.domain.impl.Affiliation\",")
                .append("\"address\": \"TestAffiliationAddress\",")
                .append("\"country\": \"TestAffilisationCountry\"").append("},")
                .append("\"birthYear\": \"TestFirstAutherBirthDay\",")
                .append("\"deathYear\": \"TestFirstAuthorDeathYear\"").append("},").append("{")
                .append("\"name\": \"TestSecondAutherName\",")
                .append("\"role\": \"TestSecondFirstAutherRole\",").append("\"affiliation\": {")
                .append("\"@class\": \"com.copyright.rup.works.domain.impl.Affiliation\",")
                .append("\"address\": \"TestAffiliationAddress\",")
                .append("\"country\": \"TestAffilisationCountry\"").append("},")
                .append("\"birthYear\": \"TestSecondAutherBirthDay\",")
                .append("\"deathYear\": \"TestSecondAuthorDeathYear\"").append("}").append("],")
                .append("\"workCollection\": {")
                .append("\"@class\": \"com.copyright.rup.works.domain.impl.WorkCollection\",")
                .append("\"collectionName\": \"TestWorkCollection\",")
                .append("\"collectionType\": \"TestWorkCollectionType\",")
                .append("\"dataProvider\": \"TestWorkCollectionDataProvider\",")
                .append("\"submittedByUser\": \"TestWorkCollectionSubmittedByUser\",")
                .append("\"submittedDatetime\": \"2012-04-12 06:15:03.369 UTC\",")
                .append("\"submitProcessedDatetime\": \"2012-04-12 06:15:03.369 UTC\",")
                .append("\"createByFileSubmittedPath\": \"TestWorkCollection???2\",")
                .append("\"createByFileOSFilePath\": \"TestWorkCollection???1\",")
                .append("\"importFileType\": \"TestWorkCollectionImportantFileType\",")
                .append("\"importFileContentType\": \"TestWorkCollectionImportanteFileContent\"")
                .append("},").append("\"editors\": [").append("{")
                .append("\"name\": \"TestEditorName\",").append("\"role\": \"TestEditorRole\",")
                .append("\"affiliation\": {")
                .append("\"@class\": \"com.copyright.rup.works.domain.impl.Affiliation\",")
                .append("\"address\": \"TestEditorAffiliationAddress\",")
                .append("\"country\": \"TestEditorAffiliationCountry\"").append("}").append("}")
                .append("],").append("\"language\": {")
                .append("\"@class\": \"com.copyright.rup.works.domain.impl.WorkLanguage\",")
                .append("\"language\": \"TestLanguage\",")
                .append("\"languageRole\": \"TestLanguageType\"").append("},")
                .append("\"publicationType\": \"TestPublicationType\",")
                .append("\"publicationCountry\": \"TestPublicationCountry\",")
                .append("\"publisher\": {")
                .append("\"@class\": \"com.copyright.rup.works.domain.impl.Publisher\",")
                .append("\"name\": \"TestPublishetName\",")
                .append("\"role\": \"TestPublishetRole\",")
                .append("\"publicationPlace\": \"TestPublishetPlace\",")
                .append("\"status\": \"TestPublishetStatus\",").append("\"sortOrder\": 1")
                .append("},").append("\"titles\": [").append("{")
                .append("\"title\": \"TestFirstTitle\",")
                .append("\"volume\": \"TestFirstTitleVolume\",")
                .append("\"type\": \"TestFirstTitleType\",")
                .append("\"edition\": \"TestFirstTitleEdition\"").append("},").append("{")
                .append("\"title\": \"TestSecondtTitle\",")
                .append("\"volume\": \"TestSecondTitleVolume\",")
                .append("\"type\": \"TestSecondTitleType\",")
                .append("\"edition\": \"TestSecondTitleEdition\"").append("}").append("],")
                .append("\"audience\": [").append("[").append("\"TestFirstAudience\",")
                .append("\"TestSecondAudience\",").append("\"TestThirdAudience\"").append("]")
                .append("]").append("}");
        return sb.toString();
    }
}
