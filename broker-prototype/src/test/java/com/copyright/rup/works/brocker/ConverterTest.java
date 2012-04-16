/**
 *
 */
package com.copyright.rup.works.brocker;

import com.copyright.rup.works.broker.api.IMarshaler;
import com.copyright.rup.works.broker.marshaler.GsonMarshaler;
import com.copyright.rup.works.broker.marshaler.JacksonMarshaler;
import com.copyright.rup.works.broker.marshaler.JaxbMarshaler;
import com.copyright.rup.works.broker.marshaler.XStreamMarshaler;
import com.copyright.rup.works.domain.api.IWork;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.List;

/**
 * @author Andrei_Khadziukou
 *
 */
@Ignore
@RunWith(Parameterized.class)
public class ConverterTest {

    @Parameters
    public static List<Object[]> paramitrize() {
        return Arrays.asList(new Object[][] { { new GsonMarshaler() }, { new JaxbMarshaler() },
                { new XStreamMarshaler() }, { new JacksonMarshaler() } });
    }

    private IMarshaler converter;

    public ConverterTest(IMarshaler converter) {
        this.converter = converter;
    }

    @Test
    public void testConverter() throws Exception {
        for (IWork work : TestUtil.works) {
            converter.toJson(work);
        }
    }

    @Test
    public void testConverterFullCollectionAsASingleObject() throws Exception {
        converter.toJson(TestUtil.works);
    }

}
