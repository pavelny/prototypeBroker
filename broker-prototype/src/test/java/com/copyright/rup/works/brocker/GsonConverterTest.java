package com.copyright.rup.works.brocker;

import com.copyright.rup.works.broker.api.IMarshaler;
import com.copyright.rup.works.broker.marshaler.GsonMarshaler;
import com.copyright.rup.works.domain.api.IWork;

import org.junit.Ignore;
import org.junit.Test;

@Ignore("Was deleted, this test was moved into ConverterTest class")
public class GsonConverterTest {

    private IMarshaler converter = new GsonMarshaler();

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
