package com.integrador.services;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
@Slf4j
public class RestTemplateUtil {

	private static final String BEARER = "Bearer ";
	
	@Autowired
	private RestTemplate restTemplate;

	
	public <T> ResponseEntity<T>sendRequest(UriComponentsBuilder uri,HttpMethod method ,
											Object body,Class<T> classOfT,HttpHeaders headersAdd){
		long startTimeTry = System.currentTimeMillis();
		ResponseEntity<String> resp = null;
		ResponseEntity<T> result = null;
		HttpHeaders headers = headersAdd!= null ? headersAdd : new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		try {
			HttpEntity<Object> entity = null;
			entity = (body != null)?new HttpEntity<>(body,headers):new HttpEntity<>(headers);
			resp = restTemplate.exchange(uri.toUriString(), method, entity, String.class);

			log.info("info: [RestTemplateUtil][sendRequest] el servicio responde: ", resp);

			T respClassOfT = new Gson().fromJson(resp.getBody(), classOfT);
				result = new ResponseEntity<>(respClassOfT,resp.getHeaders(),resp.getStatusCode());
			long endTimeConn = System.currentTimeMillis() - startTimeTry;

		}catch (Exception e) {
			log.error("Error:  [RestTemplateUtil][sendRequest] excepcion: ",e.getMessage());
		}
		return result;
	}

	public <T> ResponseEntity<T>sendRequest(String uri,HttpMethod method ,Object body,
											Class<T> classOfT,HttpHeaders headersAdd){
		ResponseEntity<String> resp = null;
		ResponseEntity<T> result = null;
		HttpHeaders headers = headersAdd!= null ? headersAdd : new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		try {
			HttpEntity<Object> entity = null;
			entity = (body != null)?new HttpEntity<>(body,headers):new HttpEntity<>(headers);
			resp = restTemplate.exchange(uri, method, entity, String.class);
			if (classOfT != String.class) {
				T respClassOfT = new Gson().fromJson(resp.getBody(), classOfT);
				result = new ResponseEntity<>(respClassOfT,resp.getHeaders(),resp.getStatusCode());
			}else {
				T respClassOfT = (T) resp;
				result = new ResponseEntity<>(respClassOfT,resp.getHeaders(),resp.getStatusCode());
			}
			
			log.info("Respuesta de api ws response: ",resp);
		}catch (Exception e) {
			log.info("Error en respuesta de api ws response: ",resp);
		}
		return result;
	}
	
}
