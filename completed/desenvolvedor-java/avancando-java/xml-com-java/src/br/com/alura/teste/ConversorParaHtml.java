package br.com.alura.teste;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class ConversorParaHtml {

	public static void main(String[] args)
			throws FileNotFoundException, TransformerFactoryConfigurationError, TransformerException {

		InputStream xsl = new FileInputStream("src/xmlParaHtml.xsl");
		StreamSource xslSorce = new StreamSource(xsl);
		InputStream dados = new FileInputStream("src/vendas.xml");
		StreamSource xmlSource = new StreamSource(dados);

		Transformer transformer = TransformerFactory.newInstance().newTransformer(xslSorce);

		StreamResult saida = new StreamResult("src/vendas.html");
		transformer.transform(xmlSource, saida);

		System.out.println("Conversão Concluida");
	}

}
