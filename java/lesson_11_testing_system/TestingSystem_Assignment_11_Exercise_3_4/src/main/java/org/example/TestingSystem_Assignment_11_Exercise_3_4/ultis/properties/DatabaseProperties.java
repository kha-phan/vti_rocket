package org.example.TestingSystem_Assignment_11_Exercise_3_4.ultis.properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * This class is used for accessing properties file.
 * 
 * @Description: .
 * @author: DangBlack
 * @create_date: May 26, 2020
 * @version: 1.0
 * @modifer: DangBlack
 * @modifer_date: May 26, 2020
 */
public class DatabaseProperties {

	public static final String RESOURCE_FOLDER_URL = "/Users/rainee/Project/vti_rocket/java/lesson_11_testing_system/TestingSystem_Assignment_11_Exercise_3_4/src/main/resources/";

	private Properties properties;

	/**
	 * Constructor for class DatabaseProperties.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: May 28, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: May 28, 2020
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public DatabaseProperties() throws FileNotFoundException, IOException {
		properties = new Properties();
		properties.load(new FileInputStream(RESOURCE_FOLDER_URL + "database.properties"));
	}

	/**
	 * This method is used for get property from properties file. 
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: May 28, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: May 28, 2020
	 * @param key
	 * @return
	 */
	public String getProperty(String key) {
		return properties.getProperty(key);
	}
}
