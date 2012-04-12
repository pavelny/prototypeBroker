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

import com.copyright.rup.works.brocker.api.IMarshaler;
import com.copyright.rup.works.brocker.marshaler.GsonMarshaler;
import com.copyright.rup.works.brocker.marshaler.JacksonMarshaler;
import com.copyright.rup.works.brocker.marshaler.JaxbMarshaler;
import com.copyright.rup.works.brocker.marshaler.XStreamMarshaler;
import com.copyright.rup.works.domain.api.IWork;

/**
 * @author Andrei_Khadziukou
 *
 */
@Ignore
@RunWith(Parameterized.class)
public class ConverterTest {

    private IMarshaler converter;

    @Parameters
    public static List<Object[]> paramitrize() {
        return Arrays.asList(new Object[][] {{new GsonMarshaler()}, {new JaxbMarshaler()}, {new XStreamMarshaler()}, {new JacksonMarshaler()}});
    }

    public ConverterTest(IMarshaler converter) {
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
