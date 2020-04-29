package com.lilljedahl.jaxb.jaxbxjc;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.lilljedahl.patient.Patient;

/**
 * Hello world!
 *
 */
public class JAXBDemo 
{
    public static void main( String[] args )
    {
        try {
			JAXBContext context = JAXBContext.newInstance(Patient.class);
			
			// Marshalling converts java objects into xml 
			Marshaller marshaller = context.createMarshaller(); 
			
			Patient patient = new Patient();
			patient.setId(123);
			patient.setName("Russell");
			
			StringWriter writer = new StringWriter();
			marshaller.marshal(patient, writer);

	        System.out.println(writer.toString());			
			
	        // Unmarshalling converts xml into java objects
	        Unmarshaller unmarshaller = context.createUnmarshaller();
	        
	        Patient patientResult = (Patient) unmarshaller.unmarshal(new StringReader(writer.toString()));
	        System.out.println(patientResult.getName());
	        
		} catch (JAXBException e) {
			e.printStackTrace();
		}
    }
}
