
namespace java com.copyright.thrift.gen

/**
 * Work
 */

struct WorkDto {
1: string id,
2: string language,
3: string publicationType,
4: string publicationCountry,
5: string subject,
6: string titles
}

service WorkData {

     oneway void send(1: WorkDto w)

     WorkDto getWorkDto()

}
