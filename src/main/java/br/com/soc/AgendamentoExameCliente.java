package br.com.soc;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class AgendamentoExameCliente {

	public static void main(String[] args) {
		try {
			Client client = Client.create();
			WebResource webResource = client.resource("http://localhost:8080/soctest/webservice/exames/1");
			ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);

			if (response.getStatus() != 200) {
				throw new RuntimeException("Erro HTTP status code: " + response.getStatus());
			}

			String output = response.getEntity(String.class);
			System.out.println("Agendamento de exame retornado: \n");
			System.out.println(output);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
