package restapi;


import ru.qatools.properties.Property;
import ru.qatools.properties.PropertyLoader;
import ru.qatools.properties.Resource;

@Resource.Classpath("ApplicationConfig.properties")
public class ApplicationConfigReader 
{

	public ApplicationConfigReader()
	{
		PropertyLoader.newInstance().populate(this);
	}

	@Property(value = "baseURL")
	private String baseURL;

	public String getBaseURL() {
		return baseURL;
	}

}
