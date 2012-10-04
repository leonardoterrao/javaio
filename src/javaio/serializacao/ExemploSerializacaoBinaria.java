package javaio.serializacao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.LinkedList;

public class ExemploSerializacaoBinaria {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {

		Pessoa joao = new Pessoa("0000", "João", new Date());
		Pessoa maria = new Pessoa("4444", "Maria", new Date());
		Pessoa jose = new Pessoa("6666", "José", new Date());

		LinkedList<Pessoa> pessoas = new LinkedList<Pessoa>();
		pessoas.add(joao);
		pessoas.add(maria);
		pessoas.add(jose);

		exportar(joao);
		exportarLista(pessoas);
		
		Pessoa importada = importar();
		System.out.println(importada.toString());
		
		LinkedList<Pessoa> importadas = importarLista();
		for (Pessoa pessoa : importadas) {
			System.out.println(pessoa.toString());
		}
	}

	public static void exportar(Pessoa pessoa) throws FileNotFoundException, IOException {
		ObjectOutputStream outList = new ObjectOutputStream(new FileOutputStream("c:\\exemplojavaio.bin"));
		outList.writeObject(pessoa);
		outList.close();
	}

	public static void exportarLista(LinkedList<Pessoa> pessoas) throws FileNotFoundException, IOException {
		ObjectOutputStream outList = new ObjectOutputStream(new FileOutputStream("c:\\exemplojavaiolista.bin"));
		outList.writeObject(pessoas);
		outList.close();
	}
	
	public static Pessoa importar() throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInput in = new ObjectInputStream(new FileInputStream("c:\\exemplojavaio.bin"));
		Pessoa pessoa = (Pessoa) in.readObject();
		in.close();
		return pessoa;
	}
	
	@SuppressWarnings("unchecked")
	public static LinkedList<Pessoa> importarLista() throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInput in = new ObjectInputStream(new FileInputStream("c:\\exemplojavaiolista.bin"));
		LinkedList<Pessoa> pessoas = (LinkedList<Pessoa>) in.readObject();
		in.close();
		return pessoas;
	}

}
