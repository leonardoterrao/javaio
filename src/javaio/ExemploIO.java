package javaio;

import java.io.*;

public class ExemploIO {

	public static void main(String[] args) {

		try {

			File arquivo = new File("c:/posJava/teste2.txt");
			if (arquivo.exists()) {
				System.out.println("Arquivo já existe");

				if (arquivo.isFile()) {
					if (arquivo.length() == 0) {

						FileOutputStream fos = new FileOutputStream(arquivo);
						BufferedOutputStream bw = new BufferedOutputStream(fos);
						PrintWriter pw = new PrintWriter(bw);

						for (int i = 0; i < 20; i++) {
							pw.println("Teste de escrita no arquivo " + i);
						}
						pw.close();

					} else {

						FileReader fr = new FileReader(arquivo);
						BufferedReader br = new BufferedReader(fr);
						String linha = null;
						while ((linha = br.readLine()) != null) {
							System.out.println("Linha : " + linha);
						}

						System.out.println("Fim de arquivo.");
					}
				} else {
					System.out.println("Diretório com " + arquivo.getUsableSpace() + " bytes usados");
				}

			} else {
				System.out.println("Arquivo NÃO existe");
				if (arquivo.createNewFile()) {
					System.out.println("Arquivo criado com sucesso");
				} else {
					System.out.println("Erro na criacao do arquivo");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}