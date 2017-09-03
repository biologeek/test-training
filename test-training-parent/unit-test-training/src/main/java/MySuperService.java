
public class MySuperService {
	
	private MySuperDao dao;
	
	
	
	public Object processObjectAndReturn(int o) {
		if (o <= 0)
			throw new IllegalArgumentException();
		Object obj = dao.getObject(o);
		return obj;
	}



	public MySuperDao getDao() {
		return dao;
	}



	public void setDao(MySuperDao dao) {
		this.dao = dao;
	}

}
