import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.*;

public class MySuperServiceTest {

	MySuperService sut;
	
	@Mock
	MySuperDao daoMock;
	
	@Before
	public void init() {
		
		// Mock de la DAO
		daoMock = mock(MySuperDao.class);
		sut = new MySuperService();
		// On injecte la DAO dans notre unité de test
		sut.setDao(daoMock);
		
	}

	//THEN
	@Test(expected=IllegalArgumentException.class)
	public void shouldThrowExceptionWithNegativeId() {
		//GIVEN
		when(daoMock.getObject(anyInt())).thenReturn(new Object());
		//WHEN
		sut.processObjectAndReturn(-1);		
	}
	
	@Test
	public void shouldProcessObjectAndReturnNonNull() {
		//GIVEN
		when(daoMock.getObject(anyInt())).thenReturn(new Object());
		
		//WHEN
		Object result = sut.processObjectAndReturn(1);
		
		//THEN
		Assert.assertNotNull(result);
		Assert.assertEquals(new Object().getClass(), result.getClass());
	}
}
