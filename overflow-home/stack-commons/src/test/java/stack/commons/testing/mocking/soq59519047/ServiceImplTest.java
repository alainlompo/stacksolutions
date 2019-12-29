package stack.commons.testing.mocking.soq59519047;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ServiceImplTest {

    private Service.Factory innerClassMock;
    private AImpl sut = new AImpl();

    @org.junit.Before
    public void setUp() throws Exception {
        innerClassMock = mock(Service.Factory.class);
    }

    @Test
    public void generateTest() throws Exception {
        String id= "id";
        when(Service.Factory.getInstance()).thenReturn(new ServiceImpl());

        String result = sut.method1("1");

        Assert.assertEquals("test", result);
    }
}