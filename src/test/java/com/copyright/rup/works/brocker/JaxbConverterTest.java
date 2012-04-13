package com.copyright.rup.works.brocker;

import com.copyright.rup.works.brocker.api.IMarshaler;
import com.copyright.rup.works.brocker.marshaler.JaxbMarshaler;
import com.copyright.rup.works.domain.api.IWork;

import org.junit.Test;

//@Ignore("Was deleted, this test was moved into ConverterTest class")
public class JaxbConverterTest {

    public IMarshaler converter = new JaxbMarshaler();

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
