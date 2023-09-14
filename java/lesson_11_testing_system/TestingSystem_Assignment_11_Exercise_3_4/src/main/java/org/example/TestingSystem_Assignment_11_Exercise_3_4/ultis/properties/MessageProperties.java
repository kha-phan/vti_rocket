package org.example.TestingSystem_Assignment_11_Exercise_3_4.ultis.properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * This class is used for accessing properties file.
 * 
 * @Description: .
 * @author: DangBack
 * @create_date: May 26, 2020
 * @version: 1.0
 * @modifer: DangBlack
 * @modifer_date: May 26, 2020
 */
public class MessageProperties {

	private Properties properties;

	/**
	 * Constructor for class MessageProperties.
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
	public MessageProperties() throws FileNotFoundException, IOException {
		properties = new Properties();
		properties.load(new FileInputStream(DatabaseProperties.RESOURCE_FOLDER_URL + "message.properties"));
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
