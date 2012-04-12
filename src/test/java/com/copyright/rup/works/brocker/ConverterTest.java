/**
 *
 */
package com.copyright.rup.works.brocker;

import java.util.Arrays;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.copyright.rup.works.brocker.api.IConverter;
import com.copyright.rup.works.brocker.impl.GsonConverter;
import com.copyright.rup.works.brocker.impl.JacksonJsonConverter;
import com.copyright.rup.works.brocker.impl.JaxbJsonConverter;
import com.copyright.rup.works.brocker.impl.XStreamJsonConverter;
import com.copyright.rup.works.domain.api.IWork;

/**
 * @author Andrei_Khadziukou
 *
 */
@Ignore
@RunWith(Parameterized.class)
public class ConverterTest {

    private IConverter converter = new GsonConverter();

    @Parameters
    public static List<Object[]> paramitrize() {
        return Arrays.asList(new Object[][] {{new GsonConverter()}, {new JaxbJsonConverter()}, {new XStreamJsonConverter()}, {new JacksonJsonConverter()}});
    }

    public ConverterTest(IConverter converter) {
        this.converter = converter;
    }

    @Test
    public void testConverter() throws Exception {
        for (IWork work: TestUtil.works) {
            converter.toJson(work);
        }
    }

    @Test
    public void testConverterFullCollectionAsASingleObject() throws Exception {
        converter.toJson(TestUtil.works);
    }

}
