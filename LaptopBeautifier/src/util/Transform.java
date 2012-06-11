package util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class Transform {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws TransformerException 
	 */
	public static void main(String[] args) throws IOException, TransformerException {
		if (args.length != 3) {
			System.err.println("Wrong arguments. Correct format: ");
			System.err.println("Transform inputxml outputhtml transformxsl");
		}
		String input = args[0];
		String output = args[1];
		String transform = args[2];
		
		TransformerFactory tFactory = TransformerFactory.newInstance();
		Source xmlSource = new StreamSource(new File(input));
		Source xslSource = new StreamSource(new File(transform));
		Transformer transformer = tFactory.newTransformer(xslSource);
		FileWriter fwriter = new FileWriter(new File(output));
		transformer.transform(xmlSource, new StreamResult(fwriter));
	}

}
