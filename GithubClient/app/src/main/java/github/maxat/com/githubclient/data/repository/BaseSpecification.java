package github.maxat.com.githubclient.data.repository;

/**
 * Created by ayrat on 12.09.17.
 */
public class BaseSpecification implements Specification {


	String field;

	Object value;

	public BaseSpecification(final String field, Object value){
		this.field = field;
		this.value = value;

	}

	@Override
	public String getField() {
		return field;
	}

	@Override
	public Object getValue() {
		return value;
	}


}
