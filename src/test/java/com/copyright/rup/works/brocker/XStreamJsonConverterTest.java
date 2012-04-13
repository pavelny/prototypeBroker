package com.copyright.rup.works.brocker;

import com.copyright.rup.works.broker.api.IMarshaler;
import com.copyright.rup.works.broker.marshaler.XStreamMarshaler;
import com.copyright.rup.works.domain.api.IWork;

import org.junit.Test;

/**
 * @author Andrei_Khadziukou
 *
 */
// TODO Add javadoc
// @Ignore("Was deleted, this test was moved into ConverterTest class")
public class XStreamJsonConverterTest {

    private IMarshaler converter = new XStreamMarshaler();

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
