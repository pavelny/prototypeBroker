
namespace java com.copyright.rup.works.broker.thrift.gen

/**
 * Work
 */

struct ThriftAuthor {
1: string birthYear,
2: string deathYear
}

struct ThriftWorkCollection {
1: string collectionName,
2: string collectionType,
3: string dataProvider,
4: string submittedByUser,
5: string submittedDatetime,
6: string submittedProcessedDatetime,
7: string createByFileSubmittedPath,
8: string createByfileOsFilePath,
9: string importFileType,
10: string importFileContentType
}

struct ThriftAffiliation {
1: string address,
2: string country
}

struct ThriftPerson {
1: string name,
2: string role,
3: ThriftAffiliation affiliation
}

struct ThriftWorkLanguage {
1: string language,
2: string languageRole
}

struct ThriftPublisher {
1: string name,
2: string role,
3: string publicationPlace,
4: string status,
5: i32 sortOrder
}

struct ThriftSubject {
1: string subject,
2: string subjectType
}

struct ThriftTitle {
1: string title,
2: string volume,
3: string type,
4: string edition
}

struct ThriftWork {
1: string id,
2: list<ThriftAuthor> authors,
3: ThriftWorkCollection collection,
4: list<ThriftPerson> contributors,
5: list<ThriftPerson> editors,
6: ThriftWorkLanguage workLanguage,
7: string publicationType,
8: string puclicationCountry,
9: ThriftPublisher publisher,
10: ThriftSubject subject,
11: list<ThriftTitle> titles,
12: list<string> audience,
13: string workItem
}

service ThriftWorkData {

     oneway void send(1: ThriftWork w)

     ThriftWork getThriftWork()

}
