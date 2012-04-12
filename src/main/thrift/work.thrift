
namespace java com.copyright.thrift.gen

/**
 * Work
 */

struct WorkDto {
1: string id,
2: list<Author> author,
3:
}

struct Author {
1: string birthYear,
2: string deathYear
}

struct WorkCollection {
1: string collectionName,
2: string collectionType,
3: string dataProvider,
4: string submittedByUser,
5: string submittedDatetime,
6: string submittedProcessedDatetime,
7: string createByFileSubmittedPath,
8: string createByfileOsFilePath,
9: string importFileType,
10: string importFileType
}

service WorkData {

     oneway void send(1: WorkDto w)

     WorkDto getWorkDto()

}
