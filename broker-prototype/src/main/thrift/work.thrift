
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

struct ThriftWorkLanguage {
1: string language,
2: string languageRole
}

struct ThriftWork {
1: string id,
2: list<ThriftAuthor> authors,
3: ThriftWorkCollection collection
4: ThriftWorkLanguage workLanguage
}

service ThriftWorkData {

     oneway void send(1: ThriftWork w)

     ThriftWork getThriftWork()

}
