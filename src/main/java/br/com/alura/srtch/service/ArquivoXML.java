package br.com.alura.srtch.service;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import br.com.alura.srtch.easycharge.modelo.Cliente;

public class ArquivoXML {

	public static void main(String[] args) { 
	//List<Cliente> Ler(String arquivo) {
		//List<Cliente> clientes;
      try {
        File file = new File("C:\\Users\\JJ\\git\\easycharge\\src\\main\\resources\\clientes.xml");
        
        JAXBContext jaxbContext = JAXBContext.newInstance(Cliente.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        Cliente cliente = (Cliente) unmarshaller.unmarshal(file);
        System.out.println(cliente.getNome());
      } catch (Exception ex) {
        ex.printStackTrace();
      }
      //return clientes;
    } 
}
