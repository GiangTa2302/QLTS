package utils;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class FileUtils {
	public static void writeXMLtoFile(String fileName, Object object) 
	{
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			File xmlFile = new File(fileName);
			marshaller.marshal(object, xmlFile);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	
	public static Object readXMLFile(String fileName, Class<?> clazz) {
		 try {
			 File xmlFile = new File(fileName);
			 JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
			 Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			 return jaxbUnmarshaller.unmarshal(xmlFile);
		 } catch (JAXBException e) {
			 e.printStackTrace();
		 }
		 	return null;
	}
}
