package com.copyright.rup.works.brocker;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.copyright.rup.works.brocker.api.IConverter;
import com.copyright.rup.works.brocker.impl.JacksonJsonConverter;
import com.copyright.rup.works.domain.api.IWork;

@Ignore("Was deleted, this test was moved into ConverterTest class")
public class JacksonConverterTest {

    private List<IWork> works = TestUtil.works;
    private IConverter converter = new JacksonJsonConverter();

    @Test
    public void testConverter() throws Exception {
        for (IWork work: works) {
            converter.toJson(work);
        }
    }

    @Test
    public void testConverterFullCollectionAsASingleObject() throws Exception {
        converter.toJson(TestUtil.works);
    }
}
